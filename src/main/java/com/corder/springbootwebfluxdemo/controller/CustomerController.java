package com.corder.springbootwebfluxdemo.controller;

import com.corder.springbootwebfluxdemo.dto.Customer;
import com.corder.springbootwebfluxdemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerService service;

    @GetMapping
    public List<Customer> getAllCustomers() throws InterruptedException {
        return service.loadAllCustomers();
    }

    @GetMapping(value ="/stream" ,produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Customer> getAllCustomersStream() throws InterruptedException {
        return service.loadAllCustomersStream();
    }


}
