package de.dhbw.cleanproject.adapter.mappers.todo.update;

import de.dhbw.cleanproject.application.todo.data.UpdateTodoData;
import de.dhbw.cleanproject.domain.models.todo.PriorityTodo;
import de.dhbw.cleanproject.domain.models.todo.StatusTodo;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;
import java.util.function.Function;

@Component
public class RawToUpdateTodoDataMapper implements Function<RawUpdateTodoData, UpdateTodoData> {

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    @Override
    public UpdateTodoData apply(final RawUpdateTodoData data) {
        return map(data);
    }

    private UpdateTodoData map(final RawUpdateTodoData data) {

        UpdateTodoData.UpdateTodoDataBuilder builder = UpdateTodoData.builder();

        if (data.getCategoryAggregateId() != null) {
            builder.categoryAggregateId(UUID.fromString(data.getCategoryAggregateId()));
        }

        try {
            PriorityTodo priority = PriorityTodo.valueOf(data.getPriority());
            builder.priority(priority);
        } catch (IllegalArgumentException | NullPointerException ignored) {
        }

        builder.deadline(LocalDate.parse(data.getDeadline(), formatter));

        try {
            StatusTodo status = StatusTodo.valueOf(data.getStatus());
            builder.status(status);
        } catch (IllegalArgumentException | NullPointerException ignored) {
        }

        builder.title(data.getTitle()).description(data.getDescription()).points(data.getPoints());

        return builder.build();
    }

}