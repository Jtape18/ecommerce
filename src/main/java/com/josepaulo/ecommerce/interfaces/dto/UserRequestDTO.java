package com.josepaulo.ecommerce.interfaces.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserRequestDTO {

    @NotBlank
    private String name;

    @NotBlank
    @Email
    private String email;

}
