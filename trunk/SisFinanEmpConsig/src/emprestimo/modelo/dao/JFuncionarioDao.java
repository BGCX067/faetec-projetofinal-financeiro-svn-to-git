package emprestimo.modelo.dao;

import emprestimo.controle.JConexao;
import emprestimo.modelo.modelo.JFuncionario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * @author Calex
 */
public class JFuncionarioDao {

    public List<JFuncionario> retornaListaTodosFuncionarios(String nome) throws Exception {

        List <JFuncionario> listaFuncionarios = new ArrayList<JFuncionario>();

        try {
            String sql;
            sql = "SELECT func_cod, func_nome, func_mat FROM Funcionario";
            PreparedStatement ps = JConexao.openConexao().prepareStatement(sql);

            ResultSet rs = ps.executeQuery(sql);

            while (rs.next()) {
                JFuncionario funcionario = new JFuncionario();

                funcionario.setFunc_cod(rs.getLong("func_cod"));
                funcionario.setFunc_nome(rs.getString("func_nome"));
                funcionario.setFunc_mat(rs.getLong("func_mat"));
                listaFuncionarios.add(funcionario);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return listaFuncionarios;
    }

    public JFuncionario retornaFuncionarioLogado (String usuario) throws Exception {
        try {
            String sql = "SELECT func_nome FROM Conta_Usuario c, Funcionario f WHERE c.func_cod=f.func_cod AND usu_login = ? ";

            PreparedStatement ps = JConexao.openConexao().prepareStatement(sql);

            ps.setString(1, usuario);
            ResultSet rs = ps.executeQuery();
            JFuncionario funcionario = new JFuncionario();
            if (rs.next()) {
                funcionario.setFunc_nome(rs.getString("func_nome"));
            }
            return funcionario;
        }
        catch (SQLException eSql) {
                eSql.printStackTrace();
                JOptionPane.showMessageDialog(null, "Erro ao Buscar Funcionario!", "Erro!", JOptionPane.ERROR_MESSAGE);
            throw new Exception("Error", eSql);
        }
    }
}
