package by.it.academy.messenger.services;

import by.it.academy.messenger.dao.api.IAuditUserStorage;
import by.it.academy.messenger.dao.api.IStorageUser;
import by.it.academy.messenger.model.AuditUser;
import by.it.academy.messenger.model.User;
import by.it.academy.messenger.services.api.IUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Collection;

@Service
@Transactional(readOnly = true)
public class UserService implements IUserService {

    private final IStorageUser storageUser;
    private final IAuditUserStorage auditUserStorage;

    public UserService(IStorageUser storageUser, IAuditUserStorage auditUserStorage) {
        this.storageUser = storageUser;
        this.auditUserStorage = auditUserStorage;
    }

    @Override
    @Transactional
    public void signUp(User user) {
        this.validationForSignUp(user);
        LocalDateTime now = LocalDateTime.now();

        user.setRegistration(now);
        user.setLastUpdate(now);
        this.storageUser.save(user);

        AuditUser auditUser = new AuditUser();
        auditUser.setDtCreate(now);
        auditUser.setText("Регистрация");
        auditUser.setUser(user);
        auditUser.setLastUpdate(now);
        this.auditUserStorage.save(auditUser);

    }

    private void validationForSignUp(User user){
        String errorMessage = "";
        if (this.nullOrEmpty(user.getLogin())){
            errorMessage += "Логин обязателен для заполнения. ";
        }
        if (this.nullOrEmpty(user.getPassword())){
            errorMessage += "Пароль обязателен для заполнения. ";
        }
        if (this.nullOrEmpty(user.getName())){
            errorMessage += "ФИО обязательно для заполнения. ";
        }
        if (!errorMessage.isEmpty()){
            throw new IllegalArgumentException(errorMessage);
        }
    }

    private boolean nullOrEmpty(String str){
        return str == null || str.isEmpty();
    }

    @Override
    public long getCount() {
        return this.storageUser.count();
    }

    @Override
    public User get(String login) {
        if (this.storageUser.findById(login).isPresent() && this.storageUser.findById(login).get().isAccessible()) {
            return this.storageUser.findById(login).get();
        } else {
            return null;
        }
    }

    @Override
    public Collection<User> getAll() {
        return this.storageUser.findAll();
    }

    @Override
    @Transactional
    public User update(User user, String login) {
        User tempUser = this.get(login);
        if (!this.nullOrEmpty(user.getPassword())) {
            tempUser.setPassword(user.getPassword());
        }
        if (!this.nullOrEmpty(user.getName())) {
            tempUser.setName(user.getName());
        }
        tempUser.setBirthday(user.getBirthday());
        tempUser.setLastUpdate(LocalDateTime.now());

        LocalDateTime now = LocalDateTime.now();
        AuditUser auditUser = new AuditUser();
        auditUser.setDtCreate(now);
        auditUser.setText("Обновление");
        auditUser.setUser(user);
        auditUser.setAuthor(user);
        auditUser.setLastUpdate(now);
        this.auditUserStorage.save(auditUser);

        return this.storageUser.save(tempUser);
    }

    @Override
    @Transactional
    public void block(String login, LocalDateTime lastUpdate) {
        User temp = this.storageUser.getById(login);
        LocalDateTime now = LocalDateTime.now();
        AuditUser auditUser = new AuditUser();
        auditUser.setDtCreate(now);
        auditUser.setText("Удаление");
        auditUser.setUser(temp);
        auditUser.setAuthor(temp);
        auditUser.setLastUpdate(now);

        this.auditUserStorage.save(auditUser);
        this.storageUser.block(login, lastUpdate);
    }
}
