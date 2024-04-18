package mk.ukim.finki.library.service;

import mk.ukim.finki.library.model.Book;
import mk.ukim.finki.library.model.DTO.BookDTO;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> allBooks();
    Optional<Book> addNewBook(BookDTO bookDTO);
    void deleteBook(Long bookId);
    Optional<Book> updateBook(Long bookId, BookDTO bookDTO);
    Optional<Book> rentBook(Long bookId);
    void refreshMaterializedView();
}
