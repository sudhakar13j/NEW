class StartProgram {
	void FReader(String stage)
	{
		try
		{
			StartProgram obj = new StartProgram()
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
				String methodname = key
				obj.metaClass.methods.each { method ->
					if (method.name == methodname) {
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
		println "VmPowerOff Started"
		String input1 = Parameter[0]
		String input2 = Parameter[1]
		println "input1:$input1"
		println "input2:$input2"
	}
	void VmRevert(List Parameter)
	{
		println "VmRevert Started"
		String input1 = Parameter[0]
		String input2 = Parameter[1]
		String input3 = Parameter[2]
		println "input1:$input1"
		println "input2:$input2"
		println "input3:$input3"
	}
	void VmPowerOn(List Parameter)
	{
		println "VmPowerOn Started"
		String input1 = Parameter[0]
		String input2 = Parameter[1]
		println "input1:$input1"
		println "input2:$input2"
	}
	static main(args) {
		StartProgram start = new StartProgram()
		start.FReader("VmSetup")
		println "VmSetup is done"
	}

}