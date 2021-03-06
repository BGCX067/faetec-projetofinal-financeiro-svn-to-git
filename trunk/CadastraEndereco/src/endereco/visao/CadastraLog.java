package endereco.visao;

import endereco.dao.BairroDao;
import endereco.dao.CidadeDao;
import endereco.dao.EstadoDao;
import endereco.dao.TipoLogradouroDao;
import endereco.modelo.Bairro;
import endereco.modelo.Cidade;
import endereco.modelo.Estado;
import endereco.modelo.TipoLogradouro;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Carlos Alexandre
 */
public class CadastraLog extends javax.swing.JDialog {

    List<Estado> estados = new ArrayList<Estado>();
    List<Cidade> cidades = new ArrayList<Cidade>();
    List<Bairro> bairros = new ArrayList<Bairro>();
    List<TipoLogradouro> tipos = new ArrayList<TipoLogradouro>();
    List<Cidade> cidades2 = new ArrayList<Cidade>();

    /** Creates new form CadastraLog */
    public CadastraLog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cbxLogradouro = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtCidade = new javax.swing.JTextField();
        btnGravar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtNumero = new javax.swing.JTextField();
        txtComplemento = new javax.swing.JTextField();
        cbxCidade = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        cbxEstado = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        cbxBairro = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        cbxLogradouro.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione" }));

        jLabel2.setText("Tipo Logradouro:");

        jLabel1.setText("Logradouro:");

        btnGravar.setText("Gravar");
        btnGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGravarActionPerformed(evt);
            }
        });

        jLabel3.setText("Número:");

        jLabel4.setText("Complemento:");

        jLabel5.setText("Cidade:");

        cbxCidade.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione" }));
        cbxCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxCidadeActionPerformed(evt);
            }
        });

        jLabel6.setText("Estado:");

        cbxEstado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione" }));
        cbxEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxEstadoActionPerformed(evt);
            }
        });

        jLabel7.setText("Bairro:");

        cbxBairro.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtCidade))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cbxLogradouro, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                                .addComponent(btnGravar)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbxCidade, 0, 293, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbxBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 203, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(103, 103, 103))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(cbxLogradouro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(btnGravar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cbxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cbxCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cbxBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        java.awt.Dimension dialogSize = getSize();
        setLocation((screenSize.width-dialogSize.width)/2,(screenSize.height-dialogSize.height)/2);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        EstadoDao estadoDao = new EstadoDao();
        TipoLogradouroDao tipoLogDao = new TipoLogradouroDao();

        try {
            estados = estadoDao.retornaListaEstado("");
            tipos = tipoLogDao.retornaListaTipoLogradouro("");
        } catch (Exception ex) {
            Logger.getLogger(CadastraLog.class.getName()).log(Level.SEVERE, null, ex);
        }

        for (Estado estado : estados) {
            getCbxEstado().addItem(estado.getEst_uf());
        }

        for (TipoLogradouro tipoLog : tipos) {
            getCbxTiposLogradouro().addItem(tipoLog.getTpl_desc());
        }

    }//GEN-LAST:event_formWindowOpened

    private void cbxEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxEstadoActionPerformed
        // TODO add your handling code here:
        carregaComboBoxCidades();
    }//GEN-LAST:event_cbxEstadoActionPerformed

    private void cbxCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxCidadeActionPerformed
        // TODO add your handling code here:
        carregaComboBoxBairros2();
    }//GEN-LAST:event_cbxCidadeActionPerformed

    private void btnGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGravarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGravarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                CadastraLog dialog = new CadastraLog(new javax.swing.JFrame(), true);
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
    private javax.swing.JComboBox cbxBairro;
    private javax.swing.JComboBox cbxCidade;
    private javax.swing.JComboBox cbxEstado;
    private javax.swing.JComboBox cbxLogradouro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField txtCidade;
    private javax.swing.JTextField txtComplemento;
    private javax.swing.JTextField txtNumero;
    // End of variables declaration//GEN-END:variables

    public javax.swing.JComboBox getCbxEstado() {
        return cbxEstado;
    }

    public javax.swing.JComboBox getCbxCidade() {
        return cbxCidade;
    }

    public javax.swing.JComboBox getCbxBairro() {
        return cbxBairro;
    }

    public javax.swing.JComboBox getCbxTiposLogradouro() {
        return cbxLogradouro;
    }

    public List<Cidade> getCidades() {
        return cidades;
    }

    public List<Bairro> getBairros() {
        return bairros;
    }
    
    public List<Cidade> getCidadesEspecificas(){
        return cidades2;
    }

    public void carregaComboBoxCidades() {

        try {
            CidadeDao cidadeDao = new CidadeDao();
            List<Cidade> cidadesSelecionadas = new ArrayList<Cidade>();
            cidadesSelecionadas = cidadeDao.retornaCidadeDoEstado(estados.get(getCbxEstado().getSelectedIndex() - 1).getEst_cod());
            //System.out.println(estados.get(getCbxEstado().getSelectedIndex() - 1).getEst_uf());
            //System.out.println(cidadesSelecionadas);
            getCbxCidade().removeAllItems();
            for (Cidade cidade : cidadesSelecionadas) {
                getCbxCidade().addItem(cidade.getCid_nome());
            }
            cidades = cidadesSelecionadas;
            carregaComboBoxBairros();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void carregaComboBoxBairros() {
        try {
            BairroDao bairroDao = new BairroDao();
            List<Bairro> bairrosSelecionadas = new ArrayList<Bairro>();
            bairrosSelecionadas = bairroDao.retornaBairroDaCidade(getCidades().get(getCbxCidade().getSelectedIndex()).getCid_cod());
            getCbxBairro().removeAllItems();
            for (Bairro bairro : bairrosSelecionadas) {
                getCbxBairro().addItem(bairro.getBai_nome());
                bairros = bairrosSelecionadas;
            }
            cidades2 = getCidades();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void carregaComboBoxBairros2() {
        try {
            BairroDao bairroDao = new BairroDao();
            List<Bairro> bairrosSelecionadas = new ArrayList<Bairro>();
            bairrosSelecionadas = bairroDao.retornaBairroDaCidade(getCidadesEspecificas().get(getCbxCidade().getSelectedIndex()).getCid_cod());
            getCbxBairro().removeAllItems();
            System.out.println("AAA"+bairrosSelecionadas);
            for (Bairro bairro : bairrosSelecionadas) {
                getCbxBairro().addItem(bairro.getBai_nome());
                bairros = bairrosSelecionadas;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            Logger.getLogger(CadastraLog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
