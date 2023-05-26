package de.dhbw.plugins.rest.model.todo;

import de.dhbw.cleanproject.domain.models.Category;
import de.dhbw.cleanproject.domain.models.todo.PriorityTodo;
import de.dhbw.cleanproject.domain.models.todo.StatusTodo;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@RequiredArgsConstructor
public class TodoModel {
    private final UUID id;
    private final String title;
    private Category categoryAggregate;
    private UUID categoryAggregateId;
    private PriorityTodo priority;
    private LocalDate deadline;
    private StatusTodo status;
    private int points;
}
