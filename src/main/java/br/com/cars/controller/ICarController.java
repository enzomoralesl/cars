package br.com.cars.controller;

import br.com.cars.dto.CarResponse;
import br.com.cars.dto.CarRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;

public interface ICarController {
    public ResponseEntity<Object> getCars(String email);
    public ResponseEntity<CarResponse> createCar(@RequestBody @Valid CarRequest carRequest, UriComponentsBuilder uriBuilder);

}
