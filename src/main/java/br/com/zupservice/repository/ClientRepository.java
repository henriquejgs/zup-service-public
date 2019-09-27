package br.com.zupservice.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.zupservice.model.Client;

public interface ClientRepository extends PagingAndSortingRepository<Client, Long> {

}
