package persistencia;

import entidade.ContasReceber;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.NumberFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author gabriel.frantz
 */
public class ContasReceberDAO implements IDAO_T<ContasReceber> {

    ResultSet resultadoQ = null;
    ContasReceber receber;
    Formatacao f = new Formatacao();
    ConexaoBD conexao = new ConexaoBD();
    ConexaoBD conexaoPaciente = new ConexaoBD();
    ConexaoBD conexaoProcedimento = new ConexaoBD();
    int idPaciente;
    int idProcedimento;

    @Override
    public String salvar(ContasReceber o) {
        receber = (ContasReceber) o;
        buscaPaciente(receber.getPaciente());
        buscaProcedimento(receber.getProcedimento());
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            String sql = "INSERT INTO contas_receber VALUES("
                    + "DEFAULT, "
                    + "'" + receber.getData_emissao() + "',"
                    + "'" + receber.getData_vencimento() + "',"
                    + "'" + receber.getValor_total() + "',"
                    + "'" + receber.getValor_recebido() + "',"
                    + "'" + receber.getValor_atualizado() + "',"
                    + "'" + receber.getValor_total_tela() + "',"
                    + "'" + receber.getStatus() + "',"
                    + "'" + idProcedimento + "',"
                    + "'" + idPaciente + "',"
                    + "'" + idPaciente + "'"
                    + ");";
            System.out.println("Sql: " + sql);
            int resultado = st.executeUpdate(sql);
            if (resultado == 0) {
                return "Erro ao cadastrar receita!";
            } else {
                JOptionPane.showMessageDialog(null, "Receita cadastrada com sucesso!");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar receita: " + ex);
        }
        return null;
    }

    public void buscaPaciente(String nomePaciente) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            String sql = "SELECT * FROM paciente WHERE nome='" + nomePaciente + "'";
            System.out.println("Sql: " + sql);
            resultadoQ = st.executeQuery(sql);
            resultadoQ.first();
            idPaciente = resultadoQ.getInt("id");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar paciente: " + ex);
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

    @Override
    public String atualizar(ContasReceber o) {
        receber = (ContasReceber) o;
        buscaPaciente(receber.getPaciente());
        buscaProcedimento(receber.getProcedimento());
        if (receber.getStatus() == 1) {
            try {
                Statement st = ConexaoBD.getInstance().getConnection().createStatement();
                String sql = "UPDATE contas_receber "
                        + "SET data_emissao = '" + receber.getData_emissao() + "',"
                        + "data_vencimento = '" + receber.getData_vencimento() + "',"
                        + "valor_total = '" + receber.getValor_total() + "',"
                        + "valor_recebido = '" + receber.getValor_recebido() + "',"
                        + "valor_atualizado = '" + receber.getValor_atualizado() + "',"
                        + "valor_total_tela = '" + receber.getValor_total_tela() + "',"
                        + "status = '" + receber.getStatus() + "',"
                        + "procedimento_id = '" + idProcedimento + "',"
                        + "paciente_id = '" + idPaciente + "',"
                        + "cod_paciente = '" + idPaciente + "'"
                        + "WHERE id = " + receber.getId();
                System.out.println("SQL: " + sql);
                int resultado = st.executeUpdate(sql);
                if (resultado == 0) {
                    return "Erro ao atualizar receita!";
                } else {
                    JOptionPane.showMessageDialog(null, "Está receita foi recebida por completo!");
                }
            } catch (Exception e) {
                System.out.println("Erro ao atualizar receita: " + e);
                return e.toString();
            }
        } else {
            try {
                Statement st = ConexaoBD.getInstance().getConnection().createStatement();
                String sql = "UPDATE contas_receber "
                        + "SET data_emissao = '" + receber.getData_emissao() + "',"
                        + "data_vencimento = '" + receber.getData_vencimento() + "',"
                        + "valor_total = '" + receber.getValor_total() + "',"
                        + "valor_recebido = '" + receber.getValor_recebido() + "',"
                        + "valor_atualizado = '" + receber.getValor_atualizado() + "',"
                        + "valor_total_tela = '" + receber.getValor_total_tela() + "',"
                        + "status = '" + receber.getStatus() + "',"
                        + "procedimento_id = '" + idProcedimento + "',"
                        + "paciente_id = '" + idPaciente + "',"
                        + "cod_paciente = '" + idPaciente + "'"
                        + "WHERE id = " + receber.getId();
                System.out.println("SQL: " + sql);
                int resultado = st.executeUpdate(sql);
                if (resultado == 0) {
                    return "Erro ao atualizar receita!";
                } else {
                    JOptionPane.showMessageDialog(null, "Receita atualizada com sucesso!");
                }
            } catch (Exception e) {
                System.out.println("Erro ao atualizar receita: " + e);
                return e.toString();
            }
        }
        return null;
    }

