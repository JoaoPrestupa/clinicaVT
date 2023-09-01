package br.com.clinicavt.repositories;

import br.com.clinicavt.infra.models.cliente.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClienteRepository extends JpaRepository<Cliente, UUID> {
    Cliente createCliente(Cliente cliente);
    Cliente findClienteByName(String name);
    Cliente findAllClientes();
    Cliente updateCliente(Cliente cliente);
    Cliente deleteCliente(Integer codigo);

}
