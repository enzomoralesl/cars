package br.com.cars.controller.impl;

import br.com.cars.controller.ICarController;
import br.com.cars.dto.CarRequest;
import br.com.cars.dto.CarResponse;
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
import java.util.List;


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
		List<CarResponse> cars = carService.getCars(email);
		return ResponseHandler.responseBuilder("Cars listed by search", HttpStatus.OK, cars);
	}

	@Override
	@GetMapping("/{email}")
	public ResponseEntity<Object> getCarsByEmail(@PathVariable String email) {
		List<CarResponse> cars = carService.getCarsByUser(email);
		return ResponseHandler.responseBuilder("Cars listed by user email", HttpStatus.OK, cars);
	}

	@Override
	@PostMapping
	public ResponseEntity<Object> createCar(@RequestBody @Valid CarRequest carRequest, UriComponentsBuilder uriBuilder) {
		Car car = mapper.map(carRequest, Car.class);
		carService.createCar(car);
		CarResponse carResponse = mapper.map(car, CarResponse.class);

		URI uri = uriBuilder.path("/api/v1/cars/{id}").buildAndExpand(car.getId()).toUri();

		return ResponseHandler.responseBuilderWithLocation("Car created with success",
				HttpStatus.CREATED, carResponse, uri);
	}
}