/*
 * JLogin.java
 *
 * Created on 24/10/2011, 15:12:35
 */
package emprestimo.visao;

import emprestimo.controle.JConexao;
import emprestimo.modelo.dao.JConta_UsuarioDao;
import emprestimo.modelo.modelo.JConta_Usuario;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 * @author Carlos Alexandre
 */
public class JLogin extends javax.swing.JDialog {

    private JConta_UsuarioDao usuarioDao = new JConta_UsuarioDao();
    private static JConta_Usuario user = null;
    private File file;
    ImageIcon foto;

    public static JConta_Usuario getUsuario() {
        return user;
    }

    /** Creates new form JLogin */
    public JLogin(java.awt.Frame parent, boolean modal) throws Exception {
        super(parent, modal);
        initComponents();
        lblFoto.setText(null);
        lblAviso.setText("");

        Timer timer = new Timer();
        TimerTask task = new TimerTask() {

            @Override
            public void run() {
                lblHoraCorrente.setText(new SimpleDateFormat("HH:mm:ss").format(new Date(System.currentTimeMillis())));
                ;
            }
        };
        timer.schedule(task, 1000, 1000);
        getRootPane().setDefaultButton(btnEntrar);
    }

    public void limpar() {
        txtLogin.setText("");
        passSenha.setText("");
    }

