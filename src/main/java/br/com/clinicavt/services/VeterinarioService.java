package br.com.clinicavt.services;

import br.com.clinicavt.infra.models.veterinario.Veterinario;
import br.com.clinicavt.repositories.VeterinarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class VeterinarioService {

    private VeterinarioRepository repository;

    public List<Veterinario> findAllVeterinario(){
        return repository.findAllVeterinario();
    }

    public Optional<Veterinario> findVeterinarioByName(String name){
        return repository.findVeterinarioByName(name);
    }

    public Veterinario create(Veterinario veterinario){
        final Optional<Veterinario> veterinarioRecuperado = repository.findVeterinarioByName(veterinario.getNome());

        if (veterinarioRecuperado.isPresent()){
            // exception
        }
        return repository.createVeterinario(veterinario);
    }

    public Veterinario update(Veterinario veterinario){
        final Optional<Veterinario> veterinarioRecuperado = repository.findVeterinarioByName(veterinario.getNome());
        veterinario.setId(veterinarioRecuperado.get().getId());
        return repository.updateVeterinario(veterinario);
    }

    public Veterinario delete(UUID uuid){
        return repository.deleteVeterinario(uuid);
    }

}
