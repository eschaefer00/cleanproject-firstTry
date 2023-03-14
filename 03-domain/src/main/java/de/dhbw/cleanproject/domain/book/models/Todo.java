package de.dhbw.cleanproject.domain.book.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name="Todo")
public class Todo {
    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name="title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name="category") //number stands for category of category table -> only 1 per todo?
    private int category;

    @Column(name="priority") //number from 1 to 5 for severity
    private int priority;

    @Column(name="deadline")
    private LocalDate deadline;

    @Column(name="status") //backlog, dashboard/planned, done
    private int status;

    protected Todo() {} //default constructor for jpa

    public Todo(UUID id, String title, String description, int category, int priority, LocalDate deadline, int status) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.category = category;
        this.priority = priority;
        this.deadline = deadline;
        this.status = status;
    }

    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getCategory() {
        return category;
    }

    public int getPriority() {
        return priority;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public int getStatus() {
        return status;
    }
}
