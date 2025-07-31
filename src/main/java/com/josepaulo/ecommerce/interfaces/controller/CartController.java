package com.josepaulo.ecommerce.interfaces.controller;

import com.josepaulo.ecommerce.interfaces.dto.UserResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "Cart Management", description = "Endpoints for managing shopping carts")
public class CartController {

    private final CartUseCase cartUseCase;

    @PostMapping("/{userId}/add")
    @Operation(summary = "Add a product to the user's cart")
    @ApiResponse(responseCode = "200", description = "Product created successfully",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = UserResponseDTO.class)))
    public CartEntity addToCart(@PathVariable Long userId,
            @RequestBody @Valid AddProductToCartDTO dto) {
        return cartUseCase.addProduct(userId, dto.getProductId(), dto.getQuantity());
    }

    @GetMapping("/{userId}")
    @Operation(summary = "Get the user's cart")
    public CartEntity getCart(@PathVariable Long userId) {
        return cartUseCase.getCart(userId);
    }
}
