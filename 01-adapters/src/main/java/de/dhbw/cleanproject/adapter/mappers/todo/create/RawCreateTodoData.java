package de.dhbw.cleanproject.adapter.mappers.todo.create;

import de.dhbw.cleanproject.domain.models.Category;
import de.dhbw.cleanproject.domain.models.todo.PriorityTodo;
import de.dhbw.cleanproject.domain.models.todo.StatusTodo;

import java.time.LocalDate;
import java.util.UUID;

public interface RawCreateTodoData {
    String getTitle();

    String getDescription();

    String getCategoryAggregateId();
    Category getCategoryAggregate();
    String getPriority();

    LocalDate getDeadline();

    String getStatus();
    int getPoints();


}