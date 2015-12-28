package endereco.dao;

import endereco.controle.Conexao;
import endereco.modelo.TipoLogradouro;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * @author Carlos Alexandre
 */
public class TipoLogradouroDao {
    
     private List<TipoLogradouro> lista = new ArrayList<TipoLogradouro>();

    public void incluir(TipoLogradouro tipoLog) throws Exception {
        try {
            String sql = "INSERT INTO tipo_log (tpl_desc) VALUES (?)";

            PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);

            ps.setString(1, tipoLog.getTpl_desc());

            ps.executeUpdate();
        } catch (Exception erro) {
            erro.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao Inserir um Tipo de Logradouro!", "ERRO!", JOptionPane.ERROR_MESSAGE);
            throw new Exception("Erro ao Incluir  o Tipo de Logradouro: " + erro.getMessage());
        }
    }

        public List<TipoLogradouro> retornaListaTipoLogradouro(String nome) throws Exception {

        try {
            String sql;
            sql = "SELECT * FROM tipo_log ORDER BY tpl_desc";
            PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);

            ResultSet rs = ps.executeQuery(sql);

            while (rs.next()) {
                TipoLogradouro tipolog = new TipoLogradouro();
                tipolog.setTpl_cod(rs.getLong("tpl_cod"));
                tipolog.setTpl_desc(rs.getString("tpl_desc"));
                getLista().add(tipolog);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return getLista();
    }

        public List <TipoLogradouro> getLista(){
        return lista;
    }
    
}
