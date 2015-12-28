package emprestimo.modelo.dao;

import emprestimo.controle.JConexao;
import emprestimo.modelo.modelo.JTipoLogradouro;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * @author Carlos Alexandre
 */
public class JTipoLogradouroDao {

      private String erro = "Erro ao ";
    private final String aviso = "Erro!";



    public JTipoLogradouroDao(){
    }




    //Método Inserir Tipo de Logradour
    public void inserir(JTipoLogradouro tipoLogradouro) throws Exception{
        try {
            String sql = "INSERT INTO Tipo_Logradouro (tpl_desc) VALUES (?)";

            PreparedStatement ps = JConexao.openConexao().prepareStatement(sql);

            ps.setString(1, tipoLogradouro.getTpl_desc());
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            String exception = "incluir Tipo de Logradouro! ";
            JOptionPane.showMessageDialog(null, erro+exception, aviso, JOptionPane.ERROR_MESSAGE);
            throw new Exception(erro+exception+e.getMessage());
        }
    }




    //Método Alterar Tipo de Logradour
    public void alterar(JTipoLogradouro tipoLogradouro) throws Exception{
        try {
            String sql = "UPDATE Tipo_Logradouro SET tpl_desc = ? WHERE tpl_cod = ?";

            PreparedStatement ps = JConexao.openConexao().prepareStatement(sql);

            ps.setLong(2, tipoLogradouro.getTpl_cod());
            ps.setString(1, tipoLogradouro.getTpl_desc());
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            String exception = "alterar Tipo de Logradour! ";
            JOptionPane.showMessageDialog(null, erro+exception, aviso, JOptionPane.ERROR_MESSAGE);
            throw  new Exception(erro+exception+e.getMessage());
        }
    }




        //Método Excluir Tipo de Logradour
    public void excluir(Long tpl_cod) throws Exception{
        try {
            String sql = "DELETE FROM Tipo_Logradouro WHERE tpl_cod = "+tpl_cod;

            PreparedStatement ps = JConexao.openConexao().prepareStatement(sql);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            String exception = "excluir Tipo de Logradour! ";
            JOptionPane.showMessageDialog(null, erro+exception, aviso, JOptionPane.ERROR_MESSAGE);
            throw  new Exception(erro+exception+e.getMessage());
        }
    }

        //Método Consultar Um Tipo de Logradouro
        /*
         * Usando em  --btnBuscaTipoLogradouro
         */
    public List<JTipoLogradouro> retornaTipoLogradouro(String nome) throws Exception{

        List<JTipoLogradouro> listaTiposLogradouro = new LinkedList<JTipoLogradouro>();

        try {
            String sql = "SELECT * FROM Tipo_Logradouro WHERE tpl_desc LIKE '"+nome+"%' ";

            PreparedStatement ps = JConexao.openConexao().prepareStatement(sql);

             ResultSet rs = ps.executeQuery();

              while (rs.next()) {

                JTipoLogradouro tipoLog = new JTipoLogradouro();
                tipoLog.setTpl_desc(rs.getString("tpl_desc"));
                listaTiposLogradouro.add(tipoLog);
            }
        } catch (Exception e) {
            e.printStackTrace();
            String exception = "buscar o Tipo de Logradouro! ";
            JOptionPane.showMessageDialog(null, erro+exception, aviso, JOptionPane.ERROR_MESSAGE);
            throw  new Exception(erro+exception+e.getMessage());
        }

        return listaTiposLogradouro;
    }

    //Método Consultar Todos os Tipo de Logradouro
        public List<JTipoLogradouro> retornaListaTiposdeLogradouro() throws Exception {

        List <JTipoLogradouro> listaTipoLogradouros = new LinkedList<JTipoLogradouro>();
        try {
            String sql;
            sql = "SELECT * FROM Tipo_Logradouro";
            PreparedStatement ps = JConexao.openConexao().prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                JTipoLogradouro tipoLogradouro = new JTipoLogradouro();

                tipoLogradouro.setTpl_cod(rs.getLong("tpl_cod"));
                tipoLogradouro.setTpl_desc(rs.getString("tpl_desc"));
                listaTipoLogradouros.add(tipoLogradouro);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        finally{
            try {
                finalize();
            } catch (Throwable ex) {
                Logger.getLogger(JEstadoDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listaTipoLogradouros;
    }

     public JTipoLogradouro retornaListaTipoLOgradouro(int tpl_cod) throws Exception {

        try {
            String sql;
            sql = "SELECT * FROM Tipo_Logradouro WHERE tpl_cod = ?";

            PreparedStatement ps = JConexao.openConexao().prepareStatement(sql);

            ps.setInt(1, tpl_cod);

            ResultSet rs = ps.executeQuery();


            JTipoLogradouro tipoLog = null;
            if (rs.next()) {
                tipoLog = new JTipoLogradouro();

                tipoLog.setTpl_cod(rs.getLong("tpl_cod"));
                tipoLog.setTpl_desc(rs.getString("tpl_desc"));
            }
            return tipoLog;

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }

    }

}
