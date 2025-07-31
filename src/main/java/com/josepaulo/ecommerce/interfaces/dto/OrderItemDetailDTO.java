package com.josepaulo.ecommerce.interfaces.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
public class OrderItemDetailDTO {
    private String productName;
    private BigDecimal productPrice;
    private Integer quantity;
}