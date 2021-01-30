package com.abans.abansweb.service;

import com.abans.abansweb.entities.Product;
import com.abans.abansweb.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {


    ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<com.waruna.abans_web.Product> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return getProducts(products);
    }

    public List<com.waruna.abans_web.Product> getProductsForQuery(String brand, String type, float cost) {

        List<Product> products =  productRepository.findByBrandAndTypeAndAndCost(brand, type, cost);
        return getProducts(products);
    }

    private List<com.waruna.abans_web.Product> getProducts(List<Product> products) {
        List<com.waruna.abans_web.Product> modifiedProd = products.stream()
                .map(p -> {
                    com.waruna.abans_web.Product prod = new com.waruna.abans_web.Product();
                    prod.setProductId(Integer.parseInt(p.getProductId()));
                    prod.setName(p.getName());
                    prod.setCost(p.getCost());
                    prod.setBrand(p.getBrand());
                    prod.setVendorId("1");
                    return prod;
                })
                .collect(Collectors.toList());
        return modifiedProd;
    }


}
