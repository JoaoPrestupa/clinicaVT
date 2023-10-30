package br.com.clinicavt.models.pet;

import br.com.clinicavt.models.cliente.Client;
import br.com.clinicavt.models.consulta.Consulta;
import br.com.clinicavt.models.veterinarian.Veterinanian;

import java.util.Date;
import java.util.UUID;

public record PetUpdate(
        UUID id,
        String nome,
        Client nameClients,
        Consulta dataUltimaConsulta,
        Boolean ativo,
        String descricaoPet,
        AnimaisEnum animal,
        String raca,
        Date nascimento ,
        Veterinanian vacinacao) {
}
