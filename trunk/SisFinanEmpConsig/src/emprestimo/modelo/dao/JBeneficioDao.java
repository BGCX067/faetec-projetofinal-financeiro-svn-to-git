package emprestimo.modelo.dao;

import emprestimo.modelo.dao.*;
import emprestimo.controle.JConexao;
import emprestimo.modelo.modelo.JBeneficio;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Calex
 */
public class JBeneficioDao {

    private String erro = "Erro ao ";
    private final String aviso = "Erro!";

    public JBeneficioDao(){

    }


        //Método Inserir Beneficio
    public void inserir(JBeneficio beneficio) throws Exception {
        try {
            String sql = "INSERT INTO Beneficio (ben_num, ben_codinss, ben_desc, ben_renda, cli_cod) VALUES (?, ?, ?, ?, ?)";

            PreparedStatement ps = JConexao.openConexao().prepareStatement(sql);

            ps.setInt(1, beneficio.getBen_numero());
            ps.setInt(2, beneficio.getBen_codinss());
            ps.setString(3, beneficio.getBen_desc());
            ps.setDouble(4, beneficio.getBen_renda());
            ps.setLong(5, beneficio.getCliente().getCli_cod());
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            String exception = "incluir Beneficio! ";
            JOptionPane.showMessageDialog(null, erro + exception, aviso, JOptionPane.ERROR_MESSAGE);
            throw new Exception(erro + exception + e.getMessage());
        }
    }

               public JBeneficio retornaObjetoBeneficio(int ben_cod) throws Exception {

        try {
            String sql;
            sql = "SELECT * FROM Beneficio WHERE ben_cod = ?";

            PreparedStatement ps = JConexao.openConexao().prepareStatement(sql);

            ps.setInt(1, ben_cod);

            ResultSet rs = ps.executeQuery();


            JBeneficio beneficio = null;
            if (rs.next()) {
                beneficio = new JBeneficio();
                JClienteDao clienteDao = new JClienteDao();

                beneficio.setBen_cod(rs.getInt("ben_cod"));
                beneficio.setBen_numero(rs.getInt("ben_num"));
                beneficio.setBen_codInss(rs.getInt("ben_codinss"));
                beneficio.setBen_desc(rs.getString("ben_desc"));
                beneficio.setBen_renda(rs.getDouble("ben_renda"));
                beneficio.setCliente(clienteDao.retornaObjetoCliente(rs.getInt("cli_cod")));


            }
            return beneficio;

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }

    }

}
