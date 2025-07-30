package com.josepaulo.ecommerce.application.useCases.user;

import java.util.List;

import org.springframework.stereotype.Service;

import com.josepaulo.ecommerce.domain.entities.UserEntity;
import com.josepaulo.ecommerce.domain.repositories.IUserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CreateUserUseCase {

    private final IUserRepository userRepository;

    public UserEntity execute(UserEntity user) {
        return userRepository.save(user);
    }

    public List<UserEntity> findAll() {
        return userRepository.findAll();
    }

}
