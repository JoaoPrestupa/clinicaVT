package br.com.clinicavt.models.veterinario;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.springframework.hateoas.RepresentationModel;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Data
@Entity
@Table(name = "veterinario")
public class Veterinario extends RepresentationModel<Veterinario> implements Serializable {

    private static final long serialVersionUUID = 1L;

    @Id
    private UUID id;

    private String nome;
    @NotBlank
    private String crmv;

    @Temporal(TemporalType.DATE)
    private Date nascimento;

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;
    private Boolean ativo;

    public Veterinario(VeterinarioRecordDto dados) {
        this.id = UUID.randomUUID();
        this.nome = dados.nome();
        this.crmv = dados.crmv();
        this.especialidade = dados.especialidade();
        this.ativo = dados.ativo();
    }

    public void updateVeterinario(DadosAtualizacaoVeterinario dados){

        if (dados.crmv() != null){
            this.crmv = dados.crmv();
        }
        if (dados.nome() != null){
            this.nome = dados.nome();
        }
        if (dados.especialidade() != null){
            this.especialidade = dados.especialidade();
        }
        if (dados.ativo() != null){
            this.ativo = dados.ativo();
        }

    }

    public UUID getIdVeterinario() {
        return id;
    }


}
