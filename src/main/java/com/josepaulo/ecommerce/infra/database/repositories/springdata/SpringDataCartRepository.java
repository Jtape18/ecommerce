package com.josepaulo.ecommerce.infra.database.repositories.springdata;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.josepaulo.ecommerce.domain.entities.CartEntity;

@Repository
public interface SpringDataCartRepository extends JpaRepository<CartEntity, Long> {
    Optional<CartEntity> findByUserId(Long userId);
}
