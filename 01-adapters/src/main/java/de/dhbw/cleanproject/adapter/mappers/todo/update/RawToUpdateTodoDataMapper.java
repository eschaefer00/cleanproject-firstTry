package de.dhbw.cleanproject.adapter.mappers.todo.update;

import de.dhbw.cleanproject.application.todo.data.UpdateTodoData;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class RawToUpdateTodoDataMapper implements Function<RawUpdateTodoData, UpdateTodoData> {

    @Override
    public UpdateTodoData apply(final RawUpdateTodoData data) {
        return map(data);
    }

    private UpdateTodoData map(final RawUpdateTodoData data) {
        return UpdateTodoData.builder().title(data.getTitle()).build();
    }
}
