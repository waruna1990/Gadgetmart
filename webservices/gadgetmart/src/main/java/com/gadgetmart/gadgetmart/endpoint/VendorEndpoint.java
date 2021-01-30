package com.gadgetmart.gadgetmart.endpoint;

import com.gadgetmart.gadgetmart.entity.Vendor;
import com.gadgetmart.gadgetmart.service.VendorService;
import com.waruna.gadgetmart_web.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class VendorEndpoint {
    private VendorService vendorService;

    @Autowired
    public VendorEndpoint(VendorService vendorService) {
        this.vendorService = vendorService;
    }

    @PayloadRoot(namespace = "http://waruna.com/gadgetmart-web",
            localPart = "saveVendorRequest")
    @ResponsePayload
    public SaveVendorResponse saveNewVendor(@RequestPayload SaveVendorRequest request) {
        Vendor vendor = vendorService.saveNewVendor(request);
        SaveVendorResponse response = new SaveVendorResponse();
        response.setVendorId(vendor.getVendorId());
        response.setName(vendor.getName());
        response.setAddress(vendor.getAddress());
        response.setPhone(vendor.getPhone());
        return response;
    }

    @PayloadRoot(namespace = "http://waruna.com/gadgetmart-web",
            localPart = "getVendorRequest")
    @ResponsePayload
    public GetVendorResponse saveNewVendor(@RequestPayload GetVendorRequest request) {
        Vendor vendor = vendorService.getVendor(request);
        GetVendorResponse response = new GetVendorResponse();
        response.setVendorId(vendor.getVendorId());
        response.setName(vendor.getName());
        response.setAddress(vendor.getAddress());
        response.setPhone(vendor.getPhone());
        return response;
    }
}
