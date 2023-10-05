package br.com.clinicavt.repositories;

import br.com.clinicavt.infra.models.cliente.Cliente;
import br.com.clinicavt.infra.models.pet.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PetRepository extends JpaRepository<Pet, UUID> {

    Pet insertPet(Pet pet);

    Pet findPetByName(String name);

    List<Pet> findAllPet();

    Pet updatePet(Pet pet);

    Pet deletePet(Integer codigo);

}
