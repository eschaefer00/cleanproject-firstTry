package de.dhbw.plugins.persistence.hibernate.book.bridges;

import de.dhbw.cleanproject.domain.book.models.User;
import de.dhbw.cleanproject.domain.book.repositories.UserRepository;
import de.dhbw.plugins.persistence.hibernate.book.springdata.SpringDataUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class UserRepositoryBridge implements UserRepository {

    private final SpringDataUserRepository springDataUserRepository;

    @Autowired
    public UserRepositoryBridge(final SpringDataUserRepository springDataUserRepository) {
        this.springDataUserRepository = springDataUserRepository;
    }

    public List<User> findAllUsers(){return this.springDataUserRepository.findAll();}

    public User findUserById(UUID id){return this.springDataUserRepository.findUserById(id);}

    public User save(User user){return this.springDataUserRepository.save(user);}
}
