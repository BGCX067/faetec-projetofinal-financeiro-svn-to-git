/*
 * JMenu.java
 *
 * Created on 05/11/2011, 11:54:12
 */
package emprestimo.visao;

import emprestimo.relatorio.JImprimirRelatorio;
import emprestimo.utilitario.JConverter;
import java.awt.Desktop;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;

/**
 * @author Carlos Alexandre
 */
public class JMenu extends javax.swing.JFrame {

    private JModuloEstado moduloEstado;
    private JModuloCidade moduloCidade;
    private JModuloBairro moduloBairro;
    private JControleUsuario controleUsuario;
    private JOpcoes opcoes;

    Calendar calendar = new GregorianCalendar();
    private int ano;
    private int mes;
    private int dia;

    /** Creates new form JMenu */
    public JMenu() {
        initComponents();
        lblBemVindoUsuario.setText("Bem Vindo "+JLogin.getFuncLogado().getFunc_nome().trim()+"!");

        ano = calendar.get(GregorianCalendar.YEAR);
        mes = calendar.get(GregorianCalendar.MONTH);
        dia = calendar.get(GregorianCalendar.DAY_OF_MONTH);
        txtCabecalho.setText("Volta Redonda, "+dia+" de "+JConverter.converteMesIntToMesString(mes)+" de "+ano+""+"");
        
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                lblHora.setText(new SimpleDateFormat("HH:mm:ss").format(new Date(System.currentTimeMillis())));;
            }
        };
        timer.schedule(task, 1000, 1000);
        System.out.println(JLogin.getUsuario().getUsu_login());
        System.out.println(JLogin.getFuncLogado().getFunc_nome());
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtCabecalho = new javax.swing.JLabel();
        lblHora = new javax.swing.JLabel();
        lblBemVindoUsuario = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu7 = new javax.swing.JMenu();
        jMenu8 = new javax.swing.JMenu();
        jMenuItem19 = new javax.swing.JMenuItem();
        jMenuItem20 = new javax.swing.JMenuItem();
        jMenuItem21 = new javax.swing.JMenuItem();
        jMenu10 = new javax.swing.JMenu();
        jMenuItem22 = new javax.swing.JMenuItem();
        jMenuItem23 = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        jMenu11 = new javax.swing.JMenu();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem26 = new javax.swing.JMenuItem();
        mnuCalculoMargem = new javax.swing.JMenuItem();
        mnuSiteBMG = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        mnuEstados = new javax.swing.JMenuItem();
        mnuCidades = new javax.swing.JMenuItem();
        mnuBairros = new javax.swing.JMenuItem();
        mnuLogradouros = new javax.swing.JMenuItem();
        mnuTipoLogradouros = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        jMenuItem17 = new javax.swing.JMenuItem();
        jMenu9 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem16 = new javax.swing.JMenuItem();
        jMenuItem18 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        mnuControleUsuario = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        mnuCalculadora = new javax.swing.JMenuItem();
        mnuLog = new javax.swing.JMenuItem();
        mnuBackup = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        mnuOpcoes = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        mnuLeiaMe = new javax.swing.JMenuItem();
        mnuTopicoAjuda = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        mnuSobre = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SisFEC - Sistema Financeiro de Empréstimo Consignado");

        jToolBar1.setRollover(true);

        jLabel1.setFont(new java.awt.Font("Algerian", 0, 140));
        jLabel1.setText("SISFEC");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24));
        jLabel2.setText("Sistema Financeiro de Empréstimo Consignado");

        txtCabecalho.setFont(new java.awt.Font("Tahoma", 0, 12));
        txtCabecalho.setForeground(new java.awt.Color(102, 102, 102));
        txtCabecalho.setText("Volta Redonda, 01 de Janeiro de 2000");

        lblHora.setFont(new java.awt.Font("Tahoma", 0, 12));
        lblHora.setForeground(new java.awt.Color(102, 102, 102));
        lblHora.setText("00:00:00");

        lblBemVindoUsuario.setFont(new java.awt.Font("Candara", 0, 15));
        lblBemVindoUsuario.setForeground(new java.awt.Color(51, 51, 255));
        lblBemVindoUsuario.setText("Bem Vindo Usuário...");

        jMenu1.setText("Módulos");

        jMenu7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/emprestimo/imagens/icones/monitor.png"))); // NOI18N
        jMenu7.setText("Organização");

        jMenu8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/emprestimo/imagens/icones/add.png"))); // NOI18N
        jMenu8.setText("Cadastrar");

        jMenuItem19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/emprestimo/imagens/icones/user_add.png"))); // NOI18N
        jMenuItem19.setText("Cliente");
        jMenuItem19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem19ActionPerformed(evt);
            }
        });
        jMenu8.add(jMenuItem19);

        jMenuItem20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/emprestimo/imagens/icones/user_edit.png"))); // NOI18N
        jMenuItem20.setText("Funcionário");
        jMenu8.add(jMenuItem20);

        jMenuItem21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/emprestimo/imagens/icones/vcard.png"))); // NOI18N
        jMenuItem21.setText("Benefício");
        jMenu8.add(jMenuItem21);

        jMenu7.add(jMenu8);

        jMenu10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/emprestimo/imagens/icones/magnifier.png"))); // NOI18N
        jMenu10.setText("Consultar");

        jMenuItem22.setText("Clientes");
        jMenuItem22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem22ActionPerformed(evt);
            }
        });
        jMenu10.add(jMenuItem22);

        jMenuItem23.setText("Contratos");
        jMenuItem23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem23ActionPerformed(evt);
            }
        });
        jMenu10.add(jMenuItem23);

        jMenu7.add(jMenu10);
        jMenu7.add(jSeparator4);

        jMenu11.setText("Contrato");

        jMenuItem8.setText("Novo");
        jMenu11.add(jMenuItem8);

        jMenuItem26.setText("Refinanciamento");
        jMenu11.add(jMenuItem26);

        jMenu7.add(jMenu11);

        mnuCalculoMargem.setText("Cálculo de Margem");
        mnuCalculoMargem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuCalculoMargemActionPerformed(evt);
            }
        });
        jMenu7.add(mnuCalculoMargem);

        mnuSiteBMG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/emprestimo/imagens/icones/world.png"))); // NOI18N
        mnuSiteBMG.setText("Ir Para BMGConsig");
        mnuSiteBMG.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mnuSiteBMGMouseClicked(evt);
            }
        });
        jMenu7.add(mnuSiteBMG);

        jMenu1.add(jMenu7);

        jMenu2.setText("Endereço");

        mnuEstados.setText("Estados");
        mnuEstados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuEstadosActionPerformed(evt);
            }
        });
        jMenu2.add(mnuEstados);

        mnuCidades.setText("Cidades");
        mnuCidades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuCidadesActionPerformed(evt);
            }
        });
        jMenu2.add(mnuCidades);

        mnuBairros.setText("Bairros");
        mnuBairros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuBairrosActionPerformed(evt);
            }
        });
        jMenu2.add(mnuBairros);

        mnuLogradouros.setText("Logradouros");
        mnuLogradouros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuLogradourosActionPerformed(evt);
            }
        });
        jMenu2.add(mnuLogradouros);

        mnuTipoLogradouros.setText("Tipos de Logradouros");
        mnuTipoLogradouros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuTipoLogradourosActionPerformed(evt);
            }
        });
        jMenu2.add(mnuTipoLogradouros);

        jMenu1.add(jMenu2);
        jMenu1.add(jSeparator3);

        jMenuItem17.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, 0));
        jMenuItem17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/emprestimo/imagens/icones/cross.png"))); // NOI18N
        jMenuItem17.setText("Sair");
        jMenuItem17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem17ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem17);

        jMenuBar1.add(jMenu1);

        jMenu9.setText("Relatórios");

        jMenu6.setText("Clientes");

        jMenuItem16.setText("Todos os Clientes");
        jMenuItem16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem16ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem16);

        jMenuItem18.setText("Por Consulta");
        jMenu6.add(jMenuItem18);

        jMenu9.add(jMenu6);

        jMenu3.setText("Contratos");

        jMenuItem11.setText("Todos os Contratos");
        jMenu3.add(jMenuItem11);

        jMenuItem4.setText("Realizados no Período");
        jMenu3.add(jMenuItem4);

        jMenuItem10.setText("Últimos Contratos");
        jMenu3.add(jMenuItem10);

        jMenu9.add(jMenu3);

        jMenuBar1.add(jMenu9);

        jMenu4.setMnemonic('F');
        jMenu4.setText("Configurações");

        mnuControleUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/emprestimo/imagens/icones/user.png"))); // NOI18N
        mnuControleUsuario.setText("Controle de Usuário");
        mnuControleUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuControleUsuarioActionPerformed(evt);
            }
        });
        jMenu4.add(mnuControleUsuario);
        jMenu4.add(jSeparator5);

        mnuCalculadora.setIcon(new javax.swing.ImageIcon(getClass().getResource("/emprestimo/imagens/icones/calculator.png"))); // NOI18N
        mnuCalculadora.setText("Calculadora");
        mnuCalculadora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuCalculadoraActionPerformed(evt);
            }
        });
        jMenu4.add(mnuCalculadora);

        mnuLog.setIcon(new javax.swing.ImageIcon(getClass().getResource("/emprestimo/imagens/icones/page_white_text.png"))); // NOI18N
        mnuLog.setText("Visualizar Log");
        mnuLog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuLogActionPerformed(evt);
            }
        });
        jMenu4.add(mnuLog);

        mnuBackup.setIcon(new javax.swing.ImageIcon(getClass().getResource("/emprestimo/imagens/icones/database_save.png"))); // NOI18N
        mnuBackup.setText("Backup");
        mnuBackup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuBackupActionPerformed(evt);
            }
        });
        jMenu4.add(mnuBackup);
        jMenu4.add(jSeparator2);

        mnuOpcoes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/emprestimo/imagens/icones/cog.png"))); // NOI18N
        mnuOpcoes.setText("Opções");
        mnuOpcoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuOpcoesActionPerformed(evt);
            }
        });
        jMenu4.add(mnuOpcoes);

        jMenuBar1.add(jMenu4);

        jMenu5.setText("Ajuda");

        mnuLeiaMe.setText("Leia-Me");
        mnuLeiaMe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuLeiaMeActionPerformed(evt);
            }
        });
        jMenu5.add(mnuLeiaMe);

        mnuTopicoAjuda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/emprestimo/imagens/icones/ajuda16x16.gif"))); // NOI18N
        mnuTopicoAjuda.setText("Tópicos de Ajuda");
        jMenu5.add(mnuTopicoAjuda);
        jMenu5.add(jSeparator1);

        mnuSobre.setText("Sobre...");
        mnuSobre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuSobreActionPerformed(evt);
            }
        });
        jMenu5.add(mnuSobre);

        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(199, 199, 199))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtCabecalho)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 643, Short.MAX_VALUE)
                        .addComponent(lblHora))
                    .addComponent(lblBemVindoUsuario))
                .addContainerGap())
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 925, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblBemVindoUsuario)
                .addGap(81, 81, 81)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(185, 185, 185)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCabecalho)
                    .addComponent(lblHora))
                .addContainerGap())
        );

        pack();
        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        java.awt.Dimension dialogSize = getSize();
        setLocation((screenSize.width-dialogSize.width)/2,(screenSize.height-dialogSize.height)/2);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem17ActionPerformed
        // TODO add your handling code here:
        System.exit(1);
    }//GEN-LAST:event_jMenuItem17ActionPerformed

    private void mnuSobreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuSobreActionPerformed
        // TODO add your handling code here:
        JSobre sobre = new JSobre(this, true);
        sobre.setVisible(true);
    }//GEN-LAST:event_mnuSobreActionPerformed

    private void mnuLeiaMeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuLeiaMeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mnuLeiaMeActionPerformed

    private void mnuOpcoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuOpcoesActionPerformed
        // TODO add your handling code here:
             if (JLogin.getFuncLogado().getFunc_nome().equalsIgnoreCase("Administrador")) {
            try {
                opcoes = new JOpcoes(this, true);
                setVisible(false);
            } catch (Exception ex) {
                Logger.getLogger(JMenu.class.getName()).log(Level.SEVERE, null, ex);
            }
            opcoes.setVisible(true);
        } else {
                 mnuOpcoes.setEnabled(false);
        }
    }//GEN-LAST:event_mnuOpcoesActionPerformed

    private void mnuControleUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuControleUsuarioActionPerformed
        // TODO add your handling code here:
        if (JLogin.getFuncLogado().getFunc_nome().equalsIgnoreCase("Administrador")) {
            try {
                controleUsuario = new JControleUsuario(this, true);
            } catch (Exception ex) {
                Logger.getLogger(JMenu.class.getName()).log(Level.SEVERE, null, ex);
            }
            controleUsuario.setVisible(true);
        } else {
            mnuControleUsuario.setEnabled(false);
        }
    }//GEN-LAST:event_mnuControleUsuarioActionPerformed

    private void mnuCalculadoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuCalculadoraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mnuCalculadoraActionPerformed

    private void mnuLogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuLogActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mnuLogActionPerformed

    private void mnuBackupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuBackupActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mnuBackupActionPerformed

    private void mnuEstadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuEstadosActionPerformed
        // TODO add your handling code here:
         if (JLogin.getUsuario().getUsu_login().equals("admin")) {
            try {
                moduloEstado = new JModuloEstado(this, true);
            } catch (Exception ex) {
                Logger.getLogger(JMenu.class.getName()).log(Level.SEVERE, null, ex);
            }
            moduloEstado.setVisible(true);
        }
    }//GEN-LAST:event_mnuEstadosActionPerformed

    private void mnuCidadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuCidadesActionPerformed
        // TODO add your handling code here:
         if (JLogin.getUsuario().getUsu_login().equals("admin")) {
            try {
                moduloCidade = new JModuloCidade(this, true);
            } catch (Exception ex) {
                Logger.getLogger(JMenu.class.getName()).log(Level.SEVERE, null, ex);
            }
            moduloCidade.setVisible(true);
        }
    }//GEN-LAST:event_mnuCidadesActionPerformed

    private void mnuBairrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuBairrosActionPerformed
        // TODO add your handling code here:
        if (JLogin.getUsuario().getUsu_login().equals("admin")) {
            try {
                moduloBairro = new JModuloBairro(this, true);
            } catch (Exception ex) {
                Logger.getLogger(JMenu.class.getName()).log(Level.SEVERE, null, ex);
            }
            moduloBairro.setVisible(true);
        }
    }//GEN-LAST:event_mnuBairrosActionPerformed

    private void mnuTipoLogradourosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuTipoLogradourosActionPerformed
        // TODO add your handling code here:
        JModuloTipoLogradouro tp = null;
        try {
            tp = new JModuloTipoLogradouro(this, true);
        } catch (Exception ex) {
            Logger.getLogger(JMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
        tp.setVisible(true);
    }//GEN-LAST:event_mnuTipoLogradourosActionPerformed

    private void mnuLogradourosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuLogradourosActionPerformed
        // TODO add your handling code here:
        JModuloLogradouro log = null;
        try {
            log = new JModuloLogradouro(this, true);
        } catch (Exception ex) {
            Logger.getLogger(JMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
        log.setVisible(true);
    }//GEN-LAST:event_mnuLogradourosActionPerformed

    private void mnuSiteBMGMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnuSiteBMGMouseClicked
        // TODO add your handling code here:
        Desktop desk = java.awt.Desktop.getDesktop();
    try {
         desk.browse(new java.net.URI("www.bmgconsig.com.br"));
    } catch (Exception e) {
         e.printStackTrace();
    }
    }//GEN-LAST:event_mnuSiteBMGMouseClicked

    private void mnuCalculoMargemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuCalculoMargemActionPerformed
        // TODO add your handling code here:
        JCalculoMargem c = new JCalculoMargem(this, true);
        c.setVisible(true);
    }//GEN-LAST:event_mnuCalculoMargemActionPerformed

    private void jMenuItem16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem16ActionPerformed
        // TODO add your handling code here:
        JImprimirRelatorio imprimi = new JImprimirRelatorio();
        try {
            imprimi.relatorioClientes();
        } catch (JRException ex) {
            Logger.getLogger(JMenu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(JMenu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(JMenu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Throwable ex) {
            Logger.getLogger(JMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem16ActionPerformed

    private void jMenuItem19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem19ActionPerformed
        // TODO add your handling code here:
        JCadastraClienteNovo cli = new JCadastraClienteNovo();
        cli.setVisible(true);
    }//GEN-LAST:event_jMenuItem19ActionPerformed

    private void jMenuItem22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem22ActionPerformed
        // TODO add your handling code here:
        JConsultaCliente consulta = new JConsultaCliente();
        consulta.setVisible(true);
    }//GEN-LAST:event_jMenuItem22ActionPerformed

    private void jMenuItem23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem23ActionPerformed
        // TODO add your handling code here:
        JModuloContrato contrato = null;
        try {
            contrato = new JModuloContrato();
        } catch (Exception ex) {
            Logger.getLogger(JMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
        contrato.setVisible(true);
    }//GEN-LAST:event_jMenuItem23ActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu10;
    private javax.swing.JMenu jMenu11;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem16;
    private javax.swing.JMenuItem jMenuItem17;
    private javax.swing.JMenuItem jMenuItem18;
    private javax.swing.JMenuItem jMenuItem19;
    private javax.swing.JMenuItem jMenuItem20;
    private javax.swing.JMenuItem jMenuItem21;
    private javax.swing.JMenuItem jMenuItem22;
    private javax.swing.JMenuItem jMenuItem23;
    private javax.swing.JMenuItem jMenuItem26;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel lblBemVindoUsuario;
    private javax.swing.JLabel lblHora;
    private javax.swing.JMenuItem mnuBackup;
    private javax.swing.JMenuItem mnuBairros;
    private javax.swing.JMenuItem mnuCalculadora;
    private javax.swing.JMenuItem mnuCalculoMargem;
    private javax.swing.JMenuItem mnuCidades;
    private javax.swing.JMenuItem mnuControleUsuario;
    private javax.swing.JMenuItem mnuEstados;
    private javax.swing.JMenuItem mnuLeiaMe;
    private javax.swing.JMenuItem mnuLog;
    private javax.swing.JMenuItem mnuLogradouros;
    private javax.swing.JMenuItem mnuOpcoes;
    private javax.swing.JMenuItem mnuSiteBMG;
    private javax.swing.JMenuItem mnuSobre;
    private javax.swing.JMenuItem mnuTipoLogradouros;
    private javax.swing.JMenuItem mnuTopicoAjuda;
    private javax.swing.JLabel txtCabecalho;
    // End of variables declaration//GEN-END:variables

}
