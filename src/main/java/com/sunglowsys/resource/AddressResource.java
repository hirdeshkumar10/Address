package com.sunglowsys.resource;

import com.sunglowsys.domain.Address;
import com.sunglowsys.service.AddressService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class AddressResource {

    private final Logger log = LoggerFactory.getLogger(AddressResource.class);


    private final AddressService addressService;

    public AddressResource(AddressService addressService) {
        this.addressService = addressService;
    }

    @PostMapping("/addresses")
    public ResponseEntity<?> create(@RequestBody Address address) throws URISyntaxException {
        log.debug("Rest request to save Address: {}",address);
        if (address.getId() != null){
            throw new RuntimeException("Id should be null in save api calls");
        }
        Address result = addressService.create(address);
        return ResponseEntity
                .created(new URI("/api/addresses/"+result.getId()))
                .body(result);
    }

    @GetMapping("/addresses")
    public ResponseEntity<List<Address>> findAllAddress(Pageable pageable) {
        log.debug("Rest request to get to all Address: {}",pageable.toString());
        Page<Address> result = addressService.findAll(pageable);
        return ResponseEntity
                .ok()
                .body(result.getContent());
    }

    @GetMapping("/addresses/{id}")
    public ResponseEntity<Address> findAddressById(@PathVariable Long id) {
        log.debug("Rest request to get by id Address: {}",id);
        Optional<Address> result = addressService.findById(id);
        return ResponseEntity
                .ok()
                .body(result.get());
    }

    @PutMapping("/addresses")
    public ResponseEntity<Address> updateAddress(@RequestBody Address address) {
        log.debug("Rest Request to update Address: {}",address);
        Address result = addressService.update(address);
        return ResponseEntity
                .ok()
                .body(result);

    }

    @DeleteMapping("/addresses/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        log.debug("Rest Request to delete Address: {}",id);
        addressService.delete(id);
        return ResponseEntity
                .ok()
                .build();
    }
}