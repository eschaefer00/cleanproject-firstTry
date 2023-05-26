package de.dhbw.cleanproject.adapter.resources;

import de.dhbw.cleanproject.domain.models.User;

import java.util.UUID;

public class CategoryResource {
    private final String name;
    private final String description;
    private final UUID userId;
    private final User user;

    public CategoryResource(final String name, final String description, final UUID userId, final User user) {
        this.name = name;
        this.description = description;
        this.userId = userId;
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public UUID getUserId(){return userId;}
    public User getUser(){return user;}
}
