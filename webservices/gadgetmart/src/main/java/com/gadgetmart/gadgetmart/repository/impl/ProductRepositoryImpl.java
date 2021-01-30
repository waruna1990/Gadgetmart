package com.gadgetmart.gadgetmart.repository.impl;

import com.gadgetmart.gadgetmart.dto.Product;
import com.gadgetmart.gadgetmart.repository.ProductRepository;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    @Override
    public List<Product> getAbansAllProducts() {
        RestTemplate restTemplate = new RestTemplate();
        String abansUrl = "http://localhost:8280/abans";

        return getProducts(restTemplate, abansUrl);
    }

    @Override
    public List<Product> getSingerAllProducts() {
        RestTemplate restTemplate = new RestTemplate();
        String singerUrl = "http://localhost:8280/singer";
        return getProducts(restTemplate, singerUrl);
    }

    @Override
    public List<Product> getSoftlogicAllProducts() {
        RestTemplate restTemplate = new RestTemplate();
        String softlogicUrl = "http://localhost:8280/softlogic";
        return getProducts(restTemplate, softlogicUrl);
    }

    private List<Product> getProducts(RestTemplate restTemplate, String url) {
        Product product = new Product();
        product.setType("all");

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<Object> entity = new HttpEntity<>(product, httpHeaders);

        ResponseEntity<List<Product>> products = restTemplate
                .exchange(url, HttpMethod.POST, entity, new ParameterizedTypeReference<List<Product>>() {
                });
        return products.getBody();
    }
}
