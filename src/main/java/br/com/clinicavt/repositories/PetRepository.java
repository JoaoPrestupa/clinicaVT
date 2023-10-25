package br.com.clinicavt.repositories;

import br.com.clinicavt.models.pet.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface PetRepository extends JpaRepository<Pet, UUID> {

}
