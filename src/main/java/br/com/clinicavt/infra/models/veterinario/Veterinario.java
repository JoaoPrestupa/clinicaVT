package br.com.clinicavt.infra.models.veterinario;

import br.com.clinicavt.infra.dto.VeterinarioRecordDto;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.util.UUID;

@Data
@Entity
@Table(name = "tb_veterinarios")
public class Veterinario extends RepresentationModel<Veterinario> implements Serializable {
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


    public Veterinario(VeterinarioRecordDto dados) {
        this.nome = dados.nome();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.crmv = dados.crmv();
        this.salario = dados.salario();
        this.especialidade = dados.especialidade();
        this.endereco = dados.endereco();
    }

    public void updateVeterinario(DadosAtualizacaoVeterinario dados){

        if (dados.crmv() != null){
            this.crmv = dados.crmv();
        }
        if (dados.email() != null){
            this.email = dados.email();
        }
        if (dados.endereco() != null){
            this.endereco = dados.endereco();
        }
        if (dados.nome() != null){
            this.nome = dados.nome();
        }
        if (dados.salario() != null){
            this.salario = dados.salario();
        }
        if (dados.telefone() != null){
            this.telefone = dados.telefone();
        }
        if (dados.especialidade() != null){
            this.especialidade = dados.especialidade();
        }

    }

    public UUID getIdVeterinario() {
        return idVeterinario;
    }

    public void setIdVeterinario(UUID idVeterinario){
        this.idVeterinario = idVeterinario;
    }

}
