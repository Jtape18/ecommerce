package com.josepaulo.ecommerce.application.useCases.report;

import com.josepaulo.ecommerce.domain.enums.OrderStatus;
import com.josepaulo.ecommerce.domain.repositories.IOrderRepository;
import com.josepaulo.ecommerce.infra.database.projections.OrderStatusTotalProjection;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class GetSalesReportUseCase {

    private final IOrderRepository orderRepository;

    public Map<OrderStatus, BigDecimal> execute(LocalDateTime start, LocalDateTime end) {
        List<OrderStatusTotalProjection> totals = orderRepository.getTotalSalesByStatus(start, end);

        Map<OrderStatus, BigDecimal> report = new EnumMap<>(OrderStatus.class);
        for (OrderStatusTotalProjection projection : totals) {
            report.put(projection.getStatus(), projection.getTotal());
        }

        return report;
    }
}
