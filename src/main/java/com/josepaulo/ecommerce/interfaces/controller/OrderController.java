package com.josepaulo.ecommerce.interfaces.controller;


import com.josepaulo.ecommerce.application.useCases.order.*;
import com.josepaulo.ecommerce.domain.entities.OrderEntity;
import com.josepaulo.ecommerce.interfaces.dto.*;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final CreateOrderUseCase createOrderUseCase;
    private final ListUserOrdersUseCase listUserOrdersUseCase;
    private final GetOrderDetailsUseCase getOrderDetailsUseCase;
    private final UpdateOrderStatusUseCase updateOrderStatusUseCase;
    private final SimulatePaymentUseCase simulatePaymentUseCase;

    @PostMapping("/checkout/{userId}")
    public OrderResponseDTO checkout(@PathVariable Long userId) {
        OrderEntity order = createOrderUseCase.checkout(userId);
        return new OrderResponseDTO(order.getId(), order.getTotal(), order.getStatus());
    }

    @PostMapping("/{orderId}/pay")
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
    public List<OrderListResponseDTO> listOrdersByUser(@PathVariable Long userId) {
        return listUserOrdersUseCase.execute(userId).stream()
                .map(order -> new OrderListResponseDTO(order.getId(), order.getTotal(), order.getStatus()))
                .toList();
    }

    @PatchMapping("/{orderId}/status")
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
