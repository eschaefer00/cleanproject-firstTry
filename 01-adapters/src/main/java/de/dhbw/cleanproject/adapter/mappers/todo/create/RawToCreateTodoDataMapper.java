package de.dhbw.cleanproject.adapter.mappers.todo.create;

import de.dhbw.cleanproject.application.category.CategoryApplicationService;
import de.dhbw.cleanproject.application.todo.data.CreateTodoData;
import de.dhbw.cleanproject.domain.models.todo.PriorityTodo;
import de.dhbw.cleanproject.domain.models.todo.StatusTodo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;
import java.util.function.Function;

@Component
@RequiredArgsConstructor
public class RawToCreateTodoDataMapper implements Function<RawCreateTodoData, CreateTodoData> {
    private final CategoryApplicationService categoryApplicationService;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    @Override
    public CreateTodoData apply(final RawCreateTodoData data) { return map(data); }

    private CreateTodoData map(final RawCreateTodoData data) {
        CreateTodoData.CreateTodoDataBuilder builder = CreateTodoData.builder();
        if(data.getCategoryAggregateId() != null){
            builder.categoryAggregateId(UUID.fromString(data.getCategoryAggregateId()));
        }

        try {
            PriorityTodo priority = PriorityTodo.valueOf(data.getPriority());
            builder.priority(priority);
        }catch (IllegalArgumentException|NullPointerException ignored){}

        builder.deadline(LocalDate.parse(data.getDeadline(), formatter));

        try {
            StatusTodo status = StatusTodo.valueOf(data.getStatus());
            builder.status(status);
        }catch (IllegalArgumentException|NullPointerException ignored){}

        builder.title(data.getTitle()).description(data.getDescription()).points(data.getPoints());

        return builder.build();
    }
}
