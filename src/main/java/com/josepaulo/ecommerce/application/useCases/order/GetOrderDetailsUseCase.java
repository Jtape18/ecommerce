package com.josepaulo.ecommerce.application.useCases.order;

import com.josepaulo.ecommerce.domain.entities.OrderEntity;
import com.josepaulo.ecommerce.domain.repositories.IOrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetOrderDetailsUseCase {

    private final IOrderRepository orderRepository;

    public OrderEntity execute(Long orderId){
        return orderRepository.findById(orderId)
                .orElseThrow(()-> new RuntimeException("Order not found!"));
    }
}
