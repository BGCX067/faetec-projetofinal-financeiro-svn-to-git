package endereco.dao;

import endereco.controle.Conexao;
import endereco.modelo.Estado;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Carlos Alexandre
 */
public class EstadoDao {
    
      private List<Estado> lista = null;

    
    //Método Inserir no Banco de Dados
    public void incluir(Estado estado) throws Exception {

        try {
            String sql = "INSERT INTO Estado (est_uf, est_nome) VALUES (?, ?)";

            PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, estado.getEst_uf());
            ps.setString(2, estado.getEst_nome());

            ps.executeUpdate();
        } catch (Exception erro) {
            erro.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao Inserir UF!", "ERRO!", JOptionPane.ERROR_MESSAGE);
            throw new Exception("Erro ao Incluir Estado: " +erro.getMessage());
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
    public void excluir(Long est_cod) throws Exception {

        try {
            String sql = "DELETE FROM Estado WHERE est_cod ="+ est_cod;
            System.out.println(sql);
            PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception erro) {
            erro.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao Excluir UF!", "ERRO!", JOptionPane.ERROR_MESSAGE);
            throw new Exception("Erro ao Excluir Estado: " + erro.getMessage());
        }

    }
    
    public Estado selecionarPorUf(Long uf) throws Exception {

        try {
            String sql = "SELECT * FROM Estado WHERE est_cod ="+uf;

            PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
            //ps.setLong(1, uf);
            ResultSet rs = ps.executeQuery(sql);
            Estado estado = null;

            if (rs.next()) {
                estado = new Estado();
                estado.setEst_cod(rs.getLong("est_cod"));
                estado.setEst_uf(rs.getString("est_uf"));
                estado.setEst_nome(rs.getString("est_nome"));
            }

            return estado;


        } catch (Exception erro) {
            erro.printStackTrace();
            throw new Exception("Erro ao Selecionar o Estado: " + erro.getMessage());
        }

    }
    
    public List<Estado> retornaListaEstado(String nome) throws Exception {

        try {
            String sql;
                sql = "SELECT * FROM Estado ORDER BY est_nome";
            PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);

            /*if (ps.getParameterMetaData().getParameterCount() > 0)  {
                ps.setString(1, nome + "%");
                // "%" somente String, para substituir palavras inteiras
                //"_" somente String, para substituir caracteres
            }*/

            ResultSet rs = ps.executeQuery(sql);

            lista = new ArrayList<Estado>();

            while (rs.next()) {

                Estado estado = new Estado();
                estado.setEst_cod(rs.getLong("est_cod"));
                estado.setEst_uf(rs.getString("est_uf"));
                estado.setEst_nome(rs.getString("est_nome"));

                getLista().add(estado);
            }

            return getLista();

        } catch (Exception erro) {
            throw new Exception("Erro ao Localizar Estado pelo nome: " + erro.getMessage());
        }
    }


    public List<Estado> getLista() {
        return lista;
    }
    
    public Estado buscaEstado(String nomeEstado){
        Estado estado = null;
        try{
            String sql = "SELECT * FROM estado WHERE est_nome = '"+nomeEstado+"'";
            PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
            ResultSet rs = ps.executeQuery(sql);
            if(rs.next()){
                estado = new Estado();
                estado.setEst_cod(rs.getLong("est_cod"));
                estado.setEst_uf(rs.getString("est_uf"));
                estado.setEst_nome(rs.getString("est_nome"));
            }
        } catch (Exception e){
            e.printStackTrace();
        } finally{
            
        }
        return estado;
    } 
    
}
