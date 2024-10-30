package com.workintech.s18d4.service;

import com.workintech.s18d4.repository.CustomerRepository;
import com.workintech.s18d4.dto.CustomerResponse;
import com.workintech.s18d4.entity.Customer;
import com.workintech.s18d4.exceptions.BankException;
import com.workintech.s18d4.validation.CustomerValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService{


    private CustomerRepository customerRepository;


    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }



    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer find(long id) {
        if(CustomerValidation.isIdValid(id)){
            Optional<Customer> foundCustomer = customerRepository.findById(id);
            if(foundCustomer.isPresent()){
                Customer customer=foundCustomer.get();
                return foundCustomer.get();
            }else{
             throw new BankException("There is no customer with this id" , HttpStatus.NOT_FOUND);
            }
        }

        throw new BankException("Please enter a valid id" , HttpStatus.BAD_REQUEST);
    }

    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public CustomerResponse update(long id, Customer customer) {
        if(CustomerValidation.isIdValid(id)){
            Optional<Customer> foundCustomer=customerRepository.findById(id);
            if(foundCustomer.isPresent()){
                Customer foundCust=foundCustomer.get();
                customer.setAccount(foundCust.getAccount());
                customer.setId(customer.getId());
                customer.setSalary(customer.getSalary());
                customer.setAddress(foundCust.getAddress());
                customer.setFirstName(foundCust.getFirstName());
                customer.setLastName(foundCust.getLastName());
            }else{
                throw new BankException("There is no customer with this id", HttpStatus.NOT_FOUND);
            }
        }

        throw new BankException("Please enter a valid id" , HttpStatus.BAD_REQUEST);
    }

    @Override
    public Customer delete(long id) {
        if (CustomerValidation.isIdValid(id)) {
            Optional<Customer> foundCustomer = customerRepository.findById(id);
            if (foundCustomer.isPresent()) {
                Customer customer = foundCustomer.get();
                customerRepository.deleteById(id);
                return customer;
            }
           return null;
        }
        throw new BankException("Please enter a valid id", HttpStatus.BAD_REQUEST);
    }


}
