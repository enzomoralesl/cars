package br.com.cars.dto;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarUserRequest {

    @NotBlank
    private String name;
    @NotBlank
    private String email;
    @NotBlank @Length(min = 3)
    private String password;
}
