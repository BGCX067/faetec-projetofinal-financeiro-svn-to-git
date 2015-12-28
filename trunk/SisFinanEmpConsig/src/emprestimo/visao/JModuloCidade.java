/*
 * JModuloEstado.java
 *
 * Created on 26/11/2011, 20:58:43
 */
package emprestimo.visao;

import emprestimo.modelo.dao.JCidadeDao;
import emprestimo.modelo.dao.JEstadoDao;
import emprestimo.modelo.modelo.JCidade;
import emprestimo.modelo.modelo.JEstado;
import emprestimo.modelo.tabela.JTabelaModuloCidade;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 * @author Manutenção
 */
public class JModuloCidade extends javax.swing.JDialog {

    private JCidade cidade;
    private JCidadeDao cidadeDao;
    private JEstadoDao estadoDao;
    private JTabelaModuloCidade tabelaModuloCidade = new JTabelaModuloCidade();
    DefaultComboBoxModel comboBoxUf;
    boolean novo = true;
    private List<JEstado> lista = new ArrayList<JEstado>();

    /** Creates new form JModuloEstado */
    public JModuloCidade(java.awt.Frame parent, boolean modal) throws Exception {
        super(parent, modal);
        initComponents();
        tblCidades.setModel(tabelaModuloCidade);
        cidadeDao = new JCidadeDao();
        estadoDao = new JEstadoDao();
        atualizaTabela();
        setTamanhoColunas();
        txtNomeCidade.setEditable(false);
        txtNomeCidade.setEditable(false);
        
         /*try {
            comboBoxUf = new DefaultComboBoxModel(estadoDao.retornaListaUf().toArray());
        } catch (Exception e) {
            e.printStackTrace();
            comboBoxUf = new DefaultComboBoxModel();
        }
        cbxUfs.setModel(comboBoxUf);*/
    }

    private void setTamanhoColunas() {
        for (int x = 0; x < tabelaModuloCidade.getColumnCount(); x++) {
            tblCidades.getColumnModel().getColumn(x).setMinWidth(tabelaModuloCidade.getColumnSize(x));
        }
        tblCidades.getTableHeader().setReorderingAllowed(false);
    }

    public void limpar() {
        txtNomeCidade.setText("");
        cbxUfs.setSelectedIndex(0);
    }

    public void atualizaTabela() throws Exception {
        tabelaModuloCidade.setResultados(cidadeDao.retornaListaCidades());
        setTamanhoColunas();
    }

    private void exibir() {
        if (cidade != null) {
            txtNomeCidade.setText("" + cidade.getCid_nome());
            cbxUfs.setSelectedItem(cidade.getEstado().getEst_uf());
        }
    }

