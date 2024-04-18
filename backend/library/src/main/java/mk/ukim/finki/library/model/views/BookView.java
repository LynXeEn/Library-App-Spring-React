package mk.ukim.finki.library.model.views;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;

@Entity
@Data
@Subselect("select * from public.book_view")
@Immutable
public class BookView {
    @Id
    @Column(name = "bookId")
    private Long bookId;

    @Column(name = "available_copies")
    private int availableCopies;
}
