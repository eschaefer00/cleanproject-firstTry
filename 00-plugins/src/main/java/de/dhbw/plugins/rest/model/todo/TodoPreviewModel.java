package de.dhbw.plugins.rest.model.todo;

import de.dhbw.cleanproject.domain.models.Category;
import de.dhbw.cleanproject.domain.models.todo.PriorityTodo;
import de.dhbw.cleanproject.domain.models.todo.StatusTodo;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@RequiredArgsConstructor
@Builder
public class TodoPreviewModel {
    private final UUID id;
    private final String title;

    private String description;
    private UUID categoryAggregateId;
    private Category categoryAggregate;
    private PriorityTodo priority;
    private LocalDate deadline;
    private StatusTodo status;
    private int points;

}
