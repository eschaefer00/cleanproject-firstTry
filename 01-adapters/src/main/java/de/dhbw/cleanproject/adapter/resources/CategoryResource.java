package de.dhbw.cleanproject.adapter.resources;

import de.dhbw.cleanproject.domain.models.User;

import java.util.UUID;

public class CategoryResource {
    private final String name;
    private final String description;
    private final UUID userId;

    public CategoryResource(final String name, final String description, final UUID userId) {
        this.name = name;
        this.description = description;
        this.userId = userId;
    }

    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public UUID getUserId(){return userId;}
}
