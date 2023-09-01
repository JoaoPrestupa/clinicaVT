package br.com.clinicavt.repositories;

import br.com.clinicavt.infra.models.cliente.Cliente;
import br.com.clinicavt.infra.models.pet.Pet;
import br.com.clinicavt.infra.models.pet.PetsRecordDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PetRepository extends JpaRepository<Pet, UUID> {

    //  Consulta insert(Consulta consulta);
    /*
        Consulta findByIdConsulta(UUID id);
    List<Consulta> findAllConsultas();
    Consulta update(Consulta consulta);
    Consulta delete(UUID id);
    */

    Pet createPet(Cliente cliente, Pet pet);
    Pet findPetByCodigo(Integer codigo);
    Pet findAllPet();
    Pet updatePet(Pet pet);
    Pet deletePet(UUID id);

}
