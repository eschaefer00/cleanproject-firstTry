package de.dhbw.plugins.rest.model.todo;

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
    private final String description;
    private final UUID categoryAggregateId;
    private final PriorityTodo priority;
    private final LocalDate deadline;
    private final StatusTodo status;
    private final int points;

}
