/*
 * JCadastraClienteNovo.java
 *
 * Created on 25/11/2011, 15:37:54
 */
package emprestimo.visao;

import emprestimo.modelo.dao.JBairroDao;
import emprestimo.modelo.dao.JBeneficioDao;
import emprestimo.modelo.dao.JCidadeDao;
import emprestimo.modelo.dao.JClienteDao;
import emprestimo.modelo.dao.JEstadoDao;
import emprestimo.modelo.dao.JLogradouroDao;
import emprestimo.modelo.dao.JTelefoneDao;
import emprestimo.modelo.dao.JTipoLogradouroDao;
import emprestimo.modelo.modelo.JBairro;
import emprestimo.modelo.modelo.JBeneficio;
import emprestimo.modelo.modelo.JCidade;
import emprestimo.modelo.modelo.JCliente;
import emprestimo.modelo.modelo.JEstado;
import emprestimo.modelo.modelo.JLogradouro;
import emprestimo.modelo.modelo.JTelefone;
import emprestimo.modelo.modelo.JTipoLogradouro;
import emprestimo.utilitario.JConverter;
import java.awt.Color;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 * @author Calex
 */
public class JCadastraClienteNovo extends javax.swing.JFrame {

    private JCliente cliente;
    private JClienteDao clienteDao;
    private JLogradouro logradouro;
    private JLogradouroDao logradouroDao;
    private JBeneficio beneficio;
    private JBeneficioDao beneficioDao;
    private JTelefone telefone;
    private JTelefoneDao telefoneDao;
    private JEstadoDao estadoDao;
    private JCidadeDao cidadeDao;
    private JBairroDao bairroDao;
    private JTipoLogradouroDao tipoLogDao;
    boolean novo = true;
    //private JTabelaCadastraCliente tabelaCadastraCliente = new JTabelaCadastraCliente();
    List<String> estado_civil = new ArrayList<String>();
    List<String> cod_inss = new ArrayList<String>();
    private DefaultComboBoxModel comboBoxEstado;
    private DefaultComboBoxModel comboBoxCidade;
    private DefaultComboBoxModel comboBoxBairro;
    private DefaultComboBoxModel comboBoxTipoLog;

    /** Creates new form JCadastraClienteNovo */
    public JCadastraClienteNovo() {
        initComponents();
        //tblTelefones.setModel(null);
        estadoDao = new JEstadoDao();
        cidadeDao = new JCidadeDao();
        bairroDao = new JBairroDao();
        clienteDao = new JClienteDao();
        tipoLogDao = new JTipoLogradouroDao();
        estado();
        estados_civil();
        cod_inss();
        preencherUf();
        preencherTipoLog();

    }

    public void limpar() {
    }

    private void exibir() {
    }

    private void estado() {
        cbxCodigoBeneficio1.setEnabled(false);
        txtNumBeneficio1.setEditable(false);
        txtDescricaoBeneficio1.setEditable(false);
        txtValorRenda1.setEditable(false);
        cbxCodigoBeneficio2.setEnabled(false);
        txtNumBeneficio2.setEditable(false);
        txtDescricaoBeneficio2.setEditable(false);
        txtValorRenda2.setEditable(false);
        cbxCodigoBeneficio3.setEnabled(false);
        txtNumBeneficio3.setEditable(false);
        txtDescricaoBeneficio3.setEditable(false);
        txtValorRenda3.setEditable(false);
    }

    private void mudaEstado1() {
        if (novo == true) {
            cbxCodigoBeneficio1.setEnabled(true);
            txtNumBeneficio1.setEditable(true);
            txtDescricaoBeneficio1.setEditable(true);
            txtValorRenda1.setEditable(true);
        } else {
            cbxCodigoBeneficio1.setEnabled(false);
            txtNumBeneficio1.setEditable(false);
            txtDescricaoBeneficio1.setEditable(false);
            txtValorRenda1.setEditable(false);
        }
    }

    private void mudaEstado2() {
        if (novo == true) {
            cbxCodigoBeneficio2.setEnabled(true);
            txtNumBeneficio2.setEditable(true);
            txtDescricaoBeneficio2.setEditable(true);
            txtValorRenda2.setEditable(true);
        } else {
            cbxCodigoBeneficio2.setEnabled(false);
            txtNumBeneficio2.setEditable(false);
            txtDescricaoBeneficio2.setEditable(false);
            txtValorRenda2.setEditable(false);
        }
    }

