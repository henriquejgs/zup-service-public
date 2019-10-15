package br.com.zupservice.controller;

import br.com.zupservice.model.Client;
import br.com.zupservice.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping
    public ResponseEntity<?> getClient(Pageable pageable) {
        return new ResponseEntity<>(clientService.findAll(pageable), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getClient(@PathVariable(name = "id") Long id) {
        return getHttpStatusToClientDAO(clientService.getClient(id).get());
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Client client) {
        return getHttpStatusToClientDAO(clientService.save(client));
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Client client) {
        return getHttpStatusToClientDAO(clientService.update(client));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") Long id) {
        return new ResponseEntity<>(clientService.delete(id));
    }

    private ResponseEntity<?> getHttpStatusToClientDAO(Client client) {
        return Optional.ofNullable(client).isPresent()
                ? new ResponseEntity<>(client, HttpStatus.OK)
                : new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

}
