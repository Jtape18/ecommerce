package com.josepaulo.ecommerce.interfaces.dto;

import com.josepaulo.ecommerce.domain.enums.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class OrderListResponseDTO {

    private Long id;
    private BigDecimal total;
    private OrderStatus status;

}
