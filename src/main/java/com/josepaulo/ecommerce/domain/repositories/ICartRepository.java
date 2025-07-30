package com.josepaulo.ecommerce.domain.repositories;

import java.util.Optional;

import com.josepaulo.ecommerce.domain.entities.CartEntity;

public interface ICartRepository {
    CartEntity save(CartEntity cart);

    Optional<CartEntity> findByUserId(Long userId);
}
