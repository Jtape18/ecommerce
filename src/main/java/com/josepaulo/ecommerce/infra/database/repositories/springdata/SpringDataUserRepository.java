package com.josepaulo.ecommerce.infra.database.repositories.springdata;

import org.springframework.data.jpa.repository.JpaRepository;

import com.josepaulo.ecommerce.domain.entities.UserEntity;

import java.util.Optional;

public interface SpringDataUserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByEmail(String email);
}
