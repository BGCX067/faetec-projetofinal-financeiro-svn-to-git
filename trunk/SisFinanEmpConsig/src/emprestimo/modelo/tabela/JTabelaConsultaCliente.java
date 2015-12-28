package emprestimo.modelo.tabela;

import emprestimo.modelo.modelo.JCliente;
import emprestimo.utilitario.JConverter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Calex
 */
public class JTabelaConsultaCliente extends AbstractTableModel {

    private final Integer[] vnTamanho = {10, 30, 200, 80};
    private final String[] vsTitulo = {"","CPF", "Nome", "Data de Nascimento"};
    private Class[] vsClasses = {Object.class,String.class, String.class, String.class};
    private List<JCliente> dadosCliente = null;
    private List<Object[]> rsTabela = new ArrayList<Object[]>();

    public JTabelaConsultaCliente() {
        Object[] linha = {null,"", "", ""};
        rsTabela.add(linha);
    }

    public void setResultados(List<JCliente> listaClientes) {
        dadosCliente = listaClientes;
        rsTabela.clear(); //Remover Dados Anteriores
        if (listaClientes != null) { //se tiver item
            Iterator<JCliente> it = listaClientes.iterator(); //navegação sequencial, sempre pra frente
            while (it.hasNext()) { //estrutura de repetição WHILE (enquanto tive rproximo item da llista
                JCliente cli = it.next(); // procimo item e associa ao estado
                Object[] linha = {
                                cli.getCli_cod(),
                    cli.getCli_cpf(),
                    cli.getCli_nome(),
                    JConverter.converteDateToString(cli.getCli_dtnasc())};
                rsTabela.add(linha);
            }
        }
        if (listaClientes == null || listaClientes.size() == 0) {
            Object[] linha = {null, null};
            rsTabela.add(linha);
        }
        fireTableStructureChanged();
    }

    public void adicionarLinha(JCliente cliente) {
        Object[] linha = {
            cliente.getCli_cod(),
            cliente.getCli_cpf(),
                          cliente.getCli_nome(),
                         JConverter.converteDateToString(cliente.getCli_dtnasc())};
        rsTabela.add(linha);
        fireTableStructureChanged();
    }

    public void removerLinha(int linha) {
        rsTabela.remove(linha);
        dadosCliente.remove(linha);
        fireTableStructureChanged();
    }

    public JCliente getCliente(int linha) {
        JCliente cli = null;
        if (dadosCliente != null & dadosCliente.size() > linha) {
            cli = dadosCliente.get(linha);
        }
        return cli;
    }

    public JTabelaConsultaCliente(List<JCliente> lista) {
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
