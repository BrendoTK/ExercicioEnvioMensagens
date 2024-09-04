# Envio de Mensagens

Para resolver o problema de envio de mensagens e a necessidade de alternar entre diferentes formas de envio sem alterar o código dos clientes, foram utilizados os seguintes padrões de projeto:

# 1. Padrão Simple Factory

O padrão **Simple Factory** foi utilizado na implementação da classe `MessageServiceFactory`. Este padrão permite a criação de objetos `MessageService` sem que o código cliente precise conhecer as classes concretas que implementam essa interface. A classe `MessageServiceFactory` centraliza a lógica de criação de objetos, simplificando a adição de novos tipos de serviço de mensagem no futuro.

**Exemplo de implementação:**

```java
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
```
# 2. Padrão Strategy

O padrão **Strategy** é utilizado para encapsular o algoritmo de envio de mensagens em diferentes classes que implementam a interface `MessageService`. Isso permite que o tipo de envio (como e-mail, SMS ou WhatsApp) seja trocado dinamicamente sem alterar o código do cliente.

## Exemplo de Implementação

### Interface `MessageService`

```java
public interface MessageService {
    void send(String destination, String msg) throws MessageSendException;
}
```

# Implementações Concretas

### WhatsApp

```java
public class WhatsApp implements MessageService {
    @Override
    public void send(final String destination, final String msg) throws MessageSendException {
        System.out.printf("Enviando msg WhatsApp para %s: %s%n", destination, msg);
    }
}
```

### Sms

```java
public class Sms implements MessageService {
    @Override
    public void send(final String destination, final String msg) throws MessageSendException {
        System.out.printf("Enviando SMS para %s: %s%n", destination, msg);
    }
}
```

### Email

```java
public class Email implements MessageService {
    @Override
    public void send(final String destination, final String msg) throws MessageSendException {
        System.out.printf("Enviando email para %s: %s%n", destination, msg);
    }
}
```
# Conclusão

Os padrões **Simple Factory** e **Strategy** ajudam a resolver o problema de alternar entre diferentes formas de envio de mensagens de forma eficiente e escalável. O **Simple Factory** centraliza a criação de instâncias de `MessageService`, enquanto o **Strategy** permite a troca dinâmica de algoritmos de envio.
