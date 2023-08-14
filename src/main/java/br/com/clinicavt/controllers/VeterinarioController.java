package br.com.clinicavt.controllers;

import br.com.clinicavt.infra.dto.VeterinarioRecordDto;
import br.com.clinicavt.repositories.VeterinarioRepository;
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
public class VeterinarioController {

    @Autowired
    VeterinarioRepository veterinarioRepository;

    @GetMapping("/veterinarios")
    public ResponseEntity<List<VeterinarioModel>> getAllVeterinarios(){
        List<VeterinarioModel> veterinarioList = veterinarioRepository.findAll();
        if(!veterinarioList.isEmpty()){
            for (VeterinarioModel veterinario : veterinarioList){
                UUID id = veterinario.getIdVeterinario();
                veterinario.add(linkTo(methodOn(VeterinarioController.class).getOneVeterinarios(id)).withSelfRel());
            }
        }
        return ResponseEntity.status(HttpStatus.OK).body(veterinarioList);
    }

    @GetMapping("/veterionarios/{id}")
    public ResponseEntity<Object> getOneVeterinarios(@PathVariable(value = "id") UUID id){
        Optional<VeterinarioModel> veterinarioO = veterinarioRepository.findById(id);
        if(veterinarioO.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Veterinário não encontrado. ");
        }
        veterinarioO.get().add(linkTo(methodOn(VeterinarioController.class).getAllVeterinarios()).withRel("Veterinário Encontrado. "));
        return ResponseEntity.status(HttpStatus.OK).body(veterinarioO.get());
    }

    @PostMapping("/veterinarios")
    public ResponseEntity<VeterinarioModel> saveVeterinarios(@RequestBody @Valid VeterinarioRecordDto veterinarioDto){
        var veterinarioModel = new VeterinarioModel();
        BeanUtils.copyProperties(veterinarioDto, veterinarioModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(veterinarioRepository.save(veterinarioModel));
    }

    @DeleteMapping("/veterionarios/{id}")
    public ResponseEntity<Object> deleteVeterionario(@PathVariable(value = "id") UUID id){
        Optional<VeterinarioModel> veterinarioO = veterinarioRepository.findById(id);
        if (veterinarioO.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Veterinário não encontrado.");
        }
        veterinarioRepository.delete(veterinarioO.get());;
        return ResponseEntity.status(HttpStatus.OK).body("Veterinário excluído com sucesso.");
    }

    @PutMapping("/veterinarios/{id}")
    public ResponseEntity<Object> updateVeterinario(@PathVariable(value = "id") UUID id, VeterinarioRecordDto veterinarioDto){
        Optional<VeterinarioModel> veterinarioO = veterinarioRepository.findById(id);
        if (veterinarioO.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Veterinário não encontrado.");
        }
        var veterinarioModel = veterinarioO.get();
        BeanUtils.copyProperties(veterinarioDto, veterinarioModel);
        return ResponseEntity.status(HttpStatus.OK).body(veterinarioRepository.save(veterinarioModel));
    }

}
