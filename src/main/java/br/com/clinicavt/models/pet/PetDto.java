package br.com.clinicavt.models.pet;

import br.com.clinicavt.models.cliente.Clients;
import br.com.clinicavt.models.consulta.Consulta;
import br.com.clinicavt.models.vacinacao.Vacinacao;

import java.util.Date;

public record PetDto(String nome,
                     Clients nameClients,
                     Consulta dataUltimaConsulta,
                     Boolean ativo,
                     String descricaoPet,
                     AnimaisEnum animal,
                     String raca,
                     Date nascimento ,
                     Vacinacao vacinacao) {
}
