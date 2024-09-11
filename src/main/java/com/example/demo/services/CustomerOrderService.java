package com.example.demo.services;

import com.example.demo.entities.CustomerOrder;
import com.example.demo.entities.OrderItem;
import com.example.demo.repositories.ICustomerOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;
import java.util.List;  // Import the List class

@Service
public class CustomerOrderService implements ICustomerOrderService {

    @Autowired
    private ICustomerOrderRepository orderRepository;

    @Override
    public CustomerOrder createOrder(String customerEmail, String customerAddress, Date orderDate, List<OrderItem> items) {
        CustomerOrder order = new CustomerOrder(null, customerEmail, customerAddress, orderDate, items);
        return orderRepository.save(order);
    }

    @Override
    public void addOrderItem(Long orderId, OrderItem item) {
        Optional<CustomerOrder> orderOptional = orderRepository.findById(orderId);
        if (orderOptional.isPresent()) {
            CustomerOrder order = orderOptional.get();
            order.addOrderItem(item);
            orderRepository.save(order);
        }
    }

    @Override
    public void removeOrderItem(Long orderId, OrderItem item) {
        Optional<CustomerOrder> orderOptional = orderRepository.findById(orderId);
        if (orderOptional.isPresent()) {
            CustomerOrder order = orderOptional.get();
            order.removeOrderItem(item);
            orderRepository.save(order);
        }
    }

    @Override
    public CustomerOrder getOrder(Long orderId) {
        return orderRepository.findById(orderId).orElse(null);
    }

    @Override
    public void sendForDelivery(Long orderId) {
        Optional<CustomerOrder> orderOptional = orderRepository.findById(orderId);
        if (orderOptional.isPresent()) {
            CustomerOrder order = orderOptional.get();
            order.sendForDelivery();
            orderRepository.save(order);
        }
    }

    @Override
    public void updateDeliveryStatus(Long orderId, String status) {
        Optional<CustomerOrder> orderOptional = orderRepository.findById(orderId);
        if (orderOptional.isPresent()) {
            CustomerOrder order = orderOptional.get();
            order.updateDeliveryStatus(status);
            orderRepository.save(order);
        }
    }
}
