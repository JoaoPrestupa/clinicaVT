package br.com.clinicavt.repositories;

import br.com.clinicavt.models.vacinacao.Vacinacao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface VacinacaoRepository extends JpaRepository<Vacinacao, UUID> {

    Vacinacao vacinar(Vacinacao vacinacao);

    Vacinacao vacinacaoByPetName(String name);

    List<Vacinacao> findAllVacinacao();

    Vacinacao updateVacinacao(Vacinacao vacinacao);

    Vacinacao deleteVacinacao(Integer codigo);

}
