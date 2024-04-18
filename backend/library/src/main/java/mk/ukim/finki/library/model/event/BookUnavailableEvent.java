package mk.ukim.finki.library.model.event;

import lombok.Getter;
import mk.ukim.finki.library.model.Book;
import org.springframework.context.ApplicationEvent;

import java.time.LocalDateTime;

@Getter
public class BookUnavailableEvent extends ApplicationEvent {

    private String message;
    private LocalDateTime eventCreated;

    public BookUnavailableEvent(Book source) {
        super(source);
    }

    public BookUnavailableEvent(Book source, String message) {
        super(source);
        this.message = message;
        this.eventCreated = LocalDateTime.now();
    }
}
