package br.com.clinicavt.controllers;

import br.com.clinicavt.models.pet.Pet;
import br.com.clinicavt.models.pet.PetDto;
import br.com.clinicavt.models.pet.PetUpdate;
import br.com.clinicavt.repositories.PetRepository;
import br.com.clinicavt.services.PetService;
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
@RequestMapping("pet")
public class PetController {

    @Autowired
    private PetService service;
    @Autowired
    private PetRepository repository;

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Pet>> getById (@PathVariable UUID id){
        var pet = service.getById(id);

        return ResponseEntity.status(HttpStatus.OK).body(pet);
    }

    @GetMapping
    public ResponseEntity<List<Pet>> getAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @PostMapping
    public  ResponseEntity<Pet> create (PetDto pet){
        var petInserted = new Pet(pet);
        service.create(petInserted);
        final URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(petInserted.getId()).toUri();

        return ResponseEntity.status(HttpStatus.CREATED).location(location).body(petInserted);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<Pet> update (@RequestBody @Valid PetUpdate petUpdate){

    }

}
