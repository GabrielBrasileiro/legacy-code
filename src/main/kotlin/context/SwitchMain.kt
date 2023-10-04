package context

import context.data.ContextLegacy
import context.data.ContextNew
import context.data.ContextToggle
import context.decider.ContextScopeDecider

fun main() {
	val contextLegacy = ContextLegacy()
	val contextNew = ContextNew()
	val contextToggle = ContextToggle()
	val decider = ContextScopeDecider(contextLegacy, contextNew, contextToggle)

	// Local de consumo
	val data = decider.getData()

	// Resulado
	println("Nome: ${data.name} - Idade: ${data.age}")
}
