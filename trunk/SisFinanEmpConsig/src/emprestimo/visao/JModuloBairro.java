/*
 * JModuloEstado.java
 *
 * Created on 26/11/2011, 20:58:43
 */
package emprestimo.visao;

import emprestimo.modelo.dao.JBairroDao;
import emprestimo.modelo.dao.JCidadeDao;
import emprestimo.modelo.dao.JEstadoDao;
import emprestimo.modelo.modelo.JBairro;
import emprestimo.modelo.modelo.JCidade;
import emprestimo.modelo.modelo.JEstado;
import emprestimo.modelo.tabela.JTabelaModuloBairro;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 * @author Manutenção
 */
public class JModuloBairro extends javax.swing.JDialog {

    private JBairro bairro;
    private JBairroDao bairroDao;
    private JCidadeDao cidadeDao;
    private JEstadoDao estadoDao;
    private JTabelaModuloBairro tabelaModuloBairro = new JTabelaModuloBairro();
    boolean novo = true;
    private List<JEstado> listaEstados = new ArrayList<JEstado>();
    private List<JCidade> listaCidades = new ArrayList<JCidade>();
    private DefaultComboBoxModel comboBoxEstado;
    private DefaultComboBoxModel comboBoxCidade;

    /** Creates new form JModuloEstado */
    public JModuloBairro(java.awt.Frame parent, boolean modal) throws Exception{
        super(parent, modal);
        initComponents();
        tblBairros.setModel(tabelaModuloBairro);
        bairroDao = new JBairroDao();
        cidadeDao = new JCidadeDao();
        estadoDao = new JEstadoDao();
        atualizaTabela();
        setTamanhoColunas();
        txtNomeBairro.setEditable(false);
        cbxEstados.setEditable(false);
        cbxCidades.setEditable(false);
        preencherUf();
    }

    private void setTamanhoColunas() {
        for (int x = 0; x < tabelaModuloBairro.getColumnCount(); x++) {
            tblBairros.getColumnModel().getColumn(x).setMinWidth(tabelaModuloBairro.getColumnSize(x));
        }
        tblBairros.getTableHeader().setReorderingAllowed(false);
    }

    public void limpar() {
        txtNomeBairro.setText("");
        cbxEstados.setSelectedIndex(0);
        cbxCidades.setSelectedIndex(0);;
    }

    public void atualizaTabela() throws Exception{
        tabelaModuloBairro.setResultados(bairroDao.retornaListaBairros());
        setTamanhoColunas();
    }

    private void exibir() {
        /*if (bairro != null) {
            txtUf.setText("" + estado.getEst_uf());
            txtNomeBairro.setText(estado.getEst_nome());
        }*/
    }

    private void mudaEstado() {
        if (novo == true) {
            txtNomeBairro.setEditable(true);
            cbxEstados.setEditable(true);
            cbxCidades.setEditable(true);
            txtNomeBairro.requestFocus();
        } else {
            txtNomeBairro.setEditable(false);
            cbxEstados.setEditable(false);
            cbxCidades.setEditable(false);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panTituloEstado = new javax.swing.JPanel();
        barraEstado = new javax.swing.JToolBar();
        btnAdicionarBairro = new javax.swing.JButton();
        btnAlterarBairro = new javax.swing.JButton();
        btnExcluirBairro = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBairros = new javax.swing.JTable();
        panCadastraBairro = new javax.swing.JPanel();
        lblNomeBairro = new javax.swing.JLabel();
        txtNomeBairro = new javax.swing.JTextField();
        btnGravar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        lblUf = new javax.swing.JLabel();
        cbxEstados = new javax.swing.JComboBox();
        lblCidade = new javax.swing.JLabel();
        cbxCidades = new javax.swing.JComboBox();
        panBuscaBairro = new javax.swing.JPanel();
        lblBuscaBairro = new javax.swing.JLabel();
        txtBuscaBairro = new javax.swing.JTextField();
        btnBuscaBairro = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        panTituloEstado.setBackground(new java.awt.Color(255, 153, 0));
        panTituloEstado.setPreferredSize(new java.awt.Dimension(650, 80));

        javax.swing.GroupLayout panTituloEstadoLayout = new javax.swing.GroupLayout(panTituloEstado);
        panTituloEstado.setLayout(panTituloEstadoLayout);
        panTituloEstadoLayout.setHorizontalGroup(
            panTituloEstadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 650, Short.MAX_VALUE)
        );
        panTituloEstadoLayout.setVerticalGroup(
            panTituloEstadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 80, Short.MAX_VALUE)
        );

        barraEstado.setRollover(true);

