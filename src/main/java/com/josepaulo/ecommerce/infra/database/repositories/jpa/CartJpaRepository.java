package com.josepaulo.ecommerce.infra.database.repositories.jpa;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.josepaulo.ecommerce.domain.entities.CartEntity;
import com.josepaulo.ecommerce.domain.repositories.ICartRepository;

@Repository
public class CartJpaRepository implements ICartRepository {

    private final SpringDataCartRepository springDataCartRepository;

    public CartJpaRepository(SpringDataCartRepository springDataCartRepository) {
        this.springDataCartRepository = springDataCartRepository;
    }

    @Override
    public CartEntity save(CartEntity cart) {
        return springDataCartRepository.save(cart);
    }

    @Override
    public Optional<CartEntity> findByUserId(Long userId) {
        return springDataCartRepository.findByUserId(userId);
    }
}
