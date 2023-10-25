package br.com.clinicavt.models.colaborador;

import br.com.clinicavt.models.veterinario.Veterinario;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Data
@EqualsAndHashCode
@Getter
@Setter
@Entity
@Table(name = "colaborador")
public class Colaborador extends RepresentationModel<Colaborador> implements Serializable {

    @Serial
    private static final Long serialVersionUUID = 1L;

    @Id
    private UUID id;
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer codigo;
    @NotBlank
    @Size(min = 5, message = "O nome deve conter no mínimo 5 letras.")
    private String nome;
    @NotBlank
    private String funcao;
    @NotBlank
    private BigDecimal salario;
    private Veterinario veterinario;
    @Temporal(TemporalType.DATE)
    private Date dataEntrada;
    @Column(columnDefinition = "boolean default true")
    private Boolean ativo;

    public Colaborador(ColaboradorRecordDto colaboradorDto){
        this.id = UUID.randomUUID();
        this.dataEntrada = colaboradorDto.dataEntrada();
        this.nome = colaboradorDto.nome();
        this.funcao = colaboradorDto.funcao();
        this.salario = colaboradorDto.salario();
        if (this.veterinario != null){
            this.veterinario = colaboradorDto.veterinario();
        }
        this.ativo = true;
    }

    public void updateColaborador(DadosAtualizacaoColaborador dados){
        if (dados.nome() != null){
            this.nome = dados.nome();
        }
        if (dados.funcao() != null){
            this.funcao = dados.funcao();
        }
        if (dados.salario() != null){
            this.salario = dados.salario();
        }
        if (dados.veterinario() != null){
            this.veterinario = dados.veterinario();
        }
        if (dados.dataEntrada() != null){
            this.dataEntrada = dados.dataEntrada();
        }
        if (dados.ativo() != null){
            this.ativo = dados.ativo();
        }
    }
    public Boolean isAtivo(){
        return ativo;
    }

    public Optional<Colaborador> setAtivo(Boolean ativo){
        this.ativo = ativo;
        return null;
    }

}
