package com.gadgetmart.gadgetmart.service;

import com.gadgetmart.gadgetmart.entity.Vendor;
import com.gadgetmart.gadgetmart.repository.VendorRepository;
import com.waruna.gadgetmart_web.GetVendorRequest;
import com.waruna.gadgetmart_web.SaveVendorRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VendorService {
    private VendorRepository vendorRepository;

    @Autowired
    public VendorService(VendorRepository vendorRepository) {
        this.vendorRepository = vendorRepository;
    }

    public Vendor saveNewVendor(SaveVendorRequest request){
        Vendor vendor = new Vendor();
        vendor.setVendorId(request.getVendorId());
        vendor.setName(request.getName());
        vendor.setAddress(request.getAddress());
        vendor.setPhone(request.getPhone());

        return vendorRepository.save(vendor);
    }

    public Vendor getVendor(GetVendorRequest request){
        return vendorRepository.findByVendorId(request.getVendorId());
    }
}
