package com.example.demo.controllers;

import com.example.demo.entities.CustomerOrder;
import com.example.demo.entities.OrderItem;
import com.example.demo.services.ICustomerOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class CustomerOrderController {

    @Autowired
    private ICustomerOrderService orderService;

    @PostMapping
    public CustomerOrder createOrder(@RequestBody CustomerOrder order) {
        return orderService.createOrder(order.getCustomerEmail(), order.getCustomerAddress(), order.getOrderDate(), order.getItems());
    }

    @PostMapping("/{orderId}/items")
    public void addOrderItem(@PathVariable Long orderId, @RequestBody OrderItem item) {
        orderService.addOrderItem(orderId, item);
    }

    @DeleteMapping("/{orderId}/items")
    public void removeOrderItem(@PathVariable Long orderId, @RequestBody OrderItem item) {
        orderService.removeOrderItem(orderId, item);
    }

    @GetMapping("/{orderId}")
    public CustomerOrder getOrder(@PathVariable Long orderId) {
        return orderService.getOrder(orderId);
    }

    @PutMapping("/{orderId}/send-for-delivery")
    public void sendForDelivery(@PathVariable Long orderId) {
        orderService.sendForDelivery(orderId);
    }

    @PutMapping("/{orderId}/delivery-status")
    public void updateDeliveryStatus(@PathVariable Long orderId, @RequestParam String status) {
        orderService.updateDeliveryStatus(orderId, status);
    }
}
