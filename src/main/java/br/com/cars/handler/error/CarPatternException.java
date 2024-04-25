package br.com.cars.handler.error;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class CarPatternException {

    private final String message;

    private final HttpStatus cause;

    private final int status;

    public CarPatternException(String message, HttpStatus cause, int status) {
        this.message = message;
        this.cause = cause;
        this.status = status;
    }

}
