package de.dhbw.plugins.persistence.hibernate.bridges;

import de.dhbw.cleanproject.domain.models.Scope;
import de.dhbw.cleanproject.domain.repositories.ScopeRepository;
import de.dhbw.plugins.persistence.hibernate.springdata.SpringDataScopeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class ScopeRepositoryBridge implements ScopeRepository {
    private final SpringDataScopeRepository springDataScopeRepository;

    @Override
    public Optional<Scope> findScopeById(UUID scopeId) {
        return this.springDataScopeRepository.findById(scopeId);
    }

    @Override
    public void save(Scope scope) {
        this.springDataScopeRepository.save(scope);
    }

    @Override
    public void deleteById(UUID scopeId) {
        this.springDataScopeRepository.deleteById(scopeId);
    }

    @Override
    public List<Scope> findByUserId(UUID userId) {
        return this.springDataScopeRepository.findByUserId();
    }
}
