package crud.modelo;

import static crud.modelo.Banco.abrirConexao;
import entidade.Cidade;
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
public class CidadeDao extends Banco{
    
    public void create(Cidade entity) throws Exception {
        Connection con = null;
        try {
            con = abrirConexao();
            Statement pst = con.createStatement();

            pst.execute("INSERT INTO CIDADE (NOME,IDESTADO) VALUES ('" + entity.getNome() + "','" + entity.getEstado() + "')");
            System.out.println("CIDADE INSERIDA");
            con.close();
        } catch (SQLException e) {
            throw new Exception("Nao pode ser inserido.", e);
        }

    }

    public void update(Cidade entity, Integer id) throws Exception {
        Connection con = null;
        try {
            con = abrirConexao();
            Statement pst = con.createStatement();

            pst.execute("UPDATE CIDADE SET NOME = '" + entity.getNome() + "' ,IDESTADO = '" + entity.getEstado() + "' WHERE ID = " + id + "");
            System.out.println("CIDADE ATUALIZADA");
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

            pst.execute("DELETE FROM CIDADE WHERE ID = " + id + "");
            System.out.println("CIDADE REMOVIDA");
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
            ResultSet rs = pst.executeQuery("SELECT * FROM CIDADE INNER JOIN ESTADO ON ESTADO.ID = CIDADE.IDESTADO");
            System.out.println("Resultado do SELECT:");
            while (rs.next()) {
                System.out.println(rs.getInt("ID") + " - " + rs.getString("NOME") + " - " + rs.getString("ESTADO.NOME"));
            }
            rs.close();
            con.close();
        } catch (Exception e) {
            throw new Exception("Nao pode ser Removido.", e);
        }

    }

    public List<Cidade> getCidades() {

        String sql = "SELECT * FROM CIDADE INNER JOIN ESTADO ON ESTADO.ID = CIDADE.IDESTADO";

        List<Cidade> cidades = new ArrayList<Cidade>();

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

                Cidade cid = new Cidade();

                //Recupera o id do banco e atribui ele ao objeto
                cid.setId(rset.getInt("id"));

                //Recupera o nome do banco e atribui ele ao objeto
                cid.setNome(rset.getString("nome"));
                
                cid.setEstado(Integer.parseInt(rset.getString("estado.id")));


                //Adiciono o contato recuperado, a lista de contatos
                cidades.add(cid);
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

        return cidades;
    }
    
    public List<Cidade> pegaBusca(String busca){
        
        List<Cidade> cidades = new ArrayList<Cidade>();
        
       String sql = "SELECT * FROM CIDADE WHERE NOME LIKE '%"+busca+"%'";

        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;

        try {
            conn = abrirConexao();
            pstm = conn.prepareStatement(sql);
            rset = pstm.executeQuery();

            //Enquanto existir dados no banco de dados, faça
            while (rset.next()) {

                Cidade cid = new Cidade();

                //Recupera o id do banco e atribui ele ao objeto
                cid.setId(rset.getInt("id"));

                //Recupera o nome do banco e atribui ele ao objeto
                cid.setNome(rset.getString("nome"));

                //Recupera a sigla do banco e atribui ele ao objeto
                cid.setEstado(rset.getInt("idestado"));

                //Adiciono o estado recuperado, a lista de estados
                cidades.add(cid);
                conn.close();
                pstm.close();
            }
        } catch (Exception e) {

            e.printStackTrace();
        }
        return cidades;
    }

}
