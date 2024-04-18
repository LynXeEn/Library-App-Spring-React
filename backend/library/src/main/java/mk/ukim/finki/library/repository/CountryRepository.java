package mk.ukim.finki.library.repository;

import mk.ukim.finki.library.model.Country;
import mk.ukim.finki.library.model.projections.CountryProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CountryRepository extends JpaRepository<Country, Long> {

    @Query("select c.name from Country c")
    List<CountryProjection> takeNames();
}
