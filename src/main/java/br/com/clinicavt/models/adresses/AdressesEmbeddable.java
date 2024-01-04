package br.com.clinicavt.models.adresses;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
public class AdressesEmbeddable {

    String cep;
    String bairro;
    String rua;
    String cidade;
    String uf;
    String complemento;
    String numero;

    public AdressesEmbeddable() {
    }

    public AdressesEmbeddable(DataAdressesDto data){
        this.bairro = data.bairro();
        this.cep = data.cep();
        this.numero = data.numero();
        this.uf = data.uf();
        this.rua = data.rua();
        this.cidade = data.cidade();
        this.complemento = data.complemento();
    }

    public void adressesUpdate(AdressesUpdate data){
        if (data.bairro() == null){

        } else {
            this.bairro = data.bairro();
        };
        if (data.cep() == null){

        } else {
            this.cep = data.cep();
        }
        if (data.numero() == null){

        } else {
            this.numero = data.numero();
        }

        if (data.uf() != null){
            this.uf = data.uf();
        }
        if (data.rua() != null){
            this.rua = data.rua();
        }
        if (data.cidade() != null){
            this.cidade = data.cidade();
        }
        if (data.complemento() != null){
            this.complemento = data.complemento();
        }
    }

}
