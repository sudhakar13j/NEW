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
  stage('SendSMTP')
  {
	echo "SendSMTP file started"
	def SampleEmail = new Email.SendSMPTmail()
	def Configvalues = new Scripts.CSVReader()
	def Receiver = Configvalues.ReadCSVFile("SMTPReceiver")
	def Subject = Configvalues.ReadCSVFile("EmailSubject")
	def Body = Configvalues.ReadCSVFile("EmailBody")
	def Attachment = Configvalues.ReadCSVFile("Attachment")
	SampleEmail.sendMail(Receiver,Subject,Body)
	echo "Mail Sent Successfully"
  }
  stage('CSVReader')
  {
   echo "CSVReader file started"
   def csv = new Scripts.CSVReader()
   def input1 = csv.ReadCSVFile("SMTPReceiver")
   println "Input1:$input1"
   def input2 = csv.ReadCSVFile("SMTPHost")
   println "Input2:$input2"
  }
 }
}
