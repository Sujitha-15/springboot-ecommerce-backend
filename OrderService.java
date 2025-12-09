package com.ecommerce.service;

import com.ecommerce.model.Order;
import java.util.List;

public interface OrderService {

    Order placeOrder(Order order);

    Order updateOrder(Long id, Order updatedOrder);

    void deleteOrder(Long id);

    Order getOrderById(Long id);

    List<Order> getAllOrders();
}
