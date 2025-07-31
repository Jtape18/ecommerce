package com.josepaulo.ecommerce.interfaces.dto;

import com.josepaulo.ecommerce.domain.enums.OrderStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@AllArgsConstructor
@Schema(description = "DTO for order detail response")
public class OrderDetailResponseDTO {

    @Schema(description = "ID of the order", example = "1")
    private Long id;

    @Schema(description = "Total amount of the order", example = "99.99")
    private BigDecimal total;

    @Schema(description = "Status of the order", example = "PENDING")
    private OrderStatus status;

    @Schema(description = "List of items in the order")
    private List<OrderItemDetailDTO> items;
}
