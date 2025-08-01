package com.josepaulo.ecommerce.interfaces.controller;

import com.josepaulo.ecommerce.application.useCases.auth.LoginUserUseCase;
import com.josepaulo.ecommerce.application.useCases.auth.RegisterUserUseCase;
import com.josepaulo.ecommerce.interfaces.dto.auth.AuthRequestDTO;
import com.josepaulo.ecommerce.interfaces.dto.auth.AuthResponseDTO;
import com.josepaulo.ecommerce.interfaces.dto.auth.RegisterRequestDTO;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final RegisterUserUseCase registerUserUseCase;
    private final LoginUserUseCase loginUserUseCase;

    @PostMapping("/register")
    @Operation(summary = "Register a new user")
    public AuthResponseDTO register(@RequestBody RegisterRequestDTO request) {
        return registerUserUseCase.execute(request);
    }

    @PostMapping("/login")
    @Operation(summary = "Login and get JWT token")
    public AuthResponseDTO login(@RequestBody AuthRequestDTO request) {
        return loginUserUseCase.execute(request);
    }
}
