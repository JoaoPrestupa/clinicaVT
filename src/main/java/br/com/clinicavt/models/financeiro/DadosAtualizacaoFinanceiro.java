package br.com.clinicavt.models.financeiro;

import br.com.clinicavt.models.cirurgia.Cirurgia;
import br.com.clinicavt.models.colaborador.Employe;
import br.com.clinicavt.models.consulta.Consulta;
import br.com.clinicavt.models.equipamento.Equipamento;
import br.com.clinicavt.models.internacao.Internacao;
import br.com.clinicavt.models.veterinarian.Veterinanian;

public record DadosAtualizacaoFinanceiro(Employe salarioColaborador, Internacao valorInternacao, Veterinanian valorVacinacao,
                                         Equipamento valorEquipamento, Cirurgia valorCirurgia, Consulta valorConsulta, Boolean ativo) {
}
