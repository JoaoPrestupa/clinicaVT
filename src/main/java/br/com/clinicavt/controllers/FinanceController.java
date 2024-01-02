package br.com.clinicavt.controllers;

import br.com.clinicavt.models.finance.Finance;
import br.com.clinicavt.models.finance.FinanceDto;
import br.com.clinicavt.models.finance.FinanceUpdate;
import br.com.clinicavt.services.FinanceService;
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
@RequestMapping("finance")
public class FinanceController {

   @Autowired
   private FinanceService service;

   @GetMapping("/{id}")
   public ResponseEntity<Optional<Finance>> getById(@PathVariable UUID id){
       return ResponseEntity.status(HttpStatus.OK).body(service.getById(id));
   }

   @GetMapping
   public ResponseEntity<List<Finance>> getAll(){
       return ResponseEntity.status(HttpStatus.OK).body(service.getAll());
   }

   @PostMapping
   public ResponseEntity<Finance> create(@RequestBody @Valid FinanceDto financeDto){
       var financeCreated = new Finance(financeDto);
       service.create(financeCreated);
       final URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(financeCreated.getId()).toUri();

       return ResponseEntity.status(HttpStatus.CREATED).location(location).body(financeCreated);
   }

   // Adicionar o atualizar financeiro depois.
    // Adicionar o delete financeiro depois.

}

