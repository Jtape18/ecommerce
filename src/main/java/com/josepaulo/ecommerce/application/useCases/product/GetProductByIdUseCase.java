package com.josepaulo.ecommerce.application.useCases.product;


import com.josepaulo.ecommerce.domain.entities.ProductEntity;
import com.josepaulo.ecommerce.domain.repositories.IProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetProductByIdUseCase {

    private final IProductRepository productRepository;

    public ProductEntity execute(Long id){
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found!"));
    }

}
