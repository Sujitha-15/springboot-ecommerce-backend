package com.ecommerce.service.impl;

import com.ecommerce.model.Order;
import com.ecommerce.repository.OrderRepository;
import com.ecommerce.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Order placeOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order updateOrder(Long id, Order updatedOrder) {
        Order existing = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        existing.setUser(updatedOrder.getUser());
        existing.setProducts(updatedOrder.getProducts());
        existing.setTotalAmount(updatedOrder.getTotalAmount());
        existing.setStatus(updatedOrder.getStatus());

        return orderRepository.save(existing);
    }

    @Override
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }

    @Override
    public Order getOrderById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
}
