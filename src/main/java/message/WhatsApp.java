package message;

public class WhatsApp implements MessageService {
    @Override
    public void send(final String destination, final String msg) throws MessageSendException {
        System.out.printf("Enviando msg WhatsApp para %s: %s%n", destination, msg);
    }
}