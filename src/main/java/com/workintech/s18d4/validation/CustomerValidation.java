package com.workintech.s18d4.validation;

import com.workintech.s18d4.entity.Customer;

public class CustomerValidation {



    public static boolean isIdValid(long id){
        if(id >= 0){
            return true;
        }

        return false;
    }


    public static boolean isCustomerValid(Customer customer){
        if( customer.getEmail()==null || customer.getSalary()==null ||
                customer.getFirstName()==null || customer.getLastName()==null || customer.getAddress()==null){
            return false;
        }

        return true;
    }

}
