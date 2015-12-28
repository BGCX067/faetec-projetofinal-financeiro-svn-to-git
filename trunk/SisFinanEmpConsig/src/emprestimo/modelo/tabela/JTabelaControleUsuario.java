package emprestimo.modelo.tabela;

import emprestimo.modelo.modelo.JCliente;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Calex
 */
public class JTabelaControleUsuario extends AbstractTableModel {

    private final Integer[] vnTamanho = {60, 200, 100, 150, 120};
    private final String[] vsTitulo = {"CPF", "Nome", "Data de Nascimento", "Nº do Benefício", "Telefone"};
    private List<JCliente> dadosCliente = null;
    private List<Object[]> rsTabela = new ArrayList<Object[]>();

    public JTabelaControleUsuario() {
        Object[] linha = {null, "", "", "", ""};
        rsTabela.add(linha);
    }

    public void setResultados(List<JCliente> listaClientes) {
        dadosCliente = listaClientes;
        rsTabela.clear(); //Remover Dados Anteriores
        if (listaClientes != null) { //se tiver item
            Iterator<JCliente> it = listaClientes.iterator(); //navegação sequencial, sempre pra frente
            while (it.hasNext()) { //estrutura de repetição WHILE (enquanto tive rproximo item da llista
                JCliente cli = it.next(); // procimo item e associa ao estado
                adicionarLinha(cli);
            }
        }
        if (listaClientes == null || listaClientes.size() == 0) {
            Object[] linha = {null, null};
            rsTabela.add(linha);
        }
        fireTableStructureChanged();
    }

    public void adicionarLinha(JCliente cliente) {
        Object[] linha = {cliente.getCli_cpf(), cliente.getCli_nome(), cliente.getCli_dtnasc(), cliente.getLogradouro().getLog_desc()};
        rsTabela.add(linha);
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

    public JTabelaControleUsuario(List<JCliente> lista) {
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
