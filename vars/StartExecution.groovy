def call()
{
 node
 {
  stage('Sample')
  {
   def SampleObj = new Scripts.test()
   SampleObj.testgroovy()
   echo "Welcome to Jenkins"
  }
  stage('SendEmail')
  {
   def SampleEmail = new Email.SendEmail()
   SampleEmail.SendEmail("sudhakar.anandan@ravsoftsolutions.com","sudhakar.anandan@ravsoftsolutions.com","demo_mail","Execution started")
   echo "Mail Sent Successfully"
  }
  stage('SendSMTP')
  {
	echo "SendSMTP file started"
	def SampleEmail = new Email.SendSMPTmail()
	SampleEmail.sendMail("secure200.inmotionhosting.com","sudhakar.anandan@ravsoftsolutions.com","deepak.kumar@ravsoftsolutions.com","demo_mail")
	echo "Mail Sent Successfully"
  }
  stage('SendMailAttach')
  {
   echo "SendMailAttach file started"
   def mailatach = new SendMailwithAttachment()
   mailatach.sendMail("Jenkins mail","C:\\Issuedetails.txt","Attachment")
  }
 }
}
