package br.com.clinicavt.models.client;


import br.com.clinicavt.models.adresses.AdressesEmbeddable;
import br.com.clinicavt.models.adresses.AdressesUpdate;
import br.com.clinicavt.models.pet.Pet;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;
import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.UUID;


// testar retirar os metodos getters e setters para substituir pelas anottations @Data ou @Setter e @Getter

@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Client")
@Table(name = "client")
public class Client extends RepresentationModel<Client> implements Serializable {

    @Serial
    private static final Long serialVersionUUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @NotBlank
    @Size(min = 5, message = "Um nome deve conter no mínimo 5 caracteres.")
    private String nome;
    @Temporal(TemporalType.DATE)
    private Date dataCadastro;
    @Embedded
    private AdressesEmbeddable endereco;
    @Email(message = "Deve ser inserido um endereço de e-mail válido.")
    @Column(unique = true)
    private String email;

    private String telefone;

    private Date nascimento;

    @NotBlank
    @Pattern(regexp = "\\d{11}", message = "Um CPF deve conter 11 digitos.")
    @Column(unique = true)
    private String cpf;

    @OneToMany(mappedBy = "client")
    private List<Pet> petList;

    private Boolean ativo;

    public void updateAdress(AdressesUpdate adressesUpdate){
        AdressesEmbeddable newAdress = new AdressesEmbeddable();
        if (adressesUpdate.bairro() != null){
            newAdress.setBairro(adressesUpdate.bairro());
        }
        if (adressesUpdate.cep() != null){
            newAdress.setCep(adressesUpdate.cep());
        }
        if (adressesUpdate.rua() != null){
            newAdress.setRua(adressesUpdate.rua());
        }
    }

    public void updateClients (ClientUpdate dados){
        if (dados.nome() != null){
            this.nome = dados.nome();
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
        if (dados.nascimento() != null){
            this.nascimento = dados.nascimento();
        }
        if (dados.cpf() != null){
            this.cpf = dados.cpf();
        }
    }

    public Client(@Valid ClientDto clinicaDto){
        this.nome = clinicaDto.nome();
        this.dataCadastro = clinicaDto.dataCadastro();
        this.email = clinicaDto.email();
        this.telefone = clinicaDto.telefone();
        this.nascimento = clinicaDto.nascimento();
        this.cpf = clinicaDto.cpf();
        this.endereco = clinicaDto.endereco();
        this.ativo = true;
    }

    public void delete(){
        this.ativo = false;
    }

    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setEndereco(AdressesEmbeddable endereco) {
        this.endereco = endereco;
    }
    public String getCpf() {
        return cpf;
    }
    public Boolean getAtivo() {
        return ativo;
    }
    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

}
