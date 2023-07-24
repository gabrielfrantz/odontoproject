package tela;

import entidade.Agendamento;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.table.DefaultTableModel;
import persistencia.AgendamentoDAO;
import persistencia.CombosDAO;
import persistencia.ConexaoBD;
import persistencia.Formatacao;
import persistencia.PacienteDAO;

/**
 *
 * @author gabriel.frantz
 */
public class JfrmNovoAgendamento extends javax.swing.JFrame {

    Formatacao f = new Formatacao();
    Agendamento agendamento = new Agendamento();
    ResultSet resultadoQ = null;
    int idPaciente;

    public JfrmNovoAgendamento() {
        initComponents();
        new CombosDAO().popularCombo1("procedimento", comboProcedimento);
        new CombosDAO().popularCombo2("dentista", comboDentista);
    }

    public JfrmNovoAgendamento(int idPaciente, String nomePaciente) {
        initComponents();
        new CombosDAO().popularCombo1("procedimento", comboProcedimento);
        new CombosDAO().popularCombo2("dentista", comboDentista);
        Agendamento agendamento = new AgendamentoDAO().consultarId(idPaciente);
        if (agendamento != null) {
            txtBuscarPaciente.setText(nomePaciente);
            chooserData.setDate(agendamento.getData());
            spinnerHoraInicio.setValue(agendamento.getHoraInicio());
            spinnerHoraFim.setValue(agendamento.getHoraFim());
            comboProcedimento.getModel().setSelectedItem(agendamento.getNomeProcedimento());
            comboDentista.getModel().setSelectedItem(agendamento.getNomeDentista());
            txtBuscarPaciente.requestFocus();
            this.idPaciente = agendamento.getId();
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao consultar registro!");
        }
    }

