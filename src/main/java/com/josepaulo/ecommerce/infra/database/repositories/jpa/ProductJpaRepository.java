package com.josepaulo.ecommerce.infra.database.repositories.jpa;

import java.util.List;
import java.util.Optional;

import com.josepaulo.ecommerce.infra.database.repositories.springdata.SpringDataProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    @Override
    public Optional<ProductEntity> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Page<ProductEntity> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

}
