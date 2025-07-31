package com.josepaulo.ecommerce.interfaces.dto;

import com.josepaulo.ecommerce.domain.enums.OrderStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;


@Data
@AllArgsConstructor
@Schema(description = "DTO for order response")
public class OrderResponseDTO {

    @Schema(description = "ID of the order", example = "1")
    private Long orderId;

    @Schema(description = "User associated with the order")
    private BigDecimal total;

    @Schema(description = "Total amount of the order", example = "99.99")
    private OrderStatus status;

}
