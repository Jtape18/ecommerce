package com.josepaulo.ecommerce.interfaces.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Schema(description = "DTO for adding a product to the cart")
public class AddProductToCartDTO {

    @Schema(description = "ID of the product to be added to the cart", example = "1")
    @NotNull
    private Long productId;

    @Schema(description = "Quantity of the product to be added to the cart", example = "2")
    @Min(1)
    private Integer quantity;
}
