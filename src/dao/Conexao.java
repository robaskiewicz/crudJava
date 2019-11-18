package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {

    private static Connection con = null;

    public static Connection getConnection() {
        if (con == null) {
            try {
                String driver = "com.mysql.jdbc.Driver";
                String url = "jdbc:mysql://localhost:3306/bancointerdisciplinar";
                String usuario = "root";
                String senha = "root";
                Class.forName(driver);
                con = DriverManager.getConnection(url, usuario, senha);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return con;
    }

    public static void closeConnection() {
        if (con != null) {
            try {
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}