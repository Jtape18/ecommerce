package com.josepaulo.ecommerce.infra.database.repositories.jpa;

import com.josepaulo.ecommerce.domain.entities.OrderEntity;
import com.josepaulo.ecommerce.domain.repositories.IOrderRepository;
import org.springframework.stereotype.Repository;

@Repository
public class OrderJpaRepository implements IOrderRepository {

    private final SpringDataOrderRepository repository;

    public OrderJpaRepository(SpringDataOrderRepository repository) {
        this.repository = repository;
    }

    @Override
    public OrderEntity save(OrderEntity order) {
        return repository.save(order);
    }


}
