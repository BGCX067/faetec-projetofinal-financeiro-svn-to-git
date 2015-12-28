/*
 * JModuloEstado.java
 *
 * Created on 26/11/2011, 20:58:43
 */
package emprestimo.visao;

import emprestimo.modelo.dao.JEstadoDao;
import emprestimo.modelo.modelo.JEstado;
import emprestimo.modelo.tabela.JTabelaModuloEstado;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * @author Manutenção
 */
public class JModuloEstado extends javax.swing.JDialog {

    private JEstado estado;
    private JEstadoDao estadoDao;
    private JTabelaModuloEstado tabelaModuloEstado = new JTabelaModuloEstado();
    boolean novo = true;

    /** Creates new form JModuloEstado */
    public JModuloEstado(java.awt.Frame parent, boolean modal) throws Exception{
        super(parent, modal);
        initComponents();
        tblEstados.setModel(tabelaModuloEstado);
        estadoDao = new JEstadoDao();
        atualizaTabela();
        setTamanhoColunas();
        txtUf.setEditable(false);
        txtNomeEstado.setEditable(false);
    }

    private void setTamanhoColunas() {
        for (int x = 0; x < tabelaModuloEstado.getColumnCount(); x++) {
            tblEstados.getColumnModel().getColumn(x).setMinWidth(tabelaModuloEstado.getColumnSize(x));
        }
        tblEstados.getTableHeader().setReorderingAllowed(false);
    }

    public void limpar() {
        txtUf.setText("");
        txtNomeEstado.setText("");
    }

    public void atualizaTabela() throws Exception{
        tabelaModuloEstado.setResultados(estadoDao.retornaListaEstados());
        setTamanhoColunas();
    }

    private void exibir() {
        if (estado != null) {
            txtUf.setText("" + estado.getEst_uf());
            txtNomeEstado.setText(estado.getEst_nome());
        }
    }

