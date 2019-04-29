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
   def SampleEmail = new Scripts.SendEmail()
   SampleEmail.SendEmail("sudhakar.anandan@ravsoftsolutions.com","deepak.kumar@ravsoftsolutions.com","demo_mail")
   echo "Mail Sent Successfully"
  }
 }
}
