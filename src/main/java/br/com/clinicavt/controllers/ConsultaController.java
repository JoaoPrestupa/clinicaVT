package br.com.clinicavt.controllers;

import br.com.clinicavt.dtos.ConsultaRecordDto;
import br.com.clinicavt.models.ConsultaModel;
import br.com.clinicavt.repositories.ConsultaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


@RestController
public class ConsultaController {

    @Autowired
    ConsultaRepository consultaRepository;

    @GetMapping("/consultas")
    public ResponseEntity<List<ConsultaModel>> getAllConsultas(){
        List<ConsultaModel> consultaList = consultaRepository.findAll();
        if(!consultaList.isEmpty()){
            for (ConsultaModel consulta : consultaList){
                UUID id = consulta.getIdConsulta();
                consulta.add(linkTo(methodOn(ConsultaController.class).getOneConsulta(id)).withSelfRel());
            }
        }
        return ResponseEntity.status(HttpStatus.OK).body(consultaList);
    }

    @GetMapping("/consultas/{id}")
    public ResponseEntity<Object> getOneConsulta(@PathVariable ("id") UUID id){
        Optional<ConsultaModel> consultaO = consultaRepository.findById((id));
        if (consultaO.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Consulta não agendada");
        }
        consultaO.get().add(linkTo(methodOn(ConsultaController.class).getAllConsultas()).withRel("Consulta Encontrada!"));
        return ResponseEntity.status(HttpStatus.OK).body(consultaO.get());
    }

    @PostMapping("/consultas")
    public ResponseEntity<ConsultaModel> saveConsulta(@RequestBody @Valid ConsultaRecordDto consultaDto){
        var consultaModel = new ConsultaModel();
        BeanUtils.copyProperties(consultaDto, consultaModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(consultaRepository.save(consultaModel));
    }

    @DeleteMapping("/consultas/{id}")
    public ResponseEntity<Object> deleteConsulta(@PathVariable (value = "id") UUID id){
        Optional<ConsultaModel> consultaO = consultaRepository.findById((id));
        if (consultaO.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Consulta não encontrada ou não agendada.");
        }
        consultaRepository.delete(consultaO.get());
        return ResponseEntity.status(HttpStatus.OK).body("Consulta deletada com sucesso.");
    }

    @PutMapping("/consultas/{id}")
    public ResponseEntity<Object> updateConsulta(@PathVariable(value = "id") UUID id, @RequestBody @Valid ConsultaRecordDto consultaDto){
        Optional<ConsultaModel> consultaO = consultaRepository.findById((id));
        if (consultaO.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Consulta não encontrada ou não agendada.");
        }
        var consultaModel = consultaO.get();
        BeanUtils.copyProperties(consultaDto, consultaModel);
        return ResponseEntity.status(HttpStatus.OK).body(consultaRepository.save(consultaModel));
    }


}
