package com.josepaulo.ecommerce.application.useCases.auth;

import com.josepaulo.ecommerce.domain.entities.UserEntity;
import com.josepaulo.ecommerce.domain.repositories.IUserRepository;
import com.josepaulo.ecommerce.interfaces.dto.auth.AuthResponseDTO;
import com.josepaulo.ecommerce.interfaces.dto.auth.RegisterRequestDTO;
import com.josepaulo.ecommerce.application.services.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegisterUserUseCase {

    private final IUserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthResponseDTO execute(RegisterRequestDTO request) {
        UserEntity user = new UserEntity();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        UserEntity saved = userRepository.save(user);
        String token = jwtService.generateToken(saved.getEmail());

        return new AuthResponseDTO(token);
    }
}
