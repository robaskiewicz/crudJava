package crud.modelo;

import entidade.Estado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Robaskiewicz
 */
public class EstadoDao extends Banco {

    public void create(Estado entity) throws Exception {
        Connection con = null;
        try {
            con = abrirConexao();
            Statement pst = con.createStatement();

            pst.execute("INSERT INTO ESTADO (NOME,SIGLA) VALUES ('" + entity.getNome() + "','" + entity.getSigla() + "')");
            System.out.println("ESTADO INSERIDO");
            con.close();
        } catch (SQLException e) {
            throw new Exception("Nao pode ser inserido.", e);
        }
    }

    public void update(Estado entity, Integer id) throws Exception {
        Connection con = null;
        try {
            con = abrirConexao();
            Statement pst = con.createStatement();

            pst.execute("UPDATE ESTADO SET NOME = '" + entity.getNome() + "' ,SIGLA = '" + entity.getSigla() + "' WHERE ID = " + id + "");
            System.out.println("ESTADO ATUALIZADO");
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

            pst.execute("DELETE FROM ESTADO WHERE ID = " + id + "");
            System.out.println("ESTADO REMOVIDO");
            con.close();
        } catch (SQLException e) {
            throw new Exception("Nao pode ser Removido.", e);
        }
    }

    public void getResultList()  {
        Connection con = null;
        try {
            con = abrirConexao();
            Statement pst = con.createStatement();
            ResultSet rs = pst.executeQuery("SELECT * FROM ESTADO");
            System.out.println("Resultado do SELECT:");
            while (rs.next()) {
                System.out.println(rs.getInt("ID") + " - " + rs.getString("NOME") + " - " + rs.getString("SIGLA"));
            }
            rs.close();
            con.close();
        } catch (Exception e) {
           
        }

    }

    public List<Estado> getEstados() {

        String sql = "SELECT * FROM ESTADO";

        List<Estado> estados = new ArrayList<Estado>();

        Connection conn = null;
        PreparedStatement pstm = null;
        //Classe que vai recuperar os dados do banco de dados
        ResultSet rset = null;

        try {
            conn = abrirConexao();
            pstm = conn.prepareStatement(sql);
            rset = pstm.executeQuery();

            //Enquanto existir dados no banco de dados, faça
            while (rset.next()) {

                Estado est = new Estado();

                //Recupera o id do banco e atribui ele ao objeto
                est.setId(rset.getInt("id"));

                //Recupera o nome do banco e atribui ele ao objeto
                est.setNome(rset.getString("nome"));

                //Recupera a idade do banco e atribui ele ao objeto
                est.setSigla(rset.getString("sigla"));

                //Adiciono o contato recuperado, a lista de contatos
                estados.add(est);
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

        return estados;
    }
    
    public List<Estado> pegaBusca(String busca){
        
        List<Estado> estados = new ArrayList<Estado>();
        
       String sql = "SELECT * FROM ESTADO WHERE NOME LIKE '%"+busca+"%'";

        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;

        try {
            conn = abrirConexao();
            pstm = conn.prepareStatement(sql);
            rset = pstm.executeQuery();

            //Enquanto existir dados no banco de dados, faça
            while (rset.next()) {

                Estado est = new Estado();

                //Recupera o id do banco e atribui ele ao objeto
                est.setId(rset.getInt("id"));

                //Recupera o nome do banco e atribui ele ao objeto
                est.setNome(rset.getString("nome"));

                //Recupera a sigla do banco e atribui ele ao objeto
                est.setSigla(rset.getString("sigla"));

                //Adiciono o estado recuperado, a lista de estados
                estados.add(est);
                conn.close();
                pstm.close();
            }
        } catch (Exception e) {

            e.printStackTrace();
        }
        return estados;
    }
    
    


}
