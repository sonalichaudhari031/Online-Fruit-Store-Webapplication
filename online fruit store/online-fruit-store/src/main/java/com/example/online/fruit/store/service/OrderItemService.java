package com.example.online.fruit.store.service;

import org.springframework.stereotype.Service;
import com.example.online.fruit.store.Repository.OrderItemRepository;
import com.example.online.fruit.store.Entity.OrderItem;
import java.util.List;
import java.util.Optional;

@Service
public class OrderItemService {

    private final OrderItemRepository orderItemRepository;

    public OrderItemService(OrderItemRepository orderItemRepository) {
        this.orderItemRepository = orderItemRepository;
    }

    public List<OrderItem> getAllOrderItems() {
        return orderItemRepository.findAll();
    }

    public Optional<OrderItem> getOrderItemById(Long id) {
        return orderItemRepository.findById(id);
    }

    public List<OrderItem> getItemsByOrder(Long orderId) {
        return orderItemRepository.findByOrderId(orderId);
    }

    public OrderItem createOrderItem(OrderItem item) {
        item.calculatePrice(); 
        return orderItemRepository.save(item);
    }

    public OrderItem updateOrderItem(Long id, OrderItem updatedItem) {
        return orderItemRepository.findById(id).map(item -> {
            item.setQuantity(updatedItem.getQuantity());
            item.setFruit(updatedItem.getFruit());
            item.calculatePrice();
            return orderItemRepository.save(item);
        }).orElseThrow(() -> new RuntimeException("OrderItem not found with id: " + id));
    }

    public void deleteOrderItem(Long id) {
        orderItemRepository.deleteById(id);
    }
}
