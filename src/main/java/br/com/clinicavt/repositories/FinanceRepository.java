package br.com.clinicavt.repositories;

import br.com.clinicavt.models.finance.Finance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface FinanceRepository extends JpaRepository<Finance, UUID> {
}
