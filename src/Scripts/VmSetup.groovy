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
void VmPowerOff(List Parameter)
{
	println "VmPowerOff method invoked"
	def Node = Parameter[0].toString()
	def Network = Parameter[1].toString()
	println "Node:$Node"
	println "Network:$Network"
	vSphere buildStep: [$class: 'PowerOff', evenIfSuspended: false, ignoreIfNotExists: false, shutdownGracefully: false, vm: Node], serverName: Network
}
void VmRevert(List Parameter)
{
	println "VmRevert method invoked"
	String Node = Parameter[0]
	String Network = Parameter[1]
	String snapshot = Parameter[2]
	println "Node:$Node"
	println "Network:$Network"
	println "snapshot:$snapshot"
}
void VmPowerOn(List Parameter)
{
	println "VmPowerOn method invoked"
	String Node = Parameter[0]
	String Network = Parameter[1]
	println "Node:$Node"
	println "Network:$Network"
	vSphere buildStep: [$class: 'PowerOn', timeoutInSeconds: 260, vm: Node], serverName: Network
}