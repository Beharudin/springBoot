package com.rest.restDemo.controller;

import com.rest.restDemo.model.CloudVendor;
import com.rest.restDemo.response.ResponseHandler;
import com.rest.restDemo.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("vendor")
@RestController
public class VendorController {
    private VendorService vendorService;

    @Autowired
    public VendorController(VendorService vendorService) {
        this.vendorService = vendorService;
    }

    @GetMapping("{id}")
    public ResponseEntity<Object> getVendorCloudById(@PathVariable("id") Integer id){
        return  ResponseHandler.responseBuilder("Success", HttpStatus.OK, vendorService.getCloudVendorById(id));
    }

    @GetMapping()
    public ResponseEntity<Object> getAllVendorCloud(){
        return  ResponseHandler.responseBuilder("Success", HttpStatus.OK, vendorService.getAllVendorCloud());
    }

    @PostMapping()
    public String addCloudVendor(@RequestBody CloudVendor cloudVendor){
        return vendorService.addCloudVendor(cloudVendor);
    }

    @PutMapping("{id}")
    public String updateVendorById(@PathVariable("id") Integer id, @RequestBody CloudVendor cloudVendor) {
        return vendorService.updateVendorById(id, cloudVendor);
    }

    @DeleteMapping("{id}")
    public String deleteVendoById(@PathVariable("id") Integer id) {
        return  vendorService.deleteVendoById(id);
    }

}
