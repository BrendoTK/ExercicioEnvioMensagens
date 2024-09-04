package message;


/**
 * Envia mensagens pelo Short Message Service (SMS)
 * @author Brendo Braz Sales
 */
public class Sms implements MessageService {
    @Override
    public void send(final String destination, final String msg) throws MessageSendException {
        System.out.printf("Enviando SMS para %s: %s%n", destination, msg);
    }
}