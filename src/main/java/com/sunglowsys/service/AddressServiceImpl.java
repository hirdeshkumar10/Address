package com.sunglowsys.service;

import com.sunglowsys.domain.Address;
import com.sunglowsys.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService{

    @Autowired
    private AddressRepository addressRepository;


    @Override
    public Address create(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public Address update(Address address, Long id) {
        Address address1 = addressRepository.getById(id);
        if(address.getAddressLine1() != null ){
            address1.setAddressLine1(address.getAddressLine1());
        }
        if(address.getAddressLine2() != null ){
            address1.setAddressLine2(address.getAddressLine2());
        }
        if(address.getCity() != null ){
            address1.setCity(address.getCity());
        }
        if(address.getState() != null ){
            address1.setState(address.getState());
        }
        if(address.getCountry() != null ){
            address1.setCountry(address.getCountry());
        }
        if(address.getZipcode() != null ){
            address1.setZipcode(address.getZipcode());
        }
        return addressRepository.save(address1);
    }

    @Override
    public Address findAddressById(Long id) {
        return addressRepository.findById(id).get();
    }

    @Override
    public List<Address> findAll() {
        return addressRepository.findAll();
    }


    @Override
    public void delete(Long id) {
        addressRepository.deleteById(id);
    }
}
