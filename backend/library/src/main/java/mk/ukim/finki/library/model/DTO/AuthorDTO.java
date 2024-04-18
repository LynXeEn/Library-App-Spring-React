package mk.ukim.finki.library.model.DTO;

import jakarta.persistence.ManyToOne;
import lombok.Data;
import mk.ukim.finki.library.model.Country;

@Data
public class AuthorDTO {
    private String name;
    private String surName;
    private Long countryId;
}
