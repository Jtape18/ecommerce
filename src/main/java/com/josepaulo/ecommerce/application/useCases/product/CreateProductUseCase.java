package com.josepaulo.ecommerce.application.useCases.product;

import java.util.List;

import org.springframework.stereotype.Service;

import com.josepaulo.ecommerce.domain.entities.ProductEntity;
import com.josepaulo.ecommerce.domain.repositories.IProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CreateProductUseCase {

    private final IProductRepository productRepository;

    public ProductEntity execute(ProductEntity product) {
        return productRepository.save(product);
    }

    public List<ProductEntity> findAll() {
        return productRepository.findAll();
    }

}
