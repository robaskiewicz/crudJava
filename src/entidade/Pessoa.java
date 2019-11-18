
package entidade;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
/**
 *
 * @author Michel Robaskiewicz
 */
@Entity
public class Pessoa {
    
    @Id 
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer Id;
    @Column(length = 100, nullable = false)
    private String nome;
    @Column(length = 11, nullable = false)
    private String cpf;
    @Column(length = 14, nullable = false)
    private String rg;
    @Column(length = 100, nullable = false)
    private String endereco;
    @Column(length = 50, nullable = false)
    private String numero;
    @ManyToOne
    private Cidade cidade;
    
    public Pessoa(){}
    
//    public Pessoa(String nome, String endereco, String numero, String cpf, String rg, Integer cidade){
//        this.nome=nome;
//        this.endereco=endereco;
//        this.numero=numero;
//        this.cpf=cpf;
//        this.rg=rg;
//        this.cidade=cidade;
//    }

    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getCpf() {
        return cpf;
    }
    
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    public String getRg() {
        return rg;
    }
    
    public void setRg(String rg) {
        this.rg = rg;
    }
    
    public String getEndereco() {
        return endereco;
    }
    
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    
    public String getNumero() {
        return numero;
    }
    
    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }
    
   

    public Integer getId() {
        return Id;
    }

    public void setId(Integer Id) {
        this.Id = Id;
    }

    @Override
    public String toString() {
        return nome;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + Objects.hashCode(this.Id);
        hash = 41 * hash + Objects.hashCode(this.nome);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pessoa other = (Pessoa) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.Id, other.Id)) {
            return false;
        }
        return true;
    }
    
    
    
    
    
}
