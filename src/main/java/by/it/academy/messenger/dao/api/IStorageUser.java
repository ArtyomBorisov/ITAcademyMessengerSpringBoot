package by.it.academy.messenger.dao.api;

import by.it.academy.messenger.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface IStorageUser extends JpaRepository<User, String> {
    @Modifying
    @Query("UPDATE\n" +
            "    User user\n" +
            "SET\n" +
            "    accessible = false\n" +
            "WHERE\n" +
            "    login = :login\n" +
            "    AND dt_update = :oldLastUpdate")
    void block(@Param("login") String login, @Param("oldLastUpdate") LocalDateTime oldLastUpdate);
}
