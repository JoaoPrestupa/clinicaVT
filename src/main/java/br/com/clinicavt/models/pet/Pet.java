package br.com.clinicavt.models.pet;

import br.com.clinicavt.models.client.Client;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
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
    private String nome;

    private String descricaoPet;

    @Enumerated(EnumType.STRING)
    private PetEnum animal;

    private String raca;

    @Temporal(TemporalType.DATE)
    private Date nascimento;

    private String welfare_animal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id")
    private Client client;

    private Boolean ativo;

    public Pet(PetDto petsDto){
        this.id = UUID.randomUUID();
        this.nome = petsDto.nome();
        this.descricaoPet = petsDto.descricaoPet();
        this.animal = petsDto.animal();
        this.raca = petsDto.raca();
        this.nascimento = petsDto.nascimento();
        this.welfare_animal = petsDto.welfare_animal();
        this.ativo = true;
    }

    public void updatePet(PetUpdate dados){
        if (dados.nome() != null){
            this.nome = dados.nome();
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
        if (dados.welfare_animal() != null){
            this.welfare_animal = dados.welfare_animal();
        }
    }

    public void delete(){
        this.ativo = false;
    }

}
