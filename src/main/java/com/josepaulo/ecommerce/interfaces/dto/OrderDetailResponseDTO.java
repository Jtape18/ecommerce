package com.josepaulo.ecommerce.interfaces.dto;

import com.josepaulo.ecommerce.domain.enums.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@AllArgsConstructor
public class OrderDetailResponseDTO {
    private Long id;
    private BigDecimal total;
    private OrderStatus status;
    private List<OrderItemDetailDTO> items;
}
