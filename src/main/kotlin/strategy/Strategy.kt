package strategy

fun main() {
	val expected = "Mário"
	val testStrategy = LegacyStrategy {
		NewInfo(name = "Mário")
	}
	val fakeFinishExecution = FakeFinish()
	val processInfo = ProcessInfo(fakeFinishExecution)
	processInfo.startNewScope(testStrategy)

	val result = fakeFinishExecution.getLastMessage()

	println(result == expected) // Saída: True
}

data class NewInfo(
	val name: String
)

fun interface LegacyStrategy {
	fun getData(): NewInfo
}

interface FinishExecution {
	fun terminate(message: String)
}

class FakeFinish : FinishExecution {
	private var lastMessage = String()

	override fun terminate(message: String) {
		lastMessage = message
	}

	fun getLastMessage(): String = lastMessage
}

class ProcessInfo(
	private val finishExecution: FinishExecution
) {
	fun startNewScope(legacyStrategy: LegacyStrategy) {
		val immutableData = legacyStrategy.getData()
		val name = immutableData.name
		finishExecution.terminate(name)
	}
}


