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
   def input1 = csv.ReadCSVFile("SMTPReceiver")
   println "Input1:$input1"
   def input2 = csv.ReadCSVFile("BuildUrl")
   println "Input2:$input2"
  }
 }
}
