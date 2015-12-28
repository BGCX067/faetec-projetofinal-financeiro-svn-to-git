package emprestimo.modelo.dao;

import emprestimo.controle.JConexao;
import emprestimo.modelo.modelo.JCidade;
import emprestimo.modelo.modelo.JEstado;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * @author Carlos Alexandre
 */
public class JCidadeDao {

    private String erro = "Erro ao ";
    private final String aviso = "Erro!";

    public JCidadeDao() {
    }

    //Método Inserir Estado
    public void inserir(JCidade cidade) throws Exception {
        try {
            String sql = "INSERT INTO Cidade (cid_nome, est_cod) VALUES (?, ?)";

            PreparedStatement ps = JConexao.openConexao().prepareStatement(sql);

            ps.setString(1, cidade.getCid_nome());
            ps.setLong(2, cidade.getEstado().getEst_cod());
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            String exception = "incluir Cidade! ";
            JOptionPane.showMessageDialog(null, erro + exception, aviso, JOptionPane.ERROR_MESSAGE);
            throw new Exception(erro + exception + e.getMessage());
        }
    }

    //Método Alterar Estado
    public void alterar(JCidade cidade) throws Exception {
        try {
            String sql = "UPDATE cidade SET cid_nome = ?, est_cod = ? WHERE cid_cod = ?";

            PreparedStatement ps = JConexao.openConexao().prepareStatement(sql);

            ps.setLong(3, cidade.getCid_cod());
            ps.setString(1, cidade.getCid_nome());
            ps.setLong(2, cidade.getEstado().getEst_cod());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            String exception = "alterar Cidade! ";
            JOptionPane.showMessageDialog(null, erro + exception, aviso, JOptionPane.ERROR_MESSAGE);
            throw new Exception(erro + exception + e.getMessage());
        }
    }

    //Método Excluir Estado
    public void excluir(int cid_cod) throws Exception {
        try {
            String sql = "DELETE FROM Cidade WHERE cid_cod =  " + cid_cod;

            PreparedStatement ps = JConexao.openConexao().prepareStatement(sql);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            String exception = "excluir Cidade! ";
            JOptionPane.showMessageDialog(null, erro + exception, aviso, JOptionPane.ERROR_MESSAGE);
            throw new Exception(erro + exception + e.getMessage());
        }
    }

    //Método Consultar Todos os Cidades
    public List<JCidade> retornaListaCidades() throws Exception {

        List<JCidade> listaCidade = new ArrayList<JCidade>();
        try {
            String sql;
            sql = "SELECT * FROM Cidade";
            PreparedStatement ps = JConexao.openConexao().prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                JCidade cidade = new JCidade();
                JEstadoDao estadoDao = new JEstadoDao();

                cidade.setCid_cod(rs.getInt("cid_cod"));
                cidade.setCid_nome(rs.getString("cid_nome"));
                cidade.setEstado(estadoDao.retornaListaEstado(rs.getLong("est_cod")));
                listaCidade.add(cidade);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return listaCidade;
    }

    public List<JCidade> retornaListaCidadePorNome(String nome) throws Exception {

        List<JCidade> listaCidades = new ArrayList<JCidade>();

        try {
            String sql = "SELECT * FROM Cidade WHERE cid_nome LIKE '" + nome + "%'";

            PreparedStatement ps = JConexao.openConexao().prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            JCidade cidade = null;
            JEstadoDao estdao = new JEstadoDao();

            while (rs.next()) {
                cidade = new JCidade();
                cidade.setCid_cod(rs.getInt("cid_cod"));
                cidade.setCid_nome(rs.getString("cid_nome"));
                cidade.setEstado(estdao.retornaListaEstado(rs.getLong("est_cod")));
                listaCidades.add(cidade);
            }
            return listaCidades;

        } catch (Exception erro) {
            throw new Exception("Erro ao localizar Cidade por Estado: " + erro.getMessage());
        }
    }



    // Método utilizando em JModuloCidade
    public List<JCidade> retornaListaCidadePorEstado(String uf) throws Exception {

        List<JCidade> listaCidades = new ArrayList<JCidade>();

        try {
            String sql = "SELECT * FROM Cidade WHERE est_cod = " + uf + "%";

            PreparedStatement ps = JConexao.openConexao().prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            JCidade cidade = null;
            JEstadoDao estdao = new JEstadoDao();

            while (rs.next()) {
                cidade = new JCidade();
                cidade.setCid_cod(rs.getInt("cid_cod"));
                cidade.setCid_nome(rs.getString("cid_nome"));
                cidade.setEstado(estdao.retornaListaEstado(rs.getLong("est_cod")));
                listaCidades.add(cidade);
            }
            return listaCidades;

        } catch (Exception erro) {
            erro.printStackTrace();
            throw new Exception("Erro ao localizar Cidade por Estado: " + erro.getMessage());
        }

    }


        // Método utilizando em JCadastraCliente
        public List<JCidade> retornaListaCidadePorEstado(Long uf) throws Exception {

        List<JCidade> listaCidades = new ArrayList<JCidade>();

        try {
            String sql = "SELECT * FROM Cidade WHERE est_cod = ?" ;

            PreparedStatement ps = JConexao.openConexao().prepareStatement(sql);

            ps.setLong(1, uf);

            ResultSet rs = ps.executeQuery();

            JCidade cidade = null;
            JEstadoDao estdao = new JEstadoDao();

            while (rs.next()) {
                cidade = new JCidade();
                cidade.setCid_cod(rs.getInt("cid_cod"));
                cidade.setCid_nome(rs.getString("cid_nome"));
                cidade.setEstado(estdao.retornaListaEstado(rs.getLong("est_cod")));
                listaCidades.add(cidade);
            }
            return listaCidades;

        } catch (Exception erro) {
            erro.printStackTrace();
            throw new Exception("Erro ao localizar Cidade por Estado: " + erro.getMessage());
        }

    }

    public JCidade retornaListaCidade(int cid_cod) throws Exception {

        try {
            String sql;
            sql = "SELECT * FROM Cidade WHERE cid_cod = ?";

            PreparedStatement ps = JConexao.openConexao().prepareStatement(sql);

            ps.setInt(1, cid_cod);

            ResultSet rs = ps.executeQuery();


            JCidade cidade = null;
            if (rs.next()) {
                cidade = new JCidade();
                JEstadoDao estadoDao = new JEstadoDao();

                cidade.setCid_cod(rs.getInt("est_cod"));
                cidade.setCid_nome(rs.getString("cid_nome"));
                cidade.setEstado(estadoDao.retornaListaEstado(rs.getLong("est_cod")));
            }
            return cidade;

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }

    }
}
