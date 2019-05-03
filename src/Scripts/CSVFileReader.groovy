package Scripts
List ReadCSVFile(String field)
	{
		println "ReadCSVFile.groovy file executed"
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
			if(lines[i].contains(field))
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
				Arrayvalues.add(lines[j])
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