def call()
{
 node
 {
  /*stage('Sample')
  {
   def SampleObj = new Scripts.test()
   SampleObj.testgroovy()
   echo "Welcome to Jenkins"
  }*/
  /*stage('SendSMTP')
  {
	echo "SendSMTP file started"
	def SampleEmail = new Email.SendSMPTmail()
	SampleEmail.sendMail("sudhakar.anandan@ravsoftsolutions.com","demo_mail","SMTP Mail received","C:\\Issuedetails.txt")
	echo "Mail Sent Successfully"
  }*/
  stage('CSVReader')
  {
   echo "CSVReader file started"
   def csv = new Scripts.CSVReader()
   def input = csv.ReadCSVFile("SMTPHost")
   println "CSBInpuit:$input"
  }
 }
}
