package functional.main

fun main() {
	val transformEnvironment: ExecutionScope = TransformEnvironment()
	val terminateEnvironment: TerminateState = TerminateEnvironment()
	val processState: ProcessState =
		ProcessStateEnvironment(transformEnvironment, terminateEnvironment)

	processState.createState()

	// Saída: Processo terminado: runtime
}

data class NewContext(
	val param: String
)

class LegacyContext {
	var state = "runtime"
	/**  Estrutura não compreensível */
}

// Interface de recepção
interface TerminateState {
	fun sendMessage(message: String)
}

// Interface de controle
interface ProcessState {
	fun createState()
}

// Interface de isolamento
interface ExecutionScope {
	// Criação do contexto funcional
	fun onScope(block: (NewContext) -> Unit)
}

class TerminateEnvironment : TerminateState {
	override fun sendMessage(message: String) {
		println("Processo terminado: $message")
	}
}

class TransformEnvironment : ExecutionScope {

	// Contexto não interpretável isolado
	private val legacyContext = LegacyContext()

	// Contexto transformado e emitido
	override fun onScope(block: (NewContext) -> Unit) {
		val state = legacyContext.state
		val newContext = NewContext(state)
		block(newContext)
	}
}

class ProcessStateEnvironment(
	private val executionScope: ExecutionScope,
	private val terminateState: TerminateState
) : ProcessState {

	override fun createState() {
		executionScope.onScope { newContext: NewContext ->
			// Condicionais e novas estruturas
			terminateState.sendMessage(newContext.param)
		}
	}
}
