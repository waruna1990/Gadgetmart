package com.gadgetmart.gadgetmart.endpoint;

import com.gadgetmart.gadgetmart.dto.Product;
import com.gadgetmart.gadgetmart.service.ProductService;
import com.waruna.gadgetmart_web.GetInventoryRequest;
import com.waruna.gadgetmart_web.GetInventoryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Endpoint
public class ProductEndpoint {

    ProductService productService;

    @Autowired
    public ProductEndpoint(ProductService productService) {
        this.productService = productService;
    }

    @PayloadRoot(namespace = "http://waruna.com/gadgetmart-web",
            localPart = "getInventoryRequest")
    @ResponsePayload
    public GetInventoryResponse getAllInventory(@RequestPayload GetInventoryRequest request) {
        GetInventoryResponse response = new GetInventoryResponse();
        List<com.waruna.gadgetmart_web.Product> modifiedList = new ArrayList<>();
        if (!ObjectUtils.isEmpty(request.getType()) &&
                request.getType().toLowerCase(Locale.ROOT).equals("all")) {
            List<Product> productList = productService.getAllProducts();
            response.setProduct(productList.stream().map(product -> {
                com.waruna.gadgetmart_web.Product prod = new com.waruna.gadgetmart_web.Product();
                prod.setProductId(Integer.parseInt(product.getProductId()));
                prod.setName(product.getName());
                prod.setBrand(product.getBrand());
                prod.setCost(product.getCost());
                return prod;
            }).collect(Collectors
                    .toCollection(ArrayList::new)));
        }
        return response;
    }
}
