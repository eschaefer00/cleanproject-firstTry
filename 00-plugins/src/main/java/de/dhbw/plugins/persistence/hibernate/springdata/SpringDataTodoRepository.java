package de.dhbw.plugins.persistence.hibernate.springdata;

import de.dhbw.cleanproject.domain.models.todo.PriorityTodo;
import de.dhbw.cleanproject.domain.models.todo.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface SpringDataTodoRepository extends JpaRepository<Todo, UUID> {

    @Query("SELECT t FROM Todo t WHERE t.categoryAggregateId = ?1")
    List<Todo> findByCategoryAggregateId(UUID categoryAggregateId);

    @Query("SELECT t FROM Todo t WHERE t.priority = ?1")
    List<Todo> findTodoByPriority(PriorityTodo priority);

}
