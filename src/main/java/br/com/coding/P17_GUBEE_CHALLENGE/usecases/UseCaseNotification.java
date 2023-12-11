package br.com.coding.P17_GUBEE_CHALLENGE.usecases;

public interface UseCaseNotification {

    void notifyEveryHour(String customerId, PresenterNotification presenter);

    @FunctionalInterface
    interface PresenterNotification {
        void notification(String message);
    }
}


