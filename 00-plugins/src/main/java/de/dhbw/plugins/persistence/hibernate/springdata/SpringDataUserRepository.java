package de.dhbw.plugins.persistence.hibernate.springdata;

import de.dhbw.cleanproject.domain.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface SpringDataUserRepository extends JpaRepository<User, UUID> {

}
