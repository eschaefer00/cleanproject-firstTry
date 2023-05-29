package de.dhbw.cleanproject.application.todo.data;

import de.dhbw.cleanproject.domain.models.todo.PriorityTodo;
import de.dhbw.cleanproject.domain.models.todo.StatusTodo;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Builder
@Data
public class CreateTodoData {
    private final String title;
    private final String description;
    private final UUID categoryAggregateId;
    private final PriorityTodo priority;
    private final LocalDate deadline;
    private final StatusTodo status;
    private final int points;
    private final UUID scopeAggregateId;
}
