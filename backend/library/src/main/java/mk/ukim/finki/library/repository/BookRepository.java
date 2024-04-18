package mk.ukim.finki.library.repository;

import mk.ukim.finki.library.model.Book;
import mk.ukim.finki.library.model.projections.BookProjection;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    @EntityGraph(type = EntityGraph.EntityGraphType.FETCH, attributePaths = {"author"})
    @Query("select b from Book b")
    List<Book> fetchAll();

    @Query("select b.name, b.availableCopies from Book b")
    List<BookProjection> takeNameAndAvailableCopies();
}
