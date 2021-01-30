package com.softlogic.softlogicweb.repository;

import com.softlogic.softlogicweb.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
    List<Product> findByBrandAndTypeAndAndCost(String brand, String type, float cost);

}
