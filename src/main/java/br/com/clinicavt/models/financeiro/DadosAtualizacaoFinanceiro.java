package br.com.clinicavt.models.financeiro;

import br.com.clinicavt.models.cirurgia.Cirurgia;
import br.com.clinicavt.models.colaborador.Colaborador;
import br.com.clinicavt.models.consulta.Consulta;
import br.com.clinicavt.models.equipamento.Equipamento;
import br.com.clinicavt.models.internacao.Internacao;
import br.com.clinicavt.models.vacinacao.Vacinacao;

public record DadosAtualizacaoFinanceiro(Colaborador salarioColaborador, Internacao valorInternacao, Vacinacao valorVacinacao,
                                         Equipamento valorEquipamento, Cirurgia valorCirurgia, Consulta valorConsulta, Boolean ativo) {
}
