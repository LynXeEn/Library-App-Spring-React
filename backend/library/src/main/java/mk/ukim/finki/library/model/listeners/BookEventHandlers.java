package mk.ukim.finki.library.model.listeners;

import mk.ukim.finki.library.model.event.BookUnavailableEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class BookEventHandlers {

    @EventListener
    public void bookUnavailable(BookUnavailableEvent event){
        System.out.println(event.getMessage());
    }
}
