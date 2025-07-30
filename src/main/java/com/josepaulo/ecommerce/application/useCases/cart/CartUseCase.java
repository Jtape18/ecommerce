package com.josepaulo.ecommerce.application.useCases.cart;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.josepaulo.ecommerce.domain.entities.CartEntity;
import com.josepaulo.ecommerce.domain.entities.CartItemEntity;
import com.josepaulo.ecommerce.domain.repositories.ICartRepository;
import com.josepaulo.ecommerce.domain.repositories.IProductRepository;
import com.josepaulo.ecommerce.domain.repositories.IUserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CartUseCase {

    private final ICartRepository cartRepository;
    private final IProductRepository productRepository;
    private final IUserRepository userRepository;

    public CartEntity addProduct(Long userId, Long productId, Integer quantity) {
        var user = userRepository.findAll().stream()
                .filter(u -> u.getId().equals(userId))
                .findFirst()
                .orElseThrow();

        var product = productRepository.findAll().stream()
                .filter(p -> p.getId().equals(productId))
                .findFirst()
                .orElseThrow();

        var cart = cartRepository.findByUserId(userId)
                .orElse(CartEntity.builder()
                        .user(user)
                        .items(new ArrayList<>())
                        .build());

        var item = CartItemEntity.builder()
                .cart(cart)
                .product(product)
                .quantity(quantity)
                .build();

        cart.getItems().add(item);
        return cartRepository.save(cart);
    }

    public CartEntity getCart(Long userId) {
        return cartRepository.findByUserId(userId).orElseThrow();
    }
}
