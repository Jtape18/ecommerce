package com.josepaulo.ecommerce.application.useCases.report;

import com.josepaulo.ecommerce.domain.enums.OrderStatus;
import com.josepaulo.ecommerce.infra.database.projections.OrderStatusTotalProjection;
import com.josepaulo.ecommerce.infra.database.repositories.jpa.OrderJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.EnumMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class GetSalesReportUseCase {

    private final OrderJpaRepository orderJpaRepository;

    public Map<OrderStatus, BigDecimal> execute(LocalDateTime start, LocalDateTime end) {
        var results = orderJpaRepository.getTotalSalesByStatus(start, end);

        Map<OrderStatus, BigDecimal> report = new EnumMap<>(OrderStatus.class);
        for (OrderStatusTotalProjection r : results) {
            report.put(r.getStatus(), r.getTotal());
        }

        return report;
    }
}