    private void mudaEstado(){
        if(novo == true){
           txtUf.setEditable(true);
           txtNomeEstado.setEditable(true);
           txtUf.requestFocus();
    } else{
            txtUf.setEditable(false);
           txtNomeEstado.setEditable(false);
    }
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panTituloEstado = new javax.swing.JPanel();
        barraEstado = new javax.swing.JToolBar();
        btnAdicionarEstado = new javax.swing.JButton();
        btnAlterarEstado = new javax.swing.JButton();
        btnExcluirEstado = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEstados = new javax.swing.JTable();
        panCadastraEstado = new javax.swing.JPanel();
        lblUf = new javax.swing.JLabel();
        txtUf = new javax.swing.JTextField();
        lblNomeEstado = new javax.swing.JLabel();
        txtNomeEstado = new javax.swing.JTextField();
        btnGravar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        panBuscaEstado = new javax.swing.JPanel();
        lblBuscaEstado = new javax.swing.JLabel();
        txtBuscaEstado = new javax.swing.JTextField();
        btnBuscaEstado = new javax.swing.JButton();

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

        btnAdicionarEstado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/emprestimo/imagens/icones/add.png"))); // NOI18N
        btnAdicionarEstado.setFocusable(false);
        btnAdicionarEstado.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAdicionarEstado.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAdicionarEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarEstadoActionPerformed(evt);
            }
        });
        barraEstado.add(btnAdicionarEstado);

        btnAlterarEstado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/emprestimo/imagens/icones/cog.png"))); // NOI18N
        btnAlterarEstado.setFocusable(false);
        btnAlterarEstado.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAlterarEstado.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAlterarEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarEstadoActionPerformed(evt);
            }
        });
        barraEstado.add(btnAlterarEstado);

        btnExcluirEstado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/emprestimo/imagens/icones/cross-script.png"))); // NOI18N
        btnExcluirEstado.setFocusable(false);
        btnExcluirEstado.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnExcluirEstado.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnExcluirEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirEstadoActionPerformed(evt);
            }
        });
        barraEstado.add(btnExcluirEstado);

        tblEstados.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblEstados);

        panCadastraEstado.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Estado", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(51, 51, 255)));

        lblUf.setText("UF:");

        txtUf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtUfKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtUfKeyTyped(evt);
            }
        });

        lblNomeEstado.setText("Nome:");

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

        javax.swing.GroupLayout panCadastraEstadoLayout = new javax.swing.GroupLayout(panCadastraEstado);
        panCadastraEstado.setLayout(panCadastraEstadoLayout);
        panCadastraEstadoLayout.setHorizontalGroup(
            panCadastraEstadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panCadastraEstadoLayout.createSequentialGroup()
                .addGroup(panCadastraEstadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panCadastraEstadoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panCadastraEstadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNomeEstado)
                            .addComponent(txtNomeEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblUf)
                            .addComponent(txtUf, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panCadastraEstadoLayout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(btnGravar)
                        .addGap(47, 47, 47)
                        .addComponent(btnCancelar)))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        panCadastraEstadoLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnCancelar, btnGravar});

        panCadastraEstadoLayout.setVerticalGroup(
            panCadastraEstadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panCadastraEstadoLayout.createSequentialGroup()
                .addComponent(lblUf)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtUf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNomeEstado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNomeEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addGroup(panCadastraEstadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnGravar))
                .addContainerGap())
        );

        panBuscaEstado.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Buscar", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(51, 51, 255)));

        lblBuscaEstado.setText("Buscar:");

        btnBuscaEstado.setText("Buscar");
        btnBuscaEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscaEstadoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panBuscaEstadoLayout = new javax.swing.GroupLayout(panBuscaEstado);
        panBuscaEstado.setLayout(panBuscaEstadoLayout);
        panBuscaEstadoLayout.setHorizontalGroup(
            panBuscaEstadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panBuscaEstadoLayout.createSequentialGroup()
                .addGroup(panBuscaEstadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panBuscaEstadoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblBuscaEstado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBuscaEstado, javax.swing.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE))
                    .addGroup(panBuscaEstadoLayout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addComponent(btnBuscaEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        panBuscaEstadoLayout.setVerticalGroup(
            panBuscaEstadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panBuscaEstadoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panBuscaEstadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBuscaEstado)
                    .addComponent(txtBuscaEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(btnBuscaEstado)
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
                    .addComponent(panBuscaEstado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panCadastraEstado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                        .addComponent(panBuscaEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(panCadastraEstado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE))
                .addGap(60, 60, 60))
        );

        pack();
        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        java.awt.Dimension dialogSize = getSize();
        setLocation((screenSize.width-dialogSize.width)/2,(screenSize.height-dialogSize.height)/2);
    }// </editor-fold>//GEN-END:initComponents

    private void btnGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGravarActionPerformed
        // TODO add your handling code here:
        String uf = txtUf.getText();
        String nomeEstado = txtNomeEstado.getText();

        if (!uf.equals("") && !nomeEstado.equals("")) {
            if (estado==null) {
                estado = new JEstado();
                estado.setEst_uf(uf);
                estado.setEst_nome(nomeEstado);

                if (JOptionPane.showConfirmDialog(null, "Gravar Dados do Estado?", "Confirma?",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {

                    try {
                        estadoDao.inserir(estado);
                        JOptionPane.showMessageDialog(null, "Estado Cadastrado com Sucesso!", "Cadastrado!", JOptionPane.INFORMATION_MESSAGE);
                        atualizaTabela();
                        limpar();
                        novo=false;
                        estado=null;
                        mudaEstado();
                    } catch (Exception ex) {
                        Logger.getLogger(JModuloEstado.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } else {
                estado.setEst_uf(uf);
                estado.setEst_nome(nomeEstado);

                if (JOptionPane.showConfirmDialog(null, "Gravar Alteração do Estado?", "Confirma?",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {

                    try {
                        estadoDao.alterar(estado);
                        JOptionPane.showMessageDialog(null, "Estado Alterado com Sucesso!", "Cadastrado!", JOptionPane.INFORMATION_MESSAGE);
                        atualizaTabela();
                        limpar();
                        novo=false;
                        estado=null;
                        mudaEstado();
                    } catch (Exception ex) {
                        Logger.getLogger(JModuloEstado.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Favor inserir UF e Nome do Estado!", "Mensagem!", JOptionPane.INFORMATION_MESSAGE);
            txtUf.requestFocus();
        }
    }//GEN-LAST:event_btnGravarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        setVisible(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnBuscaEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscaEstadoActionPerformed
        // TODO add your handling code here:
        List<JEstado> resultadoBusca = new ArrayList<JEstado>();
        String buscaEstado = txtBuscaEstado.getText();
        try {
            resultadoBusca = estadoDao.retornaEstado(buscaEstado);
        } catch (Exception ex) {
            Logger.getLogger(JModuloEstado.class.getName()).log(Level.SEVERE, null, ex);
        }

        tabelaModuloEstado.setResultados(resultadoBusca);
        txtBuscaEstado.setText("");
    }//GEN-LAST:event_btnBuscaEstadoActionPerformed

    private void btnAlterarEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarEstadoActionPerformed
        // TODO add your handling code here:
        if (tblEstados.getSelectedRow() >= 0) {
            this.estado = tabelaModuloEstado.getEstado(tblEstados.getSelectedRow());
            exibir();
            novo=true;
            mudaEstado();
        } else {
            JOptionPane.showMessageDialog(null, "Favor Selecionar uma Linha!", "Mensagem!", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnAlterarEstadoActionPerformed

    private void btnExcluirEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirEstadoActionPerformed
        // TODO add your handling code here:
        if (tblEstados.getSelectedRow() >= 0) {
            int opcao = JOptionPane.showConfirmDialog(null, "Deseja excluir o Estado?", "Confirma?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (opcao == JOptionPane.YES_OPTION) {
                try {
                    estadoDao.retornaListaEstados();
                    estadoDao.excluir(estadoDao.retornaListaEstados().get(tblEstados.getSelectedRow()).getEst_cod());
                    JOptionPane.showMessageDialog(null, "Estado excluído com Sucesso!", "Cadastrado!", JOptionPane.INFORMATION_MESSAGE);
                    atualizaTabela();
                } catch (Exception ex) {
                    Logger.getLogger(JModuloEstado.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Estado Excluído com Sucesso!", "Mensagem!", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Favor Selecionar uma Linha!", "Mensagem!", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnExcluirEstadoActionPerformed

    private void btnAdicionarEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarEstadoActionPerformed
        // TODO add your handling code here:
        novo = true;
        mudaEstado();
    }//GEN-LAST:event_btnAdicionarEstadoActionPerformed

    private void txtUfKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUfKeyTyped
        // TODO add your handling code here:
        String numeros = "0123456789";
    if (numeros.indexOf(evt.getKeyChar()) >= 0) {
        evt.consume();
        return;
    }
        if (evt.getKeyChar() != '\b' && txtUf.getText().length()==2) {
        evt.consume();
    }
    }//GEN-LAST:event_txtUfKeyTyped

    private void txtUfKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUfKeyPressed
        // TODO add your handling code here:
        txtUf.setText(txtUf.getText().toUpperCase());
    }//GEN-LAST:event_txtUfKeyPressed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                JModuloEstado dialog = null;
                try {
                    dialog = new JModuloEstado(new javax.swing.JFrame(), true);
                } catch (Exception ex) {
                    Logger.getLogger(JModuloEstado.class.getName()).log(Level.SEVERE, null, ex);
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
    private javax.swing.JButton btnAdicionarEstado;
    private javax.swing.JButton btnAlterarEstado;
    private javax.swing.JButton btnBuscaEstado;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnExcluirEstado;
    private javax.swing.JButton btnGravar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBuscaEstado;
    private javax.swing.JLabel lblNomeEstado;
    private javax.swing.JLabel lblUf;
    private javax.swing.JPanel panBuscaEstado;
    private javax.swing.JPanel panCadastraEstado;
    private javax.swing.JPanel panTituloEstado;
    private javax.swing.JTable tblEstados;
    private javax.swing.JTextField txtBuscaEstado;
    private javax.swing.JTextField txtNomeEstado;
    private javax.swing.JTextField txtUf;
    // End of variables declaration//GEN-END:variables
}
