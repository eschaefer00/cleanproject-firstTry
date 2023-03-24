package de.dhbw.cleanproject.adapter.resources;

public class CategoryResource {

    private final String name;

    private final String description;

    public CategoryResource(final String name, final String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}