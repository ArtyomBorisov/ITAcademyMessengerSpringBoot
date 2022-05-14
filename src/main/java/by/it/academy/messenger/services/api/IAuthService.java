package by.it.academy.messenger.services.api;

public interface IAuthService {
    /**
     * Аутентификация пользователя по логину/паролю
     * @param login - логин
     * @param password - пароль
     * @return true, если аутентификация пройдена
     *         false, если не пройдена
     */
    boolean authentication(String login, String password);
}
