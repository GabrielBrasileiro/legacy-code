package inheritance;

public class MessageDispatcherLegacy {

    private static final String colon = ":";
    private final String key = "identifier";

    final public void processMessage(String contentMessage) {
        String allMessage = getKey() + colon + contentMessage;
        String transformed = allMessage.toUpperCase();

        dispatchMessage(transformed);
    }

    protected void dispatchMessage(final String message) {
        System.out.println(message);
        // Local que realiza conexão com o mundo exterior.
    }

    protected String getKey() {
        return key;
    }
}
