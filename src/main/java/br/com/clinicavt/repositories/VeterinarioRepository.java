package br.com.clinicavt.repositories;

import br.com.clinicavt.models.veterinario.Veterinario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface VeterinarioRepository extends JpaRepository<Veterinario, UUID> {

    Veterinario createVeterinario(Veterinario veterinario);
    Optional<Veterinario> findVeterinarioByName(String name);
    List<Veterinario> findAllVeterinario();
    Veterinario updateVeterinario(Veterinario veterinario);
    Veterinario deleteVeterinario(UUID id);

}
