package tela;

import java.awt.Dimension;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JInternalFrame;
import persistencia.ConexaoBD;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author gabriel.frantz
 */
public class JfrmPrincipal extends javax.swing.JFrame {

    static IfrmDentistas dentista;
    static IfrmPacientes paciente;
    static IfrmProcedimentos procedimento;
    static IfrmUsuarios usuario;
    static IfrmAgenda agenda;

    public JfrmPrincipal() {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        MenuCadastroPacientes = new javax.swing.JMenuItem();
        MenuCadastroProcedimentos = new javax.swing.JMenuItem();
        MenuCadastroUsuarios = new javax.swing.JMenuItem();
        MenuCadastroDentistas = new javax.swing.JMenuItem();
        MenuCadastroFornecedores = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        MenuCadastroAgenda = new javax.swing.JMenuItem();
        menuFinanceiro = new javax.swing.JMenu();
        MenuPagar = new javax.swing.JMenuItem();
        MenuReceber = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        relatorioAgendamentoPorPeriodo = new javax.swing.JMenuItem();
        relatorioContasPagar = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        listagemCadastroPacientes = new javax.swing.JMenuItem();
        listagemCadastroProcedimentos = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Odonto+");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 471, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 279, Short.MAX_VALUE)
        );

        jMenu1.setText("Cadastro");

