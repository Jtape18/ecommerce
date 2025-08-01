package com.josepaulo.ecommerce.infra.database.repositories.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.josepaulo.ecommerce.domain.entities.ProductEntity;

@Repository
public interface SpringDataProductRepository extends PagingAndSortingRepository<ProductEntity,Long>, JpaRepository<ProductEntity, Long> {

}
