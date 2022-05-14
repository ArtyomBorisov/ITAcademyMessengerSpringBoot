package by.it.academy.messenger.services.api;

import by.it.academy.messenger.model.Message;
import by.it.academy.messenger.model.User;

import java.util.List;

public interface IMessageService {
    /**
     * Получение списка сообщений по переданному пользователю
     * @param currentUser пользователь
     * @return список сообщений
     */
    List<Message> get(User currentUser);

    /**
     * Получение списка сообщений пользователю по его логину
     * @param currentLoginUser логин
     * @return список сообщений
     */
    List<Message> get(String currentLoginUser);

    /**
     * Сохранение сообщения
     * @param message сообщение
     */
    void add(Message message);

    /**
     * Получение количества всех отправленных сообщений
     * @return количество сообщений
     */
    long getCount();
}
