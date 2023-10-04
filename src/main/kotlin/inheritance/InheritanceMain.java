package inheritance;

public class InheritanceMain {

    public static void main(String[] args) {
        // Given
        String message = "Atualizar as bases";
        String key = "teste";
        String expectedMessage = "TESTE:ATUALIZAR AS BASES";

        MessageDispatcherFake fakeDispatcher = new MessageDispatcherFake(key);

        // When
        fakeDispatcher.processMessage(message);

        // Then
        String lastMessage = fakeDispatcher.getLastMessage();
        boolean isEquals = lastMessage.equals(expectedMessage);

        System.out.println("Resultado: " + isEquals);
    }
}
