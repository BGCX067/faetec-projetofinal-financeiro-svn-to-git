package emprestimo.modelo.dao;

import emprestimo.controle.JConexao;
import emprestimo.modelo.modelo.JEstado;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * @author Carlos Alexandre
 */
public class JEstadoDao {

    private String erro = "Erro ao ";
    private final String aviso = "Erro!";


    
    public JEstadoDao(){
    }



    
    //Método Inserir Estado
    public void inserir(JEstado estado) throws Exception{
        try {
            String sql = "INSERT INTO Estado (est_uf, est_nome) VALUES (?, ?)";
            
            PreparedStatement ps = JConexao.openConexao().prepareStatement(sql);
            
            ps.setString(1, estado.getEst_uf());
            ps.setString(2, estado.getEst_nome());
            ps.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
            String exception = "incluir Estado! ";
            JOptionPane.showMessageDialog(null, erro+exception, aviso, JOptionPane.ERROR_MESSAGE);
            throw new Exception(erro+exception+e.getMessage());
        }
    }



    
    //Método Alterar Estado
    public void alterar(JEstado estado) throws Exception{
        try {
            String sql = "UPDATE Estado SET est_nome = ?, est_uf = ? WHERE est_cod = ?";

            PreparedStatement ps = JConexao.openConexao().prepareStatement(sql);

            ps.setLong(3, estado.getEst_cod());
            ps.setString(1, estado.getEst_nome());
            ps.setString(2, estado.getEst_uf());
            ps.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
            String exception = "alterar Estado! ";
            JOptionPane.showMessageDialog(null, erro+exception, aviso, JOptionPane.ERROR_MESSAGE);
            throw  new Exception(erro+exception+e.getMessage());
        }
    }


    
    
        //Método Excluir Estado
    public void excluir(Long est_cod) throws Exception{
        try {
            String sql = "DELETE FROM Estado WHERE est_cod = "+est_cod;
            
            PreparedStatement ps = JConexao.openConexao().prepareStatement(sql);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            String exception = "excluir Estado! ";
            JOptionPane.showMessageDialog(null, erro+exception, aviso, JOptionPane.ERROR_MESSAGE);
            throw  new Exception(erro+exception+e.getMessage());
        }
    }

    
    
    //Método Consultar Um Estado
    public List<JEstado> retornaEstado(String nome) throws Exception{

        List<JEstado> listaEstado = new ArrayList<JEstado>();

        try {
            String sql = "SELECT * FROM Estado WHERE est_nome LIKE '"+nome+"%' ";

            PreparedStatement ps = JConexao.openConexao().prepareStatement(sql);

             ResultSet rs = ps.executeQuery();

              while (rs.next()) {

                JEstado estado = new JEstado();
                estado.setEst_uf(rs.getString("est_uf"));
                estado.setEst_nome(rs.getString("est_nome"));
                listaEstado.add(estado);
            }
        } catch (Exception e) {
            e.printStackTrace();
            String exception = "buscar o Estado! ";
            JOptionPane.showMessageDialog(null, erro+exception, aviso, JOptionPane.ERROR_MESSAGE);
            throw  new Exception(erro+exception+e.getMessage());
        }
        
        return listaEstado;
    }


    
        //Método Consultar Todos os Estados
        public List<JEstado> retornaListaEstados() throws Exception {

        List <JEstado> listaEstados = new ArrayList<JEstado>();
        try {
            String sql;
            sql = "SELECT * FROM Estado";
            PreparedStatement ps = JConexao.openConexao().prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                JEstado estado = new JEstado();

                estado.setEst_cod(rs.getLong("est_cod"));
                estado.setEst_uf(rs.getString("est_uf"));
                estado.setEst_nome(rs.getString("est_nome"));
                listaEstados.add(estado);
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
        return listaEstados;
    }
        
      public List <JEstado> retornaListaUf(Long est_cod) throws Exception {

        List<JEstado> listaEstados = new ArrayList<JEstado>();
        try {
            String sql;
            sql = "SELECT est_uf FROM Estado WHERE est_cod = ?";
            PreparedStatement ps = JConexao.openConexao().prepareStatement(sql);

            ps.setLong(1, est_cod);

            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                JEstado estado = new JEstado();

                estado.setEst_uf(rs.getString("est_uf"));
                listaEstados.add(estado);
            }
            return listaEstados;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        
    }
        //// metodo desativado
       /* public JEstado retornaListaEstadosUF(Long est_cod) throws Exception {

        try {
            String sql;
            sql = "SELECT * FROM Estado WHERE est_cod = ?";
            
            PreparedStatement ps = JConexao.openConexao().prepareStatement(sql);

            ps.setLong(1, est_cod);

            ResultSet rs = ps.executeQuery();
            

            JEstado estado = null;
            if (rs.next()) {
                estado = new JEstado();

                estado.setEst_cod(rs.getLong("est_cod"));
                estado.setEst_uf(rs.getString("est_uf"));
                estado.setEst_nome(rs.getString("est_nome"));
            }
            return estado;

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }

    }*/
        

            public JEstado retornaListaEstado(Long est_cod) throws Exception {

        try {
            String sql;
            sql = "SELECT * FROM Estado WHERE est_cod = ?";

            PreparedStatement ps = JConexao.openConexao().prepareStatement(sql);

            ps.setLong(1, est_cod);

            ResultSet rs = ps.executeQuery();


            JEstado estado = null;
            if (rs.next()) {
                estado = new JEstado();

                estado.setEst_cod(rs.getLong("est_cod"));
                estado.setEst_uf(rs.getString("est_uf"));
                estado.setEst_nome(rs.getString("est_nome"));

            }
            return estado;

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }

    }
    
}
