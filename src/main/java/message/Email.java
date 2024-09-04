package message;

/**
 * Envia mensagens de email.
 * @author Brendo Braz Sales
 */
public class Email implements MessageService {
    @Override
    public void send(final String destination, final String msg) throws MessageSendException {
        System.out.printf("Enviando email para %s: %s%n", destination, msg);
    }
}