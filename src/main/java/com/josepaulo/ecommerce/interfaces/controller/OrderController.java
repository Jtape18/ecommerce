package com.josepaulo.ecommerce.interfaces.controller;


import com.josepaulo.ecommerce.application.useCases.order.CreateOrderUseCase;
import com.josepaulo.ecommerce.application.useCases.order.ListUserOrdersUseCase;
import com.josepaulo.ecommerce.domain.entities.OrderEntity;
import com.josepaulo.ecommerce.interfaces.dto.OrderListResponseDTO;
import com.josepaulo.ecommerce.interfaces.dto.OrderResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final CreateOrderUseCase createOrderUseCase;
    private final ListUserOrdersUseCase listUserOrdersUseCase;

    @PostMapping("/checkout/{userId}")
    public OrderResponseDTO checkout(@PathVariable Long userId) {
        OrderEntity order = createOrderUseCase.checkout(userId);
        return new OrderResponseDTO(order.getId(), order.getTotal(), order.getStatus());
    }
    @GetMapping("/user/{userId}")
    public List<OrderListResponseDTO> listOrdersByUser(@PathVariable Long userId) {
        return listUserOrdersUseCase.execute(userId).stream()
                .map(order -> new OrderListResponseDTO(order.getId(), order.getTotal(), order.getStatus()))
                .toList();
    }
}
