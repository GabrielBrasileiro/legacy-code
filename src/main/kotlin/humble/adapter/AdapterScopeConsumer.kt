package humble.adapter

import humble.adapter.entity.Consumer
import humble.impossible.ImpossibleObject

class AdapterScopeConsumer(
	private val impossibleObject: ImpossibleObject
): AdapterConsumer {

	override fun requireConsumer(): Consumer {
		val impossibleData = impossibleObject.getCurrentState()
		return Consumer(impossibleData.state)
	}
}