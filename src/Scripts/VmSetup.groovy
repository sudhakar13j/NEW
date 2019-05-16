package Scripts
void VmOperations(String key,List values)
{
	if(key.equals("VmPowerOff"))
		VmPowerOff(values)
	else if(key.equals("VmRevert"))
		VmRevert(values)
	else if(key.equals("VmPowerOn"))
		VmPowerOn(values)
	else
		println "No Methods"
}
@NonCPS
void VmPowerOff(List Parameter)
{
	println "VmPowerOff method invoked"
	def Node = Parameter[0].toString()
	def Network = Parameter[1].toString()
	println "Node:$Node"
	println "Network:$Network"
	vSphere buildStep: [$class: 'PowerOff', evenIfSuspended: false, ignoreIfNotExists: false, shutdownGracefully: false, vm: Node.trim()], serverName: Network.trim()
}
@NonCPS
void VmRevert(List Parameter)
{
	println "VmRevert method invoked"
	String Node = Parameter[0]
	String Network = Parameter[1]
	String snapshot = Parameter[2]
	println "Node:$Node"
	println "Network:$Network"
	println "snapshot:$snapshot"
	//vSphere buildStep: [$class: 'RevertToSnapshot', snapshotName: snapshot.trim(), vm: Node.trim()], serverName: Network.trim()
}
@NonCPS
void VmPowerOn(List Parameter)
{
	println "VmPowerOn method invoked"
	String Node = Parameter[0]
	String Network = Parameter[1]
	println "Node:$Node"
	println "Network:$Network"
	vSphere buildStep: [$class: 'PowerOn', timeoutInSeconds: 260, vm: Node.trim()], serverName: Network.trim()
}