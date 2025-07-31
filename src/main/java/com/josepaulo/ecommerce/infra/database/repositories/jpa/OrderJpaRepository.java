package com.josepaulo.ecommerce.infra.database.repositories.jpa;

import com.josepaulo.ecommerce.domain.entities.OrderEntity;
import com.josepaulo.ecommerce.domain.repositories.IOrderRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

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

    @Override
    public List<OrderEntity> findByUserId(Long userId) {
        return repository.findByUserId(userId);
    }
    @Override
    public Optional<OrderEntity> findById(Long id) {
        return repository.findById(id);
    }


}
