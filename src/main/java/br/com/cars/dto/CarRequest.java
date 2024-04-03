package br.com.cars.dto;


import br.com.cars.model.Status;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class CarRequest {

	@NotNull @NotEmpty @Length(min = 1)
	private String model;
	
	@NotNull @NotEmpty @Length(min = 1)
	private String brand;
	
	@NotNull @NotEmpty
	private String nameUser;

	@NotNull @NotEmpty @Type(type = "br.com.cars.model.Status")
	private Status status;
}
