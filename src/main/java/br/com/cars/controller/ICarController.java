package br.com.cars.controller;

import br.com.cars.dto.CarRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;

public interface ICarController {
    public ResponseEntity<Object> getCars(String email);

    public ResponseEntity<Object> getCarsByEmail(String email);

    public ResponseEntity<Object> createCar(@RequestBody @Valid CarRequest carRequest, UriComponentsBuilder uriBuilder);

}
