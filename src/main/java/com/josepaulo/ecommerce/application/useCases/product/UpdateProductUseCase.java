package com.josepaulo.ecommerce.application.useCases.product;


import com.josepaulo.ecommerce.domain.entities.ProductEntity;
import com.josepaulo.ecommerce.domain.repositories.IProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateProductUseCase {

    private final IProductRepository productRepository;

    public ProductEntity execute(Long id, ProductEntity updated) {
        ProductEntity existing = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found!"));

        existing.setName(updated.getName());
        existing.setDescription(updated.getDescription());
        existing.setPrice(updated.getPrice());
        existing.setStock(updated.getStock());

        return productRepository.save(existing);
    }

}
