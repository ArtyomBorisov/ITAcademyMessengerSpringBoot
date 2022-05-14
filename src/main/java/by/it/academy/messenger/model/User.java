package by.it.academy.messenger.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(schema = "app", name = "user")
public class User implements Serializable {
    private String login;
    private String password;
    private String name;
    private LocalDate birthday;
    private LocalDateTime registration;
    private LocalDateTime lastUpdate;
    private boolean accessible;

    public User() {
        this.accessible = true;
    }

    public User(String login, String password, String name, LocalDate birthday) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.birthday = birthday;
        this.accessible = true;
    }

    @Id
    @Column(name = "login")
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Column(name = "password", nullable = false)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "fio", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "birthday")
    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    @Column(name = "dt_reg", nullable = false)
    public LocalDateTime getRegistration() {
        return registration;
    }

    public void setRegistration(LocalDateTime registration) {
        this.registration = registration;
    }

    @Column(name = "dt_update", nullable = false)
    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Column(name = "accessible", nullable = false)
    public boolean isAccessible() {
        return accessible;
    }

    public void setAccessible(boolean accessible) {
        this.accessible = accessible;
    }
}
