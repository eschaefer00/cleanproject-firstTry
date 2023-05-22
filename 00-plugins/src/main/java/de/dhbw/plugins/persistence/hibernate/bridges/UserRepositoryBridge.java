package de.dhbw.plugins.persistence.hibernate.bridges;

import de.dhbw.cleanproject.domain.models.User;
import de.dhbw.cleanproject.domain.repositories.UserRepository;
import de.dhbw.plugins.persistence.hibernate.springdata.SpringDataUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class UserRepositoryBridge implements UserRepository {

    private final SpringDataUserRepository springDataUserRepository;

    @Autowired
    public UserRepositoryBridge(final SpringDataUserRepository springDataUserRepository) {
        this.springDataUserRepository = springDataUserRepository;
    }

    public List<User> findAllUsers(){return this.springDataUserRepository.findAll();}

    public Optional<User> findUserById(UUID id){return this.springDataUserRepository.findById(id);}

    public User save(User user){return this.springDataUserRepository.save(user);}
}
