package com.workintech.s18d4.service;

import com.workintech.s18d4.dto.CustomerResponse;
import com.workintech.s18d4.entity.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> findAll();

    Customer find(long id);

    Customer save(Customer customer);

    CustomerResponse update(long id , Customer customer);

    Customer delete(long id);


}
