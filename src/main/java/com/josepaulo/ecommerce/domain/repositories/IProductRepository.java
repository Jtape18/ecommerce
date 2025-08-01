package com.josepaulo.ecommerce.domain.repositories;

import java.util.List;
import java.util.Optional;

import com.josepaulo.ecommerce.domain.entities.ProductEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductRepository {

    ProductEntity save(ProductEntity product);

    public List<ProductEntity> findAll();

    Optional<ProductEntity> findById(Long id);

    void deleteById(Long id);

    Page<ProductEntity> findAll(Pageable pageable);



}
