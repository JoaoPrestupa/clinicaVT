package br.com.clinicavt.infra.models.cliente;


import br.com.clinicavt.infra.models.veterinario.EnderecoEmbeddable;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@Data
@Entity
@Table(name = "cliente")
public class Cliente extends RepresentationModel<Cliente> implements Serializable {

    @Serial
    private static final Long serialVersionUUID = 1L;

    @Id
    private UUID id;
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer codigo;
    @NotBlank
    @Size(min = 5, message = "O nome deve conter pelo menos 5 letras.")
    private String nome;
    @Temporal(TemporalType.DATE)
    private Date dataCadastro;
    @Embedded
    private EnderecoEmbeddable endereco;
    @Email(message = "Deve ser inserido um endereço de E-mail válido.")
    private String email;
    private String telefone;
    private Boolean ativo;
    @Temporal(TemporalType.DATE)
    private Date nascimento;
    @NotBlank
    private BigDecimal cpf;


    public void updateConsulta(DadosAtualizacaoCliente dados){
        if (dados.nome() != null){
            this.nome = dados.nome();
        }
        if (dados.dataCadastro() != null){
            this.dataCadastro = dados.dataCadastro();
        }
        if (dados.endereco() != null){
            this.endereco = dados.endereco();
        }
        if (dados.email() != null){
            this.email = dados.email();
        }
        if (dados.telefone() != null){
            this.telefone = dados.telefone();
        }
        if (dados.ativo() != null){
            this.ativo = dados.ativo();
        }
        if (dados.nascimento() != null){
            this.nascimento = dados.nascimento();
        }
        if (dados.cpf() != null){
            this.cpf = dados.cpf();
        }
    }

    public Cliente(ClienteRecordDto clinicaDto){
        this.id = UUID.randomUUID();
        this.nome = clinicaDto.nome();
        this.dataCadastro = clinicaDto.dataCadastro();
        this.endereco = clinicaDto.endereco();
        this.email = clinicaDto.email();
        this.telefone = clinicaDto.telefone();
        this.ativo = clinicaDto.ativo();
        this.nascimento = clinicaDto.nascimento();
        this.codigo = clinicaDto.codigo();
        this.cpf = clinicaDto.cpf();
    }

}
