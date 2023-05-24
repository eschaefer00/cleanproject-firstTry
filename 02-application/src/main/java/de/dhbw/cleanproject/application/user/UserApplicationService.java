package de.dhbw.cleanproject.application.user;

import de.dhbw.cleanproject.application.user.data.CreateUserData;
import de.dhbw.cleanproject.domain.models.User;
import de.dhbw.cleanproject.domain.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserApplicationService implements UserApplication {

    private final UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAllUsers();
    }

    @Override
    public List<User> findAllTodos() {
        return null;
    }

    @Override
    public List<User> findAllTodosByCategoryAggregateId(UUID categoryAggregateId) {
        return null;
    }

    @Override
    public Optional<User> findTodoById(UUID id) {
        return Optional.empty();
    }

    @Override
    public Optional<User> create(CreateUserData data) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(UUID userId) {
        return false;
    }

    @Override
    public User save(User user) {
        return null;
    }
}