    @Override
    public ArrayList<ContasReceber> consultarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<ContasReceber> consultar(String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ContasReceber consultarId(int id) {
        ContasReceber receber = null;
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            String sql = "SELECT * FROM contas_receber WHERE id = '" + id + "'";
            System.out.println("Sql: " + sql);
            resultadoQ = st.executeQuery(sql);
            while (resultadoQ.next()) {
                receber = new ContasReceber();
                receber.setId(id);
                receber.setData_emissao(resultadoQ.getDate("data_emissao"));
                receber.setData_vencimento(resultadoQ.getDate("data_vencimento"));
                receber.setValor_total(resultadoQ.getDouble("valor_total"));
                receber.setValor_recebido(resultadoQ.getDouble("valor_recebido"));
                receber.setValor_atualizado(resultadoQ.getDouble("valor_atualizado"));
                receber.setValor_total_tela(resultadoQ.getDouble("valor_total_tela"));
                receber.setStatus(resultadoQ.getInt("status"));
                receber.setProcedimento(String.valueOf(resultadoQ.getInt("procedimento_id")));
                receber.setPaciente(String.valueOf(resultadoQ.getInt("paciente_id")));
                receber.setCod_paciente(resultadoQ.getInt("cod_paciente"));
                return receber;
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao consultar receita: " + ex);
        }
        return null;
    }

    public ContasReceber consultarId2(int id, String nomePaciente, String nomeProcedimento) {
        ContasReceber receber = null;
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            String sql = "SELECT * FROM contas_receber WHERE id = '" + id + "'";
            System.out.println("Sql: " + sql);
            resultadoQ = st.executeQuery(sql);
            while (resultadoQ.next()) {
                receber = new ContasReceber();
                receber.setId(id);
                receber.setData_emissao(resultadoQ.getDate("data_emissao"));
                receber.setData_vencimento(resultadoQ.getDate("data_vencimento"));
                receber.setValor_total(resultadoQ.getDouble("valor_total"));
                receber.setValor_recebido(resultadoQ.getDouble("valor_recebido"));
                receber.setValor_atualizado(resultadoQ.getDouble("valor_atualizado"));
                receber.setValor_total_tela(resultadoQ.getDouble("valor_total_tela"));
                receber.setStatus(resultadoQ.getInt("status"));
                receber.setProcedimento(nomeProcedimento);
                receber.setPaciente(nomePaciente);
                receber.setCod_paciente(resultadoQ.getInt("cod_paciente"));
                return receber;
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao consultar receita: " + ex);
        }
        return null;
    }

    @Override
    public String excluir(int id) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            String sql = ""
                    + "DELETE FROM contas_receber "
                    + "WHERE id = " + id;
            System.out.println("Sql: " + sql);
            int resultado = st.executeUpdate(sql);
            if (resultado == 0) {
                return "Erro ao excluir receita!";
            } else {
                JOptionPane.showMessageDialog(null, "Receita excluída com sucesso!");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao excluir receita: " + e);
            return e.toString();
        }
        return null;
    }

