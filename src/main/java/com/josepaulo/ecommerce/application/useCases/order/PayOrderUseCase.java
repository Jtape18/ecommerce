package com.josepaulo.ecommerce.application.useCases.order;

import com.josepaulo.ecommerce.domain.entities.OrderEntity;
import com.josepaulo.ecommerce.domain.entities.OrderStatusHistoryEntity;
import com.josepaulo.ecommerce.domain.enums.OrderStatus;
import com.josepaulo.ecommerce.domain.repositories.IOrderRepository;
import com.josepaulo.ecommerce.domain.repositories.IOrderStatusHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class PayOrderUseCase {

    private final IOrderRepository orderRepository;
    private final IOrderStatusHistoryRepository statusHistoryRepository;

    public OrderEntity execute(Long orderId) {
        OrderEntity order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found!"));

        if (order.getStatus() != OrderStatus.PENDING) {
            throw new RuntimeException("Order cannot paid. Status: " + order.getStatus());
        }

        // Atualiza status
        order.setStatus(OrderStatus.PAID);
        OrderEntity updatedOrder = orderRepository.save(order);

        // Salva histórico de status
        OrderStatusHistoryEntity history = OrderStatusHistoryEntity.builder()
                .order(order)
                .status(OrderStatus.PAID)
                .changedAt(LocalDateTime.now())
                .build();

        statusHistoryRepository.save(history);

        return updatedOrder;
    }
}
