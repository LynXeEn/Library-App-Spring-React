package mk.ukim.finki.library.service.impl;

import mk.ukim.finki.library.model.Country;
import mk.ukim.finki.library.model.DTO.CountryDTO;
import mk.ukim.finki.library.model.projections.CountryProjection;
import mk.ukim.finki.library.repository.CountryRepository;
import mk.ukim.finki.library.service.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Country> allCountries() {
        return countryRepository.findAll();
    }

    @Override
    public Optional<Country> createCountry(CountryDTO country) {
        return Optional.of(countryRepository.save(new Country(country.getName(), country.getContinent())));
    }

    @Override
    public List<CountryProjection> getNames() {
        return countryRepository.takeNames();
    }
}
