package br.com.cars.handler.error;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ResponseErrorPattern {

    private final String message;

    private final String details;

    private final int statusCode;

    public ResponseErrorPattern(String message, String details, int statusCode) {
        this.message = message;
        this.details = details;
        this.statusCode = statusCode;
    }

}
