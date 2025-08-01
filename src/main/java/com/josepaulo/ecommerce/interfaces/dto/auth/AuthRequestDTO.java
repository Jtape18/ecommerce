package com.josepaulo.ecommerce.interfaces.dto.auth;

import lombok.Data;

@Data
public class AuthRequestDTO {

    private String email;
    private String password;

}
