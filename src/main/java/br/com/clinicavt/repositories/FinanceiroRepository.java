package br.com.clinicavt.repositories;

import br.com.clinicavt.infra.models.financeiro.Financeiro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface FinanceiroRepository extends JpaRepository<Financeiro, UUID> {

    Financeiro insertFinanceiro(Financeiro financeiro);

    Financeiro findFinanceiroByCodigo(Integer codigo);

    List<Financeiro> findAllFinanceiro();

    Financeiro updateFinanceiro(Financeiro financeiro);

    Financeiro deleteFinanceiro(Integer codigo);

}
