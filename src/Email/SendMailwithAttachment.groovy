def sendMail(String message, String attachment, String subject) {
    Properties properties = System.getProperties()
    properties.setProperty("mail.smtp.host", eMailSMTPHost)
    properties.setProperty("mail.smtp.port", eMailSMTPIPPort)
    Session session = Session.getDefaultInstance(properties)
    try{
        // Create a default MimeMessage object.
        MimeMessage msg = new MimeMessage(session)
        msg.setFrom(new InternetAddress(eMailSendFrom))
        eMailSendTo.split(',').each(){ item ->      msg.addRecipient(Message.RecipientType.TO,
            new InternetAddress(item)    )
        }
        eMailSendCc.split(',').each(){ item -> msg.addRecipient(Message.RecipientType.CC,
            new InternetAddress(item)    )
        }
        msg.setSubject(subject)
        BodyPart messageBodyPart = new MimeBodyPart()
        messageBodyPart.setContent(message,"text/html")
        Multipart multipart = new MimeMultipart()
        multipart.addBodyPart(messageBodyPart)

        messageBodyPart = new MimeBodyPart()
        messageBodyPart.attachFile(attachment)  
        multipart.addBodyPart(messageBodyPart)

        // Send the complete message parts
        msg.setContent(multipart)
        Transport.send(msg)     
        System.exit(0)
    } catch(RuntimeException e) {
        println e.getMessage()
    }
}