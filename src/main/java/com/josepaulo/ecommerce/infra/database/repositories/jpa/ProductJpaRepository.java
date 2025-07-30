package com.josepaulo.ecommerce.infra.database.repositories.jpa;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.josepaulo.ecommerce.domain.entities.ProductEntity;
import com.josepaulo.ecommerce.domain.repositories.IProductRepository;

@Repository
public class ProductJpaRepository implements IProductRepository {

    private final SpringDataProductRepository repository;

    public ProductJpaRepository(SpringDataProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public ProductEntity save(ProductEntity product) {
        return repository.save(product);
    }

    @Override
    public List<ProductEntity> findAll() {
        return repository.findAll();
    }

}
