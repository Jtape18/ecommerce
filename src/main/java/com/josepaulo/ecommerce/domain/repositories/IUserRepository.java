package com.josepaulo.ecommerce.domain.repositories;

import java.util.List;
import java.util.Optional;

import com.josepaulo.ecommerce.domain.entities.UserEntity;

public interface IUserRepository {

    UserEntity save(UserEntity user);

    List<UserEntity> findAll();

    Optional<UserEntity> findByEmail(String email);


}