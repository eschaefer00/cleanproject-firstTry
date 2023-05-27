package de.dhbw.plugins.rest.model.scope.mapper;

import de.dhbw.cleanproject.domain.models.Scope;
import de.dhbw.plugins.rest.model.scope.ScopePreviewModel;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class ScopeToPreviewModelMapper implements Function<Scope, ScopePreviewModel> {
    @Override
    public ScopePreviewModel apply(final Scope scope){return map(scope);}

    private ScopePreviewModel map(final Scope scope){
        return ScopePreviewModel.builder().id(scope.getId()).title(scope.getTitle()).startDate(scope.getStartDate()).endDate(scope.getEndDate()).todoAmount(scope.getTodoAmount()).build();

    }
}
