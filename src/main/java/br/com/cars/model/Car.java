package br.com.cars.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Car {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String model;
	private String brand;
	@Enumerated(EnumType.STRING)
	private Status status = Status.NO_STATE;
	@ManyToOne
	private CarUser carUser;
	
	public Car() {
	}
	
	public Car(String model, String brand, CarUser carUser) {
		this.model = model;
		this.brand = brand;
		this.carUser = carUser;
	}
	
	//construtor default e o construtor que fica mais facil de utilizar para o form
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	
	public CarUser getCarUser() {
		return carUser;
	}

	public void setCarUser(CarUser carUser) {
		this.carUser = carUser;
	}


	
	

}
