package context.data

import context.entity.ContextData

class ContextLegacy {

	private var name = "mário"
	private var age = 58

	fun getData(): ContextData {
		return ContextData(name, age)
	}
}