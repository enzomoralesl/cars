package br.com.cars.dto;

import br.com.cars.model.Car;
import br.com.cars.model.CarUser;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarResponse {

	private Long id;
	private String model;
	private String brand;
	private CarUser carUser;

	public CarResponse(Car car) {
		this.id = car.getId();
		this.model = car.getModel();
		this.brand = car.getBrand();
		this.carUser = car.getCarUser();
	}

}
