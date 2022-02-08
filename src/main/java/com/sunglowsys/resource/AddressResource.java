package com.sunglowsys.resource;

import com.sunglowsys.domain.Address;
import com.sunglowsys.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AddressResource {
    @Autowired
    private AddressService addressService;

    @PostMapping("/addresses")
    public ResponseEntity<?> create(@RequestBody Address address) {
        Address address1 = addressService.create(address);
        return ResponseEntity.ok().body("Address is created successfully: " + address1);
    }

    @GetMapping("/addresses")
    public ResponseEntity<List<Address>> findAllAddress() {
        List<Address> result = addressService.findAll();
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/addresses/{id}")
    public ResponseEntity<Address> findAddress(@PathVariable("id") Long id) {
        Address address = addressService.findAddressById(id);
        return ResponseEntity.ok().body(address);
    }

    @PutMapping("/addresses/{id}")
    public Address update(@RequestBody Address address, @PathVariable("id") Long id) {
        return addressService.update(address, id);

    }

    @DeleteMapping("/addresses/{id}")
    public void delete(@PathVariable("id") Long id) {
        addressService.delete(id);
    }
}