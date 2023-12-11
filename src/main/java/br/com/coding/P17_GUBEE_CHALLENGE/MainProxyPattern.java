package br.com.coding.P17_GUBEE_CHALLENGE;

import br.com.coding.P17_GUBEE_CHALLENGE.factory.MessageFactoryDatabase;
import br.com.coding.P17_GUBEE_CHALLENGE.factory.StubMessageFactory;
import br.com.coding.P17_GUBEE_CHALLENGE.proxy.ProxyPattern;
import br.com.coding.P17_GUBEE_CHALLENGE.usecases.PersistentPoolingUseCaseNotification;
import br.com.coding.P17_GUBEE_CHALLENGE.usecases.UseCaseNotification;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MainProxyPattern {
    private static final ScheduledExecutorService controller =
            Executors.newSingleThreadScheduledExecutor();
    private static final MessageFactoryDatabase factory =
            new StubMessageFactory();
    private static final UseCaseNotification notificationUseCase =
            new PersistentPoolingUseCaseNotification(new ProxyPattern(factory.newInstance()));

    public static void main(String[] args) {
        UseCaseNotification.PresenterNotification emailPresenter = (message) -> System.out.printf("email %s", message);
        UseCaseNotification.PresenterNotification whatsAppPresenter = (message) -> System.out.printf("whatApp %s", message);
        UseCaseNotification.PresenterNotification smsPresenter = (message) -> System.out.printf("sms %s", message);
        UseCaseNotification.PresenterNotification[] notifications = {emailPresenter, whatsAppPresenter, smsPresenter};
        controller.scheduleAtFixedRate(() -> {
            var nextPos = Math.abs(new Random().nextInt()) % 3;
            notificationUseCase.notifyEveryHour(UUID.randomUUID().toString(), notifications[nextPos]);
            System.out.println();
        }, 1, 1, TimeUnit.SECONDS);
    }
}
