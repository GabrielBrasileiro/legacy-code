package effects;

public class Effect {

    /**
     * O estado e as variáveis internas
     * desse objeto podem estar sendo alteradas!
     *
     * E essas alterações podem se propagar no
     * consumo do objeto.
     */
    private CustomData customData;

    public Effect(CustomData customData) {
        this.customData = customData;
    }
}
