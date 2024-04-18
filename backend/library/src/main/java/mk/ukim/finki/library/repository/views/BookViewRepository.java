package mk.ukim.finki.library.repository.views;

import jakarta.transaction.Transactional;
import mk.ukim.finki.library.model.views.BookView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface BookViewRepository extends JpaRepository<BookView, Long> {
    @Modifying(clearAutomatically = true)
    @Transactional
    @Query(value = "REFRESH MATERIALIZED VIEW public.book_view", nativeQuery = true)
    void refreshMaterializedView();
}
