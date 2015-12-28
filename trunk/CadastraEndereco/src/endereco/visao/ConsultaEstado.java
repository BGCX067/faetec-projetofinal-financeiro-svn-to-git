package endereco.visao;

import endereco.controle.Conexao;
import endereco.dao.EstadoDao;
import endereco.modelo.Estado;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Carlos Alexandre
 */
public class ConsultaEstado extends javax.swing.JDialog {

    EstadoDao estadoDao = new EstadoDao();
    List<Estado> listaEstados = new ArrayList<Estado>();
    final DefaultTableModel dtmEstado = new DefaultTableModel();

    /** Creates new form ConsultaEstado */
    public ConsultaEstado(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        

        try {
            tblEstados.setModel(dtmEstado);
            dtmEstado.addColumn("UF");
            dtmEstado.addColumn("Estados");
            updateTableUser();
        } catch (Exception ex) {
            Logger.getLogger(ConsultaEstado.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateTableUser() throws Exception {
        try {
            listaEstados=estadoDao.retornaListaEstado("");
            for (Estado estado : estadoDao.getLista()) {
            dtmEstado.addRow(new Object[]{estado.getEst_uf(),
                                          estado.getEst_nome()});
            dtmEstado.fireTableDataChanged();
            }
            }catch (Exception e) {
            e.printStackTrace();
            }
    }
        public void clearTable() {
        dtmEstado.setNumRows(0);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton3 = new javax.swing.JButton();
        jToolBar1 = new javax.swing.JToolBar();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEstados = new javax.swing.JTable();
        btnConfirmar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        jButton3.setText("jButton3");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jToolBar1.setRollover(true);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add_obj.gif"))); // NOI18N
        jButton1.setToolTipText("Adicionar");
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton1);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/configs.gif"))); // NOI18N
        jButton2.setToolTipText("Alterar");
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton2);

        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/delete_edit.gif"))); // NOI18N
        btnExcluir.setToolTipText("Excluir");
        btnExcluir.setFocusable(false);
        btnExcluir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnExcluir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });
        jToolBar1.add(btnExcluir);

        tblEstados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null}
            },
            new String [] {
                "Title 1"
            }
        ));
        jScrollPane1.setViewportView(tblEstados);

        btnConfirmar.setText("Confirmar");
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 707, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 687, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(264, 264, 264)
                .addComponent(btnConfirmar)
                .addGap(28, 28, 28)
                .addComponent(btnCancelar)
                .addContainerGap(257, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnCancelar, btnConfirmar});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConfirmar)
                    .addComponent(btnCancelar))
                .addContainerGap())
        );

        pack();
        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        java.awt.Dimension dialogSize = getSize();
        setLocation((screenSize.width-dialogSize.width)/2,(screenSize.height-dialogSize.height)/2);
    }// </editor-fold>//GEN-END:initComponents

private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_btnConfirmarActionPerformed

private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
// TODO add your handling code here:
    dispose();
}//GEN-LAST:event_btnCancelarActionPerformed

private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
// TODO add your handling code here:
    int opcao=JOptionPane.showConfirmDialog(null,"Tem certeza que deseja apagar a linha selecionada ?", "Mensagem", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
    if(opcao == JOptionPane.OK_OPTION){
            try {
                
                estadoDao.excluir(listaEstados.get(tblEstados.getSelectedRow()).getEst_cod()); 
                JOptionPane.showMessageDialog(null, "Estado excluido com sucesso");
                clearTable();
                updateTableUser();
                
            } catch (Exception ex) {
                Logger.getLogger(ConsultaEstado.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }
}//GEN-LAST:event_btnExcluirActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                ConsultaEstado dialog = new ConsultaEstado(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTable tblEstados;
    // End of variables declaration//GEN-END:variables

        public List getListaEstados(){
            return listaEstados;
        }

}
