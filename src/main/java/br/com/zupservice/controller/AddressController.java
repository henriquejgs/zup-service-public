package br.com.zupservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupservice.model.Address;
import br.com.zupservice.service.AddressService;

@RestController
@RequestMapping("/address")
public class AddressController {

	@Autowired
	private AddressService addressService;

	@GetMapping("/")
	public ResponseEntity<?> getAddress() {
		return new ResponseEntity<>("Maria", HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getAddress(Long id) {
		return new ResponseEntity<>(addressService.getAddress(id), HttpStatus.OK);
	}

	@PostMapping("/put")
	public ResponseEntity<?> save(Address address) {
		return new ResponseEntity<>(addressService.save(address), HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<?> update(Address address) {
		return new ResponseEntity<>(addressService.update(address), HttpStatus.OK);
	}

	@DeleteMapping
	public ResponseEntity<?> delete(Long address) {
		addressService.delete(address);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
