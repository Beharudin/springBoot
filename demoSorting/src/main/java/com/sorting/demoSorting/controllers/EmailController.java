package com.sorting.demoSorting.controllers;

import com.sorting.demoSorting.dto.EmailDto;
import com.sorting.demoSorting.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/email/send")
public class EmailController {
    @Autowired
    private EmailService service;

    @PostMapping
    private ResponseEntity<Object> sendEmail(@RequestBody() EmailDto emailDto) {
        System.out.println(emailDto);
        return service.sendEmail(emailDto.getEmail(), emailDto.getSubject(), emailDto.getBody());
    }
}

