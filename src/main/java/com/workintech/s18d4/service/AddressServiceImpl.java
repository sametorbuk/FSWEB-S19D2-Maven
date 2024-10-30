package com.workintech.s18d4.service;

import com.workintech.s18d4.repository.AddressRepository;
import com.workintech.s18d4.entity.Address;
import com.workintech.s18d4.exceptions.BankException;
import com.workintech.s18d4.validation.AddressValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService{

   private AddressRepository addressRepository;

    @Autowired
    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public List<Address> findAll() {
        return addressRepository.findAll();
    }

    @Override
    public Address find(long id) {

        if(AddressValidation.isIdValid(id)){
            Optional<Address> foundAddress = addressRepository.findById(id);
            if(foundAddress.isPresent()){
                return foundAddress.get();
            }
            throw new BankException("There is no address with this id" + id , HttpStatus.NOT_FOUND);
        }

        throw new BankException("Please enter a valid id" , HttpStatus.BAD_REQUEST);


    }

    @Override
    public Address save(Address address) {
        if(AddressValidation.isAddressValid(address)){
            addressRepository.save(address);
            return address;
        }
        throw new BankException("The data of this address is not valid" , HttpStatus.BAD_REQUEST);
    }

    @Override
    public Address update(Address address, long addressId) {
        Optional<Address> foundAddress=addressRepository.findById(addressId);
        if(foundAddress.isPresent()){
            addressRepository.save(address);
        }
        throw new BankException("There is no address with this id" , HttpStatus.NOT_FOUND);
    }

    @Override
    public Address delete(long id) {
        Optional<Address> foundAddress=addressRepository.findById(id);
        if(foundAddress.isPresent()){
            addressRepository.delete(foundAddress.get());
        }

        throw new BankException("There is no address with this id" , HttpStatus.NOT_FOUND);
    }
}
