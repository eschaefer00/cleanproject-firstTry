package de.dhbw.cleanproject.application.scope;

import de.dhbw.cleanproject.application.scope.data.CreateScopeData;
import de.dhbw.cleanproject.application.scope.data.UpdateScopeData;
import de.dhbw.cleanproject.domain.models.Scope;
import de.dhbw.cleanproject.domain.repositories.ScopeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ScopeApplicationService implements ScopeApplication{
    private final ScopeRepository scopeRepository;
    @Override
    public Optional<Scope> findScopeById(UUID scopeId) {
        return this.scopeRepository.findScopeById(scopeId);
    }

    @Override
    public Optional<Scope> update(Scope scope, UpdateScopeData data) {
        scopeRepository.save(scope);
        return Optional.of(scope);
    }

    @Override
    public boolean delete(UUID userId, UUID scopeId) {
        //todo: check if scope exists for user
        Optional<Scope> scope = findScopeById(scopeId);
        if(scope.isPresent()){
            this.scopeRepository.deleteById(scopeId);
            return true;
        }
        return false;
    }

    @Override
    public List<Scope> findAllScopesByUserId(UUID userId) {
        return scopeRepository.findByUserId(userId);
    }

    @Override
    public Optional<Scope> create(UUID userId, CreateScopeData data) {
        Scope scope = Scope.ScopeBuilder.create(data.getTitle(), data.getStartDate(), data.getEndDate(), data.getTodoAmount());
        scopeRepository.save(scope);
        return Optional.of(scope);
    }

}
