package functional.test

fun main() {
	val expected = "GIVA"
	val newContext = NewContext("Giva")
	val fakeEnvironment = TransformEnvironmentFake(newContext)
	val terminateEnvironmentFake = TerminateEnvironmentFake()
	val processState: ProcessState =
		ProcessStateEnvironment(fakeEnvironment, terminateEnvironmentFake)

	processState.createState()

	val result = terminateEnvironmentFake.getLastMessage()

	println(expected == result) // Saída: True
}

class TerminateEnvironmentFake : TerminateState {

	private var lastMessage = String()

	override fun sendMessage(message: String) {
		lastMessage = message
	}

	fun getLastMessage(): String = lastMessage
}

class ProcessStateEnvironment(
	private val executionScope: ExecutionScope,
	private val terminateState: TerminateState
) : ProcessState {

	override fun createState() {
		executionScope.onScope { newContext: NewContext ->
			terminateState.sendMessage(newContext.param.uppercase())
		}
	}
}

class TransformEnvironmentFake(
	private val newContext: NewContext
) : ExecutionScope {

	override fun onScope(block: (NewContext) -> Unit) {
		block(newContext)
	}
}

data class NewContext(
	val param: String
)

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
	fun onScope(block: (NewContext) -> Unit)
}


