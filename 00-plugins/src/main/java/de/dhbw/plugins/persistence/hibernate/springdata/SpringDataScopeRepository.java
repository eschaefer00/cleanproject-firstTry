package de.dhbw.plugins.persistence.hibernate.springdata;

import de.dhbw.cleanproject.domain.models.Scope;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface SpringDataScopeRepository extends JpaRepository<Scope, UUID> {
    @Query("SELECT s.id FROM Scope s WHERE s.userId = ?1")
    List<Scope> findByUserId(UUID userId);
}
