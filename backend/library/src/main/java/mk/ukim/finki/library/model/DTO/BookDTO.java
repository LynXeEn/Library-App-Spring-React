package mk.ukim.finki.library.model.DTO;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import mk.ukim.finki.library.model.Author;
import mk.ukim.finki.library.model.enums.BookCategory;

@Data
public class BookDTO {
    private String name;
    private String category;
    private Long authorId;
    private int availableCopies;
}
