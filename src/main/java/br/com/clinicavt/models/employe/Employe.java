package br.com.clinicavt.models.employe;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employe")
public class Employe extends RepresentationModel<Employe> implements Serializable {

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @Serial

    private static final Long serialVersionUUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank
    @Size(min = 5, message = "O nome deve conter no mínimo 5 caracteres.")
    private String nome;

    private String funcao;

    private BigDecimal salario;

    @Temporal(TemporalType.DATE)
    private Date dataEntrada;

    private Boolean ativo;

    public Employe(EmployeDto colaboradorDto){
        this.dataEntrada = colaboradorDto.dataEntrada();
        this.nome = colaboradorDto.nome();
        this.funcao = colaboradorDto.funcao();
        this.salario = colaboradorDto.salario();
        this.ativo = true;
    }

    public void updateEmploye(EmployeUpdate dados){
        if (dados.nome() != null){
            this.nome = dados.nome();
        }
        if (dados.funcao() != null){
            this.funcao = dados.funcao();
        }
        if (dados.salario() != null){
            this.salario = dados.salario();
        }
    }

    public void delete(){
        this.ativo = false;
    }

}
