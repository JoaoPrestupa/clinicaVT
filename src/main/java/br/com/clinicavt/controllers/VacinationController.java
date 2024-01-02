package br.com.clinicavt.controllers;

import br.com.clinicavt.models.vacination.Vacination;
import br.com.clinicavt.models.vacination.VacinationDto;
import br.com.clinicavt.models.vacination.VacinationUpdate;
import br.com.clinicavt.repositories.VacinationRepository;
import br.com.clinicavt.services.VacinationService;
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
@RequestMapping("vacination")
public class VacinationController {

    @Autowired
    private VacinationService service;

    @Autowired
    private VacinationRepository repository;

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Vacination>> getById(@PathVariable UUID id){
        var client = service.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(client);
    }

    @GetMapping
    public ResponseEntity<List<Vacination>> getAll() {return ResponseEntity.status(HttpStatus.OK).body(service.getAll());
    }

    @PostMapping
    public ResponseEntity<Vacination> create(@RequestBody @Valid VacinationDto vacinationDto){
        var vacinationCreated = new Vacination(vacinationDto);
        service.create(vacinationCreated);
        final URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(vacinationCreated.getId()).toUri();

        return ResponseEntity.status(HttpStatus.OK).location(location).body(vacinationCreated);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<Vacination> update (@RequestBody @Valid VacinationUpdate vacinationUpdate){
        var vacination = repository.getReferenceById(vacinationUpdate.id());
        vacination.updateVacination(vacinationUpdate);
        service.create(vacination);
        vacination.setId(vacination.getId());
        final URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(vacination.getId()).toUri();

        return ResponseEntity.status(HttpStatus.OK).location(location).body(vacination);
    }

    @DeleteMapping
    public ResponseEntity<Vacination> delete(@PathVariable UUID id){
        var vacination = repository.getReferenceById(id);
        vacination.delete();

        return ResponseEntity.status(HttpStatus.OK).body(vacination);

    }
}
