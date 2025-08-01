package com.josepaulo.ecommerce.infra.database.repositories.springdata;

import com.josepaulo.ecommerce.domain.entities.OrderStatusHistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataOrderStatusHistoryRepository extends JpaRepository<OrderStatusHistoryEntity, Long> {
}
