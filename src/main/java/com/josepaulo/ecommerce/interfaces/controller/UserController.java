package com.josepaulo.ecommerce.interfaces.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.josepaulo.ecommerce.application.useCases.CreateUserUseCase;
import com.josepaulo.ecommerce.domain.entities.UserEntity;
import com.josepaulo.ecommerce.interfaces.dto.UserRequestDTO;
import com.josepaulo.ecommerce.interfaces.dto.UserResponseDTO;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final CreateUserUseCase createUserUseCase;

    @PostMapping
    public UserResponseDTO createUser(@RequestBody @Valid UserRequestDTO dto) {
        UserEntity user = UserEntity.builder()
                .name(dto.getName())
                .email(dto.getEmail())
                .build();

        UserEntity saved = createUserUseCase.execute(user);

        return new UserResponseDTO(saved.getId(), saved.getName(), saved.getEmail());
    }

    @GetMapping
    public List<UserResponseDTO> listUsers() {
        return createUserUseCase.findAll().stream()
                .map(u -> new UserResponseDTO(u.getId(), u.getName(), u.getEmail()))
                .collect(Collectors.toList());
    }

}
