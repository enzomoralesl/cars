package br.com.cars.dto;


import br.com.cars.model.Status;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Data
public class CarRequest {

	@NotBlank(message = "The brand is required.") @Length(min = 1)
	private String brand;
	@NotBlank(message = "The model is required.") @Length(min = 1)
	private String model;
	@Valid @JsonProperty("carUser") @NotNull(message = "The car user is required.")
	private CarUserRequest carUser;
	private Status status = Status.NO_STATE;
}
