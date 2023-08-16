package br.com.clinicavt.infra.dto;

import br.com.clinicavt.infra.models.cliente.Cliente;
import br.com.clinicavt.infra.models.consulta.Consulta;
import br.com.clinicavt.infra.models.pets.AnimaisEnum;
import br.com.clinicavt.infra.models.vacinacao.Vacinacao;

import java.util.Date;

public record PetsRecordDto(String nome, Cliente cliente, Consulta dataUltimaConsulta,
                            Boolean ativo, String descricaoPet, AnimaisEnum animal, String raca,
                            Date nascimento, Vacinacao vacinacao, Integer codigo) {
}
