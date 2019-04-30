package Scripts
int ReadCSVFile(def field)
{
 echo "ReadCSVFile.groovy file executed"
 def file = new File("C:\\Newrepo\\vars\\Config.csv");
 String[] lines = file.text.split('\n')
 for(int i =0; i<lines.size(); i++)
 {
 println "$lines[i]"
 String[] rowvalues = row.split(',');
 }
}