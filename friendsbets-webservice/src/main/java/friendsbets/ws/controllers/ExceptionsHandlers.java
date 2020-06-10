package friendsbets.ws.controllers;

import java.util.NoSuchElementException;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionsHandlers  extends ResponseEntityExceptionHandler {
 
    @ExceptionHandler({ NoSuchElementException.class, IllegalArgumentException.class, EmptyResultDataAccessException.class })
    protected ResponseEntity<Object> handleConflict(RuntimeException ex, WebRequest request) {
        return handleExceptionInternal(ex, ex.getMessage(), 
          new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

}
