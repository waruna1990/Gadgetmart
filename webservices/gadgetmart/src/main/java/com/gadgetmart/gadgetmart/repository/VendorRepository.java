package com.gadgetmart.gadgetmart.repository;

import com.gadgetmart.gadgetmart.entity.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendorRepository extends JpaRepository<Vendor, String> {
    Vendor findByVendorId(String id);
}
