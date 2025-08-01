package com.josepaulo.ecommerce.interfaces.controller;


import com.josepaulo.ecommerce.application.useCases.order.*;
import com.josepaulo.ecommerce.domain.entities.OrderEntity;
import com.josepaulo.ecommerce.interfaces.dto.order.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
@Tag(name = "Order Management", description = "Endpoints for managing orders")
public class OrderController {

    private final CreateOrderUseCase createOrderUseCase;
    private final ListUserOrdersUseCase listUserOrdersUseCase;
    private final GetOrderDetailsUseCase getOrderDetailsUseCase;
    private final UpdateOrderStatusUseCase updateOrderStatusUseCase;
    private final SimulatePaymentUseCase simulatePaymentUseCase;

    @PostMapping("/checkout/{userId}")
    @Operation(summary = "Checkout an order for a user")
    @ApiResponse(responseCode = "200", description = "Order checked out successfully",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = OrderResponseDTO.class)))
    public OrderResponseDTO checkout(@PathVariable Long userId) {
        OrderEntity order = createOrderUseCase.checkout(userId);
        return new OrderResponseDTO(order.getId(), order.getTotal(), order.getStatus());
    }

    @PostMapping("/{orderId}/pay")
    @Operation(summary = "Simulate payment for an order")
    @ApiResponse(responseCode = "200", description = "Payment simulated successfully",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = OrderDetailResponseDTO.class)))
    public OrderDetailResponseDTO simulatePayment(@PathVariable Long orderId) {
        var order = simulatePaymentUseCase.execute(orderId);

        var items = order.getItems().stream()
                .map(item -> new OrderItemDetailDTO(
                        item.getProduct().getName(),
                        item.getProduct().getPrice(),
                        item.getQuantity()))
                .toList();

        return new OrderDetailResponseDTO(order.getId(), order.getTotal(), order.getStatus(), items);
    }


    @GetMapping("/{orderId}")
    @Operation(summary = "Get order details by order ID")
    public OrderDetailResponseDTO getOrderDetails(@PathVariable Long orderId) {
        var order = getOrderDetailsUseCase.execute(orderId);

        var items = order.getItems().stream()
                .map(item -> new OrderItemDetailDTO(
                        item.getProduct().getName(),
                        item.getProduct().getPrice(),
                        item.getQuantity()))
                .toList();

        return new OrderDetailResponseDTO(order.getId(), order.getTotal(), order.getStatus(), items);
    }

    @GetMapping("/user/{userId}")
    @Operation(summary = "List all orders for a specific user")
    public List<OrderListResponseDTO> listOrdersByUser(@PathVariable Long userId) {
        return listUserOrdersUseCase.execute(userId).stream()
                .map(order -> new OrderListResponseDTO(order.getId(), order.getTotal(), order.getStatus()))
                .toList();
    }

    @PatchMapping("/{orderId}/status")
    @Operation(summary = "Update the status of an order")
    @ApiResponse(responseCode = "200", description = "Order status updated successfully",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = OrderDetailResponseDTO.class)))
    public OrderDetailResponseDTO updateOrderStatus(
            @PathVariable Long orderId,
            @RequestBody @Valid UpdateOrderStatusDTO dto) {

        var updatedOrder = updateOrderStatusUseCase.execute(orderId, dto.getStatus());

        var items = updatedOrder.getItems().stream()
                .map(item -> new OrderItemDetailDTO(
                        item.getProduct().getName(),
                        item.getProduct().getPrice(),
                        item.getQuantity()))
                .toList();

        return new OrderDetailResponseDTO(
                updatedOrder.getId(),
                updatedOrder.getTotal(),
                updatedOrder.getStatus(),
                items
        );
    }
}
