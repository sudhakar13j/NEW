package Scripts
List ReadCSVFile(String header)
	{
		println "List ReadCSVFile.groovy file executed"
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
			if(lines[i].contains(header))
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
				Arrayvalues.add(lines[j].toString())
		}
		int n = Arrayvalues.size()
		for(k=0;k<n;k++)
		{
			Arrayvalues[k] = Arrayvalues[k].replace('{', '')
			Arrayvalues[k] = Arrayvalues[k].replace('}', '')
			Arrayvalues[k] = Arrayvalues[k].replace(' ', '')
		}
		return Arrayvalues
	}
	List ReadCSVFile(String header, String field)
	{
		println "List ReadCSVFile.groovy file executed"
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
			if(lines[i].contains(header))
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
				Arrayvalues.add(lines[j].toString())
		}
		int n = Arrayvalues.size()
		for(k=0;k<n;k++)
		{
			Arrayvalues[k] = Arrayvalues[k].replace('{', '')
			Arrayvalues[k] = Arrayvalues[k].replace('}', '')
			Arrayvalues[k] = Arrayvalues[k].replace(' ', '')
		}
		println "Output:$Arrayvalues"
		String temp
		for(j=0;j<Arrayvalues.size();j++)
		{
			if(Arrayvalues[j].contains(field))
			{
				temp = Arrayvalues[j]
				break
			}
		}
		String[] line = temp.split(',')
		temp = null
		temp = line[2].toString()
		line = null
		line = temp.split('\\|')
		println "Line:$line"
		List Arrayval = new ArrayList()
		for(i=0;i<line.size();i++)
		{
			Arrayval.add(line[i].toString())
		}
		return Arrayval
	}
	void test1(int a,int b, String VmName, String Network)
	{
		int c = a+b
		println "Sum:$c"
		vSphere buildStep: [$class: 'PowerOff', evenIfSuspended: false, ignoreIfNotExists: false, shutdownGracefully: false, vm: VmName], serverName: Network
	}
	def VmPowerOff(VmName,Network)
	{
	//echo "VmName is ${VmName}"
	echo "Network is ${Network}"
	vSphere buildStep: [$class: 'PowerOff', evenIfSuspended: false, ignoreIfNotExists: false, shutdownGracefully: false, vm: VmName], serverName: Network
	echo "${VmName} is Switched Off"
	
	}