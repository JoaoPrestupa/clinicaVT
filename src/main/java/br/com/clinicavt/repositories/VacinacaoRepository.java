package br.com.clinicavt.repositories;

import br.com.clinicavt.infra.models.vacinacao.Vacinacao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface VacinacaoRepository extends JpaRepository<Vacinacao, UUID> {



}
