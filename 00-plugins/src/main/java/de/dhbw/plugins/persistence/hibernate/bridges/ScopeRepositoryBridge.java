package de.dhbw.plugins.persistence.hibernate.bridges;

import de.dhbw.plugins.persistence.hibernate.springdata.SpringDataScopeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ScopeRepositoryBridge {
    private final SpringDataScopeRepository springDataScopeRepository;
    //todo implement bridge according to the other bridges
}
