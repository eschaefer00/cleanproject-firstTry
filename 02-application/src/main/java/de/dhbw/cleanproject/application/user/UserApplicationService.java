package de.dhbw.cleanproject.application.user;

import de.dhbw.cleanproject.application.user.data.CreateUserData;
import de.dhbw.cleanproject.application.user.data.UpdateUserData;
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

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAllUsers();
    }

    @Override
    public Optional<User> findUserById(UUID id) {
        return this.userRepository.findUserById(id);
    }

    @Override
    public Optional<User> create(CreateUserData data) {
        User user = User.UserBuilder.create(data.getEmail(), data.getName(), data.getPassword(), data.getPoints(), data.getDateRegistered());
        userRepository.save(user);
        return Optional.of(user);
    }

    @Override
    public boolean existsById(UUID userId) {
        return this.userRepository.existsById(userId);
    }

    @Override
    public Optional<User> update(User user, UpdateUserData data) {
        userRepository.save(user);
        return Optional.of(user);
    }

    @Override
    public User save(User user) {
        return this.userRepository.save(user);
    }

    @Override
    public boolean delete(UUID userId) {
        Optional<User> user = findUserById(userId);
        if(user.isPresent()){
            this.userRepository.deleteById(userId);
            return true;
        }
        return false;
    }


}
