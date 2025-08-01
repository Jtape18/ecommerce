package com.josepaulo.ecommerce.application.useCases.auth;

import com.josepaulo.ecommerce.domain.entities.UserEntity;
import com.josepaulo.ecommerce.domain.repositories.IUserRepository;
import com.josepaulo.ecommerce.interfaces.dto.auth.AuthRequestDTO;
import com.josepaulo.ecommerce.interfaces.dto.auth.AuthResponseDTO;
import com.josepaulo.ecommerce.application.services.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginUserUseCase {

    private final IUserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthResponseDTO execute(AuthRequestDTO request) {
        UserEntity user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("Invalid credentials"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        String token = jwtService.generateToken(user.getEmail());
        return new AuthResponseDTO(token);
    }
}
