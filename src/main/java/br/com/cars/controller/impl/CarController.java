package br.com.cars.controller.impl;

import br.com.cars.controller.ICarController;
import br.com.cars.dto.CarResponse;
import br.com.cars.dto.CarRequest;
import br.com.cars.handler.response.ResponseHandler;
import br.com.cars.model.Car;
import br.com.cars.service.impl.CarService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;


@RestController
@RequestMapping("/api/v1/cars")
public class CarController implements ICarController {

	@Autowired
	private CarService carService;

	ModelMapper mapper = new ModelMapper();
	Logger logger = LoggerFactory.getLogger(CarController.class);

	@Override
	@GetMapping
	public ResponseEntity<Object> getCars(String email) {
		return ResponseHandler.responseBuilder("Cars listed by search", HttpStatus.OK, carService.getCars(email));
	}
	@Override
	@PostMapping
	public ResponseEntity<CarResponse> createCar(@RequestBody @Valid CarRequest carRequest, UriComponentsBuilder uriBuilder) {
		Car car = mapper.map(carRequest, Car.class);
		carService.createCar(car);
		
		//retorno passando o id, dados cadastrados e o Usuario
		URI uri = uriBuilder.path("/api/v1/cars/{id}").buildAndExpand(car.getId()).toUri();

		CarResponse carResponse = mapper.map(car, CarResponse.class);
		return ResponseEntity.created(uri).body(carResponse);
	}
}