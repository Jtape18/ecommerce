package com.josepaulo.ecommerce.interfaces.controller;

import java.util.List;
import java.util.stream.Collectors;

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
public class ProductContoller {

    private final CreateProductUseCase createProductUseCase;

    @PostMapping
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
    public List<ProductResponseDTO> listProducts() {
        return createProductUseCase.findAll().stream()
                .map(p -> new ProductResponseDTO(p.getId(), p.getName(), p.getDescription(), p.getPrice(),
                        p.getStock()))
                .collect(Collectors.toList());
    }

}
