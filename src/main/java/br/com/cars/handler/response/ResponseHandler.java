package br.com.cars.handler.response;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

public class ResponseHandler {
    public static ResponseEntity<Object> responseBuilder(String message, HttpStatus status, Object data) {
        Map<String, Object> response = new HashMap<>();

        response.put("message", message);
        response.put("status", status.value());
        response.put("payload", data);
        return new ResponseEntity<>(response, status);
    }
    public static ResponseEntity<Object> responseBuilderWithLocation(String message, HttpStatus status, Object data, URI uri) {
        Map<String, Object> response = new HashMap<>();

        response.put("message", message);
        response.put("status", status.value());
        response.put("payload", data);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(uri);

        return new ResponseEntity<>(response, headers, status);
    }
}
