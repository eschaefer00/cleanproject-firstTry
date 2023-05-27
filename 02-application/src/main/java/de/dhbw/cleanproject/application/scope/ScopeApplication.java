package de.dhbw.cleanproject.application.scope;

import de.dhbw.cleanproject.application.scope.data.CreateScopeData;
import de.dhbw.cleanproject.application.scope.data.UpdateScopeData;
import de.dhbw.cleanproject.domain.models.Scope;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ScopeApplication {
    Optional<Scope> findScopeById(UUID scopeId);

    Optional<Scope> update(Scope scope, UpdateScopeData apply);

    boolean delete(UUID userId, UUID scopeId);

    List<Scope> findAllScopesByUserId(UUID userId);

    Optional<Scope> create(UUID userId, CreateScopeData data);

}
