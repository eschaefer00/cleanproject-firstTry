package de.dhbw.cleanproject.domain.repositories;

import de.dhbw.cleanproject.domain.models.Book;

import java.util.List;

public interface BookRepository {

    List<Book> findAllBooks();

    List<Book> findBooksWithIsbn(String isbn);

    Book save(Book book);
}
