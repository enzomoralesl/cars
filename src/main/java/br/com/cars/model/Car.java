package br.com.cars.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Car {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String model;
	private String brand;
	@Enumerated(EnumType.STRING)
	private Status status = Status.NO_STATE;
	@ManyToOne
	private CarUser carUser;

	public Car(String model, String brand, Status status, CarUser carUser) {
		this.model = model;
		this.brand = brand;
		this.status = status;
		this.carUser = carUser;
	}
}
