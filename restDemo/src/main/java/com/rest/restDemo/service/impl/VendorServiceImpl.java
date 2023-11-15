package com.rest.restDemo.service.impl;

import com.rest.restDemo.exception.CloudVendorConflictException;
import com.rest.restDemo.exception.CloudVendorNotFoundException;
import com.rest.restDemo.model.CloudVendor;
import com.rest.restDemo.repository.VendorRepository;
import com.rest.restDemo.service.VendorService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VendorServiceImpl implements VendorService {

    VendorRepository vendorRepository;

    public VendorServiceImpl(VendorRepository vendorRepository) {
        this.vendorRepository = vendorRepository;
    }

    private List<CloudVendor> vendors=new ArrayList<>();
    public CloudVendor getCloudVendorById(Integer id){
        if(vendorRepository.findById(id).isEmpty())
            throw new CloudVendorNotFoundException("Requested Cloud Vendor does not exist");
        return vendorRepository.findById(id).get();
    }
    public List<CloudVendor> getAllVendorCloud(){
        return  vendorRepository.findAll();
    }

    public String addCloudVendor(CloudVendor cloudVendor){
        Optional<CloudVendor> existingVendor=vendorRepository.findById(cloudVendor.getVendorId());

        if(existingVendor.isPresent()){
            throw new CloudVendorConflictException("Duplicate vendor id");
        }else{
        vendorRepository.save(cloudVendor);
        return "Succesfully Added";
        }
    }

    public String updateVendorById(Integer id, CloudVendor cloudVendor) {
        if(vendorRepository.findById(id).isEmpty())
            throw new CloudVendorNotFoundException("Requested Cloud Vendor does not exist");
        else {
        vendorRepository.save(cloudVendor);
        return "Updated succesfully";
        }
    }

    public String deleteVendoById(Integer id) {
        vendorRepository.deleteById(id);
        return "Deleted succesfully";
    }
}
