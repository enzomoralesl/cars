package br.com.cars.dto;


import br.com.cars.model.Status;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Data
public class CarRequest {

	@NotBlank @Length(min = 1)
	private String model;
	@NotBlank @Length(min = 1)
	private String brand;
	@Valid @JsonProperty("carUser")
	private CarUserRequest carUser;
	private Status status = Status.NO_STATE;
}
