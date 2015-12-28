package endereco.controle;

import java.sql.*;

public class Gerenciador {

    public Parametros params;
    public Connection con;
    public Statement stmt;
    public ResultSet rs;

    public Gerenciador() {
    }

    public Gerenciador(Parametros params){
        this.params = params;
        conecta();
    }

    public void reconecta(String database){
        desconecta();
        params.setDatabase(database);
        conecta();
    }
    
    //private void conecta() throws BancoDeDadosException {
    public void conecta() {
        try {
            Class.forName(params.getJdbcDriver());
            con = DriverManager.getConnection(params.getJdbcUrl(), "root", "");
        }
        catch (ClassNotFoundException e) {
        }
        catch (SQLException e) {
        }
    }
    
    public void desconecta() {
        try {
            if (con != null)
                con.close();
            con = null;
        }
        catch (SQLException e) {
            // ignora a excessão
        }
    }
    
    public void finaliza() {
        try {
            if (rs != null)
                rs.close();
            rs = null;
            if (stmt != null)
                stmt.close();
            stmt = null;    
        }
        catch (SQLException e) {
            // ignora a excessão
        }
    }    
    
    public void executa(String sql){
        try {
            stmt = con.createStatement();
            stmt.executeUpdate(sql);
        }
        catch (SQLException e) {
        }
        finally {
            finaliza();
        }
    }

    public PreparedStatement prepara(String sql) throws SQLException {
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            stmt = pst;
            return pst;
        }
        finally {
            finaliza();
        }
    }

}
