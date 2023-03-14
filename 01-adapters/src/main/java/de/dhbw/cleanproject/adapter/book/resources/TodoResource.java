package de.dhbw.cleanproject.adapter.book.resources;

import java.time.LocalDate;

public class TodoResource {
    private final String title;
    private final String description;
    private final int category;
    private final int priority;
    private final LocalDate deadline;
    private final int status;

    public TodoResource(final String title, final String description, final int category, final int priority, final LocalDate deadline, final int status) {
        this.title = title;
        this.description = description;
        this.category = category;
        this.priority = priority;
        this.deadline = deadline;
        this.status = status;
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
