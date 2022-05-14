package by.it.academy.messenger.dao.api;

import by.it.academy.messenger.model.Message;
import by.it.academy.messenger.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IStorageMessage extends JpaRepository<Message, Long> {
    List<Message> findByTo(User user);
    Page<Message> findByTo(User user, Pageable pageable);

    List<Message> findByTo_Login(String login);
    Page<Message> findByTo_Login(String login, Pageable pageable);
}
