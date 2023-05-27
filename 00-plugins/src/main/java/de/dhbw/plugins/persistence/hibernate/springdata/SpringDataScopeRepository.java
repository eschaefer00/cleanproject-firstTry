package de.dhbw.plugins.persistence.hibernate.springdata;

import de.dhbw.cleanproject.domain.models.Scope;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SpringDataScopeRepository extends JpaRepository<Scope, UUID> {
    //todo: implement when there are new functions that are not part of the standard library
}
