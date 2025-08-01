package com.josepaulo.ecommerce.infra.database.repositories.jpa;

import com.josepaulo.ecommerce.domain.entities.OrderStatusHistoryEntity;
import com.josepaulo.ecommerce.domain.repositories.IOrderStatusHistoryRepository;
import com.josepaulo.ecommerce.infra.database.repositories.springdata.SpringDataOrderStatusHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderStatusHistoryJpaRepository implements IOrderStatusHistoryRepository {

    private final SpringDataOrderStatusHistoryRepository repository;

    @Override
    public OrderStatusHistoryEntity save(OrderStatusHistoryEntity history) {
        return repository.save(history);
    }
}
