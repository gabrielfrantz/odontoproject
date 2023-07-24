package tela;

import entidade.Agendamento;
import java.awt.Dimension;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.table.DefaultTableModel;
import persistencia.CombosDAO;
import persistencia.ConexaoBD;
import persistencia.PacienteDAO;
import persistencia.AgendamentoDAO;
import persistencia.Formatacao;

/**
 *
 * @author gabriel.frantz
 */
public class IfrmAgenda extends javax.swing.JInternalFrame {

    Formatacao f = new Formatacao();
    Agendamento agendamento = new Agendamento();
    ResultSet resultadoQ = null;
    int idPaciente;
    int codigo = 0;

    public IfrmAgenda() {
        initComponents();
        new CombosDAO().popularCombo3("dentista", comboDentista);
        f.getDataAtual();
    }

    public void limpaCampos() {
        ((DefaultTableModel) tblPacienteConsulta.getModel()).setRowCount(0);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnSair = new javax.swing.JButton();
        menuAgenda = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        txtBuscarPacienteConsulta = new javax.swing.JTextField();
        btnBuscarPacienteConsulta = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblPacienteConsulta = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        txtDataDe = new javax.swing.JTextField();
        String dataAtual = Formatacao.getDataAtual();
        txtDataDe.setText(dataAtual);
        jLabel4 = new javax.swing.JLabel();
        txtDataAte = new javax.swing.JTextField();
        String dataAtual1 = Formatacao.getDataAtual();
        txtDataAte.setText(dataAtual1);
        jLabel2 = new javax.swing.JLabel();
        comboDentista = new javax.swing.JComboBox();
        btnCancelarAgendamento = new javax.swing.JButton();
        btnEditarAgendamento = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnNovoAgendamento = new javax.swing.JButton();

        setTitle("Odonto+");

        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        jLabel10.setText("Paciente:");

        btnBuscarPacienteConsulta.setText("Buscar");
        btnBuscarPacienteConsulta.setMaximumSize(new java.awt.Dimension(73, 23));
        btnBuscarPacienteConsulta.setMinimumSize(new java.awt.Dimension(73, 23));
        btnBuscarPacienteConsulta.setPreferredSize(new java.awt.Dimension(73, 23));
        btnBuscarPacienteConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarPacienteConsultaActionPerformed(evt);
            }
        });

        tblPacienteConsulta.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(tblPacienteConsulta);

        jLabel3.setText("De:");

        jLabel4.setText("Até:");

        jLabel2.setText("Dentista:");

        comboDentista.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txtDataDe, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(txtDataAte, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(comboDentista, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnBuscarPacienteConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtBuscarPacienteConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 737, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(69, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 797, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(66, 66, 66)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtBuscarPacienteConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtDataDe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtDataAte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarPacienteConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(comboDentista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(342, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                    .addGap(77, 77, 77)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        menuAgenda.addTab("Consultar", jPanel3);

        btnCancelarAgendamento.setText("Cancelar Agendamento");
        btnCancelarAgendamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarAgendamentoActionPerformed(evt);
            }
        });

        btnEditarAgendamento.setText("Editar Agendamento");
        btnEditarAgendamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarAgendamentoActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Agendamento");

        btnNovoAgendamento.setText("Novo");
        btnNovoAgendamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoAgendamentoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(342, 342, 342))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(204, 204, 204)
                        .addComponent(btnNovoAgendamento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEditarAgendamento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelarAgendamento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSair))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(menuAgenda, javax.swing.GroupLayout.PREFERRED_SIZE, 829, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(menuAgenda)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEditarAgendamento)
                    .addComponent(btnCancelarAgendamento)
                    .addComponent(btnSair)
                    .addComponent(btnNovoAgendamento))
                .addGap(19, 19, 19))
        );

        setSize(new java.awt.Dimension(865, 572));
    }// </editor-fold>//GEN-END:initComponents

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnCancelarAgendamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarAgendamentoActionPerformed
        int linha = tblPacienteConsulta.getSelectedRow();
        if (linha > -1) {
            try {
                String codigoS = String.valueOf(tblPacienteConsulta.getValueAt(tblPacienteConsulta.getSelectedRow(), 0));
                Statement st = ConexaoBD.getInstance().getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                String sql = "SELECT agendamento.id FROM agendamento INNER JOIN paciente ON agendamento.paciente_id = paciente.id WHERE agendamento.id='" + codigoS + "'";
                System.out.println("Sql: " + sql);
                resultadoQ = st.executeQuery(sql);
                resultadoQ.next();
                idPaciente = resultadoQ.getInt("id");
            } catch (SQLException ex) {
                Logger.getLogger(IfrmAgenda.class.getName()).log(Level.SEVERE, null, ex);
            }
            String retorno = new AgendamentoDAO().excluir(idPaciente);
            new AgendamentoDAO().popularTabela(tblPacienteConsulta, txtBuscarPacienteConsulta.getText(), txtDataDe.getText(), txtDataAte.getText(), comboDentista.getSelectedItem().toString());
            if (retorno == null) {
                ((DefaultTableModel) tblPacienteConsulta.getModel()).setRowCount(0);
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao cancelar agendamento!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um agendamento para cancelar!", "Informação", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnCancelarAgendamentoActionPerformed

    private void btnEditarAgendamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarAgendamentoActionPerformed
        int linha = tblPacienteConsulta.getSelectedRow();
        if (linha > -1) {
            try {
                idPaciente = (int) (tblPacienteConsulta.getValueAt(tblPacienteConsulta.getSelectedRow(), 0));
                String nomePaciente = String.valueOf(tblPacienteConsulta.getValueAt(tblPacienteConsulta.getSelectedRow(), 1));
                Statement st = ConexaoBD.getInstance().getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                String sql = "SELECT agendamento.id FROM agendamento INNER JOIN paciente ON agendamento.paciente_id = paciente.id WHERE agendamento.id='" + idPaciente + "'";
                System.out.println("Sql: " + sql);
                resultadoQ = st.executeQuery(sql);
                resultadoQ.next();
                idPaciente = resultadoQ.getInt("id");
                JfrmNovoAgendamento novoAgendamento = new JfrmNovoAgendamento(idPaciente, nomePaciente);
                novoAgendamento.setVisible(true);
                new AgendamentoDAO().popularTabela(tblPacienteConsulta, txtBuscarPacienteConsulta.getText(), txtDataDe.getText(), txtDataAte.getText(), comboDentista.getSelectedItem().toString());
            } catch (SQLException ex) {
                Logger.getLogger(IfrmAgenda.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um agendamento para editar!", "Informação", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnEditarAgendamentoActionPerformed

    private void btnNovoAgendamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoAgendamentoActionPerformed
        JdlNovoAgendamento novoAgendamento = new JdlNovoAgendamento(this, rootPaneCheckingEnabled);
        novoAgendamento.setVisible(true);
    }//GEN-LAST:event_btnNovoAgendamentoActionPerformed

    private void btnBuscarPacienteConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarPacienteConsultaActionPerformed
        if (txtDataDe.getText().equals("  /  /    ") || txtDataDe.getText().isEmpty() || txtDataDe.getText() == null || txtDataAte.getText().equals("  /  /    ") || txtDataAte.getText().isEmpty() || txtDataAte.getText() == null && comboDentista.getSelectedItem().toString() == null || comboDentista.getSelectedItem().toString().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, preencha as datas corretamente e selecione um Dentista antes de clicar no botão Buscar!");
            txtDataDe.requestFocus();
            btnEditarAgendamento.setEnabled(true);
            btnCancelarAgendamento.setEnabled(true);
        } else if (comboDentista.getSelectedItem().toString().contains("Todos")) {
            new AgendamentoDAO().popularTabela2(tblPacienteConsulta, txtBuscarPacienteConsulta.getText(), txtDataDe.getText(), txtDataAte.getText());
        } else {
            new AgendamentoDAO().popularTabela(tblPacienteConsulta, txtBuscarPacienteConsulta.getText(), txtDataDe.getText(), txtDataAte.getText(), comboDentista.getSelectedItem().toString());
        }
    }//GEN-LAST:event_btnBuscarPacienteConsultaActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarPacienteConsulta;
    private javax.swing.JButton btnCancelarAgendamento;
    private javax.swing.JButton btnEditarAgendamento;
    private javax.swing.JButton btnNovoAgendamento;
    private javax.swing.JButton btnSair;
    private javax.swing.JComboBox comboDentista;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane menuAgenda;
    private javax.swing.JTable tblPacienteConsulta;
    private javax.swing.JTextField txtBuscarPacienteConsulta;
    private javax.swing.JTextField txtDataAte;
    private javax.swing.JTextField txtDataDe;
    // End of variables declaration//GEN-END:variables
}
