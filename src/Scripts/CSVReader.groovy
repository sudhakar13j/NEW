package Scripts
int ReadCSVFile(def field)
{
 echo "ReadCSVFile.groovy file executed"
 int row = 0;
 int col = 0;
 int i = 0;
 int j = 0;
 def file = new File("C:/Newrepo/vars/Config.csv")
 String[] lines = file.text.split('\n')
 for(i =0; i<lines.size(); i++)
 {
  println "row:$lines[].size()"
  String[] rowvalues = lines.split(',')
  println "colcount:$rowvalues.size()"
  for(j=0;i<rowvalues.size();j++)
  {
   if(rowvalues[j].contains(field))
   {
    row = i+1;
	col = j;
	break;
   }
  }
 }
 String[] values = lines[row].split(',')
 println "Step2:$values[col]"
 return rowvalues[col]
} 