package emprestimo.modelo.tabela;

import emprestimo.modelo.modelo.JBairro;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Calex
 */
public class JTabelaModuloBairro extends AbstractTableModel {

    private final Integer[] vnTamanho = {80, 100};
    private final String[] vsTitulo = {"Bairro","Cidade"};
    private List<JBairro> dadosBairro = null;
    private Class[] vsClasses = {String.class, Object.class};
    private List<Object[]> rsTabela = new ArrayList<Object[]>();

    public JTabelaModuloBairro() {
        Object[] linha = {"", ""};
        rsTabela.add(linha);
    }

    public void setResultados(List<JBairro> listaBairros) {
        dadosBairro = listaBairros;
        rsTabela.clear(); //Remover Dados Anteriores
        if (listaBairros != null) { //se tiver item
            Iterator<JBairro> it = listaBairros.iterator(); //navegação sequencial, sempre pra frente
            while (it.hasNext()) { //estrutura de repetição WHILE (enquanto tive rproximo item da llista
                JBairro bai = it.next(); // procimo item e associa ao estado
                Object[] linha = {bai.getBai_nome(), bai.getCidade().getCid_nome()};
                rsTabela.add(linha);
            }
        }
        if (listaBairros == null || listaBairros.size() == 0) {
            Object[] linha = {null, null};
            rsTabela.add(linha);
        }
        fireTableStructureChanged();
    }

    public void adicionarLinha(JBairro bairro) {
        Object[] linha = {bairro.getBai_nome(), bairro.getCidade().getCid_nome()};
        rsTabela.add(linha);
        fireTableStructureChanged();
    }

    public void removerLinha(int linha) {
        rsTabela.remove(linha);
        dadosBairro.remove(linha);
        fireTableStructureChanged();
    }

    public JBairro getBairro(int linha) {
        JBairro bai = null;
        if (dadosBairro != null & dadosBairro.size() > linha) {
            bai = dadosBairro.get(linha);
        }
        return bai;
    }

    public JTabelaModuloBairro(List<JBairro> lista) {
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
