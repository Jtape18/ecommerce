package com.josepaulo.ecommerce.infra.database.projections;

import java.math.BigDecimal;
import com.josepaulo.ecommerce.domain.enums.OrderStatus;

public interface OrderStatusTotalProjection {
    OrderStatus getStatus();
    BigDecimal getTotal();
}
