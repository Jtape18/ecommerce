package com.josepaulo.ecommerce.interfaces.dto;

import com.josepaulo.ecommerce.domain.enums.OrderStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Schema(description = "DTO for updating order status")
public class UpdateOrderStatusDTO {

    @Schema(description = "ID of the order", example = "PAID")
    @NotNull
    private OrderStatus status;

}
