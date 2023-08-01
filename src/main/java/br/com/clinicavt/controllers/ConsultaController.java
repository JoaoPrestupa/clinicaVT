package br.com.clinicavt.controllers;

import br.com.clinicavt.dtos.ConsultaRecordDto;
import br.com.clinicavt.models.ConsultaModel;
import br.com.clinicavt.models.VeterinarioModel;
import br.com.clinicavt.repositories.ConsultaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {

    @Autowired
    ConsultaRepository consultaRepository;

    @GetMapping
    public ResponseEntity<List<VeterinarioModel>> getAllConsultas(){

    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneConsulta(@PathVariable ("id") UUID id){

    }

    @PostMapping("/marcar")
    public ResponseEntity<ConsultaModel> saveConsulta(@RequestBody @Valid ConsultaRecordDto consultaDto){

    }

    @DeleteMapping("/desmarcar/{id}")
    public ResponseEntity<Object> deleteConsulta(@PathVariable (value = "id") UUID id){

    }


}
