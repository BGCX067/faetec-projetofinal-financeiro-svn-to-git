package emprestimo.modelo.dao;

import emprestimo.controle.JConexao;
import emprestimo.modelo.modelo.JLogradouro;
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
public class JLogradouroDao {
    private String erro = "Erro ao ";
    private final String aviso = "Erro!";



    public JLogradouroDao(){
    }




    //Método Inserir Logradouro
    public void inserir(JLogradouro logradouro) throws Exception{
        try {
            String sql = "INSERT INTO Logradouro (log_desc, log_num, log_compl, log_cep, bai_cod, tpl_cod) VALUES (?, ?, ?, ?, ?, ?)";

            PreparedStatement ps = JConexao.openConexao().prepareStatement(sql);

            ps.setString(1, logradouro.getLog_desc());
            ps.setInt(2, logradouro.getLog_num());
            ps.setString(3, logradouro.getLog_compl());
            ps.setString(4, logradouro.getLog_cep());
            ps.setInt(5, logradouro.getBairro().getBai_cod());
            ps.setLong(6, logradouro.getTpl_Log().getTpl_cod());
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            String exception = "incluir Logradouro! ";
            JOptionPane.showMessageDialog(null, erro+exception, aviso, JOptionPane.ERROR_MESSAGE);
            throw new Exception(erro+exception+e.getMessage());
        }
    }




    //Método Alterar Logradouro
    public void alterar(JLogradouro logradouro) throws Exception{
        try {
            String sql = "UPDATE Logradouro SET log_desc = ?, log_num = ?, log_compl = ?, log_cep = ?, bai_cod = ?, tpl_cod = ? WHERE log_cod = ?";

            PreparedStatement ps = JConexao.openConexao().prepareStatement(sql);

            ps.setInt(7, logradouro.getLog_cod());
            ps.setString(1, logradouro.getLog_desc());
            ps.setLong(2, logradouro.getLog_num());
            ps.setString(3, logradouro.getLog_compl());
            ps.setString(4, logradouro.getLog_cep());
            ps.setLong(5, logradouro.getBairro().getBai_cod());
            ps.setLong(6, logradouro.getTpl_Log().getTpl_cod());
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            String exception = "alterar Logradouro! ";
            JOptionPane.showMessageDialog(null, erro+exception, aviso, JOptionPane.ERROR_MESSAGE);
            throw  new Exception(erro+exception+e.getMessage());
        }
    }




        //Método Excluir Logradouro
    public void excluir(int log_cod) throws Exception{
        try {
            String sql = "DELETE FROM Logradouro WHERE log_cod = "+log_cod;

            PreparedStatement ps = JConexao.openConexao().prepareStatement(sql);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            String exception = "excluir Logradouro! ";
            JOptionPane.showMessageDialog(null, erro+exception, aviso, JOptionPane.ERROR_MESSAGE);
            throw  new Exception(erro+exception+e.getMessage());
        }
    }

                //Método Consultar Todos os Logradouro
        public List<JLogradouro> retornaListaLogradouros() throws Exception {

        List <JLogradouro> listaLogradouros = new LinkedList<JLogradouro>();
        try {
            String sql;
            sql = "SELECT * FROM Logradouro";
            PreparedStatement ps = JConexao.openConexao().prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                JLogradouro log = new JLogradouro();
                JBairroDao bairroDao = new JBairroDao();
                JTipoLogradouroDao tipoLogDao = new JTipoLogradouroDao();

                log.setLog_cod(rs.getInt("log_cod"));
                log.setLog_desc(rs.getString("log_desc"));
                log.setLog_num(rs.getInt("log_num"));
                log.setLog_compl(rs.getString("log_compl"));
                log.setLog_cep(rs.getString("log_cep"));
                log.setBairro(bairroDao.retornaListaBairro(rs.getInt("bai_cod")));
                log.setTpl_Log(tipoLogDao.retornaListaTipoLOgradouro(rs.getInt("tpl_cod")));
                listaLogradouros.add(log);
                
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
        return listaLogradouros;
    }

        public List<JLogradouro> retornaListaLogradouro(String nome) throws Exception{

        List<JLogradouro> listaLogradouro = new LinkedList<JLogradouro>();

        try {
            String sql = "SELECT * FROM Logradouro WHERE log_desc LIKE '"+nome+"%' ";

            PreparedStatement ps = JConexao.openConexao().prepareStatement(sql);

             ResultSet rs = ps.executeQuery();

              while (rs.next()) {

                JLogradouro log = new JLogradouro();
                JBairroDao bairroDao = new JBairroDao();
                JTipoLogradouroDao tipoLogDao = new JTipoLogradouroDao();

                log.setLog_cod(rs.getInt("log_cod"));
                log.setLog_desc(rs.getString("log_desc"));
                log.setLog_num(rs.getInt("log_num"));
                log.setLog_compl(rs.getString("log_compl"));
                log.setLog_cep(rs.getString("log_cep"));
                log.setBairro(bairroDao.retornaListaBairro(rs.getInt("bai_cod")));
                log.setTpl_Log(tipoLogDao.retornaListaTipoLOgradouro(rs.getInt("tpl_cod")));
                listaLogradouro.add(log);
            }
        } catch (Exception e) {
            e.printStackTrace();
            String exception = "buscar o Logradouro! ";
            JOptionPane.showMessageDialog(null, erro+exception, aviso, JOptionPane.ERROR_MESSAGE);
            throw  new Exception(erro+exception+e.getMessage());
        }

        return listaLogradouro;
    }

    public JLogradouro retornaObjetoLogradouro(int log_cod) throws Exception {

        try {
            String sql;
            sql = "SELECT * FROM Logradouro WHERE log_cod = ?";

            PreparedStatement ps = JConexao.openConexao().prepareStatement(sql);

            ps.setInt(1, log_cod);

            ResultSet rs = ps.executeQuery();


            JLogradouro logradouro = null;
            if (rs.next()) {
                logradouro = new JLogradouro();
                JBairroDao bairroDao = new JBairroDao();
                JTipoLogradouroDao tipoLogDao = new JTipoLogradouroDao();

                logradouro.setLog_cod(rs.getInt("log_cod"));
                logradouro.setLog_desc(rs.getString("log_desc"));
                logradouro.setLog_num(rs.getInt("log_num"));
                logradouro.setLog_compl(rs.getString("log_compl"));
                logradouro.setLog_cep(rs.getString("log_cep"));
                logradouro.setBairro(bairroDao.retornaListaBairro(rs.getInt("bai_cod")));
                logradouro.setTpl_Log(tipoLogDao.retornaListaTipoLOgradouro(rs.getInt("tpl_cod")));
            }
            return logradouro;

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }

    }


}
