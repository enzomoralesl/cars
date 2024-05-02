package br.com.cars.handler.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
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

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        try{
            String details = ex.getBindingResult().getFieldError().getDefaultMessage();
            String field = ex.getBindingResult().getFieldError().getField();
            ResponseErrorPattern responseErrorPattern = new ResponseErrorPattern("Error in: " + field, details, HttpStatus.BAD_REQUEST.value());

            return new ResponseEntity<>(responseErrorPattern, HttpStatus.BAD_REQUEST);
        }
        catch (NullPointerException npe){
            ResponseErrorPattern responseErrorPattern = new ResponseErrorPattern("System Null error", npe.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
            return new ResponseEntity<>(responseErrorPattern, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        catch (Exception e){
            ResponseErrorPattern responseErrorPattern = new ResponseErrorPattern("System Unknown error", e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
            return new ResponseEntity<>(responseErrorPattern, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
