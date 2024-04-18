package mk.ukim.finki.library.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class InvalidIdException extends RuntimeException{
    public InvalidIdException(Long id){
        super(String.format("Object with id %d cannot be found", id));
    }
}
