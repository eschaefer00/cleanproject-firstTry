package de.dhbw.plugins.persistence.hibernate.bridges;

import de.dhbw.cleanproject.domain.models.User;
import de.dhbw.cleanproject.domain.repositories.UserRepository;
import de.dhbw.plugins.persistence.hibernate.springdata.SpringDataUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class UserRepositoryBridge implements UserRepository {
    private final SpringDataUserRepository springDataUserRepository;

    @Override
    public List<User> findAllUsers(){return this.springDataUserRepository.findAll();}

    @Override
    public Optional<User> findUserById(UUID id){return this.springDataUserRepository.findById(id);}

    @Override
    public User save(User user){return this.springDataUserRepository.save(user);}

    @Override
    public boolean existsById(UUID userId) {
        return this.springDataUserRepository.existsById(userId);
    }

    @Override
    public void deleteById(UUID userId) {
        this.springDataUserRepository.deleteById(userId);
    }
}
