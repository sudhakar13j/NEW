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
  println "$lines[i]"
  String[] rowvalues = lines.split(',')
  for(j=0;i<rowvalues.size();j++)
  {
   if(rowvalues[j] == field)
   {
    row = i+1;
	col = j;
	break;
   }
  }
 }
 rowvalues = lines[row].split(',')
 println "$rowvalues[col]"
 return rowvalues[col]
}