package com.sunglowsys.service;

import com.sunglowsys.domain.Address;
import com.sunglowsys.repository.AddressRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService{

    private final Logger log = LoggerFactory.getLogger(AddressServiceImpl.class);

    private final AddressRepository addressRepository;

    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }


    @Override
    public Address create(Address address) {
        log.debug("Request to save Address: {}",address);
        return addressRepository.save(address);
    }

    @Override
    public Address update(Address address ){
        log.debug("Request to update Address: {}",address);
        return addressRepository.save(address);
    }

    @Override
    public Optional<Address> findById(Long id) {
        log.debug("Request to find Address by id: {}",id);
        return addressRepository.findById(id);
    }


    @Override
    public Page<Address> findAll(Pageable pageable) {
        log.debug("Request to find all Address: {}", pageable.toString());
        return addressRepository.findAll(pageable);
    }


    @Override
    public void delete(Long id) {
        log.debug("Request to delete Address by id : {}",id);
        addressRepository.deleteById(id);
    }
}
