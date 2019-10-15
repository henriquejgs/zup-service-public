package br.com.zupservice.controller;

import br.com.zupservice.model.Address;
import br.com.zupservice.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping
    public ResponseEntity<?> getAddress(Pageable pageable) {
        return new ResponseEntity<>(addressService.findAll(pageable), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getAddress(@PathVariable(name = "id") Long id) {
        return getHttpStatusToAddressDAO(addressService.getAddress(id).get());
    }

    @PostMapping("/put")
    public ResponseEntity<?> save(@RequestBody Address address) {
        return getHttpStatusToAddressDAO(addressService.save(address));
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Address address) {
        return getHttpStatusToAddressDAO(addressService.update(address));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") Long address) {
        return new ResponseEntity<>(addressService.delete(address));
    }

    private ResponseEntity<?> getHttpStatusToAddressDAO(Address address) {
        return Optional.ofNullable(address).isPresent()
                ? new ResponseEntity<>(address, HttpStatus.OK)
                : new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

}
