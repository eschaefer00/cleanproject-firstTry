package de.dhbw.plugins.rest.todos.data;

import de.dhbw.cleanproject.adapter.mappers.todo.create.RawCreateTodoData;
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
public class CreateTodoData implements RawCreateTodoData {
    @NotEmpty(message = "The ID is required.")
    @ValueOfUUID(message = "The ID must be a UUID.")
    private String id;

    @NotEmpty(message = "The title is required.")
    @Size(min = 2, max = 100, message = "The length of full title must be between 2 and 100 characters.")
    private String title;

    @Size(min = 2, max = 500, message = "The length of the description must be between 2 and 500 characters.")
    private String description;

    @NotEmpty(message = "The categoryID is required.")
    @ValueOfUUID(message = "The bookingCategoryId is invalid UUID.")
    private String categoryAggregateId;

    @NotEmpty(message = "Priority is required.")
    @ValueOfEnum(enumClass = PriorityTodo.class, message = "Invalid type for a priority.")
    private String priority;

    @ValueOfLocalDate(message = "The deadline must be a LocalDate.")
    private String deadline;

    @NotEmpty(message = "Status is required.")
    @ValueOfEnum(enumClass = StatusTodo.class, message = "Invalid type for status.")
    private String status;

    @PositiveOrZero(message = "Points cannot get below zero as you cannot spend more points than you own.")
    private int points;
}