        MenuCadastroPacientes.setText("Pacientes");
        MenuCadastroPacientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuCadastroPacientesActionPerformed(evt);
            }
        });
        jMenu1.add(MenuCadastroPacientes);

        MenuCadastroProcedimentos.setText("Procedimentos");
        MenuCadastroProcedimentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuCadastroProcedimentosActionPerformed(evt);
            }
        });
        jMenu1.add(MenuCadastroProcedimentos);

        MenuCadastroUsuarios.setText("Usuários");
        MenuCadastroUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuCadastroUsuariosActionPerformed(evt);
            }
        });
        jMenu1.add(MenuCadastroUsuarios);

        MenuCadastroDentistas.setText("Dentistas");
        MenuCadastroDentistas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuCadastroDentistasActionPerformed(evt);
            }
        });
        jMenu1.add(MenuCadastroDentistas);

        MenuCadastroFornecedores.setText("Fornecedores");
        MenuCadastroFornecedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuCadastroFornecedoresActionPerformed(evt);
            }
        });
        jMenu1.add(MenuCadastroFornecedores);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Agenda");

        MenuCadastroAgenda.setText("Agendamento");
        MenuCadastroAgenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuCadastroAgendaActionPerformed(evt);
            }
        });
        jMenu2.add(MenuCadastroAgenda);

        jMenuBar1.add(jMenu2);

        menuFinanceiro.setText("Financeiro");

        MenuPagar.setText("Contas a pagar");
        MenuPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuPagarActionPerformed(evt);
            }
        });
        menuFinanceiro.add(MenuPagar);

        MenuReceber.setText("Contas a receber");
        MenuReceber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuReceberActionPerformed(evt);
            }
        });
        menuFinanceiro.add(MenuReceber);

        jMenuBar1.add(menuFinanceiro);

        jMenu3.setText("Relatórios/Listagens");

        relatorioAgendamentoPorPeriodo.setText("Relatório - Agendamento por período");
        relatorioAgendamentoPorPeriodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                relatorioAgendamentoPorPeriodoActionPerformed(evt);
            }
        });
        jMenu3.add(relatorioAgendamentoPorPeriodo);

        relatorioContasPagar.setText("Relatório - Contas a pagar por status");
        relatorioContasPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                relatorioContasPagarActionPerformed(evt);
            }
        });
        jMenu3.add(relatorioContasPagar);

        jMenuItem1.setText("Relatório - Contas a receber por status");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem1);

        jMenuItem2.setText("Relatório - Valores recebidos por período");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem2);

        listagemCadastroPacientes.setText("Listagem - Pacientes");
        listagemCadastroPacientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listagemCadastroPacientesActionPerformed(evt);
            }
        });
        jMenu3.add(listagemCadastroPacientes);

        listagemCadastroProcedimentos.setText("Listagem - Procedimentos");
        listagemCadastroProcedimentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listagemCadastroProcedimentosActionPerformed(evt);
            }
        });
        jMenu3.add(listagemCadastroProcedimentos);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setBounds(0, 0, 487, 339);
    }// </editor-fold>//GEN-END:initComponents

    private void centralizaForm(JInternalFrame frame) {
        Dimension desktopSize = jPanel1.getSize();
        Dimension jInternalFrameSize = frame.getSize();
        frame.setLocation((desktopSize.width - jInternalFrameSize.width) / 2, (desktopSize.height - jInternalFrameSize.height) / 2);
    }

    private void MenuCadastroPacientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuCadastroPacientesActionPerformed
        IfrmPacientes pacientes = new IfrmPacientes();
        jPanel1.add(pacientes);
        centralizaForm(pacientes);
        pacientes.setVisible(true);
    }//GEN-LAST:event_MenuCadastroPacientesActionPerformed

    private void MenuCadastroProcedimentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuCadastroProcedimentosActionPerformed
        IfrmProcedimentos procedimentos = new IfrmProcedimentos();
        jPanel1.add(procedimentos);
        centralizaForm(procedimentos);
        procedimentos.setVisible(true);
    }//GEN-LAST:event_MenuCadastroProcedimentosActionPerformed

    private void MenuCadastroUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuCadastroUsuariosActionPerformed
        IfrmUsuarios usuarios = new IfrmUsuarios();
        jPanel1.add(usuarios);
        centralizaForm(usuarios);
        usuarios.setVisible(true);
    }//GEN-LAST:event_MenuCadastroUsuariosActionPerformed

    private void MenuCadastroDentistasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuCadastroDentistasActionPerformed
        IfrmDentistas dentistas = new IfrmDentistas();
        jPanel1.add(dentistas);
        centralizaForm(dentistas);
        dentistas.setVisible(true);
    }//GEN-LAST:event_MenuCadastroDentistasActionPerformed

    private void listagemCadastroPacientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listagemCadastroPacientesActionPerformed
        try {
            // Compila o relatorio
            JasperReport relatorio = JasperCompileManager.compileReport(getClass().getResourceAsStream("/relatorios/listagemCadastroPacientes.jrxml"));
            // Mapeia campos de parametros para o relatorio, mesmo que nao existam
            Map parametros = new HashMap();
            // Executa relatoio
            JasperPrint impressao = JasperFillManager.fillReport(relatorio, parametros, ConexaoBD.getInstance().getConnection());
            // Exibe resultado em video
            JasperViewer.viewReport(impressao, false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao gerar relatório: " + e);
        }
    }//GEN-LAST:event_listagemCadastroPacientesActionPerformed

    private void MenuCadastroAgendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuCadastroAgendaActionPerformed
        IfrmAgenda agenda = new IfrmAgenda();
        jPanel1.add(agenda);
        centralizaForm(agenda);
        agenda.setVisible(true);
    }//GEN-LAST:event_MenuCadastroAgendaActionPerformed

    private void MenuReceberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuReceberActionPerformed
        IfrmContasReceber contasReceber = new IfrmContasReceber();
        jPanel1.add(contasReceber);
        centralizaForm(contasReceber);
        contasReceber.setVisible(true);
    }//GEN-LAST:event_MenuReceberActionPerformed

    private void MenuPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuPagarActionPerformed
        IfrmContasPagar contasPagar = new IfrmContasPagar();
        jPanel1.add(contasPagar);
        centralizaForm(contasPagar);
        contasPagar.setVisible(true);
    }//GEN-LAST:event_MenuPagarActionPerformed

    private void listagemCadastroProcedimentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listagemCadastroProcedimentosActionPerformed
        try {
            // Compila o relatorio
            JasperReport relatorio = JasperCompileManager.compileReport(getClass().getResourceAsStream("/relatorios/listagemCadastroProcedimentos.jrxml"));
            // Mapeia campos de parametros para o relatorio, mesmo que nao existam
            Map parametros = new HashMap();
            // Executa relatoio
            JasperPrint impressao = JasperFillManager.fillReport(relatorio, parametros, ConexaoBD.getInstance().getConnection());
            // Exibe resultado em video
            JasperViewer.viewReport(impressao, false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao gerar relatório: " + e);
        }
    }//GEN-LAST:event_listagemCadastroProcedimentosActionPerformed

    private void relatorioAgendamentoPorPeriodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_relatorioAgendamentoPorPeriodoActionPerformed
        JdlRelatorioAgendamentoPorPeriodo relatorioAgendamentoPorPeriodo = new JdlRelatorioAgendamentoPorPeriodo(this, true);
        relatorioAgendamentoPorPeriodo.setLocationRelativeTo(this);
        relatorioAgendamentoPorPeriodo.setVisible(true);
    }//GEN-LAST:event_relatorioAgendamentoPorPeriodoActionPerformed

    private void MenuCadastroFornecedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuCadastroFornecedoresActionPerformed
        IfrmFornecedores fornecedores = new IfrmFornecedores();
        jPanel1.add(fornecedores);
        centralizaForm(fornecedores);
        fornecedores.setVisible(true);
    }//GEN-LAST:event_MenuCadastroFornecedoresActionPerformed

    private void relatorioContasPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_relatorioContasPagarActionPerformed
        JdlRelatorioContasPagar relatorioContasPagar = new JdlRelatorioContasPagar(this, true);
        relatorioContasPagar.setLocationRelativeTo(this);
        relatorioContasPagar.setVisible(true);
    }//GEN-LAST:event_relatorioContasPagarActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        JdlRelatorioContasReceber relatorioContasReceber = new JdlRelatorioContasReceber(this, true);
        relatorioContasReceber.setLocationRelativeTo(this);
        relatorioContasReceber.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        JdlRelatorioValorRecebidoPorPeriodo relatorioValorRecebidoPorPeriodo = new JdlRelatorioValorRecebidoPorPeriodo(this, true);
        relatorioValorRecebidoPorPeriodo.setLocationRelativeTo(this);
        relatorioValorRecebidoPorPeriodo.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

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
            java.util.logging.Logger.getLogger(JfrmPrincipal.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JfrmPrincipal.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JfrmPrincipal.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JfrmPrincipal.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JfrmPrincipal().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem MenuCadastroAgenda;
    private javax.swing.JMenuItem MenuCadastroDentistas;
    private javax.swing.JMenuItem MenuCadastroFornecedores;
    private javax.swing.JMenuItem MenuCadastroPacientes;
    private javax.swing.JMenuItem MenuCadastroProcedimentos;
    private javax.swing.JMenuItem MenuCadastroUsuarios;
    private javax.swing.JMenuItem MenuPagar;
    private javax.swing.JMenuItem MenuReceber;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JMenuItem listagemCadastroPacientes;
    private javax.swing.JMenuItem listagemCadastroProcedimentos;
    private javax.swing.JMenu menuFinanceiro;
    private javax.swing.JMenuItem relatorioAgendamentoPorPeriodo;
    private javax.swing.JMenuItem relatorioContasPagar;
    // End of variables declaration//GEN-END:variables
}
