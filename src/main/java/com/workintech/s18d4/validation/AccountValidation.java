package com.workintech.s18d4.validation;

import com.workintech.s18d4.entity.Account;
import com.workintech.s18d4.entity.Address;

public class AccountValidation {

    public static boolean isIdValid(Long id){
        if(id <= 0){
            return false;
        }
        return true;
    }



    public static boolean isAccountValid(Account account){
        if(account.getAccountName() == null || account.getCustomer() == null || account.getAccountName() == null || account.getMoneyAmount() == null){
            return false;
        }
        return true;
    }
}
