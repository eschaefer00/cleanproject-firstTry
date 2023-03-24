package de.dhbw.cleanproject.adapter.mappers;

import de.dhbw.cleanproject.adapter.resources.BookResource;
import de.dhbw.cleanproject.domain.models.Book;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class BookToBookResourceMapper implements Function<Book, BookResource> {

    @Override
    public BookResource apply(final Book book) {
        return map(book);
    }

    private BookResource map(final Book book) {
        return new BookResource(book.getIsbn(), book.getTitle(), book.getAuthor(), book.getYearOfPublication().getYear());
    }
}