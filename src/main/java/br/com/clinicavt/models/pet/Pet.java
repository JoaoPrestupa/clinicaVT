package br.com.clinicavt.models.pet;

import br.com.clinicavt.models.cliente.Clients;
import br.com.clinicavt.models.vacinacao.Vacinacao;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Data
@Entity(name = "pet")
@Table(name = "Pet")
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
public class Pet extends RepresentationModel<Pet> implements Serializable {

    @Serial
    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @NotBlank
    @Size(min = 5, message = "Um nome deve conter no mínimo 5 caracteres.")
    private String nome;

    private String descricaoPet;

    @Enumerated(EnumType.STRING)
    private AnimaisEnum animal;

    private String raca;

    @Temporal(TemporalType.DATE)
    private Date nascimento;

    private Vacinacao vacinacao;

    private Clients nameClients;

    private Boolean ativo;

    public Pet(PetDto petsDto){
        this.id = UUID.randomUUID();
        this.nome = petsDto.nome();
        this.descricaoPet = petsDto.descricaoPet();
        this.animal = petsDto.animal();
        this.raca = petsDto.raca();
        this.nascimento = petsDto.nascimento();
        this.nameClients = petsDto.nameClients();
        this.vacinacao = petsDto.vacinacao();
        this.ativo = true;
    }

    public void updateConsulta(PetUpdate dados){
        if (dados.nome() != null){
            this.nome = dados.nome();
        }
        if (dados.nameClients() != null){
            this.nameClients = dados.nameClients();
        }
        if (dados.descricaoPet() != null){
            this.descricaoPet = dados.descricaoPet();
        }
        if (dados.animal() != null){
            this.animal = dados.animal();
        }
        if (dados.raca() != null){
            this.raca = dados.raca();
        }
        if (dados.nascimento() != null){
            this.nascimento = dados.nascimento();
        }
        if (dados.vacinacao() != null){
            this.vacinacao = dados.vacinacao();
        }
    }

    public void delete(){
        this.ativo = false;
    }

}
