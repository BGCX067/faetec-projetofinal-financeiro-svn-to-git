package emprestimo.modelo.dao;

import emprestimo.controle.JConexao;
import emprestimo.modelo.modelo.JConta_Usuario;
import emprestimo.modelo.modelo.JFuncionario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Carlos Alexandre
 */
public class JConta_UsuarioDao {

    private List<JConta_Usuario> usuarios;
    private String erro = "Erro ao ";
    private final String aviso = "Erro!";

    public JConta_Usuario validaUsuario(String usuario) throws Exception {
        try {
            String sql = "SELECT * FROM Conta_Usuario WHERE usu_login = ? ";

            PreparedStatement ps = JConexao.openConexao().prepareStatement(sql);
            
            ps.setString(1, usuario);
            ResultSet rs = ps.executeQuery();
            JConta_Usuario login = new JConta_Usuario();
            if (rs.next()) {
                login.setUsu_login(rs.getString("usu_login"));
            }
            return login;
        } 
        catch (SQLException eSql) {
                eSql.printStackTrace();
                JOptionPane.showMessageDialog(null, "Erro Interno de Validação!", "Erro!", JOptionPane.ERROR_MESSAGE);
            throw new Exception("Login Inexistente", eSql);
        }
    }

     public ImageIcon retornaFotoUsuario(String dir) throws Exception {
         ImageIcon foto = null;
        try {
            String sql = "SELECT usu_foto FROM Conta_Usuario WHERE usu_login = ? ";

            PreparedStatement ps = JConexao.openConexao().prepareStatement(sql);

            ps.setString(1, dir);
            ResultSet rs = ps.executeQuery();
            JConta_Usuario login = new JConta_Usuario();
            if (rs.next()) {
                foto = new ImageIcon(rs.getString("usu_login"));
                System.out.println(foto.getIconHeight());
                System.out.println(foto.getIconWidth());
            }
            return foto;
        }
        catch (SQLException eSql) {
                eSql.printStackTrace();
                JOptionPane.showMessageDialog(null, "Erro Interno de Validação!", "Erro!", JOptionPane.ERROR_MESSAGE);
            throw new Exception("Login Inexistente", eSql);
        }
    }

    public void insert (JConta_Usuario usuario) throws Exception{
        try {
            String sql = "INSERT INTO Conta_Usuario (usu_login, usu_senha, usu_foto, niv_cod, func_cod) VALUES (?, ?, ?, ?, ?) ";

            PreparedStatement ps = JConexao.openConexao().prepareStatement(sql);
            
            ps.setString(1, usuario.getUsu_login());
            ps.setString(2, usuario.getUsu_senha());
            ps.setBlob(3, usuario.getUsu_foto()==null?null:usuario.getUsu_foto());
            ps.setLong(4, usuario.getNivel().getNiv_cod());
            ps.setLong(5, usuario.getFuncionario().getFunc_cod());
            ps.executeUpdate();

        } catch (Exception eSql) {
             eSql.printStackTrace();
             String exception = "incluir Usuário! ";
                JOptionPane.showMessageDialog(null, erro+exception, aviso, JOptionPane.ERROR_MESSAGE);
        }
    }



        public void update (JConta_Usuario usuario) throws Exception{
        try {
            String sql = "UPDATE Conta_Usuario SET usu_senha = ?, usu_foto = ?  WHERE usu_login = ?) ";

            PreparedStatement ps = JConexao.openConexao().prepareStatement(sql);

            ps.setString(3, usuario.getUsu_login());
            ps.setString(1, usuario.getUsu_senha());
            ps.setBlob(2, usuario.getUsu_foto());
            ps.executeUpdate();

        } catch (Exception eSql) {
             eSql.printStackTrace();
             String exception = "alterar Usuário! ";
                JOptionPane.showMessageDialog(null, erro+exception, aviso, JOptionPane.ERROR_MESSAGE);
        }
    }

                    //Método Consultar Todos os Funcionários
        public List<JFuncionario> retornaListaFuncionarios() throws Exception {

        List <JFuncionario> listaFuncionarios = new LinkedList<JFuncionario>();
        try {
            String sql;
            sql = "SELECT * FROM Funcionario";
            PreparedStatement ps = JConexao.openConexao().prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                JFuncionario funcionario = new JFuncionario();
                JLogradouroDao logDao = new JLogradouroDao();

                funcionario.setFunc_cod(rs.getLong("func_cod"));
                funcionario.setFunc_mat(rs.getLong("func_mat"));
                funcionario.setFunc_nome(rs.getString("func_nome"));
                funcionario.setLogradouro(logDao.retornaObjetoLogradouro(rs.getInt("log_cod")));
                listaFuncionarios.add(funcionario);

            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        finally{
            try {
                finalize();
            } catch (Throwable ex) {
                Logger.getLogger(JEstadoDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listaFuncionarios;
    }
}
