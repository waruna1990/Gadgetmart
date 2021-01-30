package com.gadgetmart.gadgetmart.repository;

import com.gadgetmart.gadgetmart.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, String> {
    List<Order> findByUserId(String id);
}
