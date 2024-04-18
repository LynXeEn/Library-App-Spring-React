package mk.ukim.finki.library.service.impl;

import mk.ukim.finki.library.model.Author;
import mk.ukim.finki.library.model.Country;
import mk.ukim.finki.library.model.DTO.AuthorDTO;
import mk.ukim.finki.library.model.exceptions.InvalidIdException;
import mk.ukim.finki.library.repository.AuthorRepository;
import mk.ukim.finki.library.repository.CountryRepository;
import mk.ukim.finki.library.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;
    private final CountryRepository countryRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository, CountryRepository countryRepository) {
        this.authorRepository = authorRepository;
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Author> allAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public Optional<Author> createAuthor(AuthorDTO authorDTO) {
        Country country = countryRepository.findById(authorDTO.getCountryId())
                .orElseThrow(() -> new InvalidIdException(authorDTO.getCountryId()));
        return Optional.of(authorRepository.save(new Author(authorDTO.getName(), authorDTO.getSurName(), country)));
    }
}
