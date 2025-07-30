package com.josepaulo.ecommerce.domain.repositories;

import com.josepaulo.ecommerce.domain.entities.OrderEntity;

public interface IOrderRepository {
    OrderEntity save(OrderEntity order);
}
