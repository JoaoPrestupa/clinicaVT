package br.com.clinicavt.infra.models.consulta;

import br.com.clinicavt.infra.dto.ConsultaRecordDto;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@Data
@Entity
@Table(name = "tb_consultas")
public class Consulta extends RepresentationModel<Consulta> implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private UUID idConsulta;

    private String responsavel;

    private String raca;

    private String paciente;

//adicionados dia 02/08
   // private String problema;

   // private LocalDate data;

    // VeterinarioModel veterinario;


    public Consulta(ConsultaRecordDto consultaDto) {
        this.responsavel = consultaDto.responsavel();
        this.raca = consultaDto.raca();
        this.paciente = consultaDto.paciente();
    }

    public void updateConsulta(DadosAtualizacaoConsulta dados){

        if(dados.raca() != null){
            this.raca =  dados.raca();
        }
        if (dados.responsavel() != null){
            this.responsavel = dados.responsavel();
        }
        if (dados.paciente() != null){
            this.paciente = dados.paciente();
        }

    }

    public UUID getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(UUID idConsulta){
        this.idConsulta = idConsulta;
    }

}
