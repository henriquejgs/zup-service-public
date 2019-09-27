package br.com.zupservice.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.zupservice.model.Address;
import br.com.zupservice.repository.AddressRepository;

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

	public void delete(Long addressId) {
		Optional<Address> address = addressRepository.findById(addressId);
		address.ifPresent(c -> addressRepository.delete(address.get()));
	}
}
