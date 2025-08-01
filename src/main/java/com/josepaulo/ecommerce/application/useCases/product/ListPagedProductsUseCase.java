package com.josepaulo.ecommerce.application.useCases.product;


import com.josepaulo.ecommerce.domain.entities.ProductEntity;
import com.josepaulo.ecommerce.domain.repositories.IProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ListPagedProductsUseCase {


    public final IProductRepository productRepository;

    public Page<ProductEntity> execute(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

}
