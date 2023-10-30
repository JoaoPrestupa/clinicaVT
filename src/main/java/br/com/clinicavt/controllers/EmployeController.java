package br.com.clinicavt.controllers;

import br.com.clinicavt.models.colaborador.Employe;
import br.com.clinicavt.models.colaborador.EmployeDto;
import br.com.clinicavt.models.colaborador.EmployeUpdate;
import br.com.clinicavt.repositories.EmployeRepository;
import br.com.clinicavt.services.EmployeService;
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
@RequestMapping("employe")
public class EmployeController {

    @Autowired
    private EmployeService service;

    @Autowired
    private EmployeRepository repository;

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Employe>> getById(@PathVariable UUID id){
        var client = service.getById(id);

        return ResponseEntity.status(HttpStatus.OK).body(client);
    }

    @GetMapping
    public ResponseEntity<List<Employe>> getAll(){
        return ResponseEntity.ok(service.getAll());
    }

    @PostMapping
    public ResponseEntity<Employe> create (@RequestBody @Valid EmployeDto employe){
        var employeCreate = new Employe(employe);
        service.create(employeCreate);
        final URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(employeCreate.getId()).toUri();

        return ResponseEntity.status(HttpStatus.CREATED).location(location).body(employeCreate);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<Employe> update(@RequestBody @Valid EmployeUpdate employes){
        var employe = repository.getReferenceById(employes.id());
        employe.updateEmploye(employes);
        service.create(employe);
        employe.setId(employes.id());
        final URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(employe.getId()).toUri();

        return ResponseEntity.status(HttpStatus.OK).location(location).body(employe);
    }

}
