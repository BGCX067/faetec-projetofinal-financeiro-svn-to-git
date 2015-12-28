package endereco.visao;

import endereco.dao.EstadoDao;
import endereco.modelo.Estado;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Carlos Alexandre
 */
public class CadastraEstado extends javax.swing.JDialog {

    /** Creates new form CadastraEstado */
    public CadastraEstado(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public void limpar() {
        txtUf.setText("");
        txtEstado.setText("");
    }

    public void focus() {
        txtUf.requestFocus();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtUf = new javax.swing.JTextField();
        txtEstado = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnGravar = new javax.swing.JButton();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        txtUf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtUfKeyTyped(evt);
            }
        });

        jLabel2.setText("UF:");

        jLabel3.setText("Nome:");

        btnGravar.setText("Gravar");
        btnGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGravarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtUf, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnGravar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(txtUf, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGravar))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        pack();
        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        java.awt.Dimension dialogSize = getSize();
        setLocation((screenSize.width-dialogSize.width)/2,(screenSize.height-dialogSize.height)/2);
    }// </editor-fold>//GEN-END:initComponents

    private void btnGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGravarActionPerformed
        // TODO add your handling code here:
        if (txtUf.getText().length() != 2) {
            JOptionPane.showMessageDialog(null, "UF deve conter 2 Caracteres!", "Alerta!", JOptionPane.INFORMATION_MESSAGE);
            focus();
        } else if (txtUf.getText().isEmpty() || txtEstado.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Favor, digite a UF e/ou Estado!", "Alerta!", JOptionPane.INFORMATION_MESSAGE);
            limpar();
            focus();
        } else {
            Estado estado = new Estado();
            EstadoDao estadoDao = new EstadoDao();
            try {
                estado.setEst_uf(txtUf.getText().toUpperCase());
            } catch (Exception ex) {
                Logger.getLogger(CadastraEstado.class.getName()).log(Level.SEVERE, null, ex);
            }


            try {
                estado.setEst_nome(txtEstado.getText().toUpperCase());
            } catch (Exception ex) {
                Logger.getLogger(CadastraEstado.class.getName()).log(Level.SEVERE, null, ex);
            }


            try {
                estadoDao.incluir(estado);
                JOptionPane.showMessageDialog(null, "Dados Gravados com Sucesso!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception ex) {
                Logger.getLogger(CadastraEstado.class.getName()).log(Level.SEVERE, null, ex);
            }
            int opcao = JOptionPane.showConfirmDialog(null, "Deseja inserir novo Estado?", "Repetir Cadastro?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (opcao == JOptionPane.YES_OPTION) {
                limpar();
                focus();
            } else {
                dispose();
            }
        }
    }//GEN-LAST:event_btnGravarActionPerformed

    private void txtUfKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUfKeyTyped
        // TODO add your handling code here:

        String numeros = "0123456789";
        if (numeros.indexOf(evt.getKeyChar()) >= 0) {
            evt.consume();
            return;
        }

        if (evt.getKeyChar() != '\b' && txtUf.getText().length() == 2) {
            evt.consume();
        }
    }//GEN-LAST:event_txtUfKeyTyped

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                CadastraEstado dialog = new CadastraEstado(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnGravar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField txtEstado;
    private javax.swing.JTextField txtUf;
    // End of variables declaration//GEN-END:variables
}
