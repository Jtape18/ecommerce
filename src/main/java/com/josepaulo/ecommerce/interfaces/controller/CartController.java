package com.josepaulo.ecommerce.interfaces.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.josepaulo.ecommerce.application.useCases.cart.CartUseCase;
import com.josepaulo.ecommerce.domain.entities.CartEntity;
import com.josepaulo.ecommerce.interfaces.dto.AddProductToCartDTO;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/cart")
@RequiredArgsConstructor
public class CartController {

    private final CartUseCase cartUseCase;

    @PostMapping("/{userId}/add")
    public CartEntity addToCart(@PathVariable Long userId,
            @RequestBody @Valid AddProductToCartDTO dto) {
        return cartUseCase.addProduct(userId, dto.getProductId(), dto.getQuantity());
    }

    @GetMapping("/{userId}")
    public CartEntity getCart(@PathVariable Long userId) {
        return cartUseCase.getCart(userId);
    }
}
