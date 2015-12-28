package emprestimo.modelo.dao;

import emprestimo.controle.JConexao;
import emprestimo.modelo.modelo.JTipo_Contrato;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author Calex
 */
public class JTipo_ContratoDao {

    public JTipo_ContratoDao(){

    }

    public JTipo_Contrato retornaListaTipo_Contrato(Long tpcont_cod) throws Exception {

        try {
            String sql;
            sql = "SELECT * FROM Tipo_Contrato WHERE tpcont_cod = ?";

            PreparedStatement ps = JConexao.openConexao().prepareStatement(sql);

            ps.setLong(1, tpcont_cod);

            ResultSet rs = ps.executeQuery();


            JTipo_Contrato tipoCont = null;
            if (rs.next()) {
                tipoCont = new JTipo_Contrato();

                tipoCont.setTpcont_cod(rs.getLong("tpcont_cod"));
                tipoCont.setTpcont_desc(rs.getString("tpcont_desc"));

            }
            return tipoCont;

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }

    }

}
