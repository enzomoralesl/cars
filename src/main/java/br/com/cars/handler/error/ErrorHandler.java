package br.com.cars.handler.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(CarUserNotFoundException.class)
    public ResponseEntity<Object> handleCarUserNotFound(CarUserNotFoundException ex) {

        ResponseErrorPattern responseErrorPattern = new ResponseErrorPattern(ex.getMessage(), ex.getCause().getMessage(), HttpStatus.NOT_FOUND.value());

        return new ResponseEntity<>(responseErrorPattern, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CarNotFoundException.class)
    public ResponseEntity<Object> handleCarNotFound(CarNotFoundException ex) {

        ResponseErrorPattern responseErrorPattern = new ResponseErrorPattern(ex.getMessage(), ex.getCause().getMessage(), HttpStatus.NOT_FOUND.value());

        return new ResponseEntity<>(responseErrorPattern, HttpStatus.NOT_FOUND);
    }
/*
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Object> handleMethodArgumentNotValid(HttpMessageNotReadableException ex) {

        ResponseErrorPattern responseErrorPattern = new ResponseErrorPattern("Tipos aceitos: NEW/PRE_OWNED/NO_STATE", ex.getCause().getMessage(), HttpStatus.BAD_REQUEST.value());

        return new ResponseEntity<>(responseErrorPattern, HttpStatus.BAD_REQUEST);

    }
    */
}
