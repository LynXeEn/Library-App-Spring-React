package mk.ukim.finki.library.service;

import mk.ukim.finki.library.model.Country;
import mk.ukim.finki.library.model.DTO.CountryDTO;
import mk.ukim.finki.library.model.projections.CountryProjection;

import java.util.List;
import java.util.Optional;

public interface CountryService {
    List<Country> allCountries();
    Optional<Country> createCountry(CountryDTO country);
    List<CountryProjection> getNames();
}
