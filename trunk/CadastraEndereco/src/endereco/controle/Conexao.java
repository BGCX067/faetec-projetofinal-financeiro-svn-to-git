package endereco.controle;

import java.beans.Statement;
import javax.swing.JOptionPane;
import java.sql.*;

/**
 *
 * @author Carlos Alexandre
 */
public class Conexao {

    public static String nameDatabase ="sisfinanemprestimo";
    private static String driver = "com.mysql.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/"+nameDatabase;
    private static String usuario = "root";
    private static String senha = "";
    private static Connection conexao = null;
    public Connection con;
    public Statement stmt;
    public ResultSet rs;
    
    public static Connection getConexao() throws Exception {
        try {
            if (conexao == null) {
                Class.forName(driver);
            }
            conexao = DriverManager.getConnection(url, usuario, senha);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro de Conexão com o Banco!", "ERRO!", JOptionPane.ERROR_MESSAGE);
            throw new Exception("Erro e Conexão: " + e.getMessage());
        }
        return conexao;
    }   
}
