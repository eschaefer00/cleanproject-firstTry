package de.dhbw.cleanproject.adapter.resources;

import de.dhbw.cleanproject.domain.models.Scope;
import de.dhbw.cleanproject.domain.models.todo.PriorityTodo;
import de.dhbw.cleanproject.domain.models.todo.StatusTodo;
import net.bytebuddy.build.Plugin;

import java.time.LocalDate;
import java.util.UUID;

public class TodoResource {
    private final String title;
    private final String description;
    private final UUID categoryAggregateId;
    private final PriorityTodo priority;
    private final LocalDate deadline;
    private final StatusTodo status;
    private final UUID scopeAggregateId;

    public TodoResource(final String title, final String description, final UUID categoryAggregateId, final PriorityTodo priority, final LocalDate deadline, final StatusTodo status, final UUID scopeAggregateId) {
        this.title = title;
        this.description = description;
        this.categoryAggregateId = categoryAggregateId;
        this.priority = priority;
        this.deadline = deadline;
        this.status = status;
        this.scopeAggregateId = scopeAggregateId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public UUID getCategoryAggregteId() {
        return categoryAggregateId;
    }

    public PriorityTodo getPriority() {
        return priority;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public StatusTodo getStatus() {
        return status;
    }

    public UUID getScopeAggregateId(){return scopeAggregateId;};

}
