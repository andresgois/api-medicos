package med.voll.api.domain.endereco;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Endereco {
   
    private String logradouro;
    private String bairro;
    private String cep;
    private String cidade;
    private String uf;
    private String complemento;
    private String numero;
    
    public Endereco(DadosEndereco e) {
        this.logradouro     = e.logradouro();
        this.bairro         = e.bairro();
        this.cep            = e.cep();
        this.cidade         = e.cidade();
        this.uf             = e.uf();
        this.complemento    = e.complemento();
        this.numero         = e.numero();
    }

    public void atualizarDados(DadosEndereco e) {
        if (e.logradouro() != null)  this.logradouro    = e.logradouro();
        if (e.bairro() != null)      this.bairro        = e.bairro();
        if (e.cep() != null)         this.cep           = e.cep();
        if (e.cidade() != null)      this.cidade        = e.cidade();
        if (e.uf() != null)          this.uf            = e.uf();
        if (e.complemento() != null) this.complemento   = e.complemento();
        if (e.numero() != null)      this.numero        = e.numero();        
    }
}
