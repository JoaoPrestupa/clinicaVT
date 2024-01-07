package br.com.clinicavt.controllers;

import br.com.clinicavt.models.adresses.AdressesUpdate;
import br.com.clinicavt.models.veterinarian.Veterinanian;
import br.com.clinicavt.models.veterinarian.VeterinarianDto;
import br.com.clinicavt.models.veterinarian.VeterinarianUpdate;
import br.com.clinicavt.repositories.VeterinarianRepository;
import br.com.clinicavt.services.VeterinarianService;
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
@RequestMapping("/public/veterinarian")
public class VeterinarianController {

    @Autowired
    private VeterinarianService service;

    @Autowired
    private VeterinarianRepository repository;

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Veterinanian>> getById(@PathVariable UUID id){
        var veterinarian = service.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(veterinarian);
    }

    @GetMapping
    public ResponseEntity<List<Veterinanian>> getAll(){
        return ResponseEntity.ok(service.getAll());
    }

    @PostMapping
    public ResponseEntity<Veterinanian> create(@RequestBody VeterinarianDto veterinarian){
        var veterinarianCreate = new Veterinanian(veterinarian);
        service.create(veterinarianCreate);
        final URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(veterinarianCreate.getId()).toUri();

        return ResponseEntity.status(HttpStatus.CREATED).location(location).body(veterinarianCreate);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<Veterinanian> update(@RequestBody VeterinarianUpdate veterinarianUpdate){
        var veterian = repository.getReferenceById(veterinarianUpdate.id());
        veterian.updateVeterinarian(veterinarianUpdate);
        final URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(veterian.getId()).toUri();

        return ResponseEntity.status(HttpStatus.OK).location(location).body(veterian);
    }

    @PutMapping("/{id}/adresses")
    @Transactional
    public ResponseEntity<Veterinanian> updateAdresses(@PathVariable("id") UUID id, @RequestBody AdressesUpdate adressesUpdate){
        service.update_adresses(id, adressesUpdate);

        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