    public void focus(String foco) {
        if (foco.equals("login")) {
            txtLogin.setText("");
            txtLogin.requestFocus();
        } else if (foco.equals("senha")) {
            passSenha.setText("");
            passSenha.requestFocus();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlTelaLogin = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtLogin = new javax.swing.JTextField();
        passSenha = new javax.swing.JPasswordField();
        btnEntrar = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        pnlFoto = new javax.swing.JPanel();
        lblFoto = new javax.swing.JLabel();
        lblAviso = new javax.swing.JLabel();
        lblEmpresa = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblSisfec = new javax.swing.JLabel();
        lblHoraCorrente = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Tela de Login");
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                formFocusLost(evt);
            }
        });

        pnlTelaLogin.setBorder(javax.swing.BorderFactory.createTitledBorder("Login"));

        jLabel1.setText("Login:");

        jLabel2.setText("Senha:");

        btnEntrar.setText("Entrar");
        btnEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntrarActionPerformed(evt);
            }
        });

        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        pnlFoto.setBorder(javax.swing.BorderFactory.createTitledBorder("Foto"));

        lblFoto.setBackground(new java.awt.Color(255, 255, 255));
        lblFoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/emprestimo/imagens/figuras/sem_foto.jpg"))); // NOI18N

        javax.swing.GroupLayout pnlFotoLayout = new javax.swing.GroupLayout(pnlFoto);
        pnlFoto.setLayout(pnlFotoLayout);
        pnlFotoLayout.setHorizontalGroup(
            pnlFotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblFoto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlFotoLayout.setVerticalGroup(
            pnlFotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblFoto, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnlTelaLoginLayout = new javax.swing.GroupLayout(pnlTelaLogin);
        pnlTelaLogin.setLayout(pnlTelaLoginLayout);
        pnlTelaLoginLayout.setHorizontalGroup(
            pnlTelaLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTelaLoginLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlFoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(pnlTelaLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlTelaLoginLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(23, 23, 23)
                        .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlTelaLoginLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addGroup(pnlTelaLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(pnlTelaLoginLayout.createSequentialGroup()
                                .addComponent(btnEntrar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                                .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(passSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(30, 30, 30))
        );

        pnlTelaLoginLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnEntrar, btnLimpar});

        pnlTelaLoginLayout.setVerticalGroup(
            pnlTelaLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTelaLoginLayout.createSequentialGroup()
                .addContainerGap(53, Short.MAX_VALUE)
                .addGroup(pnlTelaLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlTelaLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(passSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(pnlTelaLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLimpar)
                    .addComponent(btnEntrar))
                .addGap(33, 33, 33))
            .addGroup(pnlTelaLoginLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlFoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        lblAviso.setText(null);

        lblEmpresa.setFont(new java.awt.Font("Courier New", 0, 11));
        lblEmpresa.setForeground(new java.awt.Color(0, 0, 204));
        lblEmpresa.setText("Underline Systems");

        jPanel1.setBackground(new java.awt.Color(255, 153, 0));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 0));
        jPanel1.setForeground(new java.awt.Color(236, 233, 216));

        lblSisfec.setFont(new java.awt.Font("Algerian", 0, 36));
        lblSisfec.setText("SISFEC");

        lblHoraCorrente.setText("00:00:00");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(177, Short.MAX_VALUE)
                .addComponent(lblSisfec)
                .addGap(98, 98, 98)
                .addComponent(lblHoraCorrente)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(lblSisfec, javax.swing.GroupLayout.PREFERRED_SIZE, 32, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addComponent(lblHoraCorrente))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlTelaLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblAviso)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblEmpresa)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlTelaLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAviso)
                    .addComponent(lblEmpresa))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        java.awt.Dimension dialogSize = getSize();
        setLocation((screenSize.width-dialogSize.width)/2,(screenSize.height-dialogSize.height)/2);
    }// </editor-fold>//GEN-END:initComponents

    private void btnEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntrarActionPerformed
        if (txtLogin.getText().isEmpty() && passSenha.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Favor, Digitar Login e Senha!", "Atenção!", JOptionPane.INFORMATION_MESSAGE);
            focus("login");
        } else if (txtLogin.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Favor Digitar Login!");
            limpar();
            focus("login");
        } else if (passSenha.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Favor Digitar uma Senha!");
            focus("senha");
        } else if (txtLogin.getText().length() > 0 && passSenha.getText().length() > 0) {
            try {
                user = usuarioDao.validaUsuario(txtLogin.getText());
            } catch (Exception ex) {
                Logger.getLogger(JLogin.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (user != null) {
                /*char[] senhaChar = passSenha.getPassword();
                String senhaString = String.valueOf(senhaChar);
                System.out.println(senhaString);*/
                String[] vetorUser = new String[5];
                try {
                    JConexao.openConexao();
                } catch (Exception ex) {
                    Logger.getLogger(JLogin.class.getName()).log(Level.SEVERE, null, ex);
                }
                JConexao conexao = new JConexao();
                try {
                    conexao.retCampos(vetorUser, "*", "Conta_Usuario WHERE usu_login='" + txtLogin.getText() + "'");
                } catch (Exception ex) {
                    Logger.getLogger(JLogin.class.getName()).log(Level.SEVERE, null, ex);
                }

                System.out.println(vetorUser[0]);
                System.out.println(vetorUser[1]);
                if (vetorUser[0] == null || vetorUser[0].isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Login Não Cadastrado!", "Login Inválido!", JOptionPane.ERROR_MESSAGE);
                    limpar();
                    focus("login");
                } else if (txtLogin.getText().equals(vetorUser[0]) && passSenha.getText().equals(vetorUser[1])) {
                     lblAviso.setText("Autenticando...");
                    try {
                        TimeUnit.SECONDS.sleep(3);
                        JMenu menu = new JMenu();
                        menu.setVisible(true);
                        dispose();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(JLogin.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else if (txtLogin.getText().equals(vetorUser[0]) && passSenha.getText() != (vetorUser[1])) {
                    JOptionPane.showMessageDialog(null, "Senha Incorreta!", "Senha Inválida!", JOptionPane.INFORMATION_MESSAGE);
                    focus("senha");

                } else if (txtLogin.getText() != (vetorUser[0]) && passSenha.getText().equals(vetorUser[1])) {
                    JOptionPane.showMessageDialog(null, "Usuário Incorreto!", "Usuário Inválido!", JOptionPane.INFORMATION_MESSAGE);
                    focus("login");
                }
            }
        }
    }//GEN-LAST:event_btnEntrarActionPerformed
    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        // TODO add your handling code here:
        limpar();
    }//GEN-LAST:event_btnLimparActionPerformed

    private void formFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusLost
        // TODO add your handling code here:
        /*try {
            foto = usuarioDao.retornaFotoUsuario(txtLogin.getText());
        } catch (Exception ex) {
            Logger.getLogger(JLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        lblFoto.setIcon(foto);*/
    }//GEN-LAST:event_formFocusLost

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                JLogin dialog = null;
                try {
                    dialog = new JLogin(new javax.swing.JFrame(), true);
                } catch (Exception ex) {
                    Logger.getLogger(JLogin.class.getName()).log(Level.SEVERE, null, ex);
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
    private javax.swing.JButton btnEntrar;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblAviso;
    private javax.swing.JLabel lblEmpresa;
    private javax.swing.JLabel lblFoto;
    private javax.swing.JLabel lblHoraCorrente;
    private javax.swing.JLabel lblSisfec;
    private javax.swing.JPasswordField passSenha;
    private javax.swing.JPanel pnlFoto;
    private javax.swing.JPanel pnlTelaLogin;
    private javax.swing.JTextField txtLogin;
    // End of variables declaration//GEN-END:variables
}
