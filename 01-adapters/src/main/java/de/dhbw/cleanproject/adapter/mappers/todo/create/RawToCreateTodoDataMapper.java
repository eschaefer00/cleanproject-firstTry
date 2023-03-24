package de.dhbw.cleanproject.adapter.mappers.todo.create;

import de.dhbw.cleanproject.application.todo.data.CreateTodoData;
import de.dhbw.cleanproject.application.todo.data.UpdateTodoData;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class RawToCreateTodoDataMapper implements Function<RawCreateTodoData, CreateTodoData> {

    @Override
    public CreateTodoData apply(final RawCreateTodoData data) {
        return map(data);
    }

    private CreateTodoData map(final RawCreateTodoData data) {
        return CreateTodoData.builder().title(data.getTitle()).build();
    }
}
