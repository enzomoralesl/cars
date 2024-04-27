package br.com.cars.handler.error;




public class CarNotFoundException extends NullPointerException {

    public CarNotFoundException(String message) {
        super( message);
    }
}
