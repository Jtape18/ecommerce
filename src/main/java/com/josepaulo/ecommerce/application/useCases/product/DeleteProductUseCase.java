package com.josepaulo.ecommerce.application.useCases.product;

import com.josepaulo.ecommerce.domain.repositories.IProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteProductUseCase {

    private final IProductRepository productRepository;

    public void execute(Long id) {
        productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found!"));
        productRepository.deleteById(id);
    }


}
