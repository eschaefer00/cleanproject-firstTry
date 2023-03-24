package de.dhbw.cleanproject.application.todo.data;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CreateTodoData {
    private final String title;
}
