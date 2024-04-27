package br.com.cars.handler.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionCarHandler {

    @ExceptionHandler(CarUserNotFoundException.class)
    public ResponseEntity<Object> handleCarUserNotFound(CarUserNotFoundException ex) {

        CarPatternException carPatternException = new CarPatternException(ex.getMessage(), HttpStatus.NOT_FOUND, HttpStatus.NOT_FOUND.value());

        return new ResponseEntity<>(carPatternException, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CarNotFoundException.class)
    public ResponseEntity<Object> handleCarNotFound(CarNotFoundException ex) {

        CarPatternException carPatternException = new CarPatternException(ex.getMessage(), HttpStatus.NOT_FOUND, HttpStatus.NOT_FOUND.value());

        return new ResponseEntity<>(carPatternException, HttpStatus.NOT_FOUND);
    }
}
