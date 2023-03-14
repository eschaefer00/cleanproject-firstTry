package de.dhbw.plugins.persistence.hibernate.book.springdata;

import de.dhbw.cleanproject.domain.book.models.Book;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataBookRepository extends JpaRepository<Book, UUID> {

    List<Book> findBookByIsbn(final String isbn);

}
