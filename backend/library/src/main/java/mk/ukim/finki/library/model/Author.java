package mk.ukim.finki.library.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;

@Entity
@Getter
public class Author {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String surName;
    @ManyToOne
    private Country country;

    public Author(String name, String surName, Country country) {
        this.name = name;
        this.surName = surName;
        this.country = country;
    }

    public Author() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
