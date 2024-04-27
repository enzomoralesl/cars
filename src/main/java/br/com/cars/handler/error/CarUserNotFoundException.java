package br.com.cars.handler.error;



public class CarUserNotFoundException extends RuntimeException {

    public CarUserNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
    public CarUserNotFoundException(String message) {
        super(message);
    }
}
