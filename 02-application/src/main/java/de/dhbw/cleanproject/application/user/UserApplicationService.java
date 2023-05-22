package de.dhbw.cleanproject.application.user;

import de.dhbw.cleanproject.domain.models.User;
import de.dhbw.cleanproject.domain.models.todo.Todo;
import de.dhbw.cleanproject.domain.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ServiceLoader;
import java.util.UUID;

@Service
public class UserApplicationService {

    private final UserRepository userRepository;

    @Autowired
    private UserApplicationService(final UserRepository userRepository){this.userRepository=userRepository;}

    public List<User> findAll() {
        return userRepository.findAllUsers();
    }

}
