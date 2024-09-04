package message;

public class MessageServiceFactory {
    public static MessageService getMessageService(String type) {
        switch (type.toLowerCase()) {
            case "email":
                return new Email();
            case "sms":
                return new Sms();
            case "whatsapp":
                return new WhatsApp();
            default:
                throw new IllegalArgumentException("Tipo de serviço de mensagem desconhecido: " + type);
        }
    }
}