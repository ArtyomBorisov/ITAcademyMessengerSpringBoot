package by.it.academy.messenger.services;

import by.it.academy.messenger.dao.api.IStorageMessage;
import by.it.academy.messenger.model.Message;
import by.it.academy.messenger.model.User;
import by.it.academy.messenger.services.api.IMessageService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class MessageService implements IMessageService {

    private final IStorageMessage storageMessage;

    public MessageService(IStorageMessage storageMessage) {
        this.storageMessage = storageMessage;
    }

    @Override
    public List<Message> get(User currentUser) {
        return this.storageMessage.findByTo(currentUser);
    }

    @Override
    public List<Message> get(String currentLoginUser) {
        return this.storageMessage.findByTo_Login(currentLoginUser);
    }

    @Override
    @Transactional
    public void add(Message message) {
        this.validationForMessage(message);
        LocalDateTime now = LocalDateTime.now();
        message.setTimeSending(now);
        message.setLastUpdate(now);
        this.storageMessage.save(message);
    }

    @Override
    public long getCount() {
        return this.storageMessage.count();
    }

    private void validationForMessage(Message message) {
        if (message.getTo() == null) {
            throw new IllegalArgumentException("Нет такого пользователя");
        }
    }
}
