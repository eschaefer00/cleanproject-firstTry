package de.dhbw.cleanproject.domain.book.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name="category")
public class Category {

    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name="name")
    private String name;

    @Column(name="description")
    private String description;

    protected Category(){}

    public Category(UUID id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
