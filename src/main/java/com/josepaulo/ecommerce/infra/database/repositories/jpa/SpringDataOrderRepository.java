package com.josepaulo.ecommerce.infra.database.repositories.jpa;


import com.josepaulo.ecommerce.domain.entities.OrderEntity;
import com.josepaulo.ecommerce.infra.database.projections.OrderStatusTotalProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface SpringDataOrderRepository extends JpaRepository<OrderEntity,Long> {
    List<OrderEntity> findByUserId(Long userId);

    @Query("SELECT o.status AS status, SUM(o.total) AS total " +
            "FROM OrderEntity o " +
            "WHERE o.createdAt BETWEEN :start AND :end " +
            "GROUP BY o.status")
    List<OrderStatusTotalProjection> getTotalSalesByStatus(@Param("start") LocalDateTime start,
                                                           @Param("end") LocalDateTime end);
}
