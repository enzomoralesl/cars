package br.com.cars.dto;

import br.com.cars.model.CarUser;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CarResponse {

	private Long id;
	private String model;
	private String brand;
	private CarUser carUser;


}
