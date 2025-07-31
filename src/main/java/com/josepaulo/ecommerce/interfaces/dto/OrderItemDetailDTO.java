package com.josepaulo.ecommerce.interfaces.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
@Schema(description = "DTO for order item details")
public class OrderItemDetailDTO {

    @Schema(description = "ID of the order item", example = "1")
    private String productName;

    @Schema(description = "Description of the product", example = "High performance laptop")
    private BigDecimal productPrice;

    @Schema(description = "Quantity of the product in the order", example = "2")
    private Integer quantity;
}