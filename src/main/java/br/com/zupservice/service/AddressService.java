package br.com.zupservice.service;

import br.com.zupservice.model.Address;
import br.com.zupservice.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddressService {

    private AddressRepository addressRepository;

    @Autowired
    private AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public Optional<Address> getAddress(Long id) {
        return addressRepository.findById(id);
    }

    public Address save(Address address) {
        return addressRepository.save(address);
    }

    public Address update(Address address) {
        return addressRepository.save(address);
    }

    public HttpStatus delete(Long addressId) {
        if (addressRepository.existsById(addressId)) {
            addressRepository.deleteById(addressId);
            return HttpStatus.OK;
        }
        return HttpStatus.NOT_FOUND;
    }

    public Page<Address> findAll(Pageable pageable) {
        return addressRepository.findAll(pageable);
    }
}
