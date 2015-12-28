package emprestimo.modelo.dao;

import emprestimo.controle.JConexao;
import emprestimo.modelo.modelo.JContrato;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Carlos Alexandre
 */
public class JContratoDao {

    public JContratoDao(){

    }

                        //Método Consultar Todos os Funcionários
        public List<JContrato> retornaListaContratosPorCPF(String cpf) throws Exception {

        List <JContrato> listaContratos = new LinkedList<JContrato>();
        try {
            String sql;
            sql = "select * "+
                   "from cliente c, beneficio b, contrato o, tipo_contrato tc "+
                   "where c.cli_cod = b.cli_cod "+
                   "and b.ben_cod=o.ben_cod " +
                   "and o.tpcont_cod=tc.tpcont_cod "+
                   "and c.cli_cpf = ?";
            PreparedStatement ps = JConexao.openConexao().prepareStatement(sql);

            ps.setString(1, cpf);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                JContrato contrato = new JContrato();
                JTipo_ContratoDao tipoContratoDao = new JTipo_ContratoDao();
                JBeneficioDao beneficioDao = new JBeneficioDao();

                //contrato.setCont_cod(rs.getInt("cont_cod"));
                contrato.setCont_dtinicio(rs.getDate("cont_dtinicio"));
                contrato.setCont_dtpreref(rs.getDate("cont_dtpreref"));
                contrato.setBeneficio(beneficioDao.retornaObjetoBeneficio(rs.getInt("ben_cod")));
                contrato.setTipo_contrato(tipoContratoDao.retornaListaTipo_Contrato(rs.getLong("tpcont_cod")));
                listaContratos.add(contrato);

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
        return listaContratos;
    }

}
