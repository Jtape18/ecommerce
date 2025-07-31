package com.josepaulo.ecommerce.application.useCases.order;

import com.josepaulo.ecommerce.domain.entities.OrderEntity;
import com.josepaulo.ecommerce.domain.enums.OrderStatus;
import com.josepaulo.ecommerce.domain.repositories.IOrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SimulatePaymentUseCase {

    private final IOrderRepository orderRepository;

    public OrderEntity execute(Long orderId) {
        OrderEntity order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));

        if (order.getStatus() != OrderStatus.PENDING) {
            throw new RuntimeException("Pedido não está pendente para pagamento");
        }

        order.setStatus(OrderStatus.PAID);
        return orderRepository.save(order);
    }
}
