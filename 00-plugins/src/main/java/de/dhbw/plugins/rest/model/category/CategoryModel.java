package de.dhbw.plugins.rest.model.category;

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
}


