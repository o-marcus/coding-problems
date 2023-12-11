package br.com.coding.P17_GUBEE_CHALLENGE.factory;

import br.com.coding.P17_GUBEE_CHALLENGE.repository.MessageRepository;

public abstract interface MessageFactoryDatabase {
    MessageRepository newInstance();
}
