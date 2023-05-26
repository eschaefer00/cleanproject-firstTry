package de.dhbw.plugins.rest.model.user.mapper;

import de.dhbw.cleanproject.domain.models.User;
import de.dhbw.plugins.rest.model.user.UserPreviewModel;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class UserToPreviewModelMapper implements Function<User, UserPreviewModel> {
    @Override
    public UserPreviewModel apply(final User resource) {
        return map(resource);
    }

    private UserPreviewModel map(final User resource) {
        return UserPreviewModel.builder().id(resource.getId()).name(resource.getName()).email(resource.getEmail()).password(resource.getPassword()).points(resource.getPoints()).timeRegistered(resource.getDateRegistered()).build();
    }
}