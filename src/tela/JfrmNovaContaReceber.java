package tela;

import entidade.ContasReceber;
import entidade.Paciente;
import entidade.Procedimento;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import persistencia.ContasReceberDAO;
import persistencia.Formatacao;
import persistencia.NumeroDocument;
import persistencia.PacienteDAO;
import persistencia.ProcedimentoDAO;
import persistencia.Validacao;
import static tela.JfrmPrincipal.procedimento;

/**
 *
 * @author GabrielFrantz
 */
public class JfrmNovaContaReceber extends javax.swing.JFrame {

    Formatacao formatacao = new Formatacao();
    int pacienteValido = 0;
    int procedimentoValido = 0;
    Paciente paciente = new Paciente();
    PacienteDAO pacienteDao = new PacienteDAO();
    Procedimento procedimento = new Procedimento();
    ProcedimentoDAO procedimentoDao = new ProcedimentoDAO();
    ContasReceberDAO cDao = new ContasReceberDAO();
    JTable tblContasReceber = new JTable();
    ContasReceber conta = new ContasReceber();
    String editar = "novo";
    double valorOriginal = 0;

    public JfrmNovaContaReceber(javax.swing.JInternalFrame parent, boolean modal, JTable tblContasReceber) {
        initComponents();
        this.editar = "novo";
        this.tblContasReceber = tblContasReceber;
    }

    public JfrmNovaContaReceber(javax.swing.JInternalFrame parent, boolean modal, JTable tblContasReceber, ContasReceber conta, String tipo) {
        initComponents();
        this.editar = tipo;
        this.tblContasReceber = tblContasReceber;
        this.conta = conta;
        carregarDados();
    }

    public void carregarDados() {
        txtProcedimento.setText(conta.getProcedimento());
        txtPaciente.setText(conta.getPaciente());
        txtDataEmissao.setText(formatacao.ajustaDataDMA(conta.getData_emissao().toString()));
        txtDataVencimento.setText(formatacao.ajustaDataDMA(conta.getData_vencimento().toString()));
        txtValorTotal.setText(String.valueOf(conta.getValor_total()));
        txtValorRecebido.setText(String.valueOf(conta.getValor_recebido()));
        txtValorAtualizado.setText(String.valueOf(conta.getValor_atualizado()));
        paciente = pacienteDao.consultarId(conta.getCod_paciente());
        pacienteValido = 1;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtProcedimento = new javax.swing.JTextField();
        txtPaciente = new javax.swing.JTextField();
        btnBuscarPaciente = new javax.swing.JButton();
        btnBuscarProcedimento = new javax.swing.JButton();
        lblValor = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtValorTotal = new javax.swing.JTextField();
        txtValorAtualizado = new javax.swing.JTextField();
        txtDataEmissao = new javax.swing.JTextField();
        String dataAtual = Formatacao.getDataAtual();
        txtDataEmissao.setText(dataAtual);
        txtDataVencimento = new javax.swing.JTextField();
        String dataAtual1 = Formatacao.getDataAtual();
        txtDataVencimento.setText(dataAtual1);
        jLabel6 = new javax.swing.JLabel();
        txtValorRecebido = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnSalvar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Odonto+");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setText("Procedimento:");

        jLabel3.setText("Paciente:");

        jLabel4.setText("Data de Emissão:");

        jLabel5.setText("Data de Vencimento:");

        btnBuscarPaciente.setText("Buscar");
        btnBuscarPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarPacienteActionPerformed(evt);
            }
        });

        btnBuscarProcedimento.setText("Buscar");
        btnBuscarProcedimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarProcedimentoActionPerformed(evt);
            }
        });

        lblValor.setText("Valor Total:");

        jLabel7.setText("Valor Atualizado:");

        jLabel6.setText("Valor Recebido:");

        txtValorRecebido.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtValorRecebidoFocusLost(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtProcedimento, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
                            .addComponent(txtPaciente))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnBuscarProcedimento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnBuscarPaciente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblValor)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtValorRecebido, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtValorAtualizado, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(28, 28, 28)
                                .addComponent(txtDataEmissao, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDataVencimento)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(14, 14, 14))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtProcedimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarProcedimento))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarPaciente))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtDataEmissao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtDataVencimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblValor)
                    .addComponent(txtValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtValorRecebido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txtValorAtualizado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Lançamento de Conta a Receber");

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnSalvar)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelar)))
                .addGap(93, 93, 93))
            .addGroup(layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSalvar)
                    .addComponent(btnCancelar))
                .addContainerGap(51, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(495, 373));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnBuscarPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarPacienteActionPerformed
        JdlPacientes telaPacientes = new JdlPacientes(this, rootPaneCheckingEnabled);
        telaPacientes.setVisible(true);
        paciente = new PacienteDAO().consultarId(telaPacientes.codPaciente);
        txtPaciente.setText(paciente.getNome());
        pacienteValido = 1;
    }//GEN-LAST:event_btnBuscarPacienteActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        double valorTotal2 = Double.parseDouble(txtValorTotal.getText().replace(",", "."));
        double valorRecebido2 = Double.parseDouble(txtValorRecebido.getText().replace(",", "."));
        if (txtProcedimento.getText() == null || txtProcedimento.getText().isEmpty() || txtPaciente.getText() == null || txtPaciente.getText().isEmpty() || txtDataEmissao.getText() == null || txtDataEmissao.getText().isEmpty() || txtDataVencimento.getText() == null || txtDataVencimento.getText().isEmpty()
                || txtValorTotal.getText().isEmpty() || txtValorTotal.getText() == null || txtValorRecebido.getText().isEmpty() || txtValorRecebido.getText() == null || txtValorAtualizado.getText().isEmpty() || txtValorAtualizado.getText() == null || valorTotal2 < 0 || valorRecebido2 < 0 || valorTotal2 < valorRecebido2 || pacienteValido == 0) {
            JOptionPane.showMessageDialog(null, "Verifique se todos os campos estão preenchidos e se o valores estão corretos!", "Informação", JOptionPane.INFORMATION_MESSAGE);
        } else {
            if (editar == "novo") {
                conta = new ContasReceber();
                conta.setProcedimento(txtProcedimento.getText());
                conta.setPaciente(paciente.getNome());
                try {
                    if (new Validacao().validarDataFormatada(txtDataEmissao.getText())) {
                        Date data = sdf.parse(txtDataEmissao.getText());
                        conta.setData_emissao(data);
                    }
                } catch (ParseException ex) {
                    Logger.getLogger(IfrmPacientes.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    if (new Validacao().validarDataFormatada(txtDataVencimento.getText())) {
                        Date data = sdf.parse(txtDataVencimento.getText());
                        conta.setData_vencimento(data);
                    }
                } catch (ParseException ex) {
                    Logger.getLogger(IfrmPacientes.class.getName()).log(Level.SEVERE, null, ex);
                }
                String valor = txtValorTotal.getText();
                valor = valor.replace(",", ".");
                //valor = formatacao.txfDouble(valor);
                conta.setValor_total_tela(Double.parseDouble(valor));
                conta.setValor_total(Double.parseDouble(valor));
                valor = txtValorRecebido.getText();
                valor = valor.replace(",", ".");
                //valor = formatacao.txfDouble(valor);
                conta.setValor_recebido(Double.parseDouble(valor));
                valor = txtValorAtualizado.getText();
                valor = valor.replace(",", ".");
                //valor = formatacao.txfDouble(valor);
                conta.setValor_atualizado(Double.parseDouble(valor));
                cDao.salvar(conta);
                new ContasReceberDAO().popularTabelaNomePaciente(tblContasReceber, "", 0);
                this.dispose();
            }
            if (editar == "editar") {
                conta = cDao.consultarId(conta.getId());
                conta.setProcedimento(txtProcedimento.getText());
                conta.setPaciente(paciente.getNome());
                try {
                    if (new Validacao().validarDataFormatada(txtDataEmissao.getText())) {
                        Date data = sdf.parse(txtDataEmissao.getText());
                        conta.setData_emissao(data);
                    }
                } catch (ParseException ex) {
                    Logger.getLogger(IfrmPacientes.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    if (new Validacao().validarDataFormatada(txtDataVencimento.getText())) {
                        Date data = sdf.parse(txtDataVencimento.getText());
                        conta.setData_vencimento(data);
                    }
                } catch (ParseException ex) {
                    Logger.getLogger(IfrmPacientes.class.getName()).log(Level.SEVERE, null, ex);
                }
                String valor = txtValorTotal.getText();
                valor = valor.replace(",", ".");
                //valor = formatacao.txfDouble(valor);
                conta.setValor_total(Double.parseDouble(valor));
                valor = txtValorRecebido.getText();
                valor = valor.replace(",", ".");
                //valor = formatacao.txfDouble(valor);
                conta.setValor_recebido(Double.parseDouble(valor));
                valor = txtValorAtualizado.getText();
                valor = valor.replace(",", ".");
                //valor = formatacao.txfDouble(valor);
                conta.setValor_atualizado(Double.parseDouble(valor));
                cDao.atualizar(conta);
                new ContasReceberDAO().popularTabelaNomePaciente(tblContasReceber, "", 0);
                this.dispose();
            }
            if (editar == "receber") {
                lblValor.setText("Valor a receber:");
                conta = cDao.consultarId(conta.getId());
                valorOriginal = conta.getValor_total();
                conta.setProcedimento(txtProcedimento.getText());
                conta.setPaciente(paciente.getNome());
                try {
                    if (new Validacao().validarDataFormatada(txtDataEmissao.getText())) {
                        Date data = sdf.parse(txtDataEmissao.getText());
                        conta.setData_emissao(data);
                    }
                } catch (ParseException ex) {
                    Logger.getLogger(IfrmPacientes.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    if (new Validacao().validarDataFormatada(txtDataVencimento.getText())) {
                        Date data = sdf.parse(txtDataVencimento.getText());
                        conta.setData_vencimento(data);
                    }
                } catch (ParseException ex) {
                    Logger.getLogger(IfrmPacientes.class.getName()).log(Level.SEVERE, null, ex);
                }
                String valorTotal = txtValorTotal.getText();
                valorTotal = valorTotal.replace(",", ".");
                //valorTotal = formatacao.txfDouble(valorTotal);
                String valorRecebido = txtValorRecebido.getText();
                valorRecebido = valorRecebido.replace(",", ".");
                //valorRecebido = formatacao.txfDouble(valorRecebido);
                String valorAtualizado = txtValorAtualizado.getText();
                valorAtualizado = valorAtualizado.replace(",", ".");
                //valorAtualizado = formatacao.txfDouble(valorAtualizado);
                double calculoAtualizado = Double.parseDouble(valorTotal) - Double.parseDouble(valorRecebido);
                double calculoTotal = calculoAtualizado;
                double calculoRecebido = 0;
                conta.setValor_total(calculoTotal);
                conta.setValor_recebido(calculoRecebido);
                conta.setValor_atualizado(calculoAtualizado);
                conta.setStatus(0);
                cDao.atualizar(conta);
                if (conta.getValor_atualizado() == 0) {
                    conta.setStatus(1);
                    conta.setValor_recebido(conta.getValor_total_tela());
                    conta.setValor_total(conta.getValor_total_tela());
                    cDao.atualizar(conta);
                }
                new ContasReceberDAO().popularTabelaNomePaciente(tblContasReceber, "", 0);
                this.dispose();
            }
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnBuscarProcedimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarProcedimentoActionPerformed
        JdlProcedimentos telaProcedimentos = new JdlProcedimentos(this, rootPaneCheckingEnabled);
        telaProcedimentos.setVisible(true);
        procedimento = new ProcedimentoDAO().consultarId(telaProcedimentos.codProcedimento);
        txtProcedimento.setText(procedimento.getDescricao());
        procedimentoValido = 1;
    }//GEN-LAST:event_btnBuscarProcedimentoActionPerformed

    private void txtValorRecebidoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtValorRecebidoFocusLost
        double valorTotal = Double.parseDouble(txtValorTotal.getText().replace(",", "."));
        double valorRecebido = Double.parseDouble(txtValorRecebido.getText().replace(",", "."));
        double valorAtualizado = valorTotal - valorRecebido;
        txtValorAtualizado.setText(String.valueOf(valorAtualizado));
    }//GEN-LAST:event_txtValorRecebidoFocusLost

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JfrmNovaContaReceber.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JfrmNovaContaReceber.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JfrmNovaContaReceber.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JfrmNovaContaReceber.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarPaciente;
    private javax.swing.JButton btnBuscarProcedimento;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblValor;
    private javax.swing.JTextField txtDataEmissao;
    private javax.swing.JTextField txtDataVencimento;
    private javax.swing.JTextField txtPaciente;
    private javax.swing.JTextField txtProcedimento;
    private javax.swing.JTextField txtValorAtualizado;
    private javax.swing.JTextField txtValorRecebido;
    private javax.swing.JTextField txtValorTotal;
    // End of variables declaration//GEN-END:variables
}
