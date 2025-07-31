package com.josepaulo.ecommerce.application.useCases.order;

import com.josepaulo.ecommerce.domain.entities.*;
import com.josepaulo.ecommerce.domain.enums.OrderStatus;
import com.josepaulo.ecommerce.domain.repositories.ICartRepository;
import com.josepaulo.ecommerce.domain.repositories.IOrderRepository;
import com.josepaulo.ecommerce.domain.repositories.IProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CreateOrderUseCase {

    private final ICartRepository cartRepository;
    private final IOrderRepository orderRepository;
    private final IProductRepository productRepository;

    public OrderEntity checkout(Long userId) {
        CartEntity cart = cartRepository.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("Carrinho não encontrado"));

        if (cart.getItems().isEmpty()) {
            throw new RuntimeException("Carrinho está vazio");
        }

        for (CartItemEntity item : cart.getItems()) {
            var product = item.getProduct();
            if (product.getStock() < item.getQuantity()) {
                throw new RuntimeException("Estoque insuficiente para o produto '" + product.getName() + "'");
            }
        }

        cart.getItems().forEach(item -> {
            var product = item.getProduct();
            int novoEstoque = product.getStock() - item.getQuantity();
            product.setStock(novoEstoque);
            productRepository.save(product);
        });

        List<OrderItemEntity> orderItems = cart.getItems().stream().map(item -> OrderItemEntity.builder()
                .product(item.getProduct())
                .quantity(item.getQuantity())
                .build()
        ).toList();

        BigDecimal total = cart.getItems().stream()
                .map(item -> item.getProduct().getPrice().multiply(BigDecimal.valueOf(item.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        OrderEntity order = OrderEntity.builder()
                .user(cart.getUser())
                .items(orderItems)
                .total(total)
                .status(OrderStatus.PENDING)
                .build();

        order.getItems().forEach(item -> item.setOrder(order));

        OrderEntity saved = orderRepository.save(order);

        cart.getItems().clear();
        cartRepository.save(cart);

        return saved;
    }

}
