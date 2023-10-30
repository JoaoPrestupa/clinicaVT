package br.com.clinicavt.repositories;

import br.com.clinicavt.models.cliente.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClientRepository extends JpaRepository<Client, UUID> {
}
