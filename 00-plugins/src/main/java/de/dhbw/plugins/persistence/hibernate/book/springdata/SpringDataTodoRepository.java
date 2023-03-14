package de.dhbw.plugins.persistence.hibernate.book.springdata;

import de.dhbw.cleanproject.domain.book.models.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface SpringDataTodoRepository extends JpaRepository<Todo, UUID> {
    Todo findTodoById(final UUID id);

    List<Todo> findAllTodos();

    List<Todo> findTodoByCategory(int category);//or real text? how would that link work then


}
