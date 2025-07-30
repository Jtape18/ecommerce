package com.josepaulo.ecommerce.domain.repositories;

import com.josepaulo.ecommerce.domain.entities.OrderEntity;

import java.util.List;

public interface IOrderRepository {
    OrderEntity save(OrderEntity order);
    List<OrderEntity> findByUserId(Long userId);
}
