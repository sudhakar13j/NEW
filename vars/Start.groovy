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
   vSphere buildStep: [$class: 'PowerOff', evenIfSuspended: false, ignoreIfNotExists: false, shutdownGracefully: false, vm: 'pa-tst4-ws16'], serverName: 'NEPTUNE'
	echo "${VmName} is Switched ON"
  }
 }
}