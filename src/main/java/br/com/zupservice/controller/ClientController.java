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

import br.com.zupservice.model.Client;
import br.com.zupservice.service.ClientService;

@RestController
@RequestMapping("/clients")
public class ClientController {

	@Autowired
	private ClientService clientService;

	@GetMapping("/")
	public ResponseEntity<?> getClient() {
		return new ResponseEntity<>("Maria", HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getClient(Long id) {
		return new ResponseEntity<>(clientService.getClient(id), HttpStatus.OK);
	}

	@PostMapping("/put")
	public ResponseEntity<?> save(Client client) {
		return new ResponseEntity<>(clientService.save(client), HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<?> update(Client client) {
		return new ResponseEntity<>(clientService.update(client), HttpStatus.OK);
	}

	@DeleteMapping
	public ResponseEntity<?> delete(Long client) {
		clientService.delete(client);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
