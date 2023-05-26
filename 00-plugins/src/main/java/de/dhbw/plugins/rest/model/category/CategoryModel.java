package de.dhbw.plugins.rest.model.category;

import de.dhbw.cleanproject.domain.models.User;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@Getter
@RequiredArgsConstructor
public class CategoryModel {
    private final UUID id;
    private final String title;
    private final String description;
    private final UUID userId;
    private final User user;
}


