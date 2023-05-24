package de.dhbw.cleanproject.application.user;

import de.dhbw.cleanproject.application.user.data.CreateUserData;
import de.dhbw.cleanproject.domain.models.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserApplication {
    List<User> findAllTodos();

    List<User> findAllTodosByCategoryAggregateId(UUID categoryAggregateId);

    Optional<User> findTodoById(UUID id);

    Optional<User> create(CreateUserData data);

    boolean existsById(UUID userId);

    //Optional<User> update(User user, UpdateUserData data);

    User save(User user);
}
