package mk.ukim.finki.library.jobs;

import mk.ukim.finki.library.service.BookService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/*
@Component
*/
public class ScheduledTasks {
    private final BookService bookService;

    public ScheduledTasks(BookService bookService) {
        this.bookService = bookService;
    }

    @Scheduled(cron = "0 0 12 * * ?")
    public void refreshMaterializedView(){
        bookService.refreshMaterializedView();
    }
}
