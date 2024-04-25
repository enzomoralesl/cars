package br.com.cars.handler.error;



public class CarUserNotFound extends RuntimeException {

    public CarUserNotFound(String message, Throwable cause) {
        super(message, cause);
    }
    public CarUserNotFound(String message) {
        super(message);
    }
}
