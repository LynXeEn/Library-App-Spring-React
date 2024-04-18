package mk.ukim.finki.library.web.rest;

import mk.ukim.finki.library.model.Country;
import mk.ukim.finki.library.model.DTO.CountryDTO;
import mk.ukim.finki.library.model.projections.CountryProjection;
import mk.ukim.finki.library.service.CountryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/countries")
@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class CountriesController {
    private final CountryService countryService;

    public CountriesController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping
    public List<Country> getAllCountries(){
        return countryService.allCountries();
    }

    @PostMapping
    public ResponseEntity<Country> createCountry(@RequestBody CountryDTO countryDTO){
        return countryService.createCountry(countryDTO)
                .map(country -> ResponseEntity.ok().body(country))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @GetMapping("/names")
    public List<CountryProjection> takeNamesForAllCountries(){
        return countryService.getNames();
    }
}
