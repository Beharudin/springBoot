package com.rest.restDemo.service;

import com.rest.restDemo.model.CloudVendor;

import java.util.List;
import java.util.Optional;


public interface VendorService {

    public CloudVendor getCloudVendorById(Integer id);
    public List<CloudVendor> getAllVendorCloud();
    public String addCloudVendor(CloudVendor cloudVendor);
    public String updateVendorById(Integer id, CloudVendor cloudVendor);
    public String deleteVendoById(Integer id);

}
