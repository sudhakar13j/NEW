def call()
{
 node
 {
  stage('Sample')
  {
   def SampleObj = new Scripts.Reusable()
   SampleObj.FReader("VmSetup")
   echo "Welcome to Jenkins"
  }
 }
}