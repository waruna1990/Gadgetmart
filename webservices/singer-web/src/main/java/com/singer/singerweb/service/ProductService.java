package com.singer.singerweb.service;

import com.singer.singerweb.ProductRepository;
import com.singer.singerweb.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<com.waruna.singer_web.Product> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return getProducts(products);
    }

    public List<com.waruna.singer_web.Product> getProductsForQuery(String brand, String type, float cost) {
        List<Product> products =  productRepository.findByBrandAndTypeAndAndCost(brand, type, cost);
        return getProducts(products);
    }

    private List<com.waruna.singer_web.Product> getProducts(List<Product> products) {
        List<com.waruna.singer_web.Product> modifiedProd = products.stream()
                .map(p -> {
                    com.waruna.singer_web.Product prod = new com.waruna.singer_web.Product();
                    prod.setProductId(Integer.parseInt(p.getProductId()));
                    prod.setName(p.getName());
                    prod.setCost(p.getCost());
                    prod.setBrand(p.getBrand());
                    prod.setVendorId("2");
                    return prod;
                })
                .collect(Collectors.toList());
        return modifiedProd;
    }

}
