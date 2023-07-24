package persistencia;

import entidade.Agendamento;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author GabrielFrantz
 */
public class AgendamentoDAO implements IDAO_T<Agendamento> {

    Agendamento agendamento;
    Formatacao f = new Formatacao();
    ResultSet resultadoQ = null;
    ConexaoBD conexao = new ConexaoBD();
    ConexaoBD conexaoPaciente = new ConexaoBD();
    ConexaoBD conexaoDentista = new ConexaoBD();
    ConexaoBD conexaoProcedimento = new ConexaoBD();
    int idPaciente;
    int idDentista;
    int idProcedimento;
    String nomeDentista;

    @Override
    public String salvar(Agendamento o) {
        agendamento = (Agendamento) o;
        buscaPaciente(agendamento.getNomePaciente());
        buscaDentista(agendamento.getNomeDentista());
        buscaProcedimento(agendamento.getNomeProcedimento());
        try {
            if (!consultaHorario((new java.sql.Date(agendamento.getData().getTime())), (new java.sql.Time(agendamento.getHoraInicio().getTime())), (new java.sql.Time(agendamento.getHoraFim().getTime())), idDentista)) {
                Statement st = ConexaoBD.getInstance().getConnection().createStatement();
                String sql = "INSERT INTO agendamento (id, data, hora_inicio, hora_fim, paciente_id, dentista_id, procedimento_id) VALUES("
                        + "DEFAULT, "
                        + "'" + new java.sql.Date(agendamento.getData().getTime()) + "',"
                        + "'" + new java.sql.Time(agendamento.getHoraInicio().getTime()) + "',"
                        + "'" + new java.sql.Time(agendamento.getHoraFim().getTime()) + "',"
                        + "'" + idPaciente + "',"
                        + "'" + idDentista + "',"
                        + "'" + idProcedimento + "'"
                        + ");";
                System.out.println("Sql: " + sql);
                st.executeUpdate(sql);
                JOptionPane.showMessageDialog(null, "Agendamento efetuado com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Já existe um paciente cadastrado para esse dentista nesse horário e nesse mesmo dia!");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao efetuar agendamento: " + ex);
        }
        return null;
    }

    public void buscaPaciente(String nomePaciente) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            String sql = "SELECT * FROM paciente WHERE nome='" + nomePaciente + "'";
            System.out.println("Sql: " + sql);
            resultadoQ = st.executeQuery(sql);
            resultadoQ.next();
            idPaciente = resultadoQ.getInt("id");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar paciente: " + ex);
        }
    }

    public void buscaDentista(String nomeDentista) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            String sql = "SELECT * FROM dentista WHERE dentista='" + nomeDentista + "'";
            System.out.println("Sql: " + sql);
            resultadoQ = st.executeQuery(sql);
            resultadoQ.next();
            idDentista = resultadoQ.getInt("id");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar dentista: " + ex);
        }
    }

    public void buscaProcedimento(String nomeProcedimento) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            String sql = "SELECT * FROM procedimento WHERE descricao='" + nomeProcedimento + "'";
            System.out.println("Sql: " + sql);
            resultadoQ = st.executeQuery(sql);
            resultadoQ.first();
            idProcedimento = resultadoQ.getInt("id");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar procedimento: " + ex);
        }
    }

    private boolean consultaHorario(Date dataHorario, Date horaInicio, Date horaFim, int idDentista) throws SQLException {
        System.out.println("DATA: "+dataHorario);
        System.out.println("HORA I: "+horaInicio);
        System.out.println("HORA F: "+horaFim);
        System.out.println("DENTI: "+idDentista);
        Statement st = ConexaoBD.getInstance().getConnection().createStatement();
        String sql = "SELECT * FROM agendamento INNER JOIN dentista ON agendamento.dentista_id = dentista.id"
                + " WHERE data='" + dataHorario + "' AND hora_inicio BETWEEN '" + horaInicio + "' AND '" + horaFim + "' "
                + "OR hora_fim BETWEEN '" + horaInicio + "' AND '" + horaFim + "' AND dentista.id='" + idDentista + "'";
        System.out.println("Sql: " + sql);
        resultadoQ = st.executeQuery(sql);
        try {
            if (resultadoQ.next()) {
                return true;
            }
        } catch (Exception ex) {
            Logger.getLogger(AgendamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public String atualizar(Agendamento o) {
        agendamento = (Agendamento) o;
        buscaPaciente(agendamento.getNomePaciente());
        buscaDentista(agendamento.getNomeDentista());
        buscaProcedimento(agendamento.getNomeProcedimento());
        try {
            if (!consultaHorario((new java.sql.Date(agendamento.getData().getTime())), (new java.sql.Time(agendamento.getHoraInicio().getTime())), (new java.sql.Time(agendamento.getHoraFim().getTime())), idDentista)) {
                Statement st = ConexaoBD.getInstance().getConnection().createStatement();
                String sql = "UPDATE agendamento "
                        + "SET data = '" + new java.sql.Date(agendamento.getData().getTime()) + "',"
                        + "hora_inicio = '" + new java.sql.Time(agendamento.getHoraInicio().getTime()) + "',"
                        + "hora_fim = '" + new java.sql.Time(agendamento.getHoraFim().getTime()) + "',"
                        + "paciente_id = '" + idPaciente + "',"
                        + "dentista_id = '" + idDentista + "',"
                        + "procedimento_id = '" + idProcedimento + "'"
                        + "WHERE id = " + agendamento.getId();
                System.out.println("SQL: " + sql);
                int resultado = st.executeUpdate(sql);
                if (resultado == 0) {
                    return "Erro ao atualizar agendamento!";
                } else {
                    JOptionPane.showMessageDialog(null, "Agendamento atualizado com sucesso!");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Já existe um paciente cadastrado para esse dentista nesse horário e nesse mesmo dia!");
            }
        } catch (Exception e) {
            System.out.println("Erro ao atualizar agendamento: " + e);
            return e.toString();
        }
        return null;
    }

    @Override
    public ArrayList<Agendamento> consultarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Agendamento> consultar(String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Agendamento consultarId(int id) {
        Agendamento agendamento = null;
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            String sql = ("SELECT paciente.nome, data, hora_inicio, hora_fim, descricao, dentista \n"
                    + "FROM agendamento \n"
                    + "INNER JOIN paciente ON agendamento.paciente_id = paciente.id \n"
                    + "INNER JOIN procedimento ON agendamento.procedimento_id = procedimento.id \n"
                    + "INNER JOIN dentista ON agendamento.dentista_id = dentista.id \n"
                    + "WHERE agendamento.id ='" + id + "'");
            System.out.println("Sql: " + sql);
            resultadoQ = st.executeQuery(sql);
            while (resultadoQ.next()) {
                agendamento = new Agendamento();
                agendamento.setId(id);
                agendamento.setNomePaciente(resultadoQ.getString("nome"));
                agendamento.setData(resultadoQ.getDate("data"));
                agendamento.setHoraInicio(resultadoQ.getTime("hora_inicio"));
                agendamento.setHoraFim(resultadoQ.getTime("hora_fim"));
                agendamento.setNomeProcedimento(resultadoQ.getString("descricao"));
                agendamento.setNomeDentista(resultadoQ.getString("dentista"));
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao consultar agenda: " + ex);
        }
        return agendamento;
    }

    @Override
    public String excluir(int id) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            String sql = ""
                    + "DELETE FROM agendamento "
                    + "WHERE id = " + id;
            System.out.println("Sql: " + sql);
            int resultado = st.executeUpdate(sql);
            if (resultado == 0) {
                return "Erro ao cancelar agendamento!";
            } else {
                JOptionPane.showMessageDialog(null, "Agendamento cancelado com sucesso!");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao cancelar agendamento: " + e);
            return e.toString();
        }
        return null;
    }

    public void popularTabela(JTable tabela, String criterio, String dataIni, String dataFim, String dentista) {
        Object[][] dadosTabela = null;
        Object[] cabecalho = new Object[7];
        cabecalho[0] = "Nº. do Paciente";
        cabecalho[1] = "Paciente";
        cabecalho[2] = "Data";
        cabecalho[3] = "Início";
        cabecalho[4] = "Fim";
        cabecalho[5] = "Procedimento";
        cabecalho[6] = "Dentista";
        try {
            resultadoQ = ConexaoBD.getInstance().getConnection().createStatement().executeQuery("SELECT count(*)\n"
                    + "FROM agendamento \n"
                    + "INNER JOIN paciente ON agendamento.paciente_id = paciente.id \n"
                    + "INNER JOIN procedimento ON agendamento.procedimento_id = procedimento.id \n"
                    + "INNER JOIN dentista ON agendamento.dentista_id = dentista.id \n"
                    + "WHERE lower(paciente.nome) ILIKE '%" + criterio + "%' AND agendamento.data BETWEEN '" + dataIni + "' AND '" + dataFim + "' AND dentista='" + dentista + "'");
            resultadoQ.next();
            dadosTabela = new Object[resultadoQ.getInt(1)][7];
        } catch (Exception e) {
            System.out.println("Erro ao consultar agenda: " + e);
        }
        int lin = 0;
        try {
            resultadoQ = ConexaoBD.getInstance().getConnection().createStatement().executeQuery("SELECT agendamento.id, paciente.nome, data, hora_inicio, hora_fim, descricao, dentista \n"
                    + "FROM agendamento \n"
                    + "INNER JOIN paciente ON agendamento.paciente_id = paciente.id \n"
                    + "INNER JOIN procedimento ON agendamento.procedimento_id = procedimento.id \n"
                    + "INNER JOIN dentista ON agendamento.dentista_id = dentista.id \n"
                    + "WHERE lower(paciente.nome) LIKE '%" + criterio + "%' AND agendamento.data BETWEEN '" + dataIni + "' AND '" + dataFim + "' AND dentista='" + dentista + "'ORDER BY data,hora_inicio,hora_fim");
            while (resultadoQ.next()) {
                dadosTabela[lin][0] = resultadoQ.getInt("id");
                dadosTabela[lin][1] = resultadoQ.getString("nome");
                dadosTabela[lin][2] = f.ajustaDataDMA(resultadoQ.getDate("data").toString());
                dadosTabela[lin][3] = f.ajustaHoraHM(resultadoQ.getTime("hora_inicio").toString());
                dadosTabela[lin][4] = f.ajustaHoraHM(resultadoQ.getTime("hora_fim").toString());
                dadosTabela[lin][5] = resultadoQ.getString("descricao");
                dadosTabela[lin][6] = "Dr(a). " + resultadoQ.getString("dentista");
                lin++;
            }
        } catch (Exception e) {
            System.out.println("Problemas ao popular a tabela de agendamentos...");
            System.out.println(e);
        }
        tabela.setModel(new DefaultTableModel(dadosTabela, cabecalho) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

            @Override
            public Class
                    getColumnClass(int column) {

                if (column == 2) {
                }
                return Object.class;
            }
        });
        tabela.setSelectionMode(0);
        TableColumn column = null;
        for (int i = 0; i < tabela.getColumnCount(); i++) {
            column = tabela.getColumnModel().getColumn(i);
            switch (i) {
                case 0:
                    column.setPreferredWidth(17);
                    break;
                case 1:
                    column.setPreferredWidth(140);
                    break;
            }
        }
    }
    
    public void popularTabela2(JTable tabela, String criterio, String dataIni, String dataFim) {
        Object[][] dadosTabela = null;
        Object[] cabecalho = new Object[7];
        cabecalho[0] = "Nº. do Paciente";
        cabecalho[1] = "Paciente";
        cabecalho[2] = "Data";
        cabecalho[3] = "Início";
        cabecalho[4] = "Fim";
        cabecalho[5] = "Procedimento";
        cabecalho[6] = "Dentista";
        try {
            resultadoQ = ConexaoBD.getInstance().getConnection().createStatement().executeQuery("SELECT count(*)\n"
                    + "FROM agendamento \n"
                    + "INNER JOIN paciente ON agendamento.paciente_id = paciente.id \n"
                    + "INNER JOIN procedimento ON agendamento.procedimento_id = procedimento.id \n"
                    + "INNER JOIN dentista ON agendamento.dentista_id = dentista.id \n"
                    + "WHERE lower(paciente.nome) ILIKE '%" + criterio + "%' AND agendamento.data BETWEEN '" + dataIni + "' AND '" + dataFim + "'");
            resultadoQ.next();
            dadosTabela = new Object[resultadoQ.getInt(1)][7];
        } catch (Exception e) {
            System.out.println("Erro ao consultar agenda: " + e);
        }
        int lin = 0;
        try {
            resultadoQ = ConexaoBD.getInstance().getConnection().createStatement().executeQuery("SELECT agendamento.id, paciente.nome, data, hora_inicio, hora_fim, descricao, dentista \n"
                    + "FROM agendamento \n"
                    + "INNER JOIN paciente ON agendamento.paciente_id = paciente.id \n"
                    + "INNER JOIN procedimento ON agendamento.procedimento_id = procedimento.id \n"
                    + "INNER JOIN dentista ON agendamento.dentista_id = dentista.id \n"
                    + "WHERE lower(paciente.nome) LIKE '%" + criterio + "%' AND agendamento.data BETWEEN '" + dataIni + "' AND '" + dataFim + "' ORDER BY data,hora_inicio,hora_fim");
            while (resultadoQ.next()) {
                dadosTabela[lin][0] = resultadoQ.getInt("id");
                dadosTabela[lin][1] = resultadoQ.getString("nome");
                dadosTabela[lin][2] = f.ajustaDataDMA(resultadoQ.getDate("data").toString());
                dadosTabela[lin][3] = f.ajustaHoraHM(resultadoQ.getTime("hora_inicio").toString());
                dadosTabela[lin][4] = f.ajustaHoraHM(resultadoQ.getTime("hora_fim").toString());
                dadosTabela[lin][5] = resultadoQ.getString("descricao");
                dadosTabela[lin][6] = "Dr(a). " + resultadoQ.getString("dentista");
                lin++;
            }
        } catch (Exception e) {
            System.out.println("Problemas ao popular a tabela de agendamentos...");
            System.out.println(e);
        }
        tabela.setModel(new DefaultTableModel(dadosTabela, cabecalho) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

            @Override
            public Class
                    getColumnClass(int column) {

                if (column == 2) {
                }
                return Object.class;
            }
        });
        tabela.setSelectionMode(0);
        TableColumn column = null;
        for (int i = 0; i < tabela.getColumnCount(); i++) {
            column = tabela.getColumnModel().getColumn(i);
            switch (i) {
                case 0:
                    column.setPreferredWidth(17);
                    break;
                case 1:
                    column.setPreferredWidth(140);
                    break;
            }
        }
    }
}

