package com.josepaulo.ecommerce.domain.repositories;

import com.josepaulo.ecommerce.domain.entities.OrderEntity;

import java.util.List;
import java.util.Optional;

public interface IOrderRepository {
    OrderEntity save(OrderEntity order);
    List<OrderEntity> findByUserId(Long userId);
    Optional<OrderEntity> findById(Long id);
}
