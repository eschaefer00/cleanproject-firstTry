package de.dhbw.plugins.persistence.hibernate.book.springdata;

import de.dhbw.cleanproject.domain.book.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface SpringDataUserRepository extends JpaRepository<User, UUID> {

    List<User> findAllUsers();

    User findUserById(UUID id);

}
