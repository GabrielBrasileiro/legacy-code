package context.decider

import context.data.ContextLegacy
import context.data.ContextNew
import context.data.ContextToggle
import context.entity.ContextData

class ContextScopeDecider(
	private val contextLegacy: ContextLegacy,
	private val contextNew: ContextNew,
	private val contextToggle: ContextToggle
) : ContextDecider {

	override fun getData(): ContextData {
		return if (contextToggle.isEnabled()) {
			contextNew.getData()
		} else {
			contextLegacy.getData()
		}
	}
}