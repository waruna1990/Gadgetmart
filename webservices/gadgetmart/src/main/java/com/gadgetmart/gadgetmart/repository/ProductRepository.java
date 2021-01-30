package com.gadgetmart.gadgetmart.repository;

import com.gadgetmart.gadgetmart.dto.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ProductRepository {

    List<Product> getAbansAllProducts();

    List<Product> getSingerAllProducts();

    List<Product> getSoftlogicAllProducts();
}
