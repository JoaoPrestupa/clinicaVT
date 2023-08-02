package br.com.clinicavt.models;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.util.UUID;

@Data
@Entity
@Table(name = "tb_veterinarios")
public class VeterinarioModel extends RepresentationModel<VeterinarioModel> implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private UUID idVeterinario;

    private String nome;

    private String email;

    private String telefone;

    private String crmv;

    private String salario;

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    @Embedded
    private EnderecoEmbeddable endereco;

    public UUID getIdVeterinario() {
        return idVeterinario;
    }

    public void setIdVeterinario(UUID idVeterinario){
        this.idVeterinario = idVeterinario;
    }

}
