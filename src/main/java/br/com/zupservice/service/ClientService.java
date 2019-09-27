package br.com.zupservice.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.zupservice.model.Client;
import br.com.zupservice.repository.ClientRepository;

@Service
public class ClientService {
	
	private ClientRepository clientRepository;
	
	@Autowired
	private ClientService(ClientRepository clientRepository) {
		this.clientRepository = clientRepository;
	}	

	public Optional<Client> getClient(Long id) {
		return clientRepository.findById(id);
	}
	
	public Client save(Client client) {
		return clientRepository.save(client);
	}
	
	public Client update(Client client) {
		return clientRepository.save(client);
	}
	
	public void delete(Long clientId) {		
		Optional<Client> client = clientRepository.findById(clientId);
		client.ifPresent(c -> clientRepository.delete(client.get()));
	}
}