    public void popularTabelaNomePaciente(JTable tabela, String criterio, int status) {
        Object[][] dadosTabela = null;
        double valor;
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        Object[] cabecalho = new Object[8];
        cabecalho[0] = "Conta";
        cabecalho[1] = "Paciente";
        cabecalho[2] = "Procedimento";
        cabecalho[3] = "Data Emissão";
        cabecalho[4] = "Data Vencimento";
        cabecalho[5] = "Valor Total";
        cabecalho[6] = "Valor Recebido";
        cabecalho[7] = "Valor Atualizado";
        try {
            resultadoQ = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(""
                    + "SELECT count(*) \n"
                    + "FROM contas_receber \n"
                    + "INNER JOIN procedimento ON contas_receber.procedimento_id = procedimento.id \n"
                    + "INNER JOIN paciente ON contas_receber.paciente_id = paciente.id \n"
                    + "WHERE lower(paciente.nome) LIKE '%" + criterio + "%' AND status = " + status);
            resultadoQ.next();
            dadosTabela = new Object[resultadoQ.getInt(1)][8];
        } catch (Exception e) {
            System.out.println("Erro ao consultar receita: " + e);
        }
        int lin = 0;
        try {
            resultadoQ = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(""
                    + "SELECT contas_receber.id, nome, descricao, data_emissao, data_vencimento, valor_total, valor_recebido, valor_atualizado \n"
                    + "FROM contas_receber \n"
                    + "INNER JOIN procedimento ON contas_receber.procedimento_id = procedimento.id \n"
                    + "INNER JOIN paciente ON contas_receber.paciente_id = paciente.id \n"
                    + "WHERE lower(paciente.nome) LIKE '%" + criterio + "%'AND status = " + status + " ORDER BY contas_receber.id,nome,data_vencimento");
            while (resultadoQ.next()) {
                dadosTabela[lin][0] = resultadoQ.getInt("id");
                dadosTabela[lin][1] = resultadoQ.getString("nome");
                dadosTabela[lin][2] = resultadoQ.getString("descricao");
                String dataEmissao = f.ajustaDataDMA(resultadoQ.getString("data_emissao"));
                dadosTabela[lin][3] = dataEmissao;
                String dataVencimento = f.ajustaDataDMA(resultadoQ.getString("data_vencimento"));
                dadosTabela[lin][4] = dataVencimento;
                valor = resultadoQ.getDouble("valor_total");
                dadosTabela[lin][5] = nf.format(valor);
                valor = resultadoQ.getDouble("valor_recebido");
                dadosTabela[lin][6] = nf.format(valor);
                valor = resultadoQ.getDouble("valor_atualizado");
                dadosTabela[lin][7] = nf.format(valor);
                lin++;
            }
        } catch (Exception e) {
            System.out.println("Problemas ao popular a tabela de receitas...");
            System.out.println(e);
        }
        tabela.setModel(new DefaultTableModel(dadosTabela, cabecalho) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

            @Override
            public Class getColumnClass(int column) {
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

    public void popularTabelaVencimento(JTable tabela, String dataInicial, String dataFinal, int status, String nome) {
        Object[][] dadosTabela = null;
        double valor;
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        Object[] cabecalho = new Object[8];
        cabecalho[0] = "Conta";
        cabecalho[1] = "Paciente";
        cabecalho[2] = "Procedimento";
        cabecalho[3] = "Data Emissão";
        cabecalho[4] = "Data Vencimento";
        cabecalho[5] = "Valor Total";
        cabecalho[6] = "Valor Recebido";
        cabecalho[7] = "Valor Atualizado";
        try {
            resultadoQ = ConexaoBD.getInstance().getConnection().createStatement().executeQuery("SELECT count(*) FROM contas_receber \n"
                    + "INNER JOIN procedimento ON contas_receber.procedimento_id = procedimento.id \n"
                    + "INNER JOIN paciente ON contas_receber.paciente_id = paciente.id \n"
                    + " WHERE data_vencimento >= '" + dataInicial + "' AND data_vencimento <= '" + dataFinal + "' AND status = '" + status + "' AND lower(paciente.nome) LIKE '%" + nome + "%'");
            resultadoQ.next();
            dadosTabela = new Object[resultadoQ.getInt(1)][8];
        } catch (Exception e) {
            System.out.println("Erro ao consultar receita: " + e);
        }
        int lin = 0;
        try {
            resultadoQ = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(""
                    + "SELECT contas_receber.id, nome, descricao, data_emissao, data_vencimento, valor_total, valor_recebido, valor_atualizado \n"
                    + "FROM contas_receber \n"
                    + "INNER JOIN procedimento ON contas_receber.procedimento_id = procedimento.id \n"
                    + "INNER JOIN paciente ON contas_receber.paciente_id = paciente.id \n"
                    + "WHERE data_vencimento >= '" + dataInicial + "' AND data_vencimento <= '" + dataFinal + "' AND status = '" + status + "' AND lower(paciente.nome) LIKE '%" + nome + "%' ORDER BY contas_receber.id,nome,data_vencimento");
            while (resultadoQ.next()) {
                dadosTabela[lin][0] = resultadoQ.getInt("id");
                dadosTabela[lin][1] = resultadoQ.getString("nome");
                dadosTabela[lin][2] = resultadoQ.getString("descricao");
                String dataEmissao = f.ajustaDataDMA(resultadoQ.getString("data_emissao"));
                dadosTabela[lin][3] = dataEmissao;
                String dataVencimento = f.ajustaDataDMA(resultadoQ.getString("data_vencimento"));
                dadosTabela[lin][4] = dataVencimento;
                valor = resultadoQ.getDouble("valor_total");
                dadosTabela[lin][5] = nf.format(valor);
                valor = resultadoQ.getDouble("valor_recebido");
                dadosTabela[lin][6] = nf.format(valor);
                valor = resultadoQ.getDouble("valor_atualizado");
                dadosTabela[lin][7] = nf.format(valor);
                lin++;
            }
        } catch (Exception e) {
            System.out.println("Problemas ao popular a tabela de receitas...");
            System.out.println(e);
        }
        tabela.setModel(new DefaultTableModel(dadosTabela, cabecalho) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

            @Override
            public Class getColumnClass(int column) {
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
