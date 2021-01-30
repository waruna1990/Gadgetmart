package com.softlogic.softlogicweb.endpoint;

import com.softlogic.softlogicweb.service.ProductService;
import com.waruna.softlogic_web.GetInventoryRequest;
import com.waruna.softlogic_web.GetInventoryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.Locale;

@Endpoint
public class InventoryEndpoint {

    ProductService productService;

    @Autowired
    public InventoryEndpoint(ProductService productService) {
        this.productService = productService;
    }

    @PayloadRoot(namespace = "http://waruna.com/softlogic-web",
            localPart = "getInventoryRequest")
    @ResponsePayload
    public GetInventoryResponse getUserRequest(@RequestPayload GetInventoryRequest request) {

        GetInventoryResponse response = new GetInventoryResponse();
        if (!ObjectUtils.isEmpty(request.getType()) &&
                request.getType().toLowerCase(Locale.ROOT).equals("all")) {
            response.setProduct(productService.getAllProducts());
        } else {
            response.setProduct(productService
                    .getProductsForQuery(request.getBrand(), request.getType(), request.getCost()));
        }

        return response;
    }

}