package Scripts
int ReadCSVFile(def field)
{
 echo "ReadCSVFile.groovy file executed"
 int row = 0
 int col = 0
 int i = 0
 int j = 0
 int rowCount = 0
 int colCount = 0
 def file = new File("C:/Newrepo/vars/Config.csv")
 String[] lines = file.text.split('\n')
 rowCount = lines.size();

 for(i =0; i<rowCount; i++)
 {
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
 println("Found place:$row and $col")
 String[] values = lines[row].split(',')
 String csvvalue = values[col]
 return csvvalue
}