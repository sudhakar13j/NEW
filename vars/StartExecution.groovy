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
  //stage('SendEmail')
  //{
   //def SampleEmail = new Email.SendEmail()
   //SampleEmail.SendEmail("sudhakar.anandan@ravsoftsolutions.com","sudhakar.anandan@ravsoftsolutions.com","demo_mail","Execution //started")
   //echo "Mail Sent Successfully"
  //}
  stage('SendSMTP')
  {
	echo "SendSMTP file started"
	def SampleEmail = new Email.SendSMPTmail()
	SampleEmail.sendMail("sudhakar.anandan@ravsoftsolutions.com","demo_mail","SMTP Mail received")
	echo "Mail Sent Successfully"
  }
 }
}
