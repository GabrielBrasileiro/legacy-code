package strategy



class HardWorkClazz {

    private var legacyName = "legacy"

    fun getStrategy(): LegacyStrategy {
        return LegacyStrategy {
            NewInfo(legacyName)
        }
    }

    /**
     * Conjunto de funções de
     * manipulação com alto risco.
     * ...
     */
}
