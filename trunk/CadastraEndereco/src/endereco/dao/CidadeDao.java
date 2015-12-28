package endereco.dao;

import endereco.controle.Conexao;
import endereco.modelo.Cidade;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Carlos Alexandre
 */
public class CidadeDao {

    private List<Cidade> lista = new ArrayList<Cidade>();

    public void incluir(Cidade cidade) throws Exception {
        try {
            String sql = "INSERT INTO Cidade (cid_nome, est_cod) VALUES (?, ?)";

            PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);

            ps.setString(1, cidade.getCid_nome());
            ps.setLong(2, cidade.getEstado().getEst_cod());

            ps.executeUpdate();
        } catch (Exception erro) {
            erro.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao Inserir a Cidade!", "ERRO!", JOptionPane.ERROR_MESSAGE);
            throw new Exception("Erro ao Incluir Cidade: " + erro.getMessage());
        }
    }

    /*public void alterar(Cidade cid) throws Exception {
    
    try {
    String sql = "UPDATE cidade SET cid_nome = ?, est_uf = ? WHERE cid_id = ?";
    PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
    
    ps.setInt(3, cid.getCid_id());
    ps.setString(1, cid.getCid_nome());
    ps.setString(2, cid.getEstado().getEst_uf());
    
    ps.executeUpdate();
    } catch (Exception erro) {
    throw new Exception("Erro ao Alterar Cidade: " + erro.getMessage());
    }
    
    }*/
    public void excluir(Long cid_cod) throws Exception {

        try {
            String sql = "DELETE FROM Cidade WHERE cid_cod =  " + cid_cod;
            PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);

            ps.executeUpdate();
        } catch (Exception erro) {
            erro.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao Excluir a Cidade!", "ERRO!", JOptionPane.ERROR_MESSAGE);
            throw new Exception("Erro ao Excluir Cidade: " + erro.getMessage());
        }

    }

    // Método de Consulta ESPECÍFICA no Banco de Dados
    public List<Cidade> retornaListaCidade(String nome) throws Exception {

        try {
            String sql;
            sql = "SELECT * FROM cidade ORDER BY cid_nome";
            PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);

            ResultSet rs = ps.executeQuery(sql);

            while (rs.next()) {
                Cidade cidade = new Cidade();
                EstadoDao estadoDao = new EstadoDao();
                cidade.setCid_cod(rs.getLong("cid_cod"));
                cidade.setCid_nome(rs.getString("cid_nome"));
                cidade.setEstado(estadoDao.selecionarPorUf(rs.getLong("est_cod")));
                getLista().add(cidade);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return getLista();
    }

    public List<Cidade> retornaCidadeDoEstado(Long est_cod) throws Exception {

        try {
            String sql;
            sql = "SELECT * FROM cidade c, estado e WHERE c.est_cod = e.est_cod AND e.est_cod='" + est_cod + "'";
            PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);

            ResultSet rs = ps.executeQuery(sql);
            while (rs.next()) {
                Cidade cidade = new Cidade();
                cidade.setCid_cod(rs.getLong("cid_cod"));
                cidade.setCid_nome(rs.getString("cid_nome"));
                getLista().add(cidade);           
            }
        } catch (Exception erro) {
            erro.printStackTrace();
            throw new Exception("Erro ao Localizar Cidade pelo nome: " + erro.getMessage());
        }
        return getLista();
    }
    
    public List <Cidade> getLista(){
        return lista;
    }
    
        public Cidade selecionarPorCidade(Long cid_cod) throws Exception {

        try {
            String sql = "SELECT * FROM Cidade WHERE cid_cod = "+ cid_cod;

            PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
            //ps.setLong(1, uf);
            ResultSet rs = ps.executeQuery(sql);
            Cidade cidade = null;

            if (rs.next()) {
                cidade = new Cidade();
                EstadoDao estadoDao = new EstadoDao();
                cidade.setCid_cod(rs.getLong("cid_cod"));
                cidade.setCid_nome(rs.getString("cid_nome"));
                cidade.setEstado(estadoDao.selecionarPorUf(rs.getLong("est_cod")));
            }
            return cidade;

        } catch (Exception erro) {
            erro.printStackTrace();
            throw new Exception("Erro ao Selecionar o Estado: " + erro.getMessage());
        }

    }
}
