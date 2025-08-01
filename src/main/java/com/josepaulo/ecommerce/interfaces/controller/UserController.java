package com.josepaulo.ecommerce.interfaces.controller;

import java.util.List;
import java.util.stream.Collectors;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.josepaulo.ecommerce.application.useCases.user.CreateUserUseCase;
import com.josepaulo.ecommerce.domain.entities.UserEntity;
import com.josepaulo.ecommerce.interfaces.dto.user.UserRequestDTO;
import com.josepaulo.ecommerce.interfaces.dto.user.UserResponseDTO;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@Tag(name = "User Management", description = "Endpoints for managing users")
public class UserController {

    private final CreateUserUseCase createUserUseCase;

    @PostMapping
    @Operation(summary = "Create a new user")
    @ApiResponse(responseCode = "200", description = "User created successfully",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = UserResponseDTO.class)))
    public UserResponseDTO createUser(@RequestBody @Valid UserRequestDTO dto) {
        UserEntity user = UserEntity.builder()
                .name(dto.getName())
                .email(dto.getEmail())
                .build();

        UserEntity saved = createUserUseCase.execute(user);

        return new UserResponseDTO(saved.getId(), saved.getName(), saved.getEmail());
    }

    @GetMapping
    @Operation(summary = "List all users")
    public List<UserResponseDTO> listUsers() {
        return createUserUseCase.findAll().stream()
                .map(u -> new UserResponseDTO(u.getId(), u.getName(), u.getEmail()))
                .collect(Collectors.toList());
    }

}
