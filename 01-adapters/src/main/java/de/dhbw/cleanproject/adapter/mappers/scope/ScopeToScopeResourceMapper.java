package de.dhbw.cleanproject.adapter.mappers.scope;

import de.dhbw.cleanproject.adapter.resources.ScopeResource;
import de.dhbw.cleanproject.domain.models.Scope;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class ScopeToScopeResourceMapper implements Function<Scope, ScopeResource> {
    @Override
    public ScopeResource apply(final Scope scope){
        return map(scope);
    }

    private ScopeResource map(final Scope scope){
        return new ScopeResource(scope.getId(), scope.getTitle(), scope.getStartDate(), scope.getEndDate(), scope.getTodoAmount(), scope.getUserId());
    }
}
