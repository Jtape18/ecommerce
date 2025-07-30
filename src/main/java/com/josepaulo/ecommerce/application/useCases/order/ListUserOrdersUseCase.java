package com.josepaulo.ecommerce.application.useCases.order;


import com.josepaulo.ecommerce.domain.entities.OrderEntity;
import com.josepaulo.ecommerce.domain.repositories.IOrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ListUserOrdersUseCase {

    private final IOrderRepository orderRepository;

    public List<OrderEntity> execute(Long userId){
        return orderRepository.findByUserId(userId);
    }

}
