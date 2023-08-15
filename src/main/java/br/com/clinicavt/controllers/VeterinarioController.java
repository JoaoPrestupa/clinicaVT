package br.com.clinicavt.controllers;

import br.com.clinicavt.infra.dto.VeterinarioRecordDto;
import br.com.clinicavt.infra.models.veterinario.DadosAtualizacaoVeterinario;
import br.com.clinicavt.infra.models.veterinario.Veterinario;
import br.com.clinicavt.repositories.VeterinarioRepository;
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
@RequestMapping("/veterinarios")
public class VeterinarioController {

    @Autowired
    VeterinarioRepository veterinarioRepository;

    @GetMapping
    public ResponseEntity<Page<Veterinario>> getAllVeterinarios (@PageableDefault(size = 5, sort = {"nome"})Pageable paginacao){
        var page = veterinarioRepository.findAll(paginacao);
        return ResponseEntity.status(HttpStatus.OK).body(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneVeterinarios (@PathVariable(value = "id") UUID id){
        Optional<Veterinario> veterinarioO = veterinarioRepository.findById(id);
        if(veterinarioO.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Veterinário não encontrado. ");
        }
        return ResponseEntity.status(HttpStatus.OK).body(veterinarioRepository.getReferenceById(id));
    }

    @PostMapping
    public ResponseEntity<Veterinario> saveVeterinarios (@RequestBody @Valid VeterinarioRecordDto veterinarioDto, UriComponentsBuilder uriBuilder){
        var veterinario = new Veterinario(veterinarioDto);
        veterinarioRepository.save(veterinario);
        var uri = uriBuilder.path("/veterinarios/{id}").buildAndExpand(veterinario.getIdVeterinario()).toUri();
        return ResponseEntity.status(HttpStatus.CREATED).location(uri).body(veterinario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteVeterionario (@PathVariable(value = "id") UUID id){
        Optional<Veterinario> veterinarioO = veterinarioRepository.findById(id);
        if (veterinarioO.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Veterinário não encontrado.");
        }
        veterinarioRepository.delete(veterinarioO.get());
        return ResponseEntity.status(HttpStatus.OK).body("Veterinário excluído com sucesso.");
    }

    @PutMapping("/veterinarios/{id}")
    public ResponseEntity<Object> updateVeterinario (@PathVariable(value = "id") UUID id, DadosAtualizacaoVeterinario dados){
        Optional<Veterinario> veterinarioO = veterinarioRepository.findById(id);
        if (veterinarioO.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Veterinário não encontrado.");
        }
        var veterinario = veterinarioRepository.getReferenceById(id);
        veterinario.updateVeterinario(dados);
        return ResponseEntity.status(HttpStatus.OK).body("Veterinario atualizado com sucesso. " + dados);
    }

}