    private void mudaEstado(){
        if(novo == true){
           txtNomeCidade.setEditable(true);
           cbxUfs.setEditable(true);
           txtNomeCidade.requestFocus();
    } else{
            txtNomeCidade.setEditable(false);
           cbxUfs.setEditable(false);
    }
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panTituloEstado = new javax.swing.JPanel();
        barraEstado = new javax.swing.JToolBar();
        btnAdicionarCidade = new javax.swing.JButton();
        btnAlterarCidade = new javax.swing.JButton();
        btnExcluirCidade = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCidades = new javax.swing.JTable();
        panCadastraCidade = new javax.swing.JPanel();
        lblCidade = new javax.swing.JLabel();
        txtNomeCidade = new javax.swing.JTextField();
        lblUfEstado = new javax.swing.JLabel();
        btnGravar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        cbxUfs = new javax.swing.JComboBox();
        panBuscaCidade = new javax.swing.JPanel();
        lblBuscaEstado = new javax.swing.JLabel();
        txtBuscaCidade = new javax.swing.JTextField();
        btnBuscaCidade = new javax.swing.JButton();
        jrbNomeCidade = new javax.swing.JRadioButton();
        jrbNomeEstado = new javax.swing.JRadioButton();
        lblEspecífica = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        panTituloEstado.setBackground(new java.awt.Color(255, 153, 0));
        panTituloEstado.setPreferredSize(new java.awt.Dimension(650, 80));

        javax.swing.GroupLayout panTituloEstadoLayout = new javax.swing.GroupLayout(panTituloEstado);
        panTituloEstado.setLayout(panTituloEstadoLayout);
        panTituloEstadoLayout.setHorizontalGroup(
            panTituloEstadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 658, Short.MAX_VALUE)
        );
        panTituloEstadoLayout.setVerticalGroup(
            panTituloEstadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 80, Short.MAX_VALUE)
        );

        barraEstado.setRollover(true);

        btnAdicionarCidade.setIcon(new javax.swing.ImageIcon(getClass().getResource("/emprestimo/imagens/icones/add.png"))); // NOI18N
        btnAdicionarCidade.setFocusable(false);
        btnAdicionarCidade.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAdicionarCidade.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAdicionarCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarCidadeActionPerformed(evt);
            }
        });
        barraEstado.add(btnAdicionarCidade);

        btnAlterarCidade.setIcon(new javax.swing.ImageIcon(getClass().getResource("/emprestimo/imagens/icones/cog.png"))); // NOI18N
        btnAlterarCidade.setFocusable(false);
        btnAlterarCidade.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAlterarCidade.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAlterarCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarCidadeActionPerformed(evt);
            }
        });
        barraEstado.add(btnAlterarCidade);

        btnExcluirCidade.setIcon(new javax.swing.ImageIcon(getClass().getResource("/emprestimo/imagens/icones/cross-script.png"))); // NOI18N
        btnExcluirCidade.setFocusable(false);
        btnExcluirCidade.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnExcluirCidade.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnExcluirCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirCidadeActionPerformed(evt);
            }
        });
        barraEstado.add(btnExcluirCidade);

        tblCidades.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "UF", "Estado"
            }
        ));
        jScrollPane1.setViewportView(tblCidades);

        panCadastraCidade.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cidade", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(51, 51, 255))); // NOI18N

        lblCidade.setText("Cidade");

        txtNomeCidade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNomeCidadeKeyTyped(evt);
            }
        });

        lblUfEstado.setText("UF:");

        btnGravar.setText("Gravar");
        btnGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGravarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panCadastraCidadeLayout = new javax.swing.GroupLayout(panCadastraCidade);
        panCadastraCidade.setLayout(panCadastraCidadeLayout);
        panCadastraCidadeLayout.setHorizontalGroup(
            panCadastraCidadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panCadastraCidadeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panCadastraCidadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panCadastraCidadeLayout.createSequentialGroup()
                        .addGroup(panCadastraCidadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNomeCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCidade))
                        .addGap(18, 18, 18)
                        .addGroup(panCadastraCidadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbxUfs, 0, 77, Short.MAX_VALUE)
                            .addComponent(lblUfEstado)))
                    .addGroup(panCadastraCidadeLayout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(btnGravar)
                        .addGap(47, 47, 47)
                        .addComponent(btnCancelar)))
                .addContainerGap())
        );

        panCadastraCidadeLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnCancelar, btnGravar});

        panCadastraCidadeLayout.setVerticalGroup(
            panCadastraCidadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panCadastraCidadeLayout.createSequentialGroup()
                .addGroup(panCadastraCidadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCidade)
                    .addComponent(lblUfEstado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panCadastraCidadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNomeCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxUfs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(panCadastraCidadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnGravar)))
        );

        panBuscaCidade.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Buscar", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(51, 51, 255))); // NOI18N

        lblBuscaEstado.setText("Buscar:");

        btnBuscaCidade.setText("Buscar");
        btnBuscaCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscaCidadeActionPerformed(evt);
            }
        });

        jrbNomeCidade.setText("Nome da Cidade");

        jrbNomeEstado.setText("Nome do Estado");

        lblEspecífica.setText("Específicar por:");

        javax.swing.GroupLayout panBuscaCidadeLayout = new javax.swing.GroupLayout(panBuscaCidade);
        panBuscaCidade.setLayout(panBuscaCidadeLayout);
        panBuscaCidadeLayout.setHorizontalGroup(
            panBuscaCidadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panBuscaCidadeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panBuscaCidadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panBuscaCidadeLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jrbNomeCidade)
                        .addGap(18, 18, 18)
                        .addComponent(jrbNomeEstado))
                    .addComponent(lblEspecífica)
                    .addGroup(panBuscaCidadeLayout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(btnBuscaCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panBuscaCidadeLayout.createSequentialGroup()
                        .addComponent(lblBuscaEstado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBuscaCidade, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panBuscaCidadeLayout.setVerticalGroup(
            panBuscaCidadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panBuscaCidadeLayout.createSequentialGroup()
                .addComponent(lblEspecífica)
                .addGap(18, 18, 18)
                .addGroup(panBuscaCidadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jrbNomeCidade)
                    .addComponent(jrbNomeEstado))
                .addGap(18, 18, 18)
                .addGroup(panBuscaCidadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBuscaEstado)
                    .addComponent(txtBuscaCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(btnBuscaCidade)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panTituloEstado, javax.swing.GroupLayout.DEFAULT_SIZE, 658, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(barraEstado, javax.swing.GroupLayout.DEFAULT_SIZE, 648, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panBuscaCidade, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panCadastraCidade, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panTituloEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(barraEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(panBuscaCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                        .addComponent(panCadastraCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE))
                .addGap(53, 53, 53))
        );

        pack();
        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        java.awt.Dimension dialogSize = getSize();
        setLocation((screenSize.width-dialogSize.width)/2,(screenSize.height-dialogSize.height)/2);
    }// </editor-fold>//GEN-END:initComponents

    private void btnGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGravarActionPerformed
        // TODO add your handling code here:
        String nomeCidade = txtNomeCidade.getText();
        //JEstado uf = cbxUfs.getSelectedItem().toString();

        if (!nomeCidade.equals("")) {
            if (cidade==null) {
                cidade = new JCidade();
               cidade.setCid_nome(nomeCidade);
                cidade.setEstado(lista.get(getCbxUfs().getSelectedIndex()));

                if (JOptionPane.showConfirmDialog(null, "Gravar Dados do Cidade?", "Confirma?",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {

                    try {
                        cidadeDao.inserir(cidade);
                        JOptionPane.showMessageDialog(null, "Cidade Cadastrado com Sucesso!", "Cadastrado!", JOptionPane.INFORMATION_MESSAGE);
                        atualizaTabela();
                        limpar();
                        novo=false;
                        cidade=null;
                        mudaEstado();
                    } catch (Exception ex) {
                        Logger.getLogger(JModuloCidade.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } else {
                cidade.setCid_nome(nomeCidade);
                cidade.setEstado(lista.get(getCbxUfs().getSelectedIndex()));

                if (JOptionPane.showConfirmDialog(null, "Gravar Alteração do Cidade?", "Confirma?",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {

                    try {
                        cidadeDao.alterar(cidade);
                        JOptionPane.showMessageDialog(null, "Cidade Alterado com Sucesso!", "Cadastrado!", JOptionPane.INFORMATION_MESSAGE);
                        atualizaTabela();
                        limpar();
                        novo=false;
                        cidade=null;
                        mudaEstado();
                    } catch (Exception ex) {
                        Logger.getLogger(JModuloCidade.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Favor inserir um Nome a Cidade!", "Mensagem!", JOptionPane.INFORMATION_MESSAGE);
            txtNomeCidade.requestFocus();
        }
    }//GEN-LAST:event_btnGravarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        setVisible(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnBuscaCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscaCidadeActionPerformed
        // TODO add your handling code here:
        if (jrbNomeCidade.isSelected()) {

            List<JCidade> resultadoBusca = new ArrayList<JCidade>();
            String buscaCidade = txtBuscaCidade.getText();
            try {
                resultadoBusca = cidadeDao.retornaListaCidadePorNome(buscaCidade);
            } catch (Exception ex) {
                Logger.getLogger(JModuloCidade.class.getName()).log(Level.SEVERE, null, ex);
            }
            tabelaModuloCidade.setResultados(resultadoBusca);
            txtBuscaCidade.setText("");

        } else {

            List<JCidade> resultadoBusca = new ArrayList<JCidade>();
            String buscaCidadePorEstado = txtBuscaCidade.getText();
            try {
                resultadoBusca = cidadeDao.retornaListaCidadePorEstado(buscaCidadePorEstado);
            } catch (Exception ex) {
                Logger.getLogger(JModuloCidade.class.getName()).log(Level.SEVERE, null, ex);
            }
            tabelaModuloCidade.setResultados(resultadoBusca);
            txtBuscaCidade.setText("");
        }
    }//GEN-LAST:event_btnBuscaCidadeActionPerformed

    private void btnAlterarCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarCidadeActionPerformed
        // TODO add your handling code here:
        if (tblCidades.getSelectedRow() >= 0) {
            this.cidade = tabelaModuloCidade.getCidade(tblCidades.getSelectedRow());
            exibir();
            novo=true;
            mudaEstado();
        } else {
            JOptionPane.showMessageDialog(null, "Favor Selecionar uma Linha!", "Mensagem!", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnAlterarCidadeActionPerformed

    private void btnExcluirCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirCidadeActionPerformed
        // TODO add your handling code here:
        if (tblCidades.getSelectedRow() >= 0) {
            int opcao = JOptionPane.showConfirmDialog(null, "Deseja excluir o Cidade?", "Confirma?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (opcao == JOptionPane.YES_OPTION) {
                try {
                    cidadeDao.retornaListaCidades();
                    cidadeDao.excluir(cidadeDao.retornaListaCidades().get(tblCidades.getSelectedRow()).getCid_cod());
                    JOptionPane.showMessageDialog(null, "Cidade excluído com Sucesso!", "Cadastrado!", JOptionPane.INFORMATION_MESSAGE);
                    atualizaTabela();
                } catch (Exception ex) {
                    Logger.getLogger(JModuloCidade.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Favor Selecionar uma Linha!", "Mensagem!", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnExcluirCidadeActionPerformed

    private void btnAdicionarCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarCidadeActionPerformed
        // TODO add your handling code here:
        novo = true;
        txtNomeCidade.setText("");
        mudaEstado();
    }//GEN-LAST:event_btnAdicionarCidadeActionPerformed

    private void txtNomeCidadeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomeCidadeKeyTyped
        // TODO add your handling code here:
        String numeros = "0123456789";
    if (numeros.indexOf(evt.getKeyChar()) >= 0) {
        evt.consume();
        return;
    }
    }//GEN-LAST:event_txtNomeCidadeKeyTyped

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
            try {
                lista = estadoDao.retornaListaEstados();
            } catch (Throwable ex) {
                Logger.getLogger(JModuloCidade.class.getName()).log(Level.SEVERE, null, ex);
            }
            for (JEstado estado : lista) {
                getCbxUfs().addItem(estado.getEst_uf().toString());
            }
    }//GEN-LAST:event_formWindowOpened

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                JModuloCidade dialog = null;
                try {
                    dialog = new JModuloCidade(new javax.swing.JFrame(), true);
                } catch (Exception ex) {
                    Logger.getLogger(JModuloCidade.class.getName()).log(Level.SEVERE, null, ex);
                }
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {

                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToolBar barraEstado;
    private javax.swing.JButton btnAdicionarCidade;
    private javax.swing.JButton btnAlterarCidade;
    private javax.swing.JButton btnBuscaCidade;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnExcluirCidade;
    private javax.swing.JButton btnGravar;
    private javax.swing.JComboBox cbxUfs;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton jrbNomeCidade;
    private javax.swing.JRadioButton jrbNomeEstado;
    private javax.swing.JLabel lblBuscaEstado;
    private javax.swing.JLabel lblCidade;
    private javax.swing.JLabel lblEspecífica;
    private javax.swing.JLabel lblUfEstado;
    private javax.swing.JPanel panBuscaCidade;
    private javax.swing.JPanel panCadastraCidade;
    private javax.swing.JPanel panTituloEstado;
    private javax.swing.JTable tblCidades;
    private javax.swing.JTextField txtBuscaCidade;
    private javax.swing.JTextField txtNomeCidade;
    // End of variables declaration//GEN-END:variables
public javax.swing.JComboBox getCbxUfs(){
    return cbxUfs;
}


}
