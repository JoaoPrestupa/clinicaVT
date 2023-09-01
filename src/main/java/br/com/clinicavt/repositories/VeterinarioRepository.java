package br.com.clinicavt.repositories;

import br.com.clinicavt.infra.models.veterinario.Veterinario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface VeterinarioRepository extends JpaRepository<Veterinario, UUID> {
    //  Consulta insert(Consulta consulta);
    /*
        Consulta findByIdConsulta(UUID id);
    List<Consulta> findAllConsultas();
    Consulta update(Consulta consulta);
    Consulta delete(UUID id);
    */

    Veterinario createVeterinario(Veterinario veterinario);
    Veterinario findVeterinarioByName(String name);
    Veterinario findAllVeterinario();
    Veterinario updateVeterinario(Veterinario veterinario);
    Veterinario deleteVeterinario(UUID id);

}
