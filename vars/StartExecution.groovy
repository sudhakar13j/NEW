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
  stage('SendSMTP')
  {
	echo "SendSMTP file started"
	def SampleEmail = new Email.SendSMPTmail()
	def Configvalues = new Scripts.CSVReader()
	def Receiver = Configvalues.ReadCSVFile("SMTPReceiver")
	def Subject = Configvalues.ReadCSVFile("EmailSubject")
	def Body = Configvalues.ReadCSVFile("EmailBody")
	def Attachment = Configvalues.ReadCSVFile("Attachment")
	println "$Receiver"
	println "$Subject"
	println "$Body"
	println "$Attachment"
	SampleEmail.sendMail(Receiver,Subject,Body,Attachment)
	echo "Mail Sent Successfully"
  }
  stage('CSVReader')
  {
   echo "CSVReader file started"
   def csv = new Scripts.CSVReader()
   def input1 = csv.ReadCSVFile("SMTPPort")
   println "Input1:$input1"
   def input2 = csv.ReadCSVFile("BuildUrl")
   println "Input2:$input2"
  }
 }
}
