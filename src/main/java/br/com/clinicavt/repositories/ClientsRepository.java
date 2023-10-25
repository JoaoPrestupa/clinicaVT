package br.com.clinicavt.repositories;

import br.com.clinicavt.models.cliente.Clients;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClientsRepository extends JpaRepository<Clients, UUID> {
}
