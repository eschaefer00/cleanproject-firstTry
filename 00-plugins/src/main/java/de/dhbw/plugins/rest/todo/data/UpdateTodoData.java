package de.dhbw.plugins.rest.todo.data;

import de.dhbw.cleanproject.adapter.mappers.todo.update.RawUpdateTodoData;
import de.dhbw.cleanproject.domain.models.Category;
import lombok.Data;

import java.time.LocalDate;

@Data
public class UpdateTodoData implements RawUpdateTodoData {
    //todo: validate data properly as in CreateTodoData
    private final String title;
    private String description;
    private String categoryAggregateId;
    private Category categoryAggregate;
    private String priority;
    private LocalDate deadline;
    private String status;
    private int points;
}
