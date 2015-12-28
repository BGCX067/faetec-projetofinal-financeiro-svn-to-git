package endereco.dao;

import endereco.controle.Conexao;
import endereco.modelo.Bairro;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * @author Carlos Alexandre
 */
public class BairroDao {

     private List<Bairro> lista = new ArrayList<Bairro>();

     public void incluir(Bairro bairro) throws Exception {

        try {
            String sql = "INSERT INTO Bairro (bai_nome, cid_cod) VALUES (?, ?)";

            PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, bairro.getBai_nome());
            ps.setLong(2, bairro.getCidade().getCid_cod());

            ps.executeUpdate();
        } catch (Exception erro) {
            erro.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao Inserir o Bairro!", "ERRO!", JOptionPane.ERROR_MESSAGE);
            throw new Exception("Erro ao Incluir Bairro: " +erro.getMessage());
        }
    }

         // Método Alterar no Banco de Dados
    /*public void alterar(Estado estado) throws Exception {

        try {
            String sql = "UPDATE Estado SET est_nome = ? WHERE est_uf = ?";
            PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);

            ps.setString(2, estado.getEst_uf());
            ps.setString(1, estado.getEst_nome());

            ps.executeUpdate();
        } catch (Exception erro) {
            throw new Exception("Erro ao Alterar Estado: " + erro.getMessage());
        }

    }*/



    // Método Excluir no Banco de Dados
    public void excluir(Bairro bairro) throws Exception {

        try {
            String sql = "DELETE FROM Bairro WHERE bai_cod = ? ";
            PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);

            ps.setLong(1, bairro.getBai_cod());

            ps.executeUpdate();
        } catch (Exception erro) {
            erro.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao Excluir UF!", "ERRO!", JOptionPane.ERROR_MESSAGE);
            throw new Exception("Erro ao Excluir Estado: " + erro.getMessage());
        }

    }

        public List<Bairro> retornaBairroDaCidade(Long cid_cod) throws Exception {

        try {
            String sql;
            sql = "SELECT * FROM bairro b, cidade c WHERE b.cid_cod = c.cid_cod AND c.cid_cod=" +cid_cod;
            PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);

            ResultSet rs = ps.executeQuery(sql);
            while (rs.next()) {
                Bairro bairro = new Bairro();
                CidadeDao cidadeDao = new CidadeDao();
                bairro.setBai_cod(rs.getInt("bai_cod"));
                bairro.setBai_nome(rs.getString("bai_nome"));
                bairro.setCidade(cidadeDao.selecionarPorCidade(rs.getLong("cid_cod")));
                getLista().add(bairro);           
            }
        } catch (Exception erro) {
            erro.printStackTrace();
            throw new Exception("Erro ao Localizar Cidade pelo nome: " + erro.getMessage());
        }
        return getLista();
    }
    
    public List<Bairro> retornaListaBairro(String nome) throws Exception {

        try {
            String sql;
            sql = "SELECT * FROM bairro;";
            PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);

            ResultSet rs = ps.executeQuery(sql);

            while (rs.next()) {
                Bairro bairro = new Bairro();
                CidadeDao cidadeDao = new CidadeDao();
                bairro.setBai_cod(rs.getInt("bai_cod"));
                bairro.setBai_nome(rs.getString("bai_nome"));
                bairro.setCidade(cidadeDao.selecionarPorCidade(rs.getLong("cid_cod")));
                getLista().add(bairro);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return getLista();
    }

    public List<Bairro> getLista() {
        return lista;
    }
    
}
