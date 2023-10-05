package br.com.clinicavt.services;

import br.com.clinicavt.infra.models.cliente.Cliente;
import br.com.clinicavt.infra.models.pet.Pet;
import br.com.clinicavt.repositories.ClienteRepository;
import br.com.clinicavt.repositories.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class PetService {

    private PetRepository repository;

    private ClienteRepository clienteRepository;

    public List<Pet> findAllPets(){
        return repository.findAllPets();
    }

    public Optional<Pet> findByCodigo(Integer codigo){
        return repository.findPetByCodigo(codigo);
    }

    public Pet create(Cliente cliente, Pet pet){
        final Optional<Pet> petRecuperado = repository.findPetByCodigo(pet.getCodigo());
        final Optional<Cliente> clienteRecuperado = clienteRepository.findClienteByName(cliente.getNome());
        if (clienteRecuperado.isEmpty()){
            // jogar exception de cliente nao encontrado
        }
        if (petRecuperado.isPresent()){
            // jogar exception de pet ja criado
        }

        return repository.createPet(cliente, pet);
    }

    public Pet update(Pet pet){
        final Optional<Pet> petRecuperado = repository.findPetByCodigo(pet.getCodigo());
        pet.setId(petRecuperado.get().getId());
        return repository.updatePet(pet);
    }

    public Pet delete(Integer codigo){
        return repository.deletePet(codigo);
    }

}


