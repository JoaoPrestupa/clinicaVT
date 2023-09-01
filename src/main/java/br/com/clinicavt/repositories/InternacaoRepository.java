package br.com.clinicavt.repositories;

import br.com.clinicavt.infra.models.internacao.Internacao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface InternacaoRepository extends JpaRepository<Internacao, UUID> {



}
