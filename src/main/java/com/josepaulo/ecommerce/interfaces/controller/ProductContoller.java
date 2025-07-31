package com.josepaulo.ecommerce.interfaces.controller;

import java.util.List;
import java.util.stream.Collectors;

import com.josepaulo.ecommerce.interfaces.dto.UserResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.josepaulo.ecommerce.application.useCases.product.CreateProductUseCase;
import com.josepaulo.ecommerce.domain.entities.ProductEntity;
import com.josepaulo.ecommerce.interfaces.dto.ProductRequestDTO;
import com.josepaulo.ecommerce.interfaces.dto.ProductResponseDTO;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
@Tag(name = "Product Management", description = "Endpoints for managing products")
public class ProductContoller {

    private final CreateProductUseCase createProductUseCase;

    @PostMapping
    @Operation(summary = "Create a new product")
    @ApiResponse(responseCode = "200", description = "Product created successfully",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProductResponseDTO.class)))
    public ProductResponseDTO createProduct(@RequestBody @Valid ProductRequestDTO dto) {
        ProductEntity product = ProductEntity.builder()
                .name(dto.getName())
                .description(dto.getDescription())
                .price(dto.getPrice())
                .stock(dto.getStock())
                .build();

        ProductEntity saved = createProductUseCase.execute(product);

        return new ProductResponseDTO(saved.getId(), saved.getName(), saved.getDescription(), saved.getPrice(),
                saved.getStock());
    }

    @GetMapping
    @Operation(summary = "List all products")
    public List<ProductResponseDTO> listProducts() {
        return createProductUseCase.findAll().stream()
                .map(p -> new ProductResponseDTO(p.getId(), p.getName(), p.getDescription(), p.getPrice(),
                        p.getStock()))
                .collect(Collectors.toList());
    }

}
