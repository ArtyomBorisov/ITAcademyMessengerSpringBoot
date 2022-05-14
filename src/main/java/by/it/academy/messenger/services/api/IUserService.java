package by.it.academy.messenger.services.api;

import by.it.academy.messenger.model.User;

import java.time.LocalDateTime;
import java.util.Collection;

public interface IUserService {
    /**
     * Регистрация пользователя
     * @param user пользователь
     */
    void signUp(User user);

    /**
     * Получение количества зарегистрированных пользователей
     * @return количество пользователей
     */
    long getCount();

    /**
     * Получение пользователя по логину
     * @param login логин
     * @return пользователь
     */
    User get(String login);

    /**
     * Получение всех пользователей
     * @return коллекция пользователей
     */
    Collection<User> getAll();

    /**
     * Обновление пользователя
     * @param user пользователь с обновленными полями
     * @param login логин
     * @return
     */
    User update(User user, String login);

    /**
     * Блокировка пользователя по координатам
     * @param login логин пользователя
     * @param lastUpdate дата/время последнего обновления
     */
    void block(String login, LocalDateTime lastUpdate);
}
