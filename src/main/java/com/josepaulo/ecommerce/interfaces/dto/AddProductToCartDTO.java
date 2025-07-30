package com.josepaulo.ecommerce.interfaces.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AddProductToCartDTO {
    @NotNull
    private Long productId;

    @Min(1)
    private Integer quantity;
}
