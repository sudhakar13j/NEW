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
	//SampleEmail.sendMail(Receiver,Subject,Body,Attachment)
	SampleEmail.sendMailNew(Receiver,Subject,Body,Attachment)
	echo "Mail Sent Successfully"
  }
  /*stage('CSVReader')
  {
   echo "CSVReader file started"
   def csv = new Scripts.CSVReader()
   def input1 = csv.ReadCSVFile("SMTPPort")
   println "Input1:$input1"
   def input2 = csv.ReadCSVFile("BuildUrl")
   println "Input2:$input2"
  }
  stage('CSVFileReader')
  {
   echo "CSVReader file started"
   def csv = new Scripts.CSVFileReader()
   List input1 = new ArrayList()
   List input2 = new ArrayList()
   input1 = csv.ReadCSVFile("VmSetup")
   String sss = input1.get(0)
   println "Input1:$sss"
   input2 = csv.ReadCSVFile("EmailConfiguration","Email")
   sss = input2.get(2)
   println "Input2:$sss"
  }
  
  stage('test')
  {
  echo "test stage started"
   def csv = new Scripts.CSVFileReader()
   String methodname = "test1"
		csv."$methodname"(10,20,"pa-tst4-ws16","NEPTUNE")
   /*csv.metaClass.methods.each { method ->
			if (method.name == 'test1') {
				method.invoke(csv, 10,20)
			}
			if (method.name == 'ReadCSVFile') {
				method.invoke(csv, 'EmailConfiguration')
			}
		}
  }*/
 }
}
