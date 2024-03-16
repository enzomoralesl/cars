package br.com.cars.controller.dto;

import br.com.cars.model.Car;
import br.com.cars.model.CarUser;

import java.util.List;


public class CarDto {

	private Long id;
	private String model;
	private String brand;
	private CarUser carUser;
	
	public CarDto(Car car) {
		this.id = car.getId();
		this.model = car.getModel();
		this.brand = car.getMensagem();
		this.carUser = car.getUsuario();
	}

	public Long getId() {
		return id;
	}

	public String getModel() {
		return model;
	}

	public String getMensagem() {
		return brand;
	}
	
	public CarUser getUsuario() {
		return carUser;
	}

	public static List<CarDto> converter(List<Car> cars) {
		return cars.stream().map(CarDto::new).toList();
		//TODO verify toList()
	}

}
