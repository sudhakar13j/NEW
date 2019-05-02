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
  println "values:$rowvalues[i]\n"
  String[] rowvalues = lines[i].split(',')
 }
 return row
} 