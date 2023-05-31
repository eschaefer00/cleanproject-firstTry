package de.dhbw.cleanproject.adapter.resources;

import java.time.LocalDate;
import java.util.UUID;

public class ScopeResource {
    private final UUID id;
    private final String title;
    private final LocalDate startDate;
    private final LocalDate endDate;
    private final int todoAmount;
    private final UUID userId;

    public ScopeResource(final UUID id, final String title, LocalDate startDate, LocalDate endDate, int todoAmount, UUID userId) {
        this.id = id;
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
        this.todoAmount = todoAmount;
        this.userId = userId;
    }

    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public int getTodoAmount() {
        return todoAmount;
    }
    public UUID getUserId() {return userId;}
}


