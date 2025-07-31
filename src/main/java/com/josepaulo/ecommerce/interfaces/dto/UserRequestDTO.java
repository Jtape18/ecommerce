package com.josepaulo.ecommerce.interfaces.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Schema(description = "DTO for user creation request")
public class UserRequestDTO {

    @Schema(description = "Name of the user", example = "John Doe")
    @NotBlank
    private String name;

    @Schema(description = "Email of the user", example = "jhon@exemple.com")
    @NotBlank
    @Email
    private String email;

}
