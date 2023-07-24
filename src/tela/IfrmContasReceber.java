package tela;

import entidade.ContasReceber;
import entidade.Paciente;
import java.awt.Dimension;
import javax.swing.JOptionPane;
import persistencia.ContasReceberDAO;
import persistencia.Formatacao;
import persistencia.PacienteDAO;
import static tela.JfrmPrincipal.paciente;

/**
 *
 * @author gabriel.frantz
 */
public class IfrmContasReceber extends javax.swing.JInternalFrame {

    Formatacao f = new Formatacao();
    ContasReceberDAO cDao = new ContasReceberDAO();
    ContasReceber conta = new ContasReceber();
    Paciente paciente = new Paciente();
    int pacienteValido = 0;

    public IfrmContasReceber() {
        initComponents();
        new ContasReceberDAO().popularTabelaNomePaciente(tblContasReceber, "", 0);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtPaciente = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        comboStatusContasReceber = new javax.swing.JComboBox();
        btnPesquisarContasReceber = new javax.swing.JButton();
        txtDataDe = new javax.swing.JTextField();
        String dataAtual = Formatacao.getDataAtual();
        txtDataDe.setText(dataAtual);
        txtDataAte = new javax.swing.JTextField();
        String dataAtual1 = Formatacao.getDataAtual();
        txtDataAte.setText(dataAtual1);
        jScrollPane1 = new javax.swing.JScrollPane();
        tblContasReceber = new javax.swing.JTable();
        btnSair = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnReceber = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnAdicionar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setTitle("Odonto+");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Paciente:");

        jLabel2.setText("Vencimento:");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("à");

        jLabel4.setText("Status:");

        comboStatusContasReceber.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Abertas", "Recebidas" }));
        comboStatusContasReceber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboStatusContasReceberActionPerformed(evt);
            }
        });

        btnPesquisarContasReceber.setText("Pesquisar");
        btnPesquisarContasReceber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarContasReceberActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txtPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(comboStatusContasReceber, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDataDe, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)
                        .addComponent(txtDataAte, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 383, Short.MAX_VALUE)
                        .addComponent(btnPesquisarContasReceber, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(comboStatusContasReceber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtDataDe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtDataAte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)
                        .addComponent(btnPesquisarContasReceber))
                    .addComponent(jLabel2))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        tblContasReceber.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblContasReceber);

        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnReceber.setText("Receber");
        btnReceber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReceberActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnAdicionar.setText("Adicionar");
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Contas a Receber");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(372, 372, 372))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAdicionar)
                        .addGap(18, 18, 18)
                        .addComponent(btnEditar)
                        .addGap(18, 18, 18)
                        .addComponent(btnReceber)
                        .addGap(18, 18, 18)
                        .addComponent(btnExcluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSair)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdicionar)
                    .addComponent(btnEditar)
                    .addComponent(btnReceber)
                    .addComponent(btnExcluir)
                    .addComponent(btnSair))
                .addGap(53, 53, 53))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnPesquisarContasReceberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarContasReceberActionPerformed
        if (txtDataDe.getText() == null || txtDataDe.getText().isEmpty() || txtDataAte.getText() == null || txtDataAte.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Insira a data inicial e final!", "Informação", JOptionPane.INFORMATION_MESSAGE);
        } else {
            String dataInicial = f.ajustaDataAMD(txtDataDe.getText());
            String dataFinal = f.ajustaDataAMD(txtDataAte.getText());
            new ContasReceberDAO().popularTabelaVencimento(tblContasReceber, dataInicial, dataFinal, comboStatusContasReceber.getSelectedIndex(), txtPaciente.getText());
        }
    }//GEN-LAST:event_btnPesquisarContasReceberActionPerformed

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        JfrmNovaContaReceber contaReceber = new JfrmNovaContaReceber(this, rootPaneCheckingEnabled, tblContasReceber);
        contaReceber.setVisible(true);
    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        int linha = tblContasReceber.getSelectedRow();
        if (linha > -1) {
            int codConta = Integer.valueOf(String.valueOf(tblContasReceber.getValueAt(linha, 0)));
            String nomePaciente = (String) tblContasReceber.getValueAt(linha, 1);
            String nomeProcedimento = (String) tblContasReceber.getValueAt(linha, 2);
            conta = cDao.consultarId2(codConta, nomePaciente, nomeProcedimento);
            JfrmNovaContaReceber receber = new JfrmNovaContaReceber(this, rootPaneCheckingEnabled, tblContasReceber, conta, "editar");
            receber.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Selecione uma receita para editar!", "Informação", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        int linha = tblContasReceber.getSelectedRow();
        if (linha > -1) {
            int codConta = Integer.valueOf(String.valueOf(tblContasReceber.getValueAt(linha, 0)));
            cDao.excluir(codConta);
            new ContasReceberDAO().popularTabelaNomePaciente(tblContasReceber, "", 0);
        } else {
            JOptionPane.showMessageDialog(null, "Selecione uma receita para excluir!", "Informação", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnReceberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReceberActionPerformed
        int linha = tblContasReceber.getSelectedRow();
        if (linha > -1) {
            int codConta = Integer.valueOf(String.valueOf(tblContasReceber.getValueAt(linha, 0)));
            String nomePaciente = (String) tblContasReceber.getValueAt(linha, 1);
            String nomeProcedimento = (String) tblContasReceber.getValueAt(linha, 2);
            conta = cDao.consultarId2(codConta, nomePaciente, nomeProcedimento);
            JfrmNovaContaReceber telaConta = new JfrmNovaContaReceber(this, rootPaneCheckingEnabled, tblContasReceber, conta, "receber");
            telaConta.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Selecione uma receita para receber!", "Informação", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnReceberActionPerformed

    private void comboStatusContasReceberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboStatusContasReceberActionPerformed
        if (comboStatusContasReceber.getSelectedIndex() == 1) {
            new ContasReceberDAO().popularTabelaNomePaciente(tblContasReceber, "", comboStatusContasReceber.getSelectedIndex());
            btnAdicionar.setEnabled(true);
            btnEditar.setEnabled(false);
            btnReceber.setEnabled(false);
            btnExcluir.setEnabled(false);
        } else {
            new ContasReceberDAO().popularTabelaNomePaciente(tblContasReceber, "", comboStatusContasReceber.getSelectedIndex());
            btnAdicionar.setEnabled(true);
            btnEditar.setEnabled(true);
            btnReceber.setEnabled(true);
            btnExcluir.setEnabled(true);
        }
    }//GEN-LAST:event_comboStatusContasReceberActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnPesquisarContasReceber;
    private javax.swing.JButton btnReceber;
    private javax.swing.JButton btnSair;
    private javax.swing.JComboBox comboStatusContasReceber;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblContasReceber;
    private javax.swing.JTextField txtDataAte;
    private javax.swing.JTextField txtDataDe;
    private javax.swing.JTextField txtPaciente;
    // End of variables declaration//GEN-END:variables
}
