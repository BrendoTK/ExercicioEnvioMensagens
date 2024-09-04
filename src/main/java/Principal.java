import message.MessageService;
import message.MessageServiceFactory;
import message.Newsletter;
import people.Customer;

import java.util.List;

public class Principal {
    public static void main(String[] args) {
        final List<Customer> customers = List.of(
                new Customer("Manoel", "(63) 1111-2222", "manoel@teste.com"),
                new Customer("Brendo", "(63) 3333-4444", "brendo@teste.com"),
                new Customer("Nicoly", "(63) 5555-7777", "nicoly@teste.com")
        );

        final String msgTemplate = "Aproveite as promoções de natal #name.";

        // Aqui escolhemos o tipo de serviço de mensagem a ser utilizado.
        MessageService messageService = MessageServiceFactory.getMessageService("whatsapp");

        final Newsletter newsletter = new Newsletter(customers, messageService);
        newsletter.send(msgTemplate);
    }
}