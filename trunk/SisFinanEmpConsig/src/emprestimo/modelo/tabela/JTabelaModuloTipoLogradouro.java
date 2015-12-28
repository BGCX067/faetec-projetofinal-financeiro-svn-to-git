package emprestimo.modelo.tabela;

import emprestimo.modelo.modelo.JEstado;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Calex
 */
public class JTabelaModuloTipoLogradouro extends AbstractTableModel {

    private final Integer[] vnTamanho = {10, 100};
    private final String[] vsTitulo = {"CPF", "Estado"};
    private List<JEstado> dadosEstado = null;
    private List<Object[]> rsTabela = new ArrayList<Object[]>();

    public JTabelaModuloTipoLogradouro() {
        Object[] linha = {null, ""};
        rsTabela.add(linha);
    }

    public void setResultados(List<JEstado> listaEstados) {
        dadosEstado = listaEstados;
        rsTabela.clear(); //Remover Dados Anteriores
        if (listaEstados != null) { //se tiver item
            Iterator<JEstado> it = listaEstados.iterator(); //navegação sequencial, sempre pra frente
            while (it.hasNext()) { //estrutura de repetição WHILE (enquanto tive rproximo item da llista
                JEstado est = it.next(); // procimo item e associa ao estado
                adicionarLinha(est);
            }
        }
        if (listaEstados == null || listaEstados.size() == 0) {
            Object[] linha = {null, null};
            rsTabela.add(linha);
        }
        fireTableStructureChanged();
    }

    public void adicionarLinha(JEstado estado) {
        Object[] linha = {estado.getEst_uf(), estado.getEst_nome()};
        rsTabela.add(linha);
    }

    public void removerLinha(int linha) {
        rsTabela.remove(linha);
        dadosEstado.remove(linha);
        fireTableStructureChanged();
    }

    public JEstado getEstado(int linha) {
        JEstado est = null;
        if (dadosEstado != null & dadosEstado.size() > linha) {
            est = dadosEstado.get(linha);
        }
        return est;
    }

    public JTabelaModuloTipoLogradouro(List<JEstado> lista) {
        setResultados(lista);
    }

    @Override
    public int getRowCount() {
        //número de linhas
        return rsTabela.size();
    }

    @Override
    public int getColumnCount() {
        //número de colunas
        return vsTitulo.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return rsTabela.get(rowIndex)[columnIndex];
    }

    @Override
    public String getColumnName(int columnIndex) {
        return vsTitulo[columnIndex];
    }

    public int getColumnSize(int columnSize) {
        return vnTamanho[columnSize];
    }
}
