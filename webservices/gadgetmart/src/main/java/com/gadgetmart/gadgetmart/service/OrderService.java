package com.gadgetmart.gadgetmart.service;

import com.gadgetmart.gadgetmart.entity.Order;
import com.gadgetmart.gadgetmart.repository.OrderRepository;
import com.waruna.gadgetmart_web.GetUserOrdersRequest;
import com.waruna.gadgetmart_web.SaveOrderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {
    private OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public int saveOrderList(SaveOrderRequest request) {
        List<Order> savedOrders = request.getOrderItem()
                .stream()
                .map(
                        orderItem -> {
                            Order order = new Order();
                            order.setId(orderItem.getId());
                            order.setUserId(orderItem.getUserId());
                            order.setProductId(orderItem.getProductId());
                            order.setVendorId(orderItem.getVendorId());
                            order.setQuantity(orderItem.getQuantity());
                            return orderRepository.save(order);
                        }
                ).collect(Collectors.toList());

        return savedOrders.size();
    }

    public List<Order> getUserOrders(GetUserOrdersRequest request){
        return orderRepository.findByUserId(request.getUserId());
    }
}
