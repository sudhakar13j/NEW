package Email
import hudson.model.*;
import jenkins.model.*;
import hudson.tools.*;
import hudson.util.Secret;
import javax.mail.*
import javax.mail.internet.*

def sendMail(receivers, subject, text) {

// Variables
def SystemAdminMailAddress = 'admin@merge.com'
def SMTPPort = 25
def SMTPHost = 'mail.products.network.internal'

// Constants
def instance = Jenkins.getInstance()
def mailServer = instance.getDescriptor("hudson.tasks.Mailer")
def jenkinsLocationConfiguration = JenkinsLocationConfiguration.get()
def extmailServer = instance.getDescriptor("hudson.plugins.emailext.ExtendedEmailPublisher")

Thread.start {
    sleep 10000

        //Jenkins Location
        println "--> Configuring JenkinsLocation"
        jenkinsLocationConfiguration.setAdminAddress(SystemAdminMailAddress)
        jenkinsLocationConfiguration.save()

        //E-mail Server
        //mailServer.setSmtpAuth(SMTPUser, SMTPPassword)
        mailServer.setSmtpHost(SMTPHost)
        mailServer.setSmtpPort(SMTPPort)
        mailServer.setCharset("UTF-8")

    // Save the state
    instance.save()
	
	//Send Email
	Properties props = System.getProperties()
    props.put("mail.smtp.host", SMTPHost)
    Session session = Session.getDefaultInstance(props, null)

    MimeMessage message = new MimeMessage(session)
    message.setFrom(new InternetAddress(SystemAdminMailAddress))
    receivers.split(',').each {
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(it))
    }
    message.setSubject(subject)
    message.setText(text)

    println 'Sending mail to ' + receivers + '.'
    Transport.send(message)
    println 'Mail sent.'
} 
    
	}