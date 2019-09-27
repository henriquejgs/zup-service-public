package br.com.zupservice.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.zupservice.model.Address;

public interface AddressRepository extends PagingAndSortingRepository<Address, Long> {

}
