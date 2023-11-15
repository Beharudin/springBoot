package com.rest.restDemo.repository;

import com.rest.restDemo.model.CloudVendor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendorRepository extends JpaRepository<CloudVendor, Integer> {
}
