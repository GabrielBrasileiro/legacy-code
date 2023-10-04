package humble.impossible

class ImpossibleObject {
	private var impossibleData = ImpossibleData(
		state = "execution",
		status = "good"
	)

	fun getCurrentState(): ImpossibleData {
		return impossibleData
	}

	// Operações extras e "impossíveis de entender".
}