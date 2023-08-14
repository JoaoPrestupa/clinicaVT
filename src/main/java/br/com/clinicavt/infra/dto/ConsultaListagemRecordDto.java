package br.com.clinicavt.infra.dto;

import br.com.clinicavt.infra.models.consulta.Consulta;

public record ConsultaListagemRecordDto(String responsavel, String raca, String paciente) {

    public ConsultaListagemRecordDto(Consulta consulta){
        this(consulta.getResponsavel(), consulta.getRaca(), consulta.getPaciente());
    }

}
