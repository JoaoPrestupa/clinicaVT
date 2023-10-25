package br.com.clinicavt.repositories;

import br.com.clinicavt.models.internacao.Internacao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface InternacaoRepository extends JpaRepository<Internacao, UUID> {


    Internacao internar(Internacao internacao);
    Internacao findInternacaoByPetName(String name);
    List<Internacao> findAllInternacao();
    Internacao updateInternacao(Internacao internacao);
    Internacao delete(UUID id);


}
