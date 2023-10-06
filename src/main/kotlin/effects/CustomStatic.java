package effects;

public class CustomStatic {

    /**
     * Controle aberto de um estado estático
     * representa alto risco de volatilidade
     * no consumidor da variável.
     */
    public static CustomData customData = new CustomData("start");

    public void changeState() {
        customData = new CustomData("execute");
    }
}
