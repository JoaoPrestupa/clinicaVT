package br.com.clinicavt.controllers;

import br.com.clinicavt.infra.dto.ConsultaRecordDto;
import br.com.clinicavt.infra.models.consulta.Consulta;
import br.com.clinicavt.infra.models.consulta.DadosAtualizacaoConsulta;
import br.com.clinicavt.repositories.ConsultaRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {

    @Autowired
    ConsultaRepository consultaRepository;

    @GetMapping
    public ResponseEntity<Page<Consulta>> getAllConsulta(@PageableDefault(size = 5, sort = {"paciente"})Pageable paginacao){
        var page = consultaRepository.findAll(paginacao);
        return ResponseEntity.status(HttpStatus.OK).body(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneConsulta(@PathVariable ("id") UUID id){
        Optional<Consulta> consultaO = consultaRepository.findById((id));
        if (consultaO.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Consulta não agendada");
        }
        return ResponseEntity.status(HttpStatus.OK).body(consultaRepository.getReferenceById(id));
    }

    @PostMapping
    @Transactional
    public ResponseEntity createConsulta(@RequestBody @Valid ConsultaRecordDto dadosConsulta, UriComponentsBuilder uriBuilder){
        var consulta = new Consulta(dadosConsulta);
        consultaRepository.save(consulta);
        var uri = uriBuilder.path("/consultas/{id}").buildAndExpand(consulta.getIdConsulta()).toUri();
        return ResponseEntity.status(HttpStatus.CREATED).location(uri).body(consulta);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteConsulta(@PathVariable (value = "id") UUID id){
        Optional<Consulta> consultaO = consultaRepository.findById((id));
        if (consultaO.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Consulta não encontrada ou não agendada.");
        }
        consultaRepository.delete(consultaO.get());
        return ResponseEntity.status(HttpStatus.OK).body("Consulta deletada com sucesso.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateConsulta(@PathVariable(value = "id") UUID id, @RequestBody @Valid DadosAtualizacaoConsulta dados){
        Optional<Consulta> consultaO = consultaRepository.findById((id));
        if (consultaO.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Consulta não encontrada ou não agendada.");
        }
        var consulta = consultaRepository.getReferenceById(id);
        consulta.updateConsulta(dados);
        return ResponseEntity.status(HttpStatus.OK).body("Consulta atualizada com sucesso" + dados);
    }

}
