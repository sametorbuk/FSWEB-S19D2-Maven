package com.workintech.s18d4.validation;

import com.workintech.s18d4.entity.Address;

public class AddressValidation {

    public static boolean isIdValid(long id){
        if(id <= 0){
            return false;
        }
        return true;
    }



    public static boolean isAddressValid(Address address){
        if(address.getId() == null || address.getCountry() == null || address.getDescription() == null || address.getStreet() == null){
            return false;
        }
        return true;
    }
}
