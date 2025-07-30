package com.josepaulo.ecommerce.infra.database.repositories.jpa;


import com.josepaulo.ecommerce.domain.entities.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringDataOrderRepository extends JpaRepository<OrderEntity,Long> {
}
