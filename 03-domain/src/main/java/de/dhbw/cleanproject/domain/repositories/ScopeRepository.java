package de.dhbw.cleanproject.domain.repositories;

import de.dhbw.cleanproject.domain.models.Scope;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ScopeRepository {
    Optional<Scope> findScopeById(UUID scopeId);

    void save(Scope scope);

    void deleteById(UUID scopeId);

    List<Scope> findByUserId(UUID userId);

}
