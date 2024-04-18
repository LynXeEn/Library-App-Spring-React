package mk.ukim.finki.library.service.impl;

import mk.ukim.finki.library.model.Author;
import mk.ukim.finki.library.model.Book;
import mk.ukim.finki.library.model.DTO.BookDTO;
import mk.ukim.finki.library.model.enums.BookCategory;
import mk.ukim.finki.library.model.event.BookUnavailableEvent;
import mk.ukim.finki.library.model.exceptions.InvalidIdException;
import mk.ukim.finki.library.repository.AuthorRepository;
import mk.ukim.finki.library.repository.BookRepository;
import mk.ukim.finki.library.repository.views.BookViewRepository;
import mk.ukim.finki.library.service.BookService;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final BookViewRepository bookViewRepository;
    private final ApplicationEventPublisher applicationEventPublisher;

    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository, BookViewRepository bookViewRepository, ApplicationEventPublisher applicationEventPublisher) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.bookViewRepository = bookViewRepository;
        this.applicationEventPublisher = applicationEventPublisher;
    }

    @Override
    public List<Book> allBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> addNewBook(BookDTO bookDTO) {
        Author author = authorRepository.findById(bookDTO.getAuthorId())
                .orElseThrow(() -> new InvalidIdException(bookDTO.getAuthorId()));
        return Optional.of(bookRepository
                .save(new Book(bookDTO.getName(), BookCategory.valueOf(bookDTO.getCategory()), author, bookDTO.getAvailableCopies())));
    }

    @Override
    public void deleteBook(Long bookId) {
        bookRepository.deleteById(bookId);
    }

    @Override
    public Optional<Book> updateBook(Long bookId, BookDTO bookDTO) {
        Book book = bookRepository.findById(bookId).orElseThrow(() -> new InvalidIdException(bookId));
        book.setName(bookDTO.getName());
        book.setAuthor(authorRepository.findById(bookDTO.getAuthorId()).orElseThrow());
        book.setCategory(BookCategory.valueOf(bookDTO.getCategory()));
        book.setAvailableCopies(bookDTO.getAvailableCopies());

        return Optional.of(bookRepository.save(book));
    }

    @Override
    public Optional<Book> rentBook(Long bookId) {
        Book book = bookRepository.findById(bookId).orElseThrow(() -> new InvalidIdException(bookId));

        if (book.getAvailableCopies() <= 0){
            applicationEventPublisher.publishEvent(new BookUnavailableEvent(book, "You cannot rent this book because it's unavailable"));
        } else {
            book.setAvailableCopies(book.getAvailableCopies() - 1);
        }

        return Optional.of(bookRepository.save(book));
    }

    @Override
    public void refreshMaterializedView() {
        bookViewRepository.refreshMaterializedView();;
    }
}
