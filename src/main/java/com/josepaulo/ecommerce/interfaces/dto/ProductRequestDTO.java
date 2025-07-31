package com.josepaulo.ecommerce.interfaces.dto;

import java.math.BigDecimal;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Schema(description = "DTO for product creation request")
public class ProductRequestDTO {

    @Schema(description = "Name of the product", example = "Laptop")
    @NotBlank
    private String name;

    @Schema(description = "Description of the product", example = "High performance laptop")
    @NotBlank
    private String description;

    @Schema(description = "Price of the product", example = "999.99")
    @NotNull
    @DecimalMin("0.0")
    private BigDecimal price;

    @Schema(description = "Stock quantity of the product", example = "50")
    @NotNull(message = "estoque é obrigatório")
    @Min(value = 1, message = "estoque deve ser maior que zero")
    private Integer stock;

}
