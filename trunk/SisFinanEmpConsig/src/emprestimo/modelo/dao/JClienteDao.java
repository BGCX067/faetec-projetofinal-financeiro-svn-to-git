package emprestimo.modelo.dao;

import emprestimo.modelo.dao.*;
import emprestimo.controle.JConexao;
import emprestimo.modelo.modelo.JCliente;
import emprestimo.utilitario.JConverter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * @author Calex
 */
public class JClienteDao {

    private String erro = "Erro ao ";
    private final String aviso = "Erro!";

    public JClienteDao() {
    }

    //Método Inserir Cliente
    public void inserir(JCliente cliente) throws Exception {
        try {
            String sql = "INSERT INTO Cliente (cli_cpf, cli_nome, cli_sexo, cli_dtnasc, cli_email, cli_estcivil, log_cod) VALUES (?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement ps = JConexao.openConexao().prepareStatement(sql);

            ps.setString(1, cliente.getCli_cpf());
            ps.setString(2, cliente.getCli_nome());
            ps.setString(3, cliente.getCli_sexo());
            ps.setString(4, JConverter.converteDateToStringMysql(cliente.getCli_dtnasc()));
            ps.setString(5, cliente.getCli_email());
            ps.setString(6, cliente.getCli_estadocivil());
            ps.setLong(7, cliente.getLogradouro().getLog_cod());
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            String exception = "incluir Cliente! ";
            JOptionPane.showMessageDialog(null, erro + exception, aviso, JOptionPane.ERROR_MESSAGE);
            throw new Exception(erro + exception + e.getMessage());
        }
    }

    //Método Alterar Cliente
    public void alterar(JCliente cliente) throws Exception {
        try {
            String sql = "UPDATE Cliente SET cli_nome = ?, cli_sexo = ?, cli_dtnasc = ?, cli_email = ?, cli_estcivil = ?, log_cod = ? WHERE cli_cpf = ?";

            PreparedStatement ps = JConexao.openConexao().prepareStatement(sql);

            ps.setString(7, cliente.getCli_cpf());
            ps.setString(1, cliente.getCli_nome());
            ps.setString(2, cliente.getCli_sexo());
            ps.setString(3, JConverter.converteDateToStringMysql(cliente.getCli_dtnasc()));
            ps.setString(4, cliente.getCli_email());
            ps.setString(5, cliente.getCli_estadocivil());
            ps.setLong(6, cliente.getLogradouro().getLog_cod());
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            String exception = "alterar Cliente! ";
            JOptionPane.showMessageDialog(null, erro + exception, aviso, JOptionPane.ERROR_MESSAGE);
            throw new Exception(erro + exception + e.getMessage());
        }
    }

    //Método Excluir Cliente
    /*public void excluir(Long cli_cod) throws Exception {
        try {
            String sql = "DELETE FROM Cliente WHERE cli_cod = " + cli_cod;

            PreparedStatement ps = JConexao.openConexao().prepareStatement(sql);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            String exception = "excluir Cliente! ";
            JOptionPane.showMessageDialog(null, erro + exception, aviso, JOptionPane.ERROR_MESSAGE);
            throw new Exception(erro + exception + e.getMessage());
        }
    }*/

        public List<JCliente> retornaClientePorCPF(String cpf) throws Exception{

        List<JCliente> listaClientes = new ArrayList<JCliente>();
        String sql;
        try {
            sql = "SELECT * FROM Cliente WHERE cli_cpf LIKE '"+cpf+"%' ";

            PreparedStatement ps = JConexao.openConexao().prepareStatement(sql);

             ResultSet rs = ps.executeQuery();

              while (rs.next()) {

                JCliente cliente = new JCliente();
                JLogradouroDao logradouroDao = new JLogradouroDao();
                cliente.setCli_cod(rs.getInt("cli_cod"));
                cliente.setCli_cpf(rs.getString("cli_cpf"));
                cliente.setCli_nome(rs.getString("cli_nome"));
                cliente.setCli_sexo(rs.getString("cli_sexo"));
                cliente.setCli_dtnasc(rs.getDate("cli_dtnasc"));
                cliente.setCli_email(rs.getString("cli_email"));
                cliente.setCli_estadocivil(rs.getString("cli_estcivil"));
                //cliente.setLogradouro(logradouroDao.("log_cod"));
                listaClientes.add(cliente);
            }
        } catch (Exception e) {
            e.printStackTrace();
            String exception = "buscar o Cliente pelo CPF! ";
            JOptionPane.showMessageDialog(null, erro+exception, aviso, JOptionPane.ERROR_MESSAGE);
            throw  new Exception(erro+exception+e.getMessage());
        }

        return listaClientes;
    }

     public JCliente retornaObjetoCliente(int cli_cod) throws Exception {

        try {
            String sql;
            sql = "SELECT * FROM Cliente WHERE cli_cod = ?";

            PreparedStatement ps = JConexao.openConexao().prepareStatement(sql);

            ps.setInt(1, cli_cod);

            ResultSet rs = ps.executeQuery();


            JCliente cliente = null;
            if (rs.next()) {
                cliente = new JCliente();
                JLogradouroDao logDao = new JLogradouroDao();

                cliente.setCli_cod(rs.getInt("cli_cod"));
                cliente.setCli_cpf(rs.getString("cli_cpf"));
                cliente.setCli_nome(rs.getString("cli_nome"));
                cliente.setCli_sexo(rs.getString("cli_sexo"));
                cliente.setCli_dtnasc(rs.getDate("cli_dtnasc"));
                cliente.setCli_email(rs.getString("cli_email"));
                cliente.setCli_estadocivil(rs.getString("cli_estcivil"));
                cliente.setLogradouro(logDao.retornaObjetoLogradouro(rs.getInt("log_cod")));
            }
            return cliente;

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }

    }
}
