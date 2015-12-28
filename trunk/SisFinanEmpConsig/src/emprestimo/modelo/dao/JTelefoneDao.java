package emprestimo.modelo.dao;

import emprestimo.controle.JConexao;
import emprestimo.modelo.modelo.JTelefone;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

/**
 *
 * @author Calex
 */
public class JTelefoneDao {

    private String erro = "Erro ao ";
    private final String aviso = "Erro!";

     public JTelefoneDao() {
    }

    //Método Inserir Telefone
    public void inserir(JTelefone telefone) throws Exception {
        try {
            String sql = "INSERT INTO Telefone (tel_codarea, tel_num, tel_tipo, cli_cpf) VALUES (?, ?, ?, ?)";

            PreparedStatement ps = JConexao.openConexao().prepareStatement(sql);

            ps.setString(1, telefone.getTel_codarea());
            ps.setString(2, telefone.getTel_num());
            ps.setString(3, telefone.getTel_tipo());
            ps.setString(4, telefone.getCliente().getCli_cpf());
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            String exception = "incluir Telefone! ";
            JOptionPane.showMessageDialog(null, erro + exception, aviso, JOptionPane.ERROR_MESSAGE);
            throw new Exception(erro + exception + e.getMessage());
        }
    }

    //Método Alterar Telefone
    public void alterar(JTelefone telefone) throws Exception {
        try {
            String sql = "UPDATE Telefone SET tel_codarea = ?, tel_num = ?, tel_tipo = ?, cli_cpf = ? WHERE tel_cod = ?";

            PreparedStatement ps = JConexao.openConexao().prepareStatement(sql);

            ps.setString(1, telefone.getTel_codarea());
            ps.setString(2, telefone.getTel_num());
            ps.setString(3, telefone.getTel_tipo());
            ps.setString(4, telefone.getCliente().getCli_cpf());
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            String exception = "alterar Telefone! ";
            JOptionPane.showMessageDialog(null, erro + exception, aviso, JOptionPane.ERROR_MESSAGE);
            throw new Exception(erro + exception + e.getMessage());
        }
    }

    //Método Excluir Telefone
    public void excluir(Long tel_cod) throws Exception {
        try {
            String sql = "DELETE FROM Telefone WHERE tel_cod = " + tel_cod;

            PreparedStatement ps = JConexao.openConexao().prepareStatement(sql);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            String exception = "excluir Telefone! ";
            JOptionPane.showMessageDialog(null, erro + exception, aviso, JOptionPane.ERROR_MESSAGE);
            throw new Exception(erro + exception + e.getMessage());
        }
    }

}
