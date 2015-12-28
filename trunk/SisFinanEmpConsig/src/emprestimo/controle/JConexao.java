package emprestimo.controle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Carlos Alexandre
 */

public class JConexao {

    private static Connection con;
    final private static String driverMySQL = "com.mysql.jdbc.Driver";//MySQL
    final private static String driverOracle = "oracle.jdbc.driver.OracleDriver";// Oracle
    private static String proxy = "127.0.0.1";
    private static String porta = "3306";
    private static String nomeBanco = "sisfinanempconsig";
    public static String usuario = "root";
    public static String senha = "";
    public static String urlbanco = "jdbc:mysql://" + proxy + ":" + porta + "/" + nomeBanco;

    /*public static String getProxy() {
        return proxy;
    }

    public static void setProxy(String aProxy) {
        proxy = aProxy;
    }

    public static String getPorta() {
        return porta;
    }

    public static void setPorta(String aPorta) {
        porta = aPorta;
    }

    public static String getNomeBanco() {
        return nomeBanco;
    }

    public static void setNomeBanco(String aNomeBanco) {
        nomeBanco = aNomeBanco;
    }
    */
    public static Connection openConexao() throws Exception {
        try {
            if (con == null) {
                Class.forName(driverMySQL);
                con = DriverManager.getConnection(urlbanco, usuario, senha);
                System.out.println("Conectado");
            } 
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Erro de Conexão: " + e.getMessage());
        }
        return con;
    }
    
    public static void closeConnection() throws Exception{
        try{
            if(con != null){
                con.close();
            }
        } catch (Exception e){
            e.printStackTrace();
             throw new Exception("Erro de Conexão: " + e.getMessage());
        }
    }

    public void retCampos(String[] campos, String query1, String query2) throws Exception {
    try {
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT " + query1 + " FROM " + query2);
      if (rs.next()) {
        for (int i = 0; i < campos.length; i++) {
          campos[i] = rs.getString(i + 1);
        }
      }
      rs.close();
      stmt.close();
    } catch (SQLException eSql) {
        eSql.printStackTrace();
      System.out.println("Problemas na Query: Select " + query1 + " From " + query2);
    }
  }
}
