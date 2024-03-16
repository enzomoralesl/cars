package br.com.cars.controller.form;


import br.com.cars.model.Car;
import br.com.cars.model.CarUser;
import br.com.cars.repository.CarUserRepository;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


public class CarForm {

	@NotNull @NotEmpty @Length(min = 5)
	private String model;
	
	@NotNull @NotEmpty @Length(min = 10)
	private String brand;
	
	@NotNull @NotEmpty
	private String nameUser;

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getMensagem() {
		return brand;
	}

	public void setMensagem(String brand) {
		this.brand = brand;
	}

	public String getNameUser() {
		return nameUser;
	}

	public void setNameUser(String nameUser) {
		this.nameUser = nameUser;
	}

	public Car converter(CarUserRepository carUserRepository) {
		CarUser carUser = carUserRepository.findByName(nameUser);
		return new Car(model, brand, carUser);
	}

}
