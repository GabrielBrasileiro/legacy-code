package inheritance;

public class MessageDispatcherFake extends MessageDispatcherLegacy {

    private final String customKey;
    private String lastMessage;

    public MessageDispatcherFake(String customKey) {
        this.customKey = customKey;
    }

    @Override
    final protected void dispatchMessage(String message) {
        this.lastMessage = message;
    }

    @Override
    final protected String getKey() {
        return customKey;
    }

    protected String getLastMessage() {
        return lastMessage;
    }
}