        btnAdicionarBairro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/emprestimo/imagens/icones/add.png"))); // NOI18N
        btnAdicionarBairro.setFocusable(false);
        btnAdicionarBairro.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAdicionarBairro.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAdicionarBairro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarBairroActionPerformed(evt);
            }
        });
        barraEstado.add(btnAdicionarBairro);

        btnAlterarBairro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/emprestimo/imagens/icones/cog.png"))); // NOI18N
        btnAlterarBairro.setFocusable(false);
        btnAlterarBairro.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAlterarBairro.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAlterarBairro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarBairroActionPerformed(evt);
            }
        });
        barraEstado.add(btnAlterarBairro);

        btnExcluirBairro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/emprestimo/imagens/icones/cross-script.png"))); // NOI18N
        btnExcluirBairro.setFocusable(false);
        btnExcluirBairro.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnExcluirBairro.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnExcluirBairro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirBairroActionPerformed(evt);
            }
        });
        barraEstado.add(btnExcluirBairro);

        tblBairros.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblBairros);

        panCadastraBairro.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Bairro", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(51, 51, 255)));

        lblNomeBairro.setText("Bairro:");

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

        lblUf.setText("UF:");

        cbxEstados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxEstadosActionPerformed(evt);
            }
        });

        lblCidade.setText("Cidade:");

        javax.swing.GroupLayout panCadastraBairroLayout = new javax.swing.GroupLayout(panCadastraBairro);
        panCadastraBairro.setLayout(panCadastraBairroLayout);
        panCadastraBairroLayout.setHorizontalGroup(
            panCadastraBairroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panCadastraBairroLayout.createSequentialGroup()
                .addGroup(panCadastraBairroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panCadastraBairroLayout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(btnGravar)
                        .addGap(47, 47, 47)
                        .addComponent(btnCancelar))
                    .addGroup(panCadastraBairroLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblNomeBairro))
                    .addGroup(panCadastraBairroLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtNomeBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panCadastraBairroLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panCadastraBairroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbxEstados, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblUf))
                        .addGap(18, 18, 18)
                        .addGroup(panCadastraBairroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCidade)
                            .addComponent(cbxCidades, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        panCadastraBairroLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnCancelar, btnGravar});

        panCadastraBairroLayout.setVerticalGroup(
            panCadastraBairroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panCadastraBairroLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNomeBairro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtNomeBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panCadastraBairroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUf)
                    .addComponent(lblCidade))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panCadastraBairroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxEstados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxCidades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(panCadastraBairroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnGravar))
                .addContainerGap())
        );

        panBuscaBairro.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Buscar", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(51, 51, 255)));

        lblBuscaBairro.setText("Buscar:");

        btnBuscaBairro.setText("Buscar");
        btnBuscaBairro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscaBairroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panBuscaBairroLayout = new javax.swing.GroupLayout(panBuscaBairro);
        panBuscaBairro.setLayout(panBuscaBairroLayout);
        panBuscaBairroLayout.setHorizontalGroup(
            panBuscaBairroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panBuscaBairroLayout.createSequentialGroup()
                .addGroup(panBuscaBairroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panBuscaBairroLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblBuscaBairro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBuscaBairro, javax.swing.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE))
                    .addGroup(panBuscaBairroLayout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addComponent(btnBuscaBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        panBuscaBairroLayout.setVerticalGroup(
            panBuscaBairroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panBuscaBairroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panBuscaBairroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBuscaBairro)
                    .addComponent(txtBuscaBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(btnBuscaBairro)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panTituloEstado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(barraEstado, javax.swing.GroupLayout.DEFAULT_SIZE, 640, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panBuscaBairro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panCadastraBairro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panBuscaBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(panCadastraBairro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 334, Short.MAX_VALUE))
                .addGap(60, 60, 60))
        );

        pack();
        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        java.awt.Dimension dialogSize = getSize();
        setLocation((screenSize.width-dialogSize.width)/2,(screenSize.height-dialogSize.height)/2);
    }// </editor-fold>//GEN-END:initComponents

    private void btnGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGravarActionPerformed
        // TODO add your handling code here:
        String nomeBairro = txtNomeBairro.getText();
        String nomeEstado = txtNomeBairro.getText();

        if (!nomeBairro.equals("")) {
            if (bairro==null) {
                bairro = new JBairro();
                bairro.setBai_nome(nomeBairro);
                //bairro.setCidade(listaCidades.get(getCbx().getSelectedIndex()));

                if (JOptionPane.showConfirmDialog(null, "Gravar Dados do Bairro?", "Confirma?",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {

                    try {
                        bairroDao.inserir(bairro);
                        JOptionPane.showMessageDialog(null, "Bairro Cadastrado com Sucesso!", "Cadastrado!", JOptionPane.INFORMATION_MESSAGE);
                        atualizaTabela();
                        limpar();
                        novo=false;
                        bairro=null;
                        mudaEstado();
                    } catch (Exception ex) {
                        Logger.getLogger(JModuloBairro.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } else {
                bairro.setBai_nome(nomeBairro);
                //bairro.setCidade();

                if (JOptionPane.showConfirmDialog(null, "Gravar Alteração do Bairro?", "Confirma?",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {

                    try {
                        bairroDao.alterar(bairro);
                        JOptionPane.showMessageDialog(null, "Bairro Alterado com Sucesso!", "Cadastrado!", JOptionPane.INFORMATION_MESSAGE);
                        atualizaTabela();
                        limpar();
                        novo=false;
                        bairro=null;
                        mudaEstado();
                    } catch (Exception ex) {
                        Logger.getLogger(JModuloBairro.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Favor inserir Nome do Bairro!", "Mensagem!", JOptionPane.INFORMATION_MESSAGE);
            txtNomeBairro.requestFocus();
        }
    }//GEN-LAST:event_btnGravarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        setVisible(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnBuscaBairroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscaBairroActionPerformed
        // TODO add your handling code here:
        List<JBairro> resultadoBusca = new ArrayList<JBairro>();
        String buscaBairro = txtBuscaBairro.getText();
        try {
            //resultadoBusca = bairroDao.retornaEstado(buscaBairro);
        } catch (Exception ex) {
            Logger.getLogger(JModuloBairro.class.getName()).log(Level.SEVERE, null, ex);
        }

        //tabelaModuloBairro.setResultados(resultadoBusca);
        txtBuscaBairro.setText("");
    }//GEN-LAST:event_btnBuscaBairroActionPerformed

    private void btnAlterarBairroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarBairroActionPerformed
        // TODO add your handling code here:
        if (tblBairros.getSelectedRow() >= 0) {
            //this.bairro = tabelaModuloBairro.getBairro(tblBairros.getSelectedRow());
            exibir();
            novo=true;
            mudaEstado();
        } else {
            JOptionPane.showMessageDialog(null, "Favor Selecionar uma Linha!", "Mensagem!", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnAlterarBairroActionPerformed

    private void btnExcluirBairroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirBairroActionPerformed
        // TODO add your handling code here:
        if (tblBairros.getSelectedRow() >= 0) {
            int opcao = JOptionPane.showConfirmDialog(null, "Deseja excluir o Bairro?", "Confirma?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (opcao == JOptionPane.YES_OPTION) {
                try {
                    //bairroDao.retornaListaEstados();
                    //bairroDao.excluir(bairroDao.retornaListaEstados().get(tblBairros.getSelectedRow()).getEst_cod());
                    JOptionPane.showMessageDialog(null, "Bairro excluído com Sucesso!", "Cadastrado!", JOptionPane.INFORMATION_MESSAGE);
                    atualizaTabela();
                } catch (Exception ex) {
                    Logger.getLogger(JModuloBairro.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Estado Excluído com Sucesso!", "Mensagem!", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Favor Selecionar uma Linha!", "Mensagem!", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnExcluirBairroActionPerformed

    private void btnAdicionarBairroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarBairroActionPerformed
        // TODO add your handling code here:
        novo = true;
        mudaEstado();
    }//GEN-LAST:event_btnAdicionarBairroActionPerformed

    private void cbxEstadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxEstadosActionPerformed
        // TODO add your handling code here:
        preencherCidade();
    }//GEN-LAST:event_cbxEstadosActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                JModuloBairro dialog = null;
                try {
                    dialog = new JModuloBairro(new javax.swing.JFrame(), true);
                } catch (Exception ex) {
                    Logger.getLogger(JModuloBairro.class.getName()).log(Level.SEVERE, null, ex);
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
    private javax.swing.JButton btnAdicionarBairro;
    private javax.swing.JButton btnAlterarBairro;
    private javax.swing.JButton btnBuscaBairro;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnExcluirBairro;
    private javax.swing.JButton btnGravar;
    private javax.swing.JComboBox cbxCidades;
    private javax.swing.JComboBox cbxEstados;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBuscaBairro;
    private javax.swing.JLabel lblCidade;
    private javax.swing.JLabel lblNomeBairro;
    private javax.swing.JLabel lblUf;
    private javax.swing.JPanel panBuscaBairro;
    private javax.swing.JPanel panCadastraBairro;
    private javax.swing.JPanel panTituloEstado;
    private javax.swing.JTable tblBairros;
    private javax.swing.JTextField txtBuscaBairro;
    private javax.swing.JTextField txtNomeBairro;
    // End of variables declaration//GEN-END:variables

    public javax.swing.JComboBox getCbxCidade() {
        return cbxCidades;
    }

    public javax.swing.JComboBox getCbxEstado() {
        return cbxEstados;
    }

    public List<JCidade> getCidades() {
        return listaCidades;
    }

     private void preencherUf() {
        try {
            estadoDao.retornaListaEstados();
            comboBoxEstado = new DefaultComboBoxModel(estadoDao.retornaListaEstados().toArray());
            cbxEstados.setModel(comboBoxEstado);
            comboBoxEstado.setSelectedItem(null);
        } catch (Exception e) {
        }
        cbxCidades.setSelectedItem(null);
        cbxCidades.setEnabled(false);
    }

    private void preencherCidade() {
        try {
            if (comboBoxEstado != null && cbxEstados.getSelectedItem() instanceof JEstado) {
                //cidadeDao.retornaListaCidadePorNome(((JEstado) cbxEstados.getSelectedItem()).getEst_uf(), "");
                comboBoxCidade = new DefaultComboBoxModel(cidadeDao.retornaListaCidades().toArray());
                cbxCidades.setModel(comboBoxCidade);
                cbxCidades.setSelectedItem(null);
                cbxCidades.setEnabled(true);
            }
        } catch (Exception e) {
        }
    }

}
