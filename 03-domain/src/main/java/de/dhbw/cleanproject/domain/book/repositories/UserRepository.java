package de.dhbw.cleanproject.domain.book.repositories;
import de.dhbw.cleanproject.domain.book.models.User;

import java.util.List;
import java.util.UUID;

public interface UserRepository {

    List<User> findAllUsers();

    User findUserById(UUID id);

    User save(User user);

}
