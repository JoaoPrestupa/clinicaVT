package br.com.clinicavt.models;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@Data
@Entity
@Table(name = "tb_consultas")
public class ConsultaModel extends RepresentationModel<ConsultaModel> implements Serializable {

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


    public UUID getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(UUID idConsulta){
        this.idConsulta = idConsulta;
    }

}
