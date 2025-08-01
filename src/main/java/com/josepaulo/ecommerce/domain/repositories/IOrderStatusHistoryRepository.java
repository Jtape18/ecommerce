package com.josepaulo.ecommerce.domain.repositories;

import com.josepaulo.ecommerce.domain.entities.OrderStatusHistoryEntity;

public interface IOrderStatusHistoryRepository {
    OrderStatusHistoryEntity save(OrderStatusHistoryEntity history);
}
