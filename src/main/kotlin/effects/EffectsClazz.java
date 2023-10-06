package effects;

public class EffectsClazz {

    public static void main(String[] args) {

    }

    private CustomData customData = new CustomData("");

    public CustomData getData() {
        return customData;
    }

    public String getState() {
        return "custom";
    }
}
