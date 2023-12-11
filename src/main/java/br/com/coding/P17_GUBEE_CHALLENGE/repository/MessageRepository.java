package br.com.coding.P17_GUBEE_CHALLENGE.repository;

import br.com.coding.P17_GUBEE_CHALLENGE.annotation.Transactional;
import java.util.UUID;

public interface MessageRepository {
    @Transactional
    void saveMessage(UUID id, String message) throws NoSuchMethodException;
}
