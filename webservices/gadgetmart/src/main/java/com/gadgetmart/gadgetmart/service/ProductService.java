package com.gadgetmart.gadgetmart.service;

import com.gadgetmart.gadgetmart.dto.Product;
import com.gadgetmart.gadgetmart.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        List<Product> mainList = productRepository.getAbansAllProducts();
        List<Product> singerList = productRepository.getSingerAllProducts();
        singerList.stream().forEach(mainList::add);
        List<Product> softlogicList = productRepository.getSoftlogicAllProducts();
        softlogicList.stream().forEach(mainList::add);
        return mainList;
    }
}
