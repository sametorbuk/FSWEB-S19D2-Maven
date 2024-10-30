package com.workintech.s18d4.service;

import com.workintech.s18d4.repository.AccountRepository;
import com.workintech.s18d4.repository.CustomerRepository;
import com.workintech.s18d4.entity.Account;
import com.workintech.s18d4.entity.Customer;
import com.workintech.s18d4.exceptions.BankException;
import com.workintech.s18d4.dto.AccountResponse;
import com.workintech.s18d4.dto.CustomerResponse;
import com.workintech.s18d4.validation.AccountValidation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements AccountService{

    private AccountRepository accountRepository;
    private CustomerRepository customerRepository;


    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }


    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public Account find(long id) {
        if(AccountValidation.isIdValid(id)){
           Optional<Account> foundAccount = accountRepository.findById(id);
           if(foundAccount.isPresent()){
               return foundAccount.get();
           }else{
               throw new BankException("There is no account with this id" , HttpStatus.NOT_FOUND);
           }
        }

        throw new BankException("Please enter a valid id" , HttpStatus.BAD_REQUEST);
    }

    @Override
    public Account save(long customer_id, Account account) {
        if(AccountValidation.isIdValid(customer_id)){
            Optional<Customer> foundCustomer = customerRepository.findById(customer_id);
            if(foundCustomer.isPresent()){
                Customer cust = foundCustomer.get();
                if(AccountValidation.isAccountValid(account)){
                    cust.addAccount(account);
                    account.setCustomer(cust);

                    return  accountRepository.save(account);
                }else{
                    throw new BankException("Please enter a valiad accound data" , HttpStatus.BAD_REQUEST);
                }

            }else{
             throw   new BankException("There is no customer with this id" , HttpStatus.NOT_FOUND);
            }
        }
        throw new BankException("Please enter a valid id" , HttpStatus.BAD_REQUEST);
    }

    @Override
    public CustomerResponse update(long customer_id, Account account) {
        if(AccountValidation.isIdValid(customer_id)){
            Optional<Customer> customer = customerRepository.findById(customer_id);
            if(customer.isPresent()){
                Customer cust = customer.get();
                if(AccountValidation.isAccountValid(account)){
                 cust.addAccount(account);
                 account.setCustomer(cust);
                 accountRepository.save(account);
                    return new CustomerResponse(cust.getId(), cust.getEmail(), cust.getSalary());
                }else{
                  throw   new BankException("Please enter a valid accound varible" , HttpStatus.BAD_REQUEST);
                }
            }else{
                throw new BankException("There is no customer with this id" , HttpStatus.NOT_FOUND);
            }
        }
        throw new BankException("Please enter a valid customer id" , HttpStatus.BAD_REQUEST);
    }

    @Override
    public Account delete(long id) {
       if(AccountValidation.isIdValid(id)){
           Optional<Account> foundAccount = accountRepository.findById(id);
           if(foundAccount.isPresent()){
               accountRepository.delete(foundAccount.get());
           }
       }
       return null;
    }

    @Override
    public Account save(Account account) {
        return accountRepository.save(account);
    }


}