    private void mudaEstado3() {
        if (novo == true) {
            cbxCodigoBeneficio3.setEnabled(true);
            txtNumBeneficio3.setEditable(true);
            txtDescricaoBeneficio3.setEditable(true);
            txtValorRenda3.setEditable(true);
        } else {
            cbxCodigoBeneficio3.setEnabled(false);
            txtNumBeneficio3.setEditable(false);
            txtDescricaoBeneficio3.setEditable(false);
            txtValorRenda3.setEditable(false);
        }
    }
        private void estados_civil(){
        estado_civil.add("Solteiro");
        estado_civil.add("Casado");
        estado_civil.add("Divorciado");
        estado_civil.add("Viúvo");
        }

        private void cod_inss(){
            cod_inss.add("24");
            cod_inss.add("32");
        }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        abaBeneficio = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        panDadosPessoais = new javax.swing.JPanel();
        lblCpf = new javax.swing.JLabel();
        txtFormatCPF = new javax.swing.JFormattedTextField();
        lblNome = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        panSexo = new javax.swing.JPanel();
        jrbMasculino = new javax.swing.JRadioButton();
        jrbFeminino = new javax.swing.JRadioButton();
        lblDataNascimento = new javax.swing.JLabel();
        lblEstadoCivil = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        txtFormatDtNasc = new javax.swing.JFormattedTextField();
        cbxEstadoCivil = new javax.swing.JComboBox();
        txtEmail = new javax.swing.JTextField();
        panEndereco = new javax.swing.JPanel();
        lblTipoLogradouro = new javax.swing.JLabel();
        cbxTipoLogradouro = new javax.swing.JComboBox();
        lblLogradouro = new javax.swing.JLabel();
        txtLogradouro = new javax.swing.JTextField();
        lblNumero = new javax.swing.JLabel();
        txtNumero = new javax.swing.JTextField();
        lblComplemento = new javax.swing.JLabel();
        txtComplemento = new javax.swing.JTextField();
        lblCep = new javax.swing.JLabel();
        txtFormatCep = new javax.swing.JFormattedTextField();
        lblUf = new javax.swing.JLabel();
        cbxUf = new javax.swing.JComboBox();
        cbxCidade = new javax.swing.JComboBox();
        lblCidade = new javax.swing.JLabel();
        cbxBairro = new javax.swing.JComboBox();
        lblBairro = new javax.swing.JLabel();
        panTelefone = new javax.swing.JPanel();
        lblTipoTelefone = new javax.swing.JLabel();
        cbxTipoTelefone = new javax.swing.JComboBox();
        lblTelefone = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblTelefones = new javax.swing.JTable();
        btnAdicionarTel = new javax.swing.JButton();
        btnRemoverTel = new javax.swing.JButton();
        txtFormatTelefone = new javax.swing.JFormattedTextField();
        jPanel3 = new javax.swing.JPanel();
        panMenuBeneficio = new javax.swing.JPanel();
        panBeneficio1 = new javax.swing.JPanel();
        ckbxAdicionarBeneficio1 = new javax.swing.JCheckBox();
        cbxCodigoBeneficio1 = new javax.swing.JComboBox();
        txtDescricaoBeneficio1 = new javax.swing.JTextField();
        lblCodigoBeneficio1 = new javax.swing.JLabel();
        lblDescricaoBeneficio = new javax.swing.JLabel();
        lblvalorRenda1 = new javax.swing.JLabel();
        txtMargem1 = new javax.swing.JTextField();
        btnCalcularMargem1 = new javax.swing.JButton();
        lblMargem1 = new javax.swing.JLabel();
        txtValorRenda1 = new javax.swing.JTextField();
        txtNumBeneficio1 = new javax.swing.JTextField();
        panBeneficio2 = new javax.swing.JPanel();
        ckbxAdicionarBeneficio2 = new javax.swing.JCheckBox();
        lblCodigoBeneficio2 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        cbxCodigoBeneficio2 = new javax.swing.JComboBox();
        txtDescricaoBeneficio2 = new javax.swing.JTextField();
        lblvalorRenda2 = new javax.swing.JLabel();
        txtMargem2 = new javax.swing.JTextField();
        btnCalcularMargem2 = new javax.swing.JButton();
        lblMargem2 = new javax.swing.JLabel();
        txtValorRenda2 = new javax.swing.JTextField();
        txtNumBeneficio2 = new javax.swing.JTextField();
        panBeneficio3 = new javax.swing.JPanel();
        ckbxAdicionarBeneficio3 = new javax.swing.JCheckBox();
        lblCodigoBeneficio3 = new javax.swing.JLabel();
        cbxCodigoBeneficio3 = new javax.swing.JComboBox();
        txtDescricaoBeneficio3 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        lblvalorRenda3 = new javax.swing.JLabel();
        txtMargem3 = new javax.swing.JTextField();
        btnCalcularMargem3 = new javax.swing.JButton();
        lblMargem3 = new javax.swing.JLabel();
        txtValorRenda3 = new javax.swing.JTextField();
        txtNumBeneficio3 = new javax.swing.JTextField();
        btnCancelar = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        btnGravar = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SisFEC - Cadastro de Clientes");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 153, 51));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 80));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 80, Short.MAX_VALUE)
        );

        panDadosPessoais.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados Pessoais", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(51, 51, 255)));

        lblCpf.setText("CPF:");

        try {
            txtFormatCPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtFormatCPF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFormatCPFKeyTyped(evt);
            }
        });

        lblNome.setText("Nome:");

        txtNome.setToolTipText("");

        panSexo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Sexo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(51, 51, 255)));

        buttonGroup1.add(jrbMasculino);
        jrbMasculino.setText("Masculino");

        buttonGroup1.add(jrbFeminino);
        jrbFeminino.setText("Feminino");

        javax.swing.GroupLayout panSexoLayout = new javax.swing.GroupLayout(panSexo);
        panSexo.setLayout(panSexoLayout);
        panSexoLayout.setHorizontalGroup(
            panSexoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panSexoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jrbMasculino)
                .addGap(18, 18, 18)
                .addComponent(jrbFeminino)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panSexoLayout.setVerticalGroup(
            panSexoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panSexoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panSexoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jrbFeminino)
                    .addComponent(jrbMasculino))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        lblDataNascimento.setText("Data de Nascimento:");

        lblEstadoCivil.setText("Estado Civil:");

        lblEmail.setText("E-Mail:");

        try {
            txtFormatDtNasc.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        cbxEstadoCivil.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione" }));

        txtEmail.setForeground(new java.awt.Color(204, 204, 204));
        txtEmail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtEmailFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtEmailFocusLost(evt);
            }
        });
        txtEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEmailKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout panDadosPessoaisLayout = new javax.swing.GroupLayout(panDadosPessoais);
        panDadosPessoais.setLayout(panDadosPessoaisLayout);
        panDadosPessoaisLayout.setHorizontalGroup(
            panDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panDadosPessoaisLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panDadosPessoaisLayout.createSequentialGroup()
                        .addGroup(panDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCpf)
                            .addComponent(txtFormatCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addGroup(panDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNome)
                            .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panDadosPessoaisLayout.createSequentialGroup()
                        .addGroup(panDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDataNascimento)
                            .addComponent(txtFormatDtNasc, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addGroup(panDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblEstadoCivil)
                            .addComponent(cbxEstadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(panDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panDadosPessoaisLayout.createSequentialGroup()
                                .addComponent(lblEmail)
                                .addGap(27, 27, 27))
                            .addComponent(txtEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE))))
                .addGap(26, 26, 26)
                .addComponent(panSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );
        panDadosPessoaisLayout.setVerticalGroup(
            panDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panDadosPessoaisLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panDadosPessoaisLayout.createSequentialGroup()
                        .addGroup(panDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCpf)
                            .addComponent(lblNome))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtFormatCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblDataNascimento)
                            .addComponent(lblEstadoCivil)
                            .addComponent(lblEmail))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtFormatDtNasc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxEstadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panEndereco.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Endereço", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(51, 51, 255)));

        lblTipoLogradouro.setText("Tipo Logradouro:");

        cbxTipoLogradouro.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione" }));

        lblLogradouro.setText("Logradouro:");

        lblNumero.setText("N°");

        lblComplemento.setText("Complemento:");

        lblCep.setText("CEP:");

        try {
            txtFormatCep.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        lblUf.setText("UF:");

        cbxUf.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione" }));
        cbxUf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxUfActionPerformed(evt);
            }
        });

        cbxCidade.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione" }));
        cbxCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxCidadeActionPerformed(evt);
            }
        });

        lblCidade.setText("Cidade:");

        cbxBairro.setToolTipText("Selecione");

        lblBairro.setText("Bairro:");

        javax.swing.GroupLayout panEnderecoLayout = new javax.swing.GroupLayout(panEndereco);
        panEndereco.setLayout(panEnderecoLayout);
        panEnderecoLayout.setHorizontalGroup(
            panEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panEnderecoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTipoLogradouro)
                    .addComponent(cbxTipoLogradouro, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUf)
                    .addComponent(cbxUf, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(panEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panEnderecoLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(panEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblLogradouro)
                            .addComponent(txtLogradouro, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addGroup(panEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panEnderecoLayout.createSequentialGroup()
                                .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panEnderecoLayout.createSequentialGroup()
                                .addComponent(lblNumero)
                                .addGap(47, 47, 47)
                                .addComponent(lblComplemento)))
                        .addGap(18, 18, 18)
                        .addGroup(panEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtFormatCep, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCep)))
                    .addGroup(panEnderecoLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbxCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCidade))
                        .addGap(18, 18, 18)
                        .addGroup(panEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbxBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblBairro))))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        panEnderecoLayout.setVerticalGroup(
            panEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panEnderecoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTipoLogradouro)
                    .addComponent(lblLogradouro)
                    .addComponent(lblNumero)
                    .addComponent(lblComplemento)
                    .addComponent(lblCep))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxTipoLogradouro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtLogradouro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFormatCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(panEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panEnderecoLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(lblUf)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panEnderecoLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCidade)
                            .addComponent(lblBairro))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(panEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxUf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        panTelefone.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Telefone", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(51, 51, 255)));

        lblTipoTelefone.setText("Tipo:");

        lblTelefone.setText("Telefone:");

        tblTelefones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null}
            },
            new String [] {
                "Tipo", "Telefone"
            }
        ));
        jScrollPane2.setViewportView(tblTelefones);

        btnAdicionarTel.setText("Adicionar");

        btnRemoverTel.setText("Remover");

        try {
            txtFormatTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)-####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout panTelefoneLayout = new javax.swing.GroupLayout(panTelefone);
        panTelefone.setLayout(panTelefoneLayout);
        panTelefoneLayout.setHorizontalGroup(
            panTelefoneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panTelefoneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panTelefoneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTipoTelefone)
                    .addComponent(cbxTipoTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panTelefoneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTelefone)
                    .addComponent(txtFormatTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(panTelefoneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAdicionarTel)
                    .addComponent(btnRemoverTel))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
                .addGap(45, 45, 45))
        );
        panTelefoneLayout.setVerticalGroup(
            panTelefoneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panTelefoneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panTelefoneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTipoTelefone)
                    .addComponent(lblTelefone))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panTelefoneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxTipoTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdicionarTel)
                    .addComponent(txtFormatTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnRemoverTel)
                .addContainerGap(23, Short.MAX_VALUE))
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panDadosPessoais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(panEndereco, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panTelefone, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panDadosPessoais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(panTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        abaBeneficio.addTab("Dados Pessoais", jPanel2);

        panMenuBeneficio.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Benefício", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(51, 51, 255)));

        panBeneficio1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Benefício 1", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(51, 51, 255)));

        ckbxAdicionarBeneficio1.setText("Adicionar Benefício");
        ckbxAdicionarBeneficio1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ckbxAdicionarBeneficio1ItemStateChanged(evt);
            }
        });

        lblCodigoBeneficio1.setText("Código Benefício:");

        lblDescricaoBeneficio.setText("Descrição do Benefício:");

        lblvalorRenda1.setText("Valor da Renda:");

        txtMargem1.setEditable(false);

        btnCalcularMargem1.setText("Calcular Margem");

        lblMargem1.setText("Margem:");

        javax.swing.GroupLayout panBeneficio1Layout = new javax.swing.GroupLayout(panBeneficio1);
        panBeneficio1.setLayout(panBeneficio1Layout);
        panBeneficio1Layout.setHorizontalGroup(
            panBeneficio1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panBeneficio1Layout.createSequentialGroup()
                .addGroup(panBeneficio1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panBeneficio1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(ckbxAdicionarBeneficio1)
                        .addGap(18, 18, 18)
                        .addComponent(txtNumBeneficio1))
                    .addGroup(panBeneficio1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(panBeneficio1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbxCodigoBeneficio1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblCodigoBeneficio1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(panBeneficio1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDescricaoBeneficio1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDescricaoBeneficio))))
                .addGap(18, 18, 18)
                .addGroup(panBeneficio1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtValorRenda1)
                    .addComponent(lblvalorRenda1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(panBeneficio1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panBeneficio1Layout.createSequentialGroup()
                        .addComponent(txtMargem1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCalcularMargem1))
                    .addComponent(lblMargem1))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        panBeneficio1Layout.setVerticalGroup(
            panBeneficio1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panBeneficio1Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(panBeneficio1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ckbxAdicionarBeneficio1)
                    .addComponent(txtNumBeneficio1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(panBeneficio1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCodigoBeneficio1)
                    .addComponent(lblDescricaoBeneficio)
                    .addComponent(lblvalorRenda1)
                    .addComponent(lblMargem1))
                .addGap(13, 13, 13)
                .addGroup(panBeneficio1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxCodigoBeneficio1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDescricaoBeneficio1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMargem1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtValorRenda1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCalcularMargem1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panBeneficio2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Beneficio 2", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(51, 51, 255)));

        ckbxAdicionarBeneficio2.setText("Adicionar Benefício");
        ckbxAdicionarBeneficio2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ckbxAdicionarBeneficio2ItemStateChanged(evt);
            }
        });

        lblCodigoBeneficio2.setText("Código Benefício:");

        jLabel12.setText("Descrição do Benefício:");

        lblvalorRenda2.setText("Valor da Renda:");

        txtMargem2.setEditable(false);

        btnCalcularMargem2.setText("Calcular Margem");

        lblMargem2.setText("Margem:");

        javax.swing.GroupLayout panBeneficio2Layout = new javax.swing.GroupLayout(panBeneficio2);
        panBeneficio2.setLayout(panBeneficio2Layout);
        panBeneficio2Layout.setHorizontalGroup(
            panBeneficio2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panBeneficio2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panBeneficio2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panBeneficio2Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(panBeneficio2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblCodigoBeneficio2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbxCodigoBeneficio2, 0, 84, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(panBeneficio2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDescricaoBeneficio2, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12)))
                    .addGroup(panBeneficio2Layout.createSequentialGroup()
                        .addComponent(ckbxAdicionarBeneficio2)
                        .addGap(18, 18, 18)
                        .addComponent(txtNumBeneficio2)))
                .addGap(18, 18, 18)
                .addGroup(panBeneficio2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtValorRenda2)
                    .addComponent(lblvalorRenda2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(panBeneficio2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panBeneficio2Layout.createSequentialGroup()
                        .addComponent(txtMargem2, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCalcularMargem2))
                    .addComponent(lblMargem2))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        panBeneficio2Layout.setVerticalGroup(
            panBeneficio2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panBeneficio2Layout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addGroup(panBeneficio2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ckbxAdicionarBeneficio2)
                    .addComponent(txtNumBeneficio2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panBeneficio2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panBeneficio2Layout.createSequentialGroup()
                        .addGroup(panBeneficio2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCodigoBeneficio2)
                            .addComponent(jLabel12))
                        .addGap(31, 31, 31))
                    .addGroup(panBeneficio2Layout.createSequentialGroup()
                        .addGroup(panBeneficio2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblvalorRenda2)
                            .addComponent(lblMargem2))
                        .addGap(18, 18, 18)
                        .addGroup(panBeneficio2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbxCodigoBeneficio2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDescricaoBeneficio2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMargem2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtValorRenda2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCalcularMargem2))))
                .addGap(14, 14, 14))
        );

        panBeneficio3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Benefício 3", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(51, 51, 255)));

        ckbxAdicionarBeneficio3.setText("Adicionar Benefício");
        ckbxAdicionarBeneficio3.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ckbxAdicionarBeneficio3ItemStateChanged(evt);
            }
        });

        lblCodigoBeneficio3.setText("Código Benefício:");

        jLabel16.setText("Descrição do Benefício:");

        lblvalorRenda3.setText("Valor da Renda:");

        txtMargem3.setEditable(false);

        btnCalcularMargem3.setText("Calcular Margem");

        lblMargem3.setText("Margem:");

        javax.swing.GroupLayout panBeneficio3Layout = new javax.swing.GroupLayout(panBeneficio3);
        panBeneficio3.setLayout(panBeneficio3Layout);
        panBeneficio3Layout.setHorizontalGroup(
            panBeneficio3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panBeneficio3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panBeneficio3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panBeneficio3Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(panBeneficio3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(cbxCodigoBeneficio3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblCodigoBeneficio3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(panBeneficio3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDescricaoBeneficio3, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16)))
                    .addGroup(panBeneficio3Layout.createSequentialGroup()
                        .addComponent(ckbxAdicionarBeneficio3)
                        .addGap(18, 18, 18)
                        .addComponent(txtNumBeneficio3)))
                .addGap(18, 18, 18)
                .addGroup(panBeneficio3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtValorRenda3)
                    .addComponent(lblvalorRenda3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(panBeneficio3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panBeneficio3Layout.createSequentialGroup()
                        .addComponent(txtMargem3, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCalcularMargem3))
                    .addComponent(lblMargem3))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        panBeneficio3Layout.setVerticalGroup(
            panBeneficio3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panBeneficio3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panBeneficio3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ckbxAdicionarBeneficio3)
                    .addComponent(txtNumBeneficio3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(panBeneficio3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(lblCodigoBeneficio3)
                    .addComponent(lblvalorRenda3)
                    .addComponent(lblMargem3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panBeneficio3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxCodigoBeneficio3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDescricaoBeneficio3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMargem3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtValorRenda3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCalcularMargem3))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panMenuBeneficioLayout = new javax.swing.GroupLayout(panMenuBeneficio);
        panMenuBeneficio.setLayout(panMenuBeneficioLayout);
        panMenuBeneficioLayout.setHorizontalGroup(
            panMenuBeneficioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panMenuBeneficioLayout.createSequentialGroup()
                .addGroup(panMenuBeneficioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(panBeneficio1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panBeneficio2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panBeneficio3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        panMenuBeneficioLayout.setVerticalGroup(
            panMenuBeneficioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panMenuBeneficioLayout.createSequentialGroup()
                .addComponent(panBeneficio1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panBeneficio2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panBeneficio3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(panMenuBeneficio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(82, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panMenuBeneficio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        abaBeneficio.addTab("Benefício", jPanel3);

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

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
                .addGap(520, 520, 520)
                .addComponent(btnGravar, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(abaBeneficio, javax.swing.GroupLayout.DEFAULT_SIZE, 780, Short.MAX_VALUE)
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnCancelar, btnGravar, btnLimpar});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(abaBeneficio, javax.swing.GroupLayout.PREFERRED_SIZE, 508, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnLimpar)
                    .addComponent(btnGravar))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        java.awt.Dimension dialogSize = getSize();
        setLocation((screenSize.width-dialogSize.width)/2,(screenSize.height-dialogSize.height)/2);
    }// </editor-fold>//GEN-END:initComponents

    private void txtEmailFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEmailFocusGained
        // TODO add your handling code here:
        txtEmail.setText("");
        txtEmail.setForeground(Color.black);
    }//GEN-LAST:event_txtEmailFocusGained

    private void btnGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGravarActionPerformed
        // TODO add your handling code here:
        if (!txtLogradouro.getText().isEmpty()) {
            // Dados Endereço:
            String strLogradouro = txtLogradouro.getText();
            String strNum = txtNumero.getText();
            String strComplemento = txtComplemento.getText();
            String strCep = txtFormatCep.getText();
            String strTipoLogradouro = cbxTipoLogradouro.getSelectedItem().toString();
            String strBairro = cbxBairro.getSelectedItem().toString();

            logradouro = new JLogradouro();
            logradouro.setLog_desc(strLogradouro);
            logradouro.setLog_num(Integer.parseInt(strNum));
            logradouro.setLog_compl(strComplemento);
            logradouro.setLog_cep(strCep);
            logradouro.setTpl_Log(null);
            logradouro.setBairro(null);

        } else if (!txtNome.getText().isEmpty()) {
            // Dados Cliente
            String cpf = txtFormatCPF.getText();
            String nome = txtNome.getText();
            String dataNasc = txtFormatDtNasc.getText();
            String email = txtEmail.getText();
            String estCivil = cbxEstadoCivil.getSelectedItem().toString();

            cliente = new JCliente();

            cliente.setCli_cpf(cpf);
            cliente.setCli_nome(nome);
            cliente.setCli_sexo(jrbMasculino.isSelected() ? "M" : "F");
            try {
                cliente.setCli_dtnasc(JConverter.converteStringToDate(dataNasc));
            } catch (ParseException ex) {
                Logger.getLogger(JCadastraClienteNovo.class.getName()).log(Level.SEVERE, null, ex);
            }
            cliente.setCli_email(email);
            cliente.setCli_estadocivil(estCivil);
            cliente.setLogradouro(this.logradouro);


        } else if (!ckbxAdicionarBeneficio1.isSelected()) {
            int sim = JOptionPane.showConfirmDialog(null, "Adicionar Benefício ao Cliente?", "Mensagem?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (sim == JOptionPane.YES_OPTION) {
                abaBeneficio.setVisible(true);


            String benNum1 = txtNumBeneficio1.getText();
            //String benInss1 = cbxCodigoBeneficio1.getSelectedItem().toString();
            String benDesc1 = txtDescricaoBeneficio1.getText();
            String renda1 = txtValorRenda1.getText();

            String benNum2 = txtNumBeneficio1.getText();
            //String benInss2 = cbxCodigoBeneficio2.getSelectedItem().toString();
            String benDesc2 = txtDescricaoBeneficio2.getText();
            String renda2 = txtValorRenda2.getText();


            String benNum3 = txtNumBeneficio1.getText();
            //String benInss3 = cbxCodigoBeneficio3.getSelectedItem().toString();
            String benDesc3 = txtDescricaoBeneficio3.getText();
            String renda3 = txtValorRenda3.getText();
                
                beneficio = new JBeneficio();
                beneficio.setBen_numero(Integer.parseInt(benNum1));
                beneficio.setBen_codInss(sim);
                beneficio.setBen_desc(benDesc3);
                beneficio.setBen_renda(Double.MAX_VALUE);
        } else {

            }
        }

                int opcao = JOptionPane.showConfirmDialog(null, "Deseja Gravar Dados do Cliente?", "Confirma?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (opcao == JOptionPane.YES_OPTION) {
                    try {
                         logradouroDao.inserir(logradouro);
                        clienteDao.inserir(cliente);
                        beneficioDao.inserir(beneficio);
                        JOptionPane.showMessageDialog(null, "Cliente Cadastrado com Sucesso!", "Cadastrado!", JOptionPane.INFORMATION_MESSAGE);
                        setVisible(false);
                    } catch (Exception ex) {
                        Logger.getLogger(JCadastraClienteNovo.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Cliente Não Cadastrado!", "Error!", JOptionPane.ERROR_MESSAGE);
                }

    }//GEN-LAST:event_btnGravarActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLimparActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        setVisible(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void ckbxAdicionarBeneficio1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ckbxAdicionarBeneficio1ItemStateChanged
        // TODO add your handling code here:
        if (ckbxAdicionarBeneficio1.isSelected()) {
            novo = true;
            mudaEstado1();
        } else {
            novo = false;
            mudaEstado1();
        }
    }//GEN-LAST:event_ckbxAdicionarBeneficio1ItemStateChanged

    private void ckbxAdicionarBeneficio2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ckbxAdicionarBeneficio2ItemStateChanged
        // TODO add your handling code here:
        if (ckbxAdicionarBeneficio2.isSelected()) {
            novo = true;
            mudaEstado2();
        } else {
            novo = false;
            mudaEstado2();
        }
    }//GEN-LAST:event_ckbxAdicionarBeneficio2ItemStateChanged

    private void ckbxAdicionarBeneficio3ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ckbxAdicionarBeneficio3ItemStateChanged
        // TODO add your handling code here:
        if (ckbxAdicionarBeneficio3.isSelected()) {
            novo = true;
            mudaEstado3();
        } else {
            novo = false;
            mudaEstado3();
        }
    }//GEN-LAST:event_ckbxAdicionarBeneficio3ItemStateChanged

    private void txtEmailKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmailKeyTyped
        // TODO add your handling code here:
        /*if (txtEmail.getText().indexOf("@")>0) {
            evt.consume();
        }*/
    }//GEN-LAST:event_txtEmailKeyTyped

    private void txtFormatCPFKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFormatCPFKeyTyped
        // TODO add your handling code here:
        String letras = "qwertyuiopasdfghjklçzxcvbnm";
        if (letras.indexOf(evt.getKeyChar()) >= 0) {
            evt.consume();
            return;
        }
    }//GEN-LAST:event_txtFormatCPFKeyTyped

    private void txtEmailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEmailFocusLost
        // TODO add your handling code here:
        //JOptionPane.showMessageDialog(null, "Favor, inserir um e-mail válido!", "Atenção", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_txtEmailFocusLost

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        for (String civil : estado_civil) {
            cbxEstadoCivil.addItem(civil);
        }

        for (String inss : cod_inss) {
            cbxCodigoBeneficio1.addItem(inss);
            cbxCodigoBeneficio2.addItem(inss);
            cbxCodigoBeneficio3.addItem(inss);
        }
    }//GEN-LAST:event_formWindowOpened

    private void cbxUfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxUfActionPerformed
        // TODO add your handling code here:
        preencherCidade();
    }//GEN-LAST:event_cbxUfActionPerformed

    private void cbxCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxCidadeActionPerformed
        // TODO add your handling code here:
        preencherBairro();
    }//GEN-LAST:event_cbxCidadeActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new JCadastraClienteNovo().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane abaBeneficio;
    private javax.swing.JButton btnAdicionarTel;
    private javax.swing.JButton btnCalcularMargem1;
    private javax.swing.JButton btnCalcularMargem2;
    private javax.swing.JButton btnCalcularMargem3;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGravar;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnRemoverTel;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox cbxBairro;
    private javax.swing.JComboBox cbxCidade;
    private javax.swing.JComboBox cbxCodigoBeneficio1;
    private javax.swing.JComboBox cbxCodigoBeneficio2;
    private javax.swing.JComboBox cbxCodigoBeneficio3;
    private javax.swing.JComboBox cbxEstadoCivil;
    private javax.swing.JComboBox cbxTipoLogradouro;
    private javax.swing.JComboBox cbxTipoTelefone;
    private javax.swing.JComboBox cbxUf;
    private javax.swing.JCheckBox ckbxAdicionarBeneficio1;
    private javax.swing.JCheckBox ckbxAdicionarBeneficio2;
    private javax.swing.JCheckBox ckbxAdicionarBeneficio3;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JRadioButton jrbFeminino;
    private javax.swing.JRadioButton jrbMasculino;
    private javax.swing.JLabel lblBairro;
    private javax.swing.JLabel lblCep;
    private javax.swing.JLabel lblCidade;
    private javax.swing.JLabel lblCodigoBeneficio1;
    private javax.swing.JLabel lblCodigoBeneficio2;
    private javax.swing.JLabel lblCodigoBeneficio3;
    private javax.swing.JLabel lblComplemento;
    private javax.swing.JLabel lblCpf;
    private javax.swing.JLabel lblDataNascimento;
    private javax.swing.JLabel lblDescricaoBeneficio;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblEstadoCivil;
    private javax.swing.JLabel lblLogradouro;
    private javax.swing.JLabel lblMargem1;
    private javax.swing.JLabel lblMargem2;
    private javax.swing.JLabel lblMargem3;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblNumero;
    private javax.swing.JLabel lblTelefone;
    private javax.swing.JLabel lblTipoLogradouro;
    private javax.swing.JLabel lblTipoTelefone;
    private javax.swing.JLabel lblUf;
    private javax.swing.JLabel lblvalorRenda1;
    private javax.swing.JLabel lblvalorRenda2;
    private javax.swing.JLabel lblvalorRenda3;
    private javax.swing.JPanel panBeneficio1;
    private javax.swing.JPanel panBeneficio2;
    private javax.swing.JPanel panBeneficio3;
    private javax.swing.JPanel panDadosPessoais;
    private javax.swing.JPanel panEndereco;
    private javax.swing.JPanel panMenuBeneficio;
    private javax.swing.JPanel panSexo;
    private javax.swing.JPanel panTelefone;
    private javax.swing.JTable tblTelefones;
    private javax.swing.JTextField txtComplemento;
    private javax.swing.JTextField txtDescricaoBeneficio1;
    private javax.swing.JTextField txtDescricaoBeneficio2;
    private javax.swing.JTextField txtDescricaoBeneficio3;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JFormattedTextField txtFormatCPF;
    private javax.swing.JFormattedTextField txtFormatCep;
    private javax.swing.JFormattedTextField txtFormatDtNasc;
    private javax.swing.JFormattedTextField txtFormatTelefone;
    private javax.swing.JTextField txtLogradouro;
    private javax.swing.JTextField txtMargem1;
    private javax.swing.JTextField txtMargem2;
    private javax.swing.JTextField txtMargem3;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtNumBeneficio1;
    private javax.swing.JTextField txtNumBeneficio2;
    private javax.swing.JTextField txtNumBeneficio3;
    private javax.swing.JTextField txtNumero;
    private javax.swing.JTextField txtValorRenda1;
    private javax.swing.JTextField txtValorRenda2;
    private javax.swing.JTextField txtValorRenda3;
    // End of variables declaration//GEN-END:variables

    public javax.swing.JComboBox getCbxEstado() {
        return cbxUf;
    }

        public javax.swing.JComboBox getCbxCidade() {
        return cbxCidade;
    }

    public javax.swing.JComboBox getCbxBairro() {
        return cbxBairro;
    }

    public javax.swing.JComboBox getCbxTipoLogradouro() {
        return cbxTipoLogradouro;
    }

        private void preencherTipoLog() {
        try {
            List<JTipoLogradouro> tipos;
            tipos = tipoLogDao.retornaListaTiposdeLogradouro();
            comboBoxTipoLog = new DefaultComboBoxModel(tipos.toArray());
            getCbxTipoLogradouro().setModel(comboBoxTipoLog);
            comboBoxTipoLog.setSelectedItem(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void preencherUf() {
        try {
            List<JEstado> estados;
            estados = estadoDao.retornaListaEstados();
            comboBoxEstado = new DefaultComboBoxModel(estados.toArray());
            getCbxEstado().setModel(comboBoxEstado);
            comboBoxEstado.setSelectedItem(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        cbxCidade.setSelectedItem(null);
        cbxCidade.setEnabled(false);
    }

        private void preencherCidade() {
            List<JCidade> cidades;
        try {
            if (comboBoxEstado != null && cbxUf.getSelectedItem() instanceof JEstado) {
                cidades = cidadeDao.retornaListaCidadePorEstado(((JEstado) cbxUf.getSelectedItem()).getEst_cod());
                comboBoxCidade = new DefaultComboBoxModel(cidades.toArray());
                getCbxCidade().setModel(comboBoxCidade);
                cbxCidade.setSelectedItem(null);
                cbxCidade.setEnabled(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
            cbxBairro.setSelectedItem(null);
            cbxBairro.setEnabled(false);
    }

    private void preencherBairro() {
        List<JBairro> bairros;
        try {
            if (comboBoxCidade != null && cbxCidade.getSelectedItem() instanceof JCidade) {
                bairros = bairroDao.retornaListaBairrosPorCidade(((JCidade) cbxCidade.getSelectedItem()).getCid_cod());
                comboBoxBairro = new DefaultComboBoxModel(bairros.toArray());
                getCbxBairro().setModel(comboBoxBairro);
                cbxBairro.setSelectedItem(null);
                cbxBairro.setEnabled(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
