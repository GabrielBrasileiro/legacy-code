package humble

import humble.adapter.AdapterConsumer
import humble.adapter.AdapterScopeConsumer
import humble.impossible.ImpossibleObject

fun main() {
	val impossibleObject = ImpossibleObject()
	val adapterConsumer: AdapterConsumer =
		AdapterScopeConsumer(impossibleObject)

	newFlowOperation(adapterConsumer)
}

fun newFlowOperation(adapterConsumer: AdapterConsumer) {
	val consumer = adapterConsumer.requireConsumer()
	val state = consumer.state

	println("Estado imutável recuperado: $state") // Excecution
}