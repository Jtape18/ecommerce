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
        if (quantity == null || quantity <= 0) {
            throw new RuntimeException("Quantity invalid");
        }

        var user = userRepository.findAll().stream()
                .filter(u -> u.getId().equals(userId))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("User not found!"));

        var product = productRepository.findAll().stream()
                .filter(p -> p.getId().equals(productId))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Product not found"));

        if (product.getStock() < quantity) {
            throw new RuntimeException("Insufficient stock for the product '" + product.getName() + "'");
        }

        var cart = cartRepository.findByUserId(userId)
                .orElse(CartEntity.builder()
                        .user(user)
                        .items(new ArrayList<>())
                        .build());

        var existingItem = cart.getItems().stream()
                .filter(i -> i.getProduct().getId().equals(productId))
                .findFirst();

        if (existingItem.isPresent()) {
            var item = existingItem.get();
            int novaQuantidade = item.getQuantity() + quantity;

            if (novaQuantidade > product.getStock()) {
                throw new RuntimeException("Insufficient stock to update the quantity in the cart");
            }

            item.setQuantity(novaQuantidade);
        } else {
            var newItem = CartItemEntity.builder()
                    .cart(cart)
                    .product(product)
                    .quantity(quantity)
                    .build();
            cart.getItems().add(newItem);
        }

        return cartRepository.save(cart);
    }

    public CartEntity getCart(Long userId) {
        return cartRepository.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("Cart not found for user"));
    }
}
