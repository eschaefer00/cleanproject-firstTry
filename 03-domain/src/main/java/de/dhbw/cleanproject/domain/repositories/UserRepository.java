package de.dhbw.cleanproject.domain.repositories;
import de.dhbw.cleanproject.domain.models.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository {

    List<User> findAllUsers();

    Optional<User> findUserById(UUID id);

    User save(User user);

}
