package br.com.clinicavt.models.veterinario;

import br.com.clinicavt.models.DadosEnderecoDto;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EnderecoEmbeddable {

    String cep;
    String bairro;
    String rua;
    String cidade;
    String uf;
    String complemento;
    String numero;

    public EnderecoEmbeddable(DadosEnderecoDto dados){
        this.bairro = dados.bairro();
        this.cep = dados.cep();
        this.numero = dados.numero();
        this.uf = dados.uf();
        this.rua = dados.rua();
        this.cidade = dados.cidade();
        this.complemento = dados.complemento();
    }

    public void atualizarInformacoes(DadosEnderecoDto dados){
        if (dados.bairro() != null){
            this.bairro = dados.bairro();
        }
        if (dados.cep() != null){
            this.cep = dados.cep();
        }
        if (dados.numero() != null){
            this.numero = dados.numero();
        }
        if (dados.uf() != null){
            this.uf = dados.uf();
        }
        if (dados.rua() != null){
            this.rua = dados.rua();
        }
        if (dados.cidade() != null){
            this.cidade = dados.cidade();
        }
        if (dados.complemento() != null){
            this.complemento = dados.complemento();
        }
    }

}
