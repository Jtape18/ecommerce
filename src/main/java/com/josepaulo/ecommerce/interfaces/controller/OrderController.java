package com.josepaulo.ecommerce.interfaces.controller;


import com.josepaulo.ecommerce.application.useCases.order.CreateOrderUseCase;
import com.josepaulo.ecommerce.domain.entities.OrderEntity;
import com.josepaulo.ecommerce.interfaces.dto.OrderResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final CreateOrderUseCase createOrderUseCase;

    @PostMapping("/checkout/{userId}")
    public OrderResponseDTO checkout(@PathVariable Long userId) {
        OrderEntity order = createOrderUseCase.checkout(userId);
        return new OrderResponseDTO(order.getId(), order.getTotal(), order.getStatus());
    }
}
