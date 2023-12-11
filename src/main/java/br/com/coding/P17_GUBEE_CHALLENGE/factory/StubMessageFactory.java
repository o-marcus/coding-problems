package br.com.coding.P17_GUBEE_CHALLENGE.factory;

import br.com.coding.P17_GUBEE_CHALLENGE.repository.MessageRepository;
import br.com.coding.P17_GUBEE_CHALLENGE.repository.StubMessageRepository;

public class StubMessageFactory implements MessageFactoryDatabase {
    @Override
    public MessageRepository newInstance() {
        return new StubMessageRepository();
    }
}
