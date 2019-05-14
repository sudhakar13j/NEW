package Scripts
void FReader(String stage)
	{
		try
		{
			Reusable obj = new Reusable()
			//StartProgram obj = new StartProgram()
			println "File Reader Method started"
			//Map<String,List> InputMap = new HashMap<String,List>();
			String input1 = null
			List input2 = new ArrayList()
			int row = 0
			int col = 0
			int i = 0
			int j = 0
			int k = 0
			int rowCount = 0
			int colCount = 0
			def file = new File("C:/Newrepo/vars/ConfigParam.csv")
			List Arrayvalues = new ArrayList()
			String[] lines = file.text.split('\n')
			rowCount = lines.size();
			for(i =0; i<rowCount; i++)
			{
				if(lines[i].contains(stage))
				{
					row = i+2
					break
				}
			}
			for(j=row;j<rowCount;j++)
			{
				if(lines[j].contains("@Stage") || lines[j] == "<EOF>" || lines[j] == '\r')
					break
				else
				{
					String[] tempkey = lines[j].split('\\$')
					for(i=1;i<tempkey.size();i++)
					{
						Arrayvalues.add(tempkey[i].toString())
					}
				}
			}
			for(String str in Arrayvalues)
			{
				str = str.replace('(', ',')
				str = str.replace(')', '')
				str = str.replace(' ', '')
				List value = new ArrayList()
				String[] temp = str.split(',')
				String key = temp[0]
				for(i=1;i<temp.size();i++)
				{
					value.add(temp[i])
				}
				//InputMap.put(key, value)
				println "Key:$key"
				println "Value:$value"
				//String val = InputMap[key]
				//String methodname = key
				obj.metaClass.methods.each { method ->
					if (method.name == key) {
						method.invoke(obj, value)
					}
				}
			}
		}
		catch(Exception ex)
		{
			println "Exception:$ex"
		}
	}
void VmPowerOff(List Parameter)
{
	println "VmPowerOff method invoked"
	def Node = Parameter[0].toString()
	def Network = Parameter[1].toString()
	println "Node:$Node"
	println "Network:$Network"
	//vSphere buildStep: [$class: 'PowerOff', evenIfSuspended: false, ignoreIfNotExists: false, shutdownGracefully: false, vm: Node], serverName: Network
	vSphere buildStep: [$class: 'PowerOff', evenIfSuspended: false, ignoreIfNotExists: false, shutdownGracefully: false, vm: 'ica-tst21-ws12'], serverName: 'NEPTUNE'
}
void VmRevert(List Parameter)
{
	println "VmRevert method invoked"
	String Node = Parameter[0]
	String Network = Parameter[1]
	String snapshot = Parameter[2]
	println "Node:$Node"
	println "Network:$Network"
	println "snapshot:$snapshot"
}
void VmPowerOn(List Parameter)
{
	println "VmPowerOn method invoked"
	String Node = Parameter[0]
	String Network = Parameter[1]
	println "Node:$Node"
	println "Network:$Network"
	//vSphere buildStep: [$class: 'PowerOn', timeoutInSeconds: 260, vm: Node], serverName: Network
}
void SMTPConfiguration(List Parameter)
{
	println "SMTPConfiguration method invoked"
	String SMTPAdmin = Parameter[0]
	String SMTPPort = Parameter[1]
	String SMTPHost = Parameter[2]
	println "SMTPAdmin:$SMTPAdmin"
	println "SMTPPort:$SMTPPort"
	println "SMTPHost:$SMTPHost"
}
void sendMail(List Parameter)
{
	println "sendMail method invoked"
	String Receiver = Parameter[0]
	String Subject = Parameter[1]
	String Body = Parameter[2]
	String Attachment = Parameter[3]
	println "Receiver:$Receiver"
	println "Subject:$Subject"
	println "Body:$Body"
	println "Attachment:$Attachment"
}