    public void limpaCampos() {
        txtBuscarPaciente.setText("");
        chooserData.setDate(null);
        ((DefaultTableModel) tblPaciente.getModel()).setRowCount(0);
        comboDentista.getModel().setSelectedItem("Selecione");
        comboProcedimento.getModel().setSelectedItem("Selecione");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuAgenda = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtBuscarPaciente = new javax.swing.JTextField();
        btnBuscarPaciente = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        chooserData = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        Date date = new Date();
        SpinnerDateModel sm = new SpinnerDateModel(date, null, null, Calendar.HOUR_OF_DAY);
        spinnerHoraInicio = new javax.swing.JSpinner(sm);
        JSpinner.DateEditor de = new JSpinner.DateEditor(spinnerHoraInicio, "HH:mm");
        spinnerHoraInicio.setEditor(de)
        ;
        jLabel5 = new javax.swing.JLabel();
        Date date1 = new Date();
        SpinnerDateModel sm1 = new SpinnerDateModel(date1, null, null, Calendar.HOUR_OF_DAY);
        spinnerHoraFim = new javax.swing.JSpinner(sm1);
        JSpinner.DateEditor de1 = new JSpinner.DateEditor(spinnerHoraFim, "HH:mm");
        spinnerHoraFim.setEditor(de1)
        ;
        jLabel9 = new javax.swing.JLabel();
        comboProcedimento = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        comboDentista = new javax.swing.JComboBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblPaciente = new javax.swing.JTable();
        btnAgendar = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Odonto+");

        menuAgenda.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel6.setText("Paciente:*");

        btnBuscarPaciente.setText("Buscar");
        btnBuscarPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarPacienteActionPerformed(evt);
            }
        });

        jLabel8.setText("Data:*");

        jLabel2.setText("Início:*");

        jLabel5.setText("Fim:*");

        jLabel9.setText("Procedimento:*");

        comboProcedimento.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel7.setText("Dentista:*");

        comboDentista.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        tblPaciente.setModel(new javax.swing.table.DefaultTableModel(
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
        tblPaciente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPacienteMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblPaciente);

        javax.swing.GroupLayout menuAgendaLayout = new javax.swing.GroupLayout(menuAgenda);
        menuAgenda.setLayout(menuAgendaLayout);
        menuAgendaLayout.setHorizontalGroup(
            menuAgendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuAgendaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(menuAgendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(menuAgendaLayout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(comboProcedimento, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(comboDentista, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(menuAgendaLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(2, 2, 2)
                        .addComponent(txtBuscarPaciente, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBuscarPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(chooserData, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(spinnerHoraInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(spinnerHoraFim, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        menuAgendaLayout.setVerticalGroup(
            menuAgendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuAgendaLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(menuAgendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(menuAgendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(txtBuscarPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnBuscarPaciente)
                        .addComponent(jLabel8))
                    .addGroup(menuAgendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(chooserData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(menuAgendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(spinnerHoraInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(spinnerHoraFim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)
                .addGap(12, 12, 12)
                .addGroup(menuAgendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboProcedimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel7)
                    .addComponent(comboDentista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(61, 61, 61))
        );

        btnAgendar.setText("Agendar");
        btnAgendar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgendarActionPerformed(evt);
            }
        });

        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Agendamento");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAgendar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSair)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(menuAgenda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(425, 425, 425)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(menuAgenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgendar)
                    .addComponent(btnSair))
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(1063, 598));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarPacienteActionPerformed
        new PacienteDAO().popularTabela(tblPaciente, txtBuscarPaciente.getText());
        btnAgendar.setEnabled(true);
    }//GEN-LAST:event_btnBuscarPacienteActionPerformed

    private void btnAgendarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgendarActionPerformed
        agendamento.setId(idPaciente);
        AgendamentoDAO agendamentoDao = new AgendamentoDAO();
        if (txtBuscarPaciente.getText() == null || txtBuscarPaciente.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Campo de pesquisa de paciente em branco, por favor, clique em buscar e selecione o paciente para realizar o agendamento!");
            txtBuscarPaciente.requestFocus();
        } else {
            agendamento.setNomePaciente(txtBuscarPaciente.getText());
            if (chooserData.getDate() == null) {
                JOptionPane.showMessageDialog(this, "Campo data em branco, por favor, escolha uma data para realizar o agendamento!");
                chooserData.requestFocus();
            } else {
                agendamento.setData(chooserData.getDate());
                agendamento.setHoraInicio((Date) spinnerHoraInicio.getValue());
                agendamento.setHoraFim((Date) spinnerHoraFim.getValue());
                if (comboProcedimento.getSelectedItem().toString() == null || comboProcedimento.getSelectedItem().toString().isEmpty() || comboProcedimento.getSelectedItem().toString().contains("Selecione")) {
                    JOptionPane.showMessageDialog(this, "Campo procedimento em branco, por favor, escolha um procedimento para realizar o agendamento!");
                    comboProcedimento.requestFocus();
                } else {
                    agendamento.setNomeProcedimento(comboProcedimento.getSelectedItem().toString());
                    if (comboDentista.getSelectedItem().toString() == null || comboDentista.getSelectedItem().toString().isEmpty() || comboDentista.getSelectedItem().toString().contains("Selecione")) {
                        JOptionPane.showMessageDialog(this, "Campo dentista em branco, por favor, escolha um dentista para realizar o agendamento!");
                        comboDentista.requestFocus();
                    } else {
                        agendamento.setNomeDentista(comboDentista.getSelectedItem().toString());
                        String retorno = null;
                        if (idPaciente == 0) {
                            retorno = agendamentoDao.salvar(agendamento);
                        } else {
                            retorno = agendamentoDao.atualizar(agendamento);
                        }
                        if (retorno == null) {
                            txtBuscarPaciente.requestFocus();
                            idPaciente = 0;
                        }
                    }
                }
            }
        }
    }//GEN-LAST:event_btnAgendarActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    private void tblPacienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPacienteMouseClicked
        String nome = "" + tblPaciente.getValueAt(tblPaciente.getSelectedRow(), 1);
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            String sql = "SELECT * FROM paciente WHERE nome='" + nome + "'";
            System.out.println("Sql: " + sql);
            resultadoQ = st.executeQuery(sql);
            resultadoQ.first();
            txtBuscarPaciente.setText(resultadoQ.getString("nome"));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao selecionar paciente: " + ex);
        }
    }//GEN-LAST:event_tblPacienteMouseClicked

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
            java.util.logging.Logger.getLogger(JfrmNovoAgendamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JfrmNovoAgendamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JfrmNovoAgendamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JfrmNovoAgendamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JfrmNovoAgendamento().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgendar;
    private javax.swing.JButton btnBuscarPaciente;
    private javax.swing.JButton btnSair;
    private com.toedter.calendar.JDateChooser chooserData;
    private javax.swing.JComboBox comboDentista;
    private javax.swing.JComboBox comboProcedimento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel menuAgenda;
    private javax.swing.JSpinner spinnerHoraFim;
    private javax.swing.JSpinner spinnerHoraInicio;
    private javax.swing.JTable tblPaciente;
    private javax.swing.JTextField txtBuscarPaciente;
    // End of variables declaration//GEN-END:variables
}
