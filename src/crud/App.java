package crud;

import crud.modelo.Banco;
import crud.modelo.CidadeDao;
import crud.modelo.EstadoDao;
import crud.modelo.PessoaDao;
import crud.visao.MenuPrincipal;
import entidade.Cidade;
import entidade.Estado;
import entidade.Pessoa;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;

/**
 *
 * @author Willian
 */
public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, Exception {
         Connection conexao = Banco.abrirConexao();        
        
        Statement declaracao = conexao.createStatement();
        declaracao.execute("CREATE TABLE if not exists ESTADO(ID INT NOT NULL IDENTITY, NOME VARCHAR(255) NOT NULL UNIQUE, SIGLA CHAR(2) NOT NULL UNIQUE, STATUS CHAR(1) DEFAULT 'A' NOT NULL);");
        
        declaracao.execute("CREATE TABLE if not exists CIDADE(ID INT NOT NULL IDENTITY, NOME VARCHAR(255) NOT NULL UNIQUE, IDESTADO INTEGER NOT NULL);");
        
        declaracao.execute("CREATE TABLE if not exists PESSOA(ID INT NOT NULL IDENTITY, NOME VARCHAR(255) NOT NULL UNIQUE, ENDERECO VARCHAR(255) NOT NULL UNIQUE, NUMERO INTEGER NOT NULL UNIQUE, CPF VARCHAR(255) NOT NULL UNIQUE, RG VARCHAR(255) NOT NULL UNIQUE, IDCIDADE INTEGER NOT NULL);");
        
        //declaracao.execute("ALTER TABLE CIDADE ADD FOREIGN KEY (IDESTADO) REFERENCES ESTADO(ID)");
        
        conexao.close();
        
        Estado est = new Estado("São paulo", "SP");
        Estado est2 = new Estado("Parana", "PR");
         
        EstadoDao estadoDao = new EstadoDao();
        
        //insere os dados
        estadoDao.create(est);
        estadoDao.create(est2);
                
        //ve os resultados
        estadoDao.getResultList();
        
        
        Cidade cid = new Cidade("Paranavaí", 1);
        CidadeDao cidadeDao = new CidadeDao();
        cidadeDao.create(cid);
        
        cidadeDao.getResultList();
        
        
        Pessoa pes = new Pessoa("michel", "Sua das nações", "218", "101110110", "54545545", 0);
        PessoaDao pessoaDao = new PessoaDao();
        pessoaDao.create(pes);
        
        pessoaDao.getResultList();
        
  
        
         /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {       
                
                
                
                final MenuPrincipal menuPrincipal = new MenuPrincipal();
                menuPrincipal.setLocationRelativeTo(null);
                menuPrincipal.setExtendedState( menuPrincipal.getExtendedState()|JFrame.MAXIMIZED_BOTH );
                menuPrincipal.setVisible(true);
            }
        });
    }
    
}
