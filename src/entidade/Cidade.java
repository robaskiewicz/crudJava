
package entidade;

import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Cidade{
    
    @Id 
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    @Column(length = 100, nullable = false)
    private String nome;
    @ManyToOne(cascade=CascadeType.ALL)
    private Estado estado;
    
    public Cidade(String nome, Estado estado){
        this.nome = nome;
        this.estado = estado;
    }
    public Cidade(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

   
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
    

    
    @Override
    public String toString() {
        return nome;
    }
    
     @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cidade other = (Cidade) obj;
        if (!Objects.equals(this.nome, other.estado)) {
            return false;
        }
        return true;
    }
    
}
