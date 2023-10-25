package br.com.clinicavt.controllers;

import br.com.clinicavt.models.cliente.Clients;
import br.com.clinicavt.models.cliente.ClientsDto;
import br.com.clinicavt.models.cliente.ClientsUpdate;
import br.com.clinicavt.repositories.ClientsRepository;
import br.com.clinicavt.services.ClientsService;
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
    private ClientsService service;

    @Autowired
    private ClientsRepository repository;

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Clients>> getById(@PathVariable UUID id){
        var client = service.getById(id);

        return ResponseEntity.status(HttpStatus.OK).body(client);
    }

    @GetMapping
    public ResponseEntity<List<Clients>> getAll(){
        return ResponseEntity.ok(service.getdAll());
    }

    @PostMapping
    public ResponseEntity<Clients> create(@RequestBody @Valid ClientsDto clients){
        var clientCreate = new Clients(clients);
        service.create(clientCreate);
        final URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(clientCreate.getId()).toUri();

        return ResponseEntity.status(HttpStatus.CREATED).location(location).body(clientCreate);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<Clients> update(@RequestBody @Valid ClientsUpdate clients){
        var client = repository.getReferenceById(clients.id());
        client.updateClients(clients);
        service.create(client);
        client.setId(clients.id());
        final URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(client.getId()).toUri();

        return ResponseEntity.status(HttpStatus.OK).location(location).body(client);
    }

}
