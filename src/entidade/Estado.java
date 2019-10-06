package entidade;

import java.util.Objects;
 
public class Estado implements Comparable<Estado>{
    
    private Integer Id;
    private String nome;
    private String sigla;
    
    public Estado(){}

    public Estado(String nome, String sigla) {
       this.nome = nome;
       this.sigla = sigla; 
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String uf) {
        this.sigla = uf;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer Id) {
        this.Id = Id;
    }

    

    

    @Override
    public String toString() {
        return nome +" - "+ sigla;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Estado other = (Estado) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        return true;
    }

    //Serve para ordenar uma lista de objetos do tipo Estado.
    //O retorno deste método é -1, 0, 1, sendo -1 menor, 0 igual, 1 maior.
    @Override
    public int compareTo(Estado objEst) {
        return nome.compareTo(objEst.getNome());
    }
    
}
