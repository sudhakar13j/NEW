package Scripts
int ReadCSVFile(def header,def field)
{
 echo "ReadCSVFile.groovy file executed"
 int row = 0
 int col = 0
 int x = 0
 int i = 0
 int j = 0
 int rowCount = 0
 int colCount = 0
 def file = new File("C:/Newrepo/vars/Config.csv")
 String[] lines = file.text.split('\n')
 rowCount = lines.size();
 for(x=0;x<rowCount;x++)
 {
  if(lines[i].contains(header))
  {
   for(i=x; i<rowCount; i++)
   {
    println "header:$x"
    String[] rowvalues = lines[i].split(',')
    colCount = rowvalues.size();
	for(j=0;j<colCount;j++)
	{
	 if(rowvalues[j].equals(field))
	 {
	  row = i+1
	  col = j
	  break;
	 }
	}
   }
  }
 }
 println("Found place:$row and $col")
 String[] values = lines[row].split(',')
 String csvvalue = values[col]

 return csvvalue
}