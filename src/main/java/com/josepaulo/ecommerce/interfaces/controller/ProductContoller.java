package com.josepaulo.ecommerce.interfaces.controller;

import com.josepaulo.ecommerce.application.useCases.product.*;
import com.josepaulo.ecommerce.domain.entities.ProductEntity;
import com.josepaulo.ecommerce.interfaces.dto.product.ProductRequestDTO;
import com.josepaulo.ecommerce.interfaces.dto.product.ProductResponseDTO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
@Tag(name = "Product Management", description = "Endpoints for managing products")
public class ProductContoller {

    private final CreateProductUseCase createProductUseCase;
    private final GetProductByIdUseCase getProductByIdUseCase;
    private final UpdateProductUseCase updateProductUseCase;
    private final DeleteProductUseCase deleteProductUseCase;
    private final ListPagedProductsUseCase listPagedProductsUseCase;

    @PostMapping
    @Operation(summary = "Create a new product")
    @ApiResponse(responseCode = "200", description = "Product created successfully",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProductResponseDTO.class)))
    public ProductResponseDTO createProduct(@RequestBody @Valid ProductRequestDTO dto) {
        var product = createProductUseCase.execute(ProductEntity.builder()
                .name(dto.getName())
                .description(dto.getDescription())
                .price(dto.getPrice())
                .stock(dto.getStock())
                .build());

        return new ProductResponseDTO(product.getId(), product.getName(), product.getDescription(), product.getPrice(), product.getStock());
    }

    @GetMapping
    @Operation(summary = "List paged products")
    public Page<ProductResponseDTO> listPagedProducts(Pageable pageable) {
        return listPagedProductsUseCase.execute(pageable)
                .map(p -> new ProductResponseDTO(p.getId(), p.getName(), p.getDescription(), p.getPrice(), p.getStock()));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get product by ID")
    public ProductResponseDTO getProduct(@PathVariable Long id) {
        var product = getProductByIdUseCase.execute(id);
        return new ProductResponseDTO(product.getId(), product.getName(), product.getDescription(), product.getPrice(), product.getStock());
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update existing product")
    public ProductResponseDTO updateProduct(@PathVariable Long id, @RequestBody @Valid ProductRequestDTO dto) {
        var updated = ProductEntity.builder()
                .name(dto.getName())
                .description(dto.getDescription())
                .price(dto.getPrice())
                .stock(dto.getStock())
                .build();

        var saved = updateProductUseCase.execute(id, updated);
        return new ProductResponseDTO(saved.getId(), saved.getName(), saved.getDescription(), saved.getPrice(), saved.getStock());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete product by ID")
    public void deleteProduct(@PathVariable Long id) {
        deleteProductUseCase.execute(id);
    }
}
