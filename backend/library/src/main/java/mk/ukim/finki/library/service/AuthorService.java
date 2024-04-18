package mk.ukim.finki.library.service;

import mk.ukim.finki.library.model.Author;
import mk.ukim.finki.library.model.DTO.AuthorDTO;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
    List<Author> allAuthors();
    Optional<Author> createAuthor(AuthorDTO authorDTO);
}
