package com.workintech.s18d4.controller;

import com.workintech.s18d4.dto.CustomerResponse;
import com.workintech.s18d4.entity.Customer;
import com.workintech.s18d4.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }


    @GetMapping
    public List<Customer> getCustomers(){
      return  customerService.findAll();
    }


    @GetMapping("/{id}")
    public Customer findById(@PathVariable long id){
        return customerService.find(id);
    }


    @PostMapping
    public Customer saveCustomer(@RequestBody Customer customer){
        return customerService.save(customer);
    }

    @PutMapping("/{id}")
    public CustomerResponse updateCustomer(@PathVariable long id , Customer customer){
        return customerService.update(id , customer);
    }


    @DeleteMapping("/{id}")
    public Customer deleteCustomer(@PathVariable long id){
        return customerService.delete(id);
    }






}
