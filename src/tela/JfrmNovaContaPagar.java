package tela;

import entidade.ContasPagar;
import entidade.Fornecedor;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import persistencia.ContasPagarDAO;
import persistencia.Formatacao;
import persistencia.FornecedorDAO;
import persistencia.Validacao;

/**
 *
 * @author GabrielFrantz
 */
public class JfrmNovaContaPagar extends javax.swing.JFrame {

    Formatacao formatacao = new Formatacao();
    int fornecedorValido = 0;
    Fornecedor fornecedor = new Fornecedor();
    FornecedorDAO fornecedorDao = new FornecedorDAO();
    ContasPagarDAO pagarDao = new ContasPagarDAO();
    JTable tblContasPagar = new JTable();
    ContasPagar conta = new ContasPagar();
    String editar = "novo";
    double valorOriginal = 0;

    public JfrmNovaContaPagar(javax.swing.JInternalFrame parent, boolean modal, JTable tblContasPagar) {
        initComponents();
        this.editar = "novo";
        this.tblContasPagar = tblContasPagar;
    }

    public JfrmNovaContaPagar(javax.swing.JInternalFrame parent, boolean modal, JTable tblContasPagar, ContasPagar conta, String tipo) {
        initComponents();
        this.editar = tipo;
        this.tblContasPagar = tblContasPagar;
        this.conta = conta;
        carregarDados();
    }

    public void carregarDados() {
        txtFornecedor.setText(conta.getFornecedor());
        txtDescricao.setText(conta.getDescricao());
        txtDataCompra.setText(formatacao.ajustaDataDMA(conta.getData_compra().toString()));
        txtDataVencimento.setText(formatacao.ajustaDataDMA(conta.getData_vencimento().toString()));
        txtValorTotal.setText(String.valueOf(conta.getValor_total()));
        txtValorPago.setText(String.valueOf(conta.getValor_pago()));
        txtValorAtualizado.setText(String.valueOf(conta.getValor_atualizado()));
        fornecedor = fornecedorDao.consultarId(conta.getCod_fornecedor());
        fornecedorValido = 1;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtFornecedor = new javax.swing.JTextField();
        btnBuscarFornecedor = new javax.swing.JButton();
        lblValor = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtValorTotal = new javax.swing.JTextField();
        txtValorAtualizado = new javax.swing.JTextField();
        txtDataCompra = new javax.swing.JTextField();
        String dataAtual = Formatacao.getDataAtual();
        txtDataCompra.setText(dataAtual);
        txtDataVencimento = new javax.swing.JTextField();
        String dataAtual1 = Formatacao.getDataAtual();
        txtDataVencimento.setText(dataAtual1);
        jLabel6 = new javax.swing.JLabel();
        txtValorPago = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtDescricao = new javax.swing.JTextField();
        btnSalvar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Odonto+");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Lançamento de Conta a Pagar");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setText("Fornecedor:");

        jLabel4.setText("Data de Compra:");

        jLabel5.setText("Data de Vencimento:");

        btnBuscarFornecedor.setText("Buscar");
        btnBuscarFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarFornecedorActionPerformed(evt);
            }
        });

        lblValor.setText("Valor Total:");

        jLabel7.setText("Valor Atualizado:");

        jLabel6.setText("Valor Pago:");

        txtValorPago.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtValorPagoFocusLost(evt);
            }
        });

        jLabel2.setText("Descrição:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBuscarFornecedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(txtDescricao)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(lblValor)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jLabel6)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtValorPago, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jLabel7)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtValorAtualizado, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addGap(28, 28, 28)
                            .addComponent(txtDataCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jLabel5)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtDataVencimento))))
                .addGap(14, 14, 14))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarFornecedor))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(txtDescricao, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtDataCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtDataVencimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblValor)
                    .addComponent(txtValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtValorPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txtValorAtualizado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48))
        );

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
            .addGroup(layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnSalvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCancelar)))
                .addGap(93, 93, 93))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnSalvar))
                .addGap(42, 42, 42))
        );

        setSize(new java.awt.Dimension(472, 459));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarFornecedorActionPerformed
        JdlFornecedores telaFornecedores = new JdlFornecedores(this, rootPaneCheckingEnabled);
        telaFornecedores.setVisible(true);
        fornecedor = new FornecedorDAO().consultarId(telaFornecedores.codFornecedor);
        txtFornecedor.setText(fornecedor.getNome());
        fornecedorValido = 1;
    }//GEN-LAST:event_btnBuscarFornecedorActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        double valorTotal2 = Double.parseDouble(txtValorTotal.getText().replace(",", "."));
        double valorPago2 = Double.parseDouble(txtValorPago.getText().replace(",", "."));
        if (txtDescricao.getText() == null || txtDescricao.getText().isEmpty() || txtDataCompra.getText().isEmpty() || txtDataCompra.getText() == null || txtDataVencimento.getText() == null || txtDataVencimento.getText().isEmpty() || txtValorPago.getText().isEmpty() || txtValorPago.getText() == null
                || txtValorTotal.getText() == null || txtValorTotal.getText().isEmpty() || txtValorAtualizado.getText().isEmpty() || txtValorAtualizado.getText() == null || valorTotal2 < 0 || valorPago2 < 0 || valorTotal2 < valorPago2 || fornecedorValido == 0) {
            JOptionPane.showMessageDialog(null, "Verifique se todos os campos estão preenchidos e se o valores estão corretos!", "Informação", JOptionPane.INFORMATION_MESSAGE);
        } else {
            if (editar == "novo") {
                conta = new ContasPagar();
                conta.setFornecedor(fornecedor.getNome());
                conta.setDescricao(txtDescricao.getText());
                try {
                    if (new Validacao().validarDataFormatada(txtDataCompra.getText())) {
                        Date data = sdf.parse(txtDataCompra.getText());
                        conta.setData_compra(data);
                    }
                } catch (ParseException ex) {
                    Logger.getLogger(IfrmFornecedores.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    if (new Validacao().validarDataFormatada(txtDataVencimento.getText())) {
                        Date data = sdf.parse(txtDataVencimento.getText());
                        conta.setData_vencimento(data);
                    }
                } catch (ParseException ex) {
                    Logger.getLogger(IfrmFornecedores.class.getName()).log(Level.SEVERE, null, ex);
                }
                String valor = txtValorTotal.getText();
                valor = valor.replace(",", ".");
                //valor = formatacao.txfDouble(valor);
                conta.setValor_total_tela(Double.parseDouble(valor));
                conta.setValor_total(Double.parseDouble(valor));
                //valor = txtValorPago.getText().toString().replace(".", "");
                valor = txtValorPago.getText();
                valor = valor.replace(",", ".");
                //valor = formatacao.txfDouble(valor);
                conta.setValor_pago(Double.parseDouble(valor));
                //valor = txtValorAtualizado.getText().toString().replace(".", "");
                valor = txtValorAtualizado.getText();
                valor = valor.replace(",", ".");
                //valor = formatacao.txfDouble(valor);
                conta.setValor_atualizado(Double.parseDouble(valor));
                pagarDao.salvar(conta);
                new ContasPagarDAO().popularTabelaNomeFornecedor(tblContasPagar, "", 0);
                this.dispose();
            }
            if (editar == "editar") {
                conta = pagarDao.consultarId(conta.getId());
                conta.setFornecedor(fornecedor.getNome());
                conta.setDescricao(txtDescricao.getText());
                try {
                    if (new Validacao().validarDataFormatada(txtDataCompra.getText())) {
                        Date data = sdf.parse(txtDataCompra.getText());
                        conta.setData_compra(data);
                    }
                } catch (ParseException ex) {
                    Logger.getLogger(IfrmFornecedores.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    if (new Validacao().validarDataFormatada(txtDataVencimento.getText())) {
                        Date data = sdf.parse(txtDataVencimento.getText());
                        conta.setData_vencimento(data);
                    }
                } catch (ParseException ex) {
                    Logger.getLogger(IfrmFornecedores.class.getName()).log(Level.SEVERE, null, ex);
                }
                String valor = txtValorTotal.getText();
                valor = valor.replace(",", ".");
                //valor = formatacao.txfDouble(valor);
                conta.setValor_total(Double.parseDouble(valor));
                valor = txtValorPago.getText();
                valor = valor.replace(",", ".");
                //valor = formatacao.txfDouble(valor);
                conta.setValor_pago(Double.parseDouble(valor));
                valor = txtValorAtualizado.getText();
                valor = valor.replace(",", ".");
                //valor = formatacao.txfDouble(valor);
                conta.setValor_atualizado(Double.parseDouble(valor));
                pagarDao.atualizar(conta);
                new ContasPagarDAO().popularTabelaNomeFornecedor(tblContasPagar, "", 0);
                this.dispose();
            }
            if (editar == "pagar") {
                lblValor.setText("Valor a pagar:");
                conta = pagarDao.consultarId(conta.getId());
                valorOriginal = conta.getValor_total();
                conta.setFornecedor(fornecedor.getNome());
                conta.setDescricao(txtDescricao.getText());
                try {
                    if (new Validacao().validarDataFormatada(txtDataCompra.getText())) {
                        Date data = sdf.parse(txtDataCompra.getText());
                        conta.setData_compra(data);
                    }
                } catch (ParseException ex) {
                    Logger.getLogger(IfrmFornecedores.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    if (new Validacao().validarDataFormatada(txtDataVencimento.getText())) {
                        Date data = sdf.parse(txtDataVencimento.getText());
                        conta.setData_vencimento(data);
                    }
                } catch (ParseException ex) {
                    Logger.getLogger(IfrmFornecedores.class.getName()).log(Level.SEVERE, null, ex);
                }
                String valorTotal = txtValorTotal.getText();
                valorTotal = valorTotal.replace(",", ".");
                //valorTotal = formatacao.txfDouble(valorTotal);
                String valorPago = txtValorPago.getText();
                valorPago = valorPago.replace(",", ".");
                //valorPago = formatacao.txfDouble(valorPago);
                String valorAtualizado = txtValorAtualizado.getText();
                valorAtualizado = valorAtualizado.replace(",", ".");
                //valorAtualizado = formatacao.txfDouble(valorAtualizado);
                double calculoAtualizado = Double.parseDouble(valorTotal) - Double.parseDouble(valorPago);
                double calculoTotal = calculoAtualizado;
                double calculoPago = 0;
                conta.setValor_total(calculoTotal);
                conta.setValor_pago(calculoPago);
                conta.setValor_atualizado(calculoAtualizado);
                conta.setStatus(0);
                pagarDao.atualizar(conta);
                if (conta.getValor_atualizado() == 0) {
                    conta.setStatus(1);
                    conta.setValor_pago(conta.getValor_total_tela());
                    conta.setValor_total(conta.getValor_total_tela());
                    pagarDao.atualizar(conta);
                }
                new ContasPagarDAO().popularTabelaNomeFornecedor(tblContasPagar, "", 0);
                this.dispose();
            }
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtValorPagoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtValorPagoFocusLost
        double valorTotal = Double.parseDouble(txtValorTotal.getText().replace(",", "."));
        double valorPago = Double.parseDouble(txtValorPago.getText().replace(",", "."));
        double valorAtualizado = valorTotal - valorPago;
        txtValorAtualizado.setText(String.valueOf(valorAtualizado));
    }//GEN-LAST:event_txtValorPagoFocusLost
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
            java.util.logging.Logger.getLogger(JfrmNovaContaPagar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JfrmNovaContaPagar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JfrmNovaContaPagar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JfrmNovaContaPagar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarFornecedor;
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
    private javax.swing.JTextField txtDataCompra;
    private javax.swing.JTextField txtDataVencimento;
    private javax.swing.JTextField txtDescricao;
    private javax.swing.JTextField txtFornecedor;
    private javax.swing.JTextField txtValorAtualizado;
    private javax.swing.JTextField txtValorPago;
    private javax.swing.JTextField txtValorTotal;
    // End of variables declaration//GEN-END:variables
}
