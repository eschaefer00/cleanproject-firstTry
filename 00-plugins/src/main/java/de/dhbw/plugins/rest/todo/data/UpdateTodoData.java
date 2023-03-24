package de.dhbw.plugins.rest.todo.data;

import de.dhbw.cleanproject.adapter.mappers.todo.update.RawUpdateTodoData;
import lombok.Data;

@Data
public class UpdateTodoData implements RawUpdateTodoData {
    private final String title;
}
