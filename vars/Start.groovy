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
  stage('poweroff')
  {
   //vSphere buildStep: [$class: 'PowerOff', evenIfSuspended: false, ignoreIfNotExists: false, shutdownGracefully: false, vm: 'ica-tst21-ws12'], serverName: 'NEPTUNE'
   vSphere buildStep: [$class: 'PowerOn', timeoutInSeconds: 260, vm: 'ica-tst21-ws12'], serverName: 'NEPTUNE'
	echo "ica-tst21-ws12 is Switched ON"
  }
 }
}