package com.gadgetmart.gadgetmart.endpoint;

import com.gadgetmart.gadgetmart.entity.Order;
import com.gadgetmart.gadgetmart.entity.User;
import com.gadgetmart.gadgetmart.service.OrderService;
import com.waruna.gadgetmart_web.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.List;
import java.util.stream.Collectors;

@Endpoint
public class OrderEndpoint {

    private OrderService orderService;

    @Autowired
    public OrderEndpoint(OrderService orderService) {
        this.orderService = orderService;
    }

    @PayloadRoot(namespace = "http://waruna.com/gadgetmart-web",
            localPart = "saveOrderRequest")
    @ResponsePayload
    public SaveOrderResponse saveUser(@RequestPayload SaveOrderRequest request) {
        int savedCount = orderService.saveOrderList(request);
        SaveOrderResponse response = new SaveOrderResponse();
        response.setCount(String.valueOf(savedCount));
        response.setMessage("Order List Saved Successfully!");
        return response;
    }

    @PayloadRoot(namespace = "http://waruna.com/gadgetmart-web",
            localPart = "getUserOrdersRequest")
    @ResponsePayload
    public GetUserOrdersResponse getUserOrderList(@RequestPayload GetUserOrdersRequest request) {
        List<Order> orders = orderService.getUserOrders(request);
        List<OrderItem> orderItemList = orders.stream().map(
                order -> {
                    OrderItem orderItem = new OrderItem();
                    orderItem.setId(order.getId());
                    orderItem.setUserId(order.getUserId());
                    orderItem.setProductId(order.getProductId());
                    orderItem.setVendorId(order.getVendorId());
                    orderItem.setQuantity(order.getQuantity());
                    return orderItem;
                }
        ).collect(Collectors.toList());
        GetUserOrdersResponse response = new GetUserOrdersResponse();
        response.setOrderItem(orderItemList);
        return response;
    }
}
