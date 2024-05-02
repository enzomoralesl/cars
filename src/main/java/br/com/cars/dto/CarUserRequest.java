package br.com.cars.dto;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern.Flag;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarUserRequest {

    @NotBlank(message = "The name is required.")
    private String name;
    @NotBlank(message = "The email is required.")
    @Email(message = "The email address is invalid.", flags = { Flag.CASE_INSENSITIVE })
    private String email;
    @NotBlank(message = "The password is required.") @Length(min = 3)
    private String password;

}
