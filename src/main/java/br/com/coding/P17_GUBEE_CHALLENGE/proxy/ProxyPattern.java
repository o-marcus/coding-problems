package br.com.coding.P17_GUBEE_CHALLENGE.proxy;

import br.com.coding.P17_GUBEE_CHALLENGE.annotation.Transactional;
import br.com.coding.P17_GUBEE_CHALLENGE.repository.MessageRepository;
import java.util.UUID;

//  Nessa classe não usei um subject porque o banco de dados é em memória
public class ProxyPattern
        implements MessageRepository {

    private final MessageRepository repository;

    public ProxyPattern(MessageRepository repository) {
        this.repository = repository;
    }

    @Override
    public void saveMessage(UUID id, String message) {
        String methodName = "saveMessage";
        try {
            var method = repository.getClass().getMethod(methodName, UUID.class, String.class);
            if (method.isAnnotationPresent(Transactional.class)) {
                System.out.println("Iniciando execução do método: " + method.getName());
                repository.saveMessage(id, message);
                System.out.println("Finalizando execução do método " + method.getName() + "com sucesso");
            }
        }
        catch (NoSuchMethodException e) {
            System.err.println("Finalizando execução do método " + methodName + " com erro");
            e.printStackTrace();
        }
    }

}

