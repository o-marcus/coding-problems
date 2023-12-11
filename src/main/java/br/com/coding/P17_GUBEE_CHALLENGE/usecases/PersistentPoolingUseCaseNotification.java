package br.com.coding.P17_GUBEE_CHALLENGE.usecases;

import br.com.coding.P17_GUBEE_CHALLENGE.repository.MessageRepository;

import java.util.Random;
import java.util.UUID;

public class PersistentPoolingUseCaseNotification
        implements UseCaseNotification{

    private final MessageRepository repository;

    public PersistentPoolingUseCaseNotification(MessageRepository repository) {
        this.repository = repository;
    }

    @Override
    public void notifyEveryHour(String customerId, PresenterNotification presenter) {
        System.out.println("processando regra de negocio");
        String message = String.format("mensagem a ser enviada para %s: %s", customerId, new Random().nextInt());
        presenter.notification(message);
        try {
            repository.saveMessage(UUID.fromString(customerId), message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
