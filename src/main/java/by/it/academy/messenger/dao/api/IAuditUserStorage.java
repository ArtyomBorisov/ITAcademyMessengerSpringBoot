package by.it.academy.messenger.dao.api;

import by.it.academy.messenger.model.AuditUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAuditUserStorage extends JpaRepository<AuditUser, Long> {
}
