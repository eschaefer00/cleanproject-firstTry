package de.dhbw.cleanproject.application.todo.data;

import de.dhbw.cleanproject.domain.models.Category;
import de.dhbw.cleanproject.domain.models.todo.PriorityTodo;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Builder
@Data
public class UpdateTodoData {
    private final String title;
    private final String description;
    private final UUID categoryAggregateId;
    private final Category categoryAggregate;
    private final PriorityTodo priority;
    private final LocalDate deadline;
}
