package Scripts
import hudson.model.*;
import jenkins.model.*;
import hudson.tools.*;
import hudson.util.Secret;
import javax.mail.*
import javax.mail.internet.*
def EmailOperation(String key,List values)
{
String SystemAdminMailAddress = values[0]
String SMTPPort = values[1]
String SMTPHost = values[2]
String receivers = values[3]
String subject = values[4]
String text = values[5]
String attachment = values[6]
println "SystemAdminMailAddress: $SystemAdminMailAddress"
println "SMTPPort: $SMTPPort"
println "SMTPHost: $SMTPHost"
println "receivers: $receivers"
println "subject: $subject"
println "text: $text"
println "attachment: $attachment"
EmailNotification(SystemAdminMailAddress,SMTPPort,SMTPHost,receivers, subject, text, attachment)
}
def EmailNotification(SystemAdminMailAddress,SMTPPort,SMTPHost,receivers, subject, text, String attachment = null)
{
	// Constants
	def instance = Jenkins.getInstance()
	def mailServer = instance.getDescriptor("hudson.tasks.Mailer")
	def jenkinsLocationConfiguration = JenkinsLocationConfiguration.get()
	//def extmailServer = instance.getDescriptor("hudson.plugins.emailext.ExtendedEmailPublisher")
   
    //Jenkins Location
        
	jenkinsLocationConfiguration.setAdminAddress(SystemAdminMailAddress)
	jenkinsLocationConfiguration.save()
	//E-mail Server
	mailServer.setSmtpHost(SMTPHost)
	mailServer.setSmtpPort(SMTPPort)
	mailServer.setCharset("UTF-8")
	// Save the state
	instance.save() 
    
    Properties props = new Properties();
    //props.put("mail.smtp.auth", "true");
    props.put("mail.smtp.host", SMTPHost);
    //props.put("mail.smtp.user", SMTPUser);
    props.put("mail.smtp.port", SMTPPort);
    //props.put("mail.smtp.password", SMTPPassword);
	println "--> Configuring JenkinsLocation"
     Session session = Session.getInstance(props, null);
        // Create a default MimeMessage object.
	if (attachment == null)
	{
		Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(SystemAdminMailAddress));
        message.setRecipients(Message.RecipientType.TO, receivers);
        message.setSubject(subject);
        message.setText(text);
        println 'Sending mail to ' + receivers + '.'
        Transport.send(message);
        println 'Mail sent.'
	}
	else
	{
	Message msg = new MimeMessage(session);
	msg.setFrom(new InternetAddress(SystemAdminMailAddress))
	msg.setRecipients(Message.RecipientType.TO, receivers);
	msg.setSubject(subject)
	BodyPart messageBodyPart = new MimeBodyPart()
	messageBodyPart.setContent(text,"text/html")
	Multipart multipart = new MimeMultipart()
	multipart.addBodyPart(messageBodyPart)

	messageBodyPart = new MimeBodyPart()
	messageBodyPart.attachFile(attachment)  
	multipart.addBodyPart(messageBodyPart)
	println "--> Attachment Added:"
	// Send the complete message parts
	msg.setContent(multipart)
	println 'Sending mail to ' + receivers + '.'
	Transport.send(msg)   
	println "--> Mail sent with Attachment"
	}
}