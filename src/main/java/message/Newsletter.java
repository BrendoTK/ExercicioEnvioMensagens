package message;

import people.Customer;

import java.util.List;

public class Newsletter {
    private final List<Customer> customers;
    private MessageService messageService;

    public Newsletter(final List<Customer> customers, MessageService messageService) {
        this.customers = customers;
        this.messageService = messageService;
    }

    public void send(final String msgTemplate) {
        for (final Customer customer : customers) {
            messageService.send(customer.getPhone(), formatMsg(customer, msgTemplate));
        }
    }

    private String formatMsg(final Customer customer, final String msgTemplate) {
        return msgTemplate
                .replaceAll("#name", customer.getName())
                .replaceAll("#email", customer.getEmail())
                .replaceAll("#phone", customer.getPhone());
    }
}