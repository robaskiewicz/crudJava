/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud.modelo;

import static crud.modelo.Banco.abrirConexao;
import entidade.Pessoa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Robaskiewicz
 */
public class PessoaDao extends Banco{
     
    public void create(Pessoa entity) throws Exception {
        Connection con = null;
        try {
            con = abrirConexao();
            Statement pst = con.createStatement();

            pst.execute("INSERT INTO PESSOA (NOME,ENDERECO, NUMERO, CPF, RG, IDCIDADE) VALUES ('" + entity.getNome() + "','" + entity.getEndereco() + "', '" + entity.getNumero() + "','" + entity.getCpf() + "','" + entity.getRg() + "','" + entity.getCidade() + "')");
            System.out.println("PESSOA INSERIDA");
            con.close();
        } catch (SQLException e) {
            throw new Exception("Nao pode ser inserido.", e);
        }

    }

    public void update(Pessoa entity, Integer id) throws Exception {
        Connection con = null;
        try {
            con = abrirConexao();
            Statement pst = con.createStatement();

            pst.execute("UPDATE PESSOA SET NOME = '" + entity.getNome() + "' ,CPF = '" + entity.getCpf() + "', RG = '" + entity.getRg() + "',ENDERECO = '" + entity.getEndereco() + "',NUMERO = '" + entity.getNumero() + "',IDCIDADE = '" + entity.getCidade() + "' WHERE ID = " + id + "");
            System.out.println("PESSOA ATUALIZADA");
            con.close();
        } catch (SQLException e) {
            throw new Exception("Nao pode ser Atualizado.", e);
        }
    }

    public void remove(Integer id) throws Exception {
        Connection con = null;
        try {
            con = abrirConexao();
            Statement pst = con.createStatement();

            pst.execute("DELETE FROM PESSOA WHERE ID = " + id + "");
            System.out.println("PESSOA REMOVIDA");
            con.close();
        } catch (SQLException e) {
            throw new Exception("Nao pode ser Removido.", e);
        }
    }

    public void getResultList() throws Exception  {
        Connection con = null;
        try {
            con = abrirConexao();
            Statement pst = con.createStatement();
            ResultSet rs = pst.executeQuery("SELECT * FROM PESSOA INNER JOIN CIDADE ON CIDADE.ID = PESSOA.IDCIDADE");
            System.out.println("Resultado do SELECT:");
            while (rs.next()) {
                System.out.println(rs.getInt("ID") + " - " + rs.getString("NOME") + " - " + rs.getString("CIDADE.NOME"));
            }
            rs.close();
            con.close();
        } catch (Exception e) {
            throw new Exception("Nao pode ser Removido.", e);
        }

    }
    
    public List<Pessoa> getBusca(String busca){
            List<Pessoa> buscass = new ArrayList<Pessoa>();
        try {
            
            String sql = "SELECT * FROM PESSOA where NOME like '%" + busca + "%'";
            
            Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;
        
            conn = abrirConexao();
            pstm = conn.prepareStatement(sql);
            rset = pstm.executeQuery();

            
            while (rset.next()) {
                Pessoa pe = new Pessoa();
                pe.setNome(rset.getString("nome"));
                buscass.add(pe);
	    }
            } catch (Exception e) {
        }
            return buscass;
    }

    public List<Pessoa> getPessoas() {

        String sql = "SELECT * FROM PESSOA INNER JOIN CIDADE ON CIDADE.ID = PESSOA.IDCIDADE";

        List<Pessoa> pessoas = new ArrayList<Pessoa>();

        Connection conn = null;
        PreparedStatement pstm = null;
        //Classe que vai recuperar os dados do banco de dados
        ResultSet rset = null;

        try {
            conn = abrirConexao();
            pstm = conn.prepareStatement(sql);
            rset = pstm.executeQuery();

            
            while (rset.next()) {

                Pessoa pe = new Pessoa();

                //Recupera o id do banco e atribui ele ao objeto
                pe.setId(rset.getInt("id"));

                //Recupera o nome do banco e atribui ele ao objeto
                pe.setNome(rset.getString("nome"));
                pe.setEndereco(rset.getString("endereco"));
                pe.setNumero(rset.getString("numero"));
                pe.setCpf(rset.getString("cpf"));
                pe.setRg(rset.getString("rg"));
                pe.setCidade(Integer.parseInt(rset.getString("cidade.id").toString()));


                //Adiciono o contato recuperado, a lista de contatos
                pessoas.add(pe);
            }
        } catch (Exception e) {

            e.printStackTrace();
        } finally {

            try {

                if (rset != null) {

                    rset.close();
                }

                if (pstm != null) {

                    pstm.close();
                }

                if (conn != null) {
                    conn.close();
                }

            } catch (Exception e) {

                e.printStackTrace();
            }
        }

        return pessoas;
    }

}
