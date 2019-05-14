def call()
{
 node
 {
  stage('VmSetup')
  {
   def VmSetupObj = new Scripts.Reusable()
   VmSetupObj.FReader("VmSetup")
   echo "VmSetup Finished"
  }
  stage('SendEmail')
  {
   def EmailObj = new Scripts.Reusable()
   EmailObj.FReader("SendEmail")
   echo "SendEmail Finished"
  }
 }
}