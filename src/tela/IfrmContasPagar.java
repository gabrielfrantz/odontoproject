package tela;

import entidade.ContasPagar;
import entidade.Fornecedor;
import javax.swing.JOptionPane;
import persistencia.ContasPagarDAO;
import persistencia.Formatacao;

/**
 *
 * @author GabrielFrantz
 */
public class IfrmContasPagar extends javax.swing.JInternalFrame {

    Formatacao f = new Formatacao();
    ContasPagarDAO cDao = new ContasPagarDAO();
    ContasPagar despesa = new ContasPagar();
    Fornecedor fornecedor = new Fornecedor();
    int fornecedorValido = 0;

    public IfrmContasPagar() {
        initComponents();
        new ContasPagarDAO().popularTabelaNomeFornecedor(tblContasPagar, "", 0);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblContasPagar = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtFornecedor = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        comboStatusContasPagar = new javax.swing.JComboBox();
        btnPesquisarContasPagar = new javax.swing.JButton();
        txtDataDe = new javax.swing.JTextField();
        String dataAtual = Formatacao.getDataAtual();
        txtDataDe.setText(dataAtual);
        txtDataAte = new javax.swing.JTextField();
        String dataAtual1 = Formatacao.getDataAtual();
        txtDataAte.setText(dataAtual1);
        jLabel5 = new javax.swing.JLabel();
        btnAdicionar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnPagar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();

        setTitle("Odonto+");
        setToolTipText("");

        tblContasPagar.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblContasPagar);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Fornecedor:");

        jLabel2.setText("Vencimento:");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("à");

        jLabel4.setText("Status:");

        comboStatusContasPagar.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Abertas", "Pagas" }));
        comboStatusContasPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboStatusContasPagarActionPerformed(evt);
            }
        });

        btnPesquisarContasPagar.setText("Pesquisar");
        btnPesquisarContasPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarContasPagarActionPerformed(evt);
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
                        .addComponent(txtFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(comboStatusContasPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDataDe, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)
                        .addComponent(txtDataAte, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 406, Short.MAX_VALUE)
                        .addComponent(btnPesquisarContasPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(comboStatusContasPagar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtDataDe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtDataAte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)
                        .addComponent(btnPesquisarContasPagar))
                    .addComponent(jLabel2))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Contas a Pagar");

        btnAdicionar.setText("Adicionar");
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnPagar.setText("Pagar");
        btnPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPagarActionPerformed(evt);
            }
        });

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
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
                        .addComponent(btnPagar)
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
                    .addComponent(btnPagar)
                    .addComponent(btnExcluir)
                    .addComponent(btnSair))
                .addGap(53, 53, 53))
        );

        setBounds(0, 0, 908, 690);
    }// </editor-fold>//GEN-END:initComponents

    private void comboStatusContasPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboStatusContasPagarActionPerformed
        if (comboStatusContasPagar.getSelectedIndex() == 1) {
            new ContasPagarDAO().popularTabelaNomeFornecedor(tblContasPagar, "", comboStatusContasPagar.getSelectedIndex());
            btnAdicionar.setEnabled(true);
            btnEditar.setEnabled(false);
            btnPagar.setEnabled(false);
            btnExcluir.setEnabled(false);
        } else {
            new ContasPagarDAO().popularTabelaNomeFornecedor(tblContasPagar, "", comboStatusContasPagar.getSelectedIndex());
            btnAdicionar.setEnabled(true);
            btnEditar.setEnabled(true);
            btnPagar.setEnabled(true);
            btnExcluir.setEnabled(true);
        }
    }//GEN-LAST:event_comboStatusContasPagarActionPerformed

    private void btnPesquisarContasPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarContasPagarActionPerformed
        if (txtDataDe.getText() == null || txtDataDe.getText().isEmpty() || txtDataAte.getText() == null || txtDataAte.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Insira a data inicial e final!", "Informação", JOptionPane.INFORMATION_MESSAGE);
        } else {
            String dataInicial = f.ajustaDataAMD(txtDataDe.getText());
            String dataFinal = f.ajustaDataAMD(txtDataAte.getText());
            new ContasPagarDAO().popularTabelaVencimento(tblContasPagar, dataInicial, dataFinal, comboStatusContasPagar.getSelectedIndex(), txtFornecedor.getText());
        }
    }//GEN-LAST:event_btnPesquisarContasPagarActionPerformed

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        JfrmNovaContaPagar contaPagar= new JfrmNovaContaPagar(this, rootPaneCheckingEnabled, tblContasPagar);
        contaPagar.setVisible(true);
    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        int linha = tblContasPagar.getSelectedRow();
        if (linha > -1) {
            int codConta = Integer.valueOf(String.valueOf(tblContasPagar.getValueAt(linha, 0)));
            String nomeFornecedor = (String) tblContasPagar.getValueAt(linha, 1);
            despesa = cDao.consultarId2(codConta, nomeFornecedor);
            JfrmNovaContaPagar pagar = new JfrmNovaContaPagar(this, rootPaneCheckingEnabled, tblContasPagar, despesa, "editar");
            pagar.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Selecione uma despesa para editar!", "Informação", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPagarActionPerformed
        int linha = tblContasPagar.getSelectedRow();
        if (linha > -1) {
            int codConta = Integer.valueOf(String.valueOf(tblContasPagar.getValueAt(linha, 0)));
            String nomeFornecedor = (String) tblContasPagar.getValueAt(linha, 1);
            despesa = cDao.consultarId2(codConta, nomeFornecedor);
            JfrmNovaContaPagar telaConta = new JfrmNovaContaPagar(this, rootPaneCheckingEnabled, tblContasPagar, despesa, "pagar");
            telaConta.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Selecione uma despesa para pagar!", "Informação", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnPagarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        int linha = tblContasPagar.getSelectedRow();
        if (linha > -1) {
            int codConta = Integer.valueOf(String.valueOf(tblContasPagar.getValueAt(linha, 0)));
            cDao.excluir(codConta);
            new ContasPagarDAO().popularTabelaNomeFornecedor(tblContasPagar, "", 0);
        } else {
            JOptionPane.showMessageDialog(null, "Selecione uma despesa para excluir!", "Informação", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSairActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnPagar;
    private javax.swing.JButton btnPesquisarContasPagar;
    private javax.swing.JButton btnSair;
    private javax.swing.JComboBox comboStatusContasPagar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblContasPagar;
    private javax.swing.JTextField txtDataAte;
    private javax.swing.JTextField txtDataDe;
    private javax.swing.JTextField txtFornecedor;
    // End of variables declaration//GEN-END:variables
}
