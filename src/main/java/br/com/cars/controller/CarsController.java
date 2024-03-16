package br.com.cars.controller;

import br.com.cars.controller.dto.CarDto;
import br.com.cars.controller.form.CarForm;
import br.com.cars.model.Car;
import br.com.cars.repository.CarRepository;
import br.com.cars.repository.CarUserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("/api/cars")
public class CarsController {
	
	@Autowired
	private CarRepository carRepository;
	
	@Autowired
	private CarUserRepository carUserRepository;
	Logger logger = LoggerFactory.getLogger(CarsController.class);

	@GetMapping
	public List<CarDto> getCars(String model) {
		if (model == null) {
			List<Car> cars = carRepository.findAll();
			return CarDto.converter(cars);
		}
		logger.info("Car type: " + model);
		List<Car> cars = carRepository.findByModel(model);
		return CarDto.converter(cars);
	}
	
	
	@PostMapping
	public ResponseEntity<CarDto> createCar(@RequestBody @Valid CarForm form, UriComponentsBuilder uriBuilder) {
		Car car = form.converter(carUserRepository);
		carRepository.save(car);
		
		//criar retorno no body passando o id, dados cadastrados e o Usuario que o UsuarioRepository pega no banco
		URI uri = uriBuilder.path("/cars/{id}").buildAndExpand(car.getId()).toUri();
		return ResponseEntity.created(uri).body(new CarDto(car));
	}
}