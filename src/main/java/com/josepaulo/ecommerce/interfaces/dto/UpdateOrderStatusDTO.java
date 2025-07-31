package com.josepaulo.ecommerce.interfaces.dto;

import com.josepaulo.ecommerce.domain.enums.OrderStatus;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UpdateOrderStatusDTO {

    @NotNull
    private OrderStatus status;

}
