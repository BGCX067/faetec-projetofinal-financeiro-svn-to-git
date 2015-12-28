package emprestimo.modelo.tabela;

import emprestimo.modelo.modelo.JCidade;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Calex
 */
public class JTabelaModuloCidade extends AbstractTableModel {

    private final Integer[] vnTamanho = {80, 10};
    private final String[] vsTitulo = {"Cidade", "UF"};
    private List<JCidade> dadosCidade = null;
    private Class[] vsClasses = {String.class, Object.class};
    private List<Object[]> rsTabela = new ArrayList<Object[]>();

    public JTabelaModuloCidade() {
        Object[] linha = {"", ""};
        rsTabela.add(linha);
    }

    public void setResultados(List<JCidade> listaCidades) {
        dadosCidade = listaCidades;
        rsTabela.clear(); //Remover Dados Anteriores
        if (listaCidades != null) { //se tiver item
            Iterator<JCidade> it = listaCidades.iterator(); //navegação sequencial, sempre pra frente
            while (it.hasNext()) { //estrutura de repetição WHILE (enquanto tive rproximo item da llista
                JCidade cid = it.next(); // procimo item e associa ao estado
                Object[] linha = {""+cid.getCid_nome(),cid.getEstado().getEst_uf()};
                rsTabela.add(linha);
            }
        }
        if (listaCidades == null || listaCidades.size() == 0) {
            Object[] linha = {null, null};
            rsTabela.add(linha);
        }
        fireTableStructureChanged();
    }

    public void adicionarLinha(JCidade cidade) {
        Object[] linha = {cidade.getCid_nome(), cidade.getEstado().getEst_uf()};
        rsTabela.add(linha);
        fireTableStructureChanged();
    }

    public void removerLinha(int linha) {
        rsTabela.remove(linha);
        dadosCidade.remove(linha);
        fireTableStructureChanged();
    }

    public JCidade getCidade(int linha) {
        JCidade cid = null;
        if (dadosCidade != null & dadosCidade.size() > linha) {
            cid = dadosCidade.get(linha);
        }
        return cid;
    }

    public JTabelaModuloCidade(List<JCidade> lista) {
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
    public Class getColumnClass(int columnIndex) {
        return vsClasses[columnIndex];
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
