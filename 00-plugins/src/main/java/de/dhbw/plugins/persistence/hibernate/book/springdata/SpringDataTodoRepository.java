package de.dhbw.plugins.persistence.hibernate.book.springdata;

import de.dhbw.cleanproject.domain.book.models.Book;
import de.dhbw.cleanproject.domain.book.models.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface SpringDataTodoRepository extends JpaRepository<Todo, UUID> {
    List<Todo> findBookById(final UUID id);
}
