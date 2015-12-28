package endereco.dao;

import endereco.controle.Conexao;
import endereco.modelo.Bairro;
import endereco.modelo.Logradouro;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * @author Carlos Alexandre
 */
public class LogradouroDao {
    
    private List<Logradouro> lista = new ArrayList<Logradouro>();
    
     public void incluir(Logradouro logradouro) throws Exception {
        try {
            String sql = "INSERT INTO Logradouro (log_desc, log_num, log_compl, bai_cod, tpl_cod) VALUES (?, ?, ?, ?, ?)";

            PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);

            ps.setString(1, logradouro.getLog_desc());
            ps.setLong(2, logradouro.getLog_num());
            ps.setString(3, logradouro.getLog_compl());
            ps.setInt(4, logradouro.getBairro().getBai_cod());
            ps.setLong(5, logradouro.getTpl_Log().getTpl_cod());
            
            ps.executeUpdate();
        } catch (Exception erro) {
            erro.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao Inserir um Logradouro!", "ERRO!", JOptionPane.ERROR_MESSAGE);
            throw new Exception("Erro ao Incluir o Logradouro: " + erro.getMessage());
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
    public void excluir(Logradouro logradouro) throws Exception {

        try {
            String sql = "DELETE FROM Logradouro WHERE log_cod = ? ";
            PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);

            ps.setLong(1, logradouro.getLog_cod());

            ps.executeUpdate();
        } catch (Exception erro) {
            erro.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao Excluir o Logradouro!", "ERRO!", JOptionPane.ERROR_MESSAGE);
            throw new Exception("Erro ao Excluir o Logradouro: " + erro.getMessage());
        }

    }
    
    public List<Logradouro> selecionarPorNomeLogradouro(String nome) throws Exception {

        try {
            String sql;
            sql = "SELECT * FROM logradouro ORDER BY log_nome";
            PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);

            ResultSet rs = ps.executeQuery(sql);

            while (rs.next()) {
                Logradouro logradouro = new Logradouro();
                BairroDao bairroDao = new BairroDao();
                TipoLogradouroDao tipoDao = new TipoLogradouroDao();
                logradouro.setLog_cod(rs.getLong("log_cod"));
                logradouro.setLog_desc(rs.getString("log_desc"));
                logradouro.setLog_num(rs.getInt("log_num"));
                logradouro.setLog_compl(rs.getString("log_compl"));
                //logradouro.setBairro(bairroDao.selecionarPorUf(rs.getLong("bai_cod")));
                //logradouro.setEstado(tipoDao.selecionarPorUf(rs.getLong("tpl_cod")));
                getLista().add(logradouro);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return getLista();
    }

    public List<Logradouro> selecionarCidadePorEstado(Long log_cod) throws Exception {

        try {
            String sql;
            sql = "SELECT * FROM cidade c, estado e WHERE c.est_cod = e.est_cod AND e.est_cod='" + log_cod + "'";
            PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);

            ResultSet rs = ps.executeQuery(sql);
            while (rs.next()) {
                Bairro bairro = new Bairro();
                //bairro.setCid_cod(rs.getLong("cid_cod"));
                //bairro.setCid_nome(rs.getString("cid_nome"));
                //getLista().add(bairro);           
            }
        } catch (Exception erro) {
            erro.printStackTrace();
            throw new Exception("Erro ao Localizar Cidade pelo nome: " + erro.getMessage());
        }
        return getLista();
    }
    
    public List <Logradouro> getLista(){
        return lista;
    }
    
        /*public Cidade selecionarPorCidade(Long cid_cod) throws Exception {

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

    }*/
    
}
