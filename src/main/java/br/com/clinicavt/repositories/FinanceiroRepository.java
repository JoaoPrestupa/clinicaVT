package br.com.clinicavt.repositories;

import br.com.clinicavt.infra.models.financeiro.Financeiro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FinanceiroRepository extends JpaRepository<Financeiro, UUID> {



}
