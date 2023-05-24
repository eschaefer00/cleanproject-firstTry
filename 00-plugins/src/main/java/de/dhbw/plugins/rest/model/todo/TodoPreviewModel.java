package de.dhbw.plugins.rest.model.todo;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@Getter
@RequiredArgsConstructor
@Builder
public class TodoPreviewModel {
    private final UUID id;
    private final String title;
    /*
    private String description;
    private UUID categoryAggregateId;
    private Category categoryAggregate;
    private PriorityTodo priority;
    private LocalDate deadline;
    private StatusTodo status;
    private int points;

     */
}
