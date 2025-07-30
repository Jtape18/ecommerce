package com.josepaulo.ecommerce.domain.repositories;

import java.util.List;

import com.josepaulo.ecommerce.domain.entities.ProductEntity;

public interface IProductRepository {

    ProductEntity save(ProductEntity product);

    public List<ProductEntity> findAll();

}
