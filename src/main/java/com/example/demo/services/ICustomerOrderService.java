package com.example.demo.services;

import com.example.demo.entities.CustomerOrder;
import com.example.demo.entities.OrderItem;

import java.util.Date;
import java.util.List;

public interface ICustomerOrderService {
    CustomerOrder createOrder(String customerEmail, String customerAddress, Date orderDate, List<OrderItem> items);
    void addOrderItem(Long orderId, OrderItem item);
    void removeOrderItem(Long orderId, OrderItem item);
    CustomerOrder getOrder(Long orderId);
    void sendForDelivery(Long orderId);
    void updateDeliveryStatus(Long orderId, String status);
}
