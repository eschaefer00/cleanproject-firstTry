package de.dhbw.plugins.persistence.hibernate.book.bridges;

import de.dhbw.cleanproject.domain.book.models.Book;
import de.dhbw.cleanproject.domain.book.repositories.BookRepository;
import de.dhbw.plugins.persistence.hibernate.book.springdata.SpringDataBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookRepositoryBridge implements BookRepository {

    private final SpringDataBookRepository springDataBookRepository;

    @Autowired
    public BookRepositoryBridge(final SpringDataBookRepository springDataBookRepository) {
        this.springDataBookRepository = springDataBookRepository;
    }

    @Override
    public List<Book> findAllBooks() {
        return this.springDataBookRepository.findAll();
    }

    @Override
    public List<Book> findBooksWithIsbn(final String isbn) {
        return this.springDataBookRepository.findBookByIsbn(isbn);
    }

    @Override
    public Book save(final Book book) {
        return this.springDataBookRepository.save(book);
    }
}
