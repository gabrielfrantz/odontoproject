package tela;

import entidade.Fornecedor;
import java.awt.Dimension;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import persistencia.Formatacao;
import persistencia.FornecedorDAO;
import persistencia.Validacao;

/**
 *
 * @author gabriel.frantz
 */
public class IfrmFornecedores extends javax.swing.JInternalFrame {

    Formatacao f = new Formatacao();
    Validacao v = new Validacao();
    int codigo = 0;

    public IfrmFornecedores() {
        initComponents();
        btnEditar.setEnabled(false);
    }

    public void limpaCampos() {
        txtNomeFornecedor.setText(null);
        txtEmail.setText(null);
        txtTelefone.setText(null);
        txtCNPJ.setText(null);
        txtTipo.setText(null);
        txtLongradouro.setText(null);
        txtNumero.setText(null);
        txtComplemento.setText(null);
        txtBairro.setText(null);
        txtCidade.setText(null);
        txtEstado.setText(null);
        txtUF.setText(null);
    }

    public void ValidaNumero(JTextField Numero) {
        long valor;
        if (Numero.getText().length() != 0) {
            try {
                valor = Long.parseLong(Numero.getText());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Esse campo só aceita números, preencha-o novamente!", "Informação", JOptionPane.INFORMATION_MESSAGE);
                Numero.grabFocus();
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuFornecedor = new javax.swing.JTabbedPane();
        JPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNomeFornecedor = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtTelefone = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtCNPJ = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtTipo = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtLongradouro = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtNumero = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtComplemento = new javax.swing.JTextField();
        txtBairro = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtCidade = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtEstado = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtUF = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblFornecedor = new javax.swing.JTable();
        btnSalvar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Cadastro de Fornecedores");

        jLabel2.setText("Razão Social do Fornecedor:*");

        jLabel3.setText("Telefone:*");

        txtTelefone = Formatacao.getTelefone();

        jLabel4.setText("CNPJ:*");

        txtCNPJ = Formatacao.getCNPJ();

        jLabel6.setText("Tipo:*");

        jLabel7.setText("Longradouro:*");

        jLabel8.setText("Número:*");

        jLabel9.setText("Complemento:");

        jLabel11.setText("Cidade:*");

        jLabel12.setText("Estado:*");

        jLabel13.setText("UF:*");

        jLabel5.setText("E-mail:*");

        jLabel10.setText("Bairro:*");

        javax.swing.GroupLayout JPanel1Layout = new javax.swing.GroupLayout(JPanel1);
        JPanel1.setLayout(JPanel1Layout);
        JPanel1Layout.setHorizontalGroup(
            JPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPanel1Layout.createSequentialGroup()
                .addGroup(JPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JPanel1Layout.createSequentialGroup()
                        .addGap(253, 253, 253)
                        .addComponent(jLabel1))
                    .addGroup(JPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(JPanel1Layout.createSequentialGroup()
                        .addGap(360, 360, 360)
                        .addComponent(jLabel10)))
                .addContainerGap(288, Short.MAX_VALUE))
            .addGroup(JPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(JPanel1Layout.createSequentialGroup()
                    .addGap(33, 33, 33)
                    .addGroup(JPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(JPanel1Layout.createSequentialGroup()
                            .addGroup(JPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, JPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel11)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, JPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel8)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jLabel9)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtComplemento)))
                            .addGap(16, 16, 16)
                            .addGroup(JPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(JPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel12)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                                    .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel13)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtUF, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(JPanel1Layout.createSequentialGroup()
                                    .addGap(0, 0, Short.MAX_VALUE)
                                    .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(JPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addGap(18, 18, 18)
                            .addComponent(txtNomeFornecedor))
                        .addGroup(JPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel6)
                            .addGap(18, 18, 18)
                            .addComponent(txtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addGroup(JPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel7)
                                .addComponent(jLabel3))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(JPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(JPanel1Layout.createSequentialGroup()
                                    .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jLabel4)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtCNPJ))
                                .addComponent(txtLongradouro))))
                    .addContainerGap(54, Short.MAX_VALUE)))
        );
        JPanel1Layout.setVerticalGroup(
            JPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(112, 112, 112)
                .addGroup(JPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 98, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addGap(151, 151, 151))
            .addGroup(JPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(JPanel1Layout.createSequentialGroup()
                    .addGap(88, 88, 88)
                    .addGroup(JPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(txtNomeFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(37, 37, 37)
                    .addGroup(JPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)
                        .addComponent(txtCNPJ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(37, 37, 37)
                    .addGroup(JPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel6)
                        .addGroup(JPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(txtLongradouro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(39, 39, 39)
                    .addGroup(JPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9)
                        .addComponent(txtComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(38, 38, 38)
                    .addGroup(JPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11)
                        .addComponent(txtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel12)
                        .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel13)
                        .addComponent(txtUF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(89, Short.MAX_VALUE)))
        );

        menuFornecedor.addTab("Cadastro", JPanel1);

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel14.setText("Buscar:");

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        tblFornecedor.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblFornecedor);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 625, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 752, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addContainerGap(390, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                    .addContainerGap(59, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );

        menuFornecedor.addTab("Consulta", jPanel3);

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(menuFornecedor)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnSalvar)
                        .addGap(18, 18, 18)
                        .addComponent(btnEditar)
                        .addGap(22, 22, 22)
                        .addComponent(btnSair)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(menuFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 456, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar)
                    .addComponent(btnEditar)
                    .addComponent(btnSair))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        new FornecedorDAO().popularTabela(tblFornecedor, txtBuscar.getText());
        btnEditar.setEnabled(true);
        btnSalvar.setEnabled(false);
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        int linha = tblFornecedor.getSelectedRow();
        if (linha > -1) {
            btnEditar.setEnabled(false);
            btnSalvar.setEnabled(true);
            String codigoS = String.valueOf(tblFornecedor.getValueAt(tblFornecedor.getSelectedRow(), 0));
            Fornecedor fornecedor = new FornecedorDAO().consultarId(Integer.parseInt(codigoS));
            ((DefaultTableModel) tblFornecedor.getModel()).setRowCount(0);
            if (fornecedor != null) {
                menuFornecedor.setSelectedIndex(0);
                txtNomeFornecedor.setText(fornecedor.getNome());
                txtEmail.setText(fornecedor.getEmail());
                txtTelefone.setText(fornecedor.getTelefone());
                txtCNPJ.setText(fornecedor.getCnpj());
                txtTipo.setText(fornecedor.getTipo_longradouro());
                txtLongradouro.setText(fornecedor.getLongradouro());
                txtNumero.setText(String.valueOf(fornecedor.getNumero()));
                txtComplemento.setText(fornecedor.getComplemento());
                txtBairro.setText(fornecedor.getBairro());
                txtCidade.setText(fornecedor.getCidade());
                txtEstado.setText(fornecedor.getEstado());
                txtUF.setText(fornecedor.getUf());
                txtNomeFornecedor.requestFocus();
                codigo = fornecedor.getId();
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao consultar registro!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um fornecedor para editar!", "Informação", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        Fornecedor fornecedor = new Fornecedor();
        FornecedorDAO fornecedorDao = new FornecedorDAO();
        fornecedor.setId(codigo);
        if (txtNomeFornecedor.getText() == null || txtNomeFornecedor.getText().isEmpty() || txtNomeFornecedor.getText().length() < 4 || (txtNomeFornecedor.getText().contains("-")) || (txtNomeFornecedor.getText().contains(",")) || (txtNomeFornecedor.getText().contains("."))) {
            JOptionPane.showMessageDialog(this, "Campo razão social em branco, incorreto ou com menos de 4 caracteres!");
            txtNomeFornecedor.requestFocus();
        } else {
            fornecedor.setNome(txtNomeFornecedor.getText());
            if (txtEmail.getText() == null || txtEmail.getText().isEmpty() || txtEmail.getText().length() < 4 || (!txtEmail.getText().contains("@"))) {
                fornecedor.setEmail("");
                JOptionPane.showMessageDialog(this, "Campo email em branco ou incorreto, insira-o novamente!");
                txtEmail.requestFocus();
            } else {
                fornecedor.setEmail(txtEmail.getText());
                if (txtTelefone.getText().equals("(  )      -    ") || txtTelefone.getText().isEmpty()) {
                    fornecedor.setTelefone("");
                    JOptionPane.showMessageDialog(this, "Campo telefone em branco ou incorreto, insira-o novamente!");
                    txtTelefone.requestFocus();
                } else {
                    fornecedor.setTelefone(txtTelefone.getText());
                    if (txtCNPJ.getText().equals("  .   .   /    -  ") || txtCNPJ.getText().isEmpty()) {
                        fornecedor.setCnpj("");
                        JOptionPane.showMessageDialog(this, "Campo CNPJ em branco ou incorreto, insira-o novamente!");
                        txtCNPJ.requestFocus();
                    } else {
                        fornecedor.setCnpj(txtCNPJ.getText());
                        if (txtTipo.getText().isEmpty() || txtTipo.getText() == null) {
                            fornecedor.setTipo_longradouro("");
                            JOptionPane.showMessageDialog(this, "Campo tipo em branco, insira-o novamente!!");
                            txtTipo.requestFocus();
                        } else {
                            fornecedor.setTipo_longradouro(txtTipo.getText());
                            if (txtLongradouro.getText().isEmpty() || txtLongradouro.getText() == null) {
                                fornecedor.setLongradouro("");
                                JOptionPane.showMessageDialog(this, "Campo longradouro em branco, insira-o novamente!");
                                txtLongradouro.requestFocus();
                            } else {
                                fornecedor.setLongradouro(txtLongradouro.getText());
                                ValidaNumero(txtNumero);
                                if (txtNumero.getText().isEmpty() || txtNumero.getText().length() > 6 || txtNumero.getText() == null) {
                                    JOptionPane.showMessageDialog(this, "Campo numero em branco ou com mais de 6 caracteres, insira-o novamente!");
                                    txtNumero.requestFocus();
                                } else {
                                    fornecedor.setNumero(Integer.parseInt(txtNumero.getText()));
                                    fornecedor.setComplemento(txtComplemento.getText());
                                    if (txtBairro.getText().isEmpty() || txtBairro.getText() == null) {
                                        fornecedor.setBairro("");
                                        JOptionPane.showMessageDialog(this, "Campo bairro em branco, insira-o novamente!");
                                        txtBairro.requestFocus();
                                    } else {
                                        fornecedor.setBairro(txtBairro.getText());
                                        if (txtCidade.getText().isEmpty() || txtCidade.getText() == null) {
                                            fornecedor.setCidade("");
                                            JOptionPane.showMessageDialog(this, "Campo cidade em branco, insira-o novamente!");
                                            txtCidade.requestFocus();
                                        } else {
                                            fornecedor.setCidade(txtCidade.getText());
                                            if (txtEstado.getText().isEmpty() || txtEstado.getText() == null) {
                                                fornecedor.setEstado("");
                                                JOptionPane.showMessageDialog(this, "Campo estado em branco, insira-o novamente!");
                                                txtEstado.requestFocus();
                                            } else {
                                                fornecedor.setEstado(txtEstado.getText());
                                                if (txtUF.getText().isEmpty() || txtUF.getText().length() > 2 || txtUF.getText() == null) {
                                                    fornecedor.setUf("");
                                                    JOptionPane.showMessageDialog(this, "Campo UF em branco ou com mais de 2 caracteres, insira-o novamente!");
                                                    txtUF.requestFocus();
                                                } else {
                                                    fornecedor.setUf(txtUF.getText());
                                                    String retorno = null;
                                                    if (codigo == 0) {
                                                        retorno = fornecedorDao.salvar(fornecedor);
                                                    } else {
                                                        retorno = fornecedorDao.atualizar(fornecedor);
                                                    }
                                                    if (retorno == null) {
                                                        limpaCampos();
                                                        txtNomeFornecedor.requestFocus();
                                                        codigo = 0;
                                                    } else if (retorno == "cnpj") {
                                                        txtCNPJ.setText(null);
                                                        txtCNPJ.requestFocus();
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }//GEN-LAST:event_btnSalvarActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JPanel1;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane menuFornecedor;
    private javax.swing.JTable tblFornecedor;
    private javax.swing.JTextField txtBairro;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtCNPJ;
    private javax.swing.JTextField txtCidade;
    private javax.swing.JTextField txtComplemento;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEstado;
    private javax.swing.JTextField txtLongradouro;
    private javax.swing.JTextField txtNomeFornecedor;
    private javax.swing.JTextField txtNumero;
    private javax.swing.JTextField txtTelefone;
    private javax.swing.JTextField txtTipo;
    private javax.swing.JTextField txtUF;
    // End of variables declaration//GEN-END:variables
}
