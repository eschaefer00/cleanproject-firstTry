package de.dhbw.cleanproject.domain.models.user;

import de.dhbw.cleanproject.domain.models.todo.PriorityTodo;
import de.dhbw.cleanproject.domain.models.todo.StatusTodo;
import de.dhbw.cleanproject.domain.models.todo.Todo;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TodoTest {

    @Test
    public void testTodoBuilder() {
        // Arrange
        String title = "Todo Title";
        String description = "Todo Description";
        UUID categoryAggregateId = UUID.randomUUID();
        PriorityTodo priority = PriorityTodo.HIGH;
        LocalDate deadline = LocalDate.now().plusDays(7);
        StatusTodo status = StatusTodo.CREATED;
        int points = 10;
        UUID scopeAggregateId = UUID.randomUUID();

        // Act
        Todo todo = Todo.TodoBuilder.create(title, description, categoryAggregateId, priority, deadline, status, points, scopeAggregateId);

        // Assert
        assertEquals(title, todo.getTitle());
        assertEquals(description, todo.getDescription());
        assertEquals(categoryAggregateId, todo.getCategoryAggregateId());
        assertEquals(priority, todo.getPriority());
        assertEquals(deadline, todo.getDeadline());
        assertEquals(status, todo.getStatus());
        assertEquals(points, todo.getPoints());
        assertEquals(scopeAggregateId, todo.getScopeAggregateId());
    }
}