def call()
{
 node
 {
  stage('VmSetup')
  {
   def VmSetupObj = new Scripts.ReadCSV()
   VmSetupObj.FReader("VmSetup")
   echo "VmSetup Finished"
  }
  /*stage('SendEmail')
  {
   def EmailObj = new Scripts.ReadCSV()
   EmailObj.FReader("SendEmail")
   echo "SendEmail Finished"
  }*/
 }
}