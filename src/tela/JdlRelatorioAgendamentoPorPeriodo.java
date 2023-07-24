package tela;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import persistencia.CombosDAO;
import persistencia.ConexaoBD;
import persistencia.Formatacao;
import persistencia.Validacao;

/**
 *
 * @author gabriel.frantz
 */
public class JdlRelatorioAgendamentoPorPeriodo extends javax.swing.JDialog {

    public JdlRelatorioAgendamentoPorPeriodo(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnGerarRelatorio = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnSair = new javax.swing.JButton();
        txtPeriodoDe = new javax.swing.JTextField();
        txtPeriodoDe = Formatacao.getData();
        txtPeriodoAte = new javax.swing.JTextField();
        txtPeriodoAte = Formatacao.getData();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Odonto+");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnGerarRelatorio.setText("Gerar Relatório");
        btnGerarRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGerarRelatorioActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("RELATÓRIO DE AGENDAMENTOS - POR PERÍODO");

        jLabel2.setText("Período de:");

        jLabel3.setText("Até:");

        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(67, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnGerarRelatorio)
                        .addGap(18, 18, 18)
                        .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(txtPeriodoDe, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(txtPeriodoAte, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(52, 52, 52))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel1)
                .addGap(63, 63, 63)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtPeriodoDe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtPeriodoAte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 117, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGerarRelatorio)
                    .addComponent(btnSair))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(603, 361));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    private boolean verificarDatas() {
        boolean retorno = false;
        if (!txtPeriodoDe.getText().contains(" ") && !txtPeriodoAte.getText().contains(" ")) {
            int d = Integer.parseInt(txtPeriodoDe.getText().substring(0, 2));
            int m = Integer.parseInt(txtPeriodoDe.getText().substring(3, 5));
            int a = Integer.parseInt(txtPeriodoDe.getText().substring(6, 10));
            int d2 = Integer.parseInt(txtPeriodoAte.getText().substring(0, 2));
            int m2 = Integer.parseInt(txtPeriodoAte.getText().substring(3, 5));
            int a2 = Integer.parseInt(txtPeriodoAte.getText().substring(6, 10));
            if (Validacao.validarDataDMA(d, m, a) && Validacao.validarDataDMA(d2, m2, a2)) {
                retorno = true;
            }
        }
        return retorno;
    }

    private void btnGerarRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGerarRelatorioActionPerformed
        if (verificarDatas()) {
            String dtIni = Formatacao.ajustaDataAMD(txtPeriodoDe.getText());
            String dtFim = Formatacao.ajustaDataAMD(txtPeriodoAte.getText());
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            Date dtIniFrmt = new Date();
            Date dtFimFrmt = new Date();
            try {
                dtIniFrmt = formato.parse(dtIni);
                formato.format(dtIniFrmt);
                dtFimFrmt = formato.parse(dtFim);
                formato.format(dtFimFrmt);
            } catch (Exception ex) {
                Logger.getLogger(JdlRelatorioAgendamentoPorPeriodo.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.dispose();
            try {
                // Compila o relatorio
                JasperReport relatorio = JasperCompileManager.compileReport(getClass().getResourceAsStream("/relatorios/relatorioAgendamentoPorPeriodo.jrxml"));
                // Mapeia campos de parametros para o relatorio, mesmo que nao existam
                Map parametros = new HashMap();
                // adiciona parametros
                // parametros.put("nomeParametro1", "valorParametro1");
                parametros.put("dataDe", dtIniFrmt);
                parametros.put("dataAte", dtFimFrmt);
                parametros.put("dataDeVis", txtPeriodoDe.getText());
                parametros.put("dataAteVis", txtPeriodoAte.getText());
                // Executa relatoio
                JasperPrint impressao = JasperFillManager.fillReport(relatorio, parametros, ConexaoBD.getInstance().getConnection());
                // Exibe resultado em video
                JasperViewer.viewReport(impressao, false);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao gerar relatório: " + e);
            }
        } else {
            JOptionPane.showMessageDialog(null, "As datas estão incorretas, por favor, verifique!");
            txtPeriodoDe.requestFocus();
        }
    }//GEN-LAST:event_btnGerarRelatorioActionPerformed

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
            java.util.logging.Logger.getLogger(JdlRelatorioAgendamentoPorPeriodo.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JdlRelatorioAgendamentoPorPeriodo.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JdlRelatorioAgendamentoPorPeriodo.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JdlRelatorioAgendamentoPorPeriodo.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JdlRelatorioAgendamentoPorPeriodo dialog = new JdlRelatorioAgendamentoPorPeriodo(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGerarRelatorio;
    private javax.swing.JButton btnSair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtPeriodoAte;
    private javax.swing.JTextField txtPeriodoDe;
    // End of variables declaration//GEN-END:variables
}
