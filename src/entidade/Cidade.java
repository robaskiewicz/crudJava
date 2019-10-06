
package entidade;

import java.util.Objects;

public class Cidade{
    
    private Integer id;
    private String nome;
    private Integer estado;
    
    public Cidade(String nome, Integer estado){
        this.nome = nome;
        this.estado = estado;
    }
    public Cidade(){}
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
