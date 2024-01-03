package br.com.clinicavt.controllers;

import br.com.clinicavt.models.client.Client;
import br.com.clinicavt.models.client.ClientDto;
import br.com.clinicavt.models.client.ClientUpdate;
import br.com.clinicavt.repositories.ClientRepository;
import br.com.clinicavt.services.ClientService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("clients")
public class ClientsController {

    @Autowired
    private ClientService service;

    @Autowired
    private ClientRepository repository;

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Client>> getById(@PathVariable UUID id){
        var client = service.getById(id);

        return ResponseEntity.status(HttpStatus.OK).body(client);
    }

    @GetMapping
    public ResponseEntity<List<Client>> getAll(){
        return ResponseEntity.ok(service.getAll());
    }

    @PostMapping
    public ResponseEntity<Client> create(@RequestBody @Valid ClientDto clients){
        var clientCreate = new Client(clients);
        service.create(clientCreate);
        final URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(clientCreate.getId()).toUri();

        return ResponseEntity.status(HttpStatus.CREATED).location(location).body(clientCreate);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<Client> update(@RequestBody @Valid ClientUpdate clients){
        var client = repository.getReferenceById(clients.id());
        client.updateClients(clients);
        final URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(client.getId()).toUri();

        return ResponseEntity.status(HttpStatus.OK).location(location).body(client);
    }

}
