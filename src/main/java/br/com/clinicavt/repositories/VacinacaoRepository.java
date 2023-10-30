package br.com.clinicavt.repositories;

import br.com.clinicavt.models.veterinarian.Veterinanian;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface VacinacaoRepository extends JpaRepository<Veterinanian, UUID> {

    Veterinanian vacinar(Veterinanian vacinacao);

    Veterinanian vacinacaoByPetName(String name);

    List<Veterinanian> findAllVacinacao();

    Veterinanian updateVacinacao(Veterinanian vacinacao);

    Veterinanian deleteVacinacao(Integer codigo);

}
