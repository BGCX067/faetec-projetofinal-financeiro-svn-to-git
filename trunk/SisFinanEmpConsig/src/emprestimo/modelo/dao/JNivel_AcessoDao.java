package emprestimo.modelo.dao;

import emprestimo.controle.JConexao;
import emprestimo.modelo.modelo.JNivel_Acesso;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Carlos Alexandre
 */
public class JNivel_AcessoDao {

    public List<JNivel_Acesso> retornaListaNiveis() throws Exception {

        List <JNivel_Acesso> listaNiveis = new LinkedList<JNivel_Acesso>();
        try {
            String sql;
            sql = "SELECT * FROM Nivel_Acesso";
            PreparedStatement ps = JConexao.openConexao().prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                JNivel_Acesso nivel = new JNivel_Acesso();

                nivel.setNiv_cod(rs.getLong("niv_cod"));
                nivel.setNiv_desc(rs.getString("niv_desc"));
                listaNiveis.add(nivel);
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
        return listaNiveis;
    }

}
