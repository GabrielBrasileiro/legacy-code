package strategy

fun main() {
    val hardWork = HardWorkClazz()
    val processInfo = ProcessInfo()

    processInfo.startNewScope(hardWork.getStrategy())
}

class ProcessInfo {

    fun startNewScope(legacyStrategy: LegacyStrategy) {
        val immutableData = legacyStrategy.getData()
        println(immutableData.name)
    }
}

data class NewInfo(
    val name: String
)

