package de.dhbw.plugins.rest.todo.data;

import de.dhbw.cleanproject.adapter.mappers.todo.update.RawUpdateTodoData;
import de.dhbw.cleanproject.domain.models.todo.PriorityTodo;
import de.dhbw.cleanproject.domain.models.todo.StatusTodo;
import de.dhbw.plugins.rest.customvalidatior.ValueOfEnum;
import de.dhbw.plugins.rest.customvalidatior.ValueOfLocalDate;
import de.dhbw.plugins.rest.customvalidatior.ValueOfUUID;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

@Data
public class UpdateTodoData implements RawUpdateTodoData {
    @NotEmpty(message = "The ID is required.")
    @ValueOfUUID(message = "The ID must be a UUID.")
    private final String id;
    @NotEmpty(message = "The title is required.")
    @Size(min = 2, max = 100, message = "The length of full title must be between 2 and 100 characters.")
    private final String title;
    @Size(min = 2, max = 500, message = "The length of full title must be between 2 and 500 characters.")
    private String description;
    @NotEmpty(message = "The category is required.")
    @ValueOfUUID(message = "The categoryID must be a UUID.")
    private String categoryAggregateId;
    @NotEmpty(message = "Priority is required.")
    @ValueOfEnum(enumClass = PriorityTodo.class, message = "Invalid priority type")
    private String priority;
    @ValueOfLocalDate(message = "The deadline must be a LocalDate.")
    private String deadline;
    @NotEmpty(message = "Status is required.")
    @ValueOfEnum(enumClass = StatusTodo.class, message = "Invalid status type")
    private String status;
    @PositiveOrZero(message = "The points cannot be below zero as you cannot spend more points than you own.")
    private int points;
}
