package de.dhbw.cleanproject.application.user;

import de.dhbw.cleanproject.domain.book.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserApplicationService {

    private final UserRepository userRepository;

    @Autowired
    private UserApplicationService(final UserRepository userRepository){this.userRepository=userRepository;}

}
