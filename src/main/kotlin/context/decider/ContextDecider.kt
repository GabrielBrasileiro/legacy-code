package context.decider

import context.entity.ContextData

interface ContextDecider {
	fun getData(): ContextData
}