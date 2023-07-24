package persistencia;

import entidade.ContasPagar;
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
public class ContasPagarDAO implements IDAO_T<ContasPagar> {

    ResultSet resultadoQ = null;
    ContasPagar pagar;
    Formatacao f = new Formatacao();
    ConexaoBD conexao = new ConexaoBD();
    ConexaoBD conexaoFornecedor = new ConexaoBD();
    int idFornecedor;

    @Override
    public String salvar(ContasPagar o) {
        pagar = (ContasPagar) o;
        buscaFornecedor(pagar.getFornecedor());
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            String sql = "INSERT INTO contas_pagar VALUES("
                    + "DEFAULT, "
                    + "'" + pagar.getDescricao() + "',"
                    + "'" + pagar.getData_compra() + "',"
                    + "'" + pagar.getData_vencimento() + "',"
                    + "'" + pagar.getValor_total() + "',"
                    + "'" + pagar.getValor_pago() + "',"
                    + "'" + pagar.getValor_atualizado() + "',"
                    + "'" + pagar.getValor_total_tela() + "',"
                    + "'" + pagar.getStatus() + "',"
                    + "'" + idFornecedor + "',"
                    + "'" + idFornecedor + "'"
                    + ");";
            System.out.println("Sql: " + sql);
            int resultado = st.executeUpdate(sql);
            if (resultado == 0) {
                return "Erro ao cadastrar despesa!";
            } else {
                JOptionPane.showMessageDialog(null, "Despesa cadastrada com sucesso!");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar despesa: " + ex);
        }
        return null;
    }

    public void buscaFornecedor(String nomeFornecedor) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            String sql = "SELECT * FROM fornecedor WHERE nome='" + nomeFornecedor + "'";
            System.out.println("Sql: " + sql);
            resultadoQ = st.executeQuery(sql);
            resultadoQ.first();
            idFornecedor = resultadoQ.getInt("id");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar fornecedor: " + ex);
        }
    }

    @Override
    public String atualizar(ContasPagar o) {
        pagar = (ContasPagar) o;
        buscaFornecedor(pagar.getFornecedor());
        if (pagar.getStatus() == 1) {
            try {
                Statement st = ConexaoBD.getInstance().getConnection().createStatement();
                String sql = "UPDATE contas_pagar "
                        + "SET descricao = '" + pagar.getDescricao() + "',"
                        + "data_compra = '" + pagar.getData_compra() + "',"
                        + "data_vencimento = '" + pagar.getData_vencimento() + "',"
                        + "valor_total = '" + pagar.getValor_total() + "',"
                        + "valor_pago = '" + pagar.getValor_pago() + "',"
                        + "valor_atualizado = '" + pagar.getValor_atualizado() + "',"
                        + "valor_total_tela = '" + pagar.getValor_total_tela() + "',"
                        + "status = '" + pagar.getStatus() + "',"
                        + "fornecedor_id = '" + idFornecedor + "',"
                        + "cod_fornecedor = '" + idFornecedor + "'"
                        + "WHERE id = " + pagar.getId();
                System.out.println("SQL: " + sql);
                int resultado = st.executeUpdate(sql);
                if (resultado == 0) {
                    return "Erro ao atualizar despesa!";
                } else {
                    JOptionPane.showMessageDialog(null, "Está despesa foi paga por completo!");
                }
            } catch (Exception e) {
                System.out.println("Erro ao atualizar despesa: " + e);
                return e.toString();
            }
        } else {
            try {
                Statement st = ConexaoBD.getInstance().getConnection().createStatement();
                String sql = "UPDATE contas_pagar "
                        + "SET descricao = '" + pagar.getDescricao() + "',"
                        + "data_compra = '" + pagar.getData_compra() + "',"
                        + "data_vencimento = '" + pagar.getData_vencimento() + "',"
                        + "valor_total = '" + pagar.getValor_total() + "',"
                        + "valor_pago = '" + pagar.getValor_pago() + "',"
                        + "valor_atualizado = '" + pagar.getValor_atualizado() + "',"
                        + "valor_total_tela = '" + pagar.getValor_total_tela() + "',"
                        + "status = '" + pagar.getStatus() + "',"
                        + "fornecedor_id = '" + idFornecedor + "',"
                        + "cod_fornecedor = '" + idFornecedor + "'"
                        + "WHERE id = " + pagar.getId();
                System.out.println("SQL: " + sql);
                int resultado = st.executeUpdate(sql);
                if (resultado == 0) {
                    return "Erro ao atualizar despesa!";
                } else {
                    JOptionPane.showMessageDialog(null, "Despesa atualizada com sucesso!");
                }
            } catch (Exception e) {
                System.out.println("Erro ao atualizar despesa: " + e);
                return e.toString();
            }
        }
        return null;
    }

    @Override
    public ArrayList<ContasPagar> consultarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<ContasPagar> consultar(String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ContasPagar consultarId(int id) {
        ContasPagar pagar = null;
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            String sql = "SELECT * FROM contas_pagar WHERE id = '" + id + "'";
            System.out.println("Sql: " + sql);
            resultadoQ = st.executeQuery(sql);
            while (resultadoQ.next()) {
                pagar = new ContasPagar();
                pagar.setId(id);
                pagar.setDescricao(resultadoQ.getString("descricao"));
                pagar.setData_compra(resultadoQ.getDate("data_compra"));
                pagar.setData_vencimento(resultadoQ.getDate("data_vencimento"));
                pagar.setValor_total(resultadoQ.getDouble("valor_total"));
                pagar.setValor_pago(resultadoQ.getDouble("valor_pago"));
                pagar.setValor_atualizado(resultadoQ.getDouble("valor_atualizado"));
                pagar.setValor_total_tela(resultadoQ.getDouble("valor_total_tela"));
                pagar.setStatus(resultadoQ.getInt("status"));
                pagar.setFornecedor(String.valueOf(resultadoQ.getInt("fornecedor_id")));
                pagar.setCod_fornecedor(resultadoQ.getInt("cod_fornecedor"));
                return pagar;
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao consultar despesa: " + ex);
        }
        return null;
    }

    public ContasPagar consultarId2(int id, String nomeFornecedor) {
        ContasPagar pagar = null;
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            String sql = "SELECT * FROM contas_pagar WHERE id = '" + id + "'";
            System.out.println("Sql: " + sql);
            resultadoQ = st.executeQuery(sql);
            while (resultadoQ.next()) {
                pagar = new ContasPagar();
                pagar.setId(id);
                pagar.setDescricao(resultadoQ.getString("descricao"));
                pagar.setData_compra(resultadoQ.getDate("data_compra"));
                pagar.setData_vencimento(resultadoQ.getDate("data_vencimento"));
                pagar.setValor_total(resultadoQ.getDouble("valor_total"));
                pagar.setValor_pago(resultadoQ.getDouble("valor_pago"));
                pagar.setValor_atualizado(resultadoQ.getDouble("valor_atualizado"));
                pagar.setValor_total_tela(resultadoQ.getDouble("valor_total_tela"));
                pagar.setStatus(resultadoQ.getInt("status"));
                pagar.setFornecedor(nomeFornecedor);
                pagar.setCod_fornecedor(resultadoQ.getInt("cod_fornecedor"));
                return pagar;
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao consultar despesa: " + ex);
        }
        return null;
    }

    @Override
    public String excluir(int id) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            String sql = ""
                    + "DELETE FROM contas_pagar "
                    + "WHERE id = " + id;
            System.out.println("Sql: " + sql);
            int resultado = st.executeUpdate(sql);
            if (resultado == 0) {
                return "Erro ao excluir despesa!";
            } else {
                JOptionPane.showMessageDialog(null, "Despesa excluída com sucesso!");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao excluir despesa: " + e);
            return e.toString();
        }
        return null;
    }

    public void popularTabelaNomeFornecedor(JTable tabela, String criterio, int status) {
        Object[][] dadosTabela = null;
        double valor;
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        Object[] cabecalho = new Object[7];
        cabecalho[0] = "Despesa";
        cabecalho[1] = "Fornecedor";
        cabecalho[2] = "Data Compra";
        cabecalho[3] = "Data Vencimento";
        cabecalho[4] = "Valor Total";
        cabecalho[5] = "Valor Pago";
        cabecalho[6] = "Valor Atualizado";
        try {
            resultadoQ = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(""
                    + "SELECT count(*) \n"
                    + "FROM contas_pagar \n"
                    + "INNER JOIN fornecedor ON contas_pagar.fornecedor_id = fornecedor.id \n"
                    + "WHERE lower(fornecedor.nome) LIKE '%" + criterio + "%' AND status = " + status);
            resultadoQ.next();
            dadosTabela = new Object[resultadoQ.getInt(1)][7];
        } catch (Exception e) {
            System.out.println("Erro ao consultar despesa: " + e);
        }
        int lin = 0;
        try {
            resultadoQ = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(""
                    + "SELECT contas_pagar.id, nome, data_compra, data_vencimento, valor_total, valor_pago, valor_atualizado \n"
                    + "FROM contas_pagar \n"
                    + "INNER JOIN fornecedor ON contas_pagar.fornecedor_id = fornecedor.id \n"
                    + "WHERE lower(fornecedor.nome) LIKE '%" + criterio + "%'AND status = " + status + " ORDER BY contas_pagar.id,nome,data_compra");
            while (resultadoQ.next()) {
                dadosTabela[lin][0] = resultadoQ.getInt("id");
                dadosTabela[lin][1] = resultadoQ.getString("nome");
                String dataCompra = f.ajustaDataDMA(resultadoQ.getString("data_compra"));
                dadosTabela[lin][2] = dataCompra;
                String dataVencimento = f.ajustaDataDMA(resultadoQ.getString("data_vencimento"));
                dadosTabela[lin][3] = dataVencimento;
                valor = resultadoQ.getDouble("valor_total");
                dadosTabela[lin][4] = nf.format(valor);
                valor = resultadoQ.getDouble("valor_pago");
                dadosTabela[lin][5] = nf.format(valor);
                valor = resultadoQ.getDouble("valor_atualizado");
                dadosTabela[lin][6] = nf.format(valor);
                lin++;
            }
        } catch (Exception e) {
            System.out.println("Problemas ao popular a tabela de despesas...");
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
        Object[] cabecalho = new Object[7];
        cabecalho[0] = "Despesa";
        cabecalho[1] = "Fornecedor";
        cabecalho[2] = "Data Compra";
        cabecalho[3] = "Data Vencimento";
        cabecalho[4] = "Valor Total";
        cabecalho[5] = "Valor Pago";
        cabecalho[6] = "Valor Atualizado";
        try {
            resultadoQ = ConexaoBD.getInstance().getConnection().createStatement().executeQuery("SELECT count(*) FROM contas_pagar \n"
                    + "INNER JOIN fornecedor ON contas_pagar.fornecedor_id = fornecedor.id \n"
                    + " WHERE data_vencimento >= '" + dataInicial + "' AND data_vencimento <= '" + dataFinal + "' AND status = '" + status + "' AND lower(fornecedor.nome) LIKE '%" + nome + "%'");
            resultadoQ.next();
            dadosTabela = new Object[resultadoQ.getInt(1)][7];
        } catch (Exception e) {
            System.out.println("Erro ao consultar despesa: " + e);
        }
        int lin = 0;
        try {
            resultadoQ = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(""
                    + "SELECT contas_pagar.id, nome, data_compra, data_vencimento, valor_total, valor_pago, valor_atualizado \n"
                    + "FROM contas_pagar \n"
                    + "INNER JOIN fornecedor ON contas_pagar.fornecedor_id = fornecedor.id \n"
                    + "WHERE data_vencimento >= '" + dataInicial + "' AND data_vencimento <= '" + dataFinal + "' AND status = '" + status + "' AND lower(fornecedor.nome) LIKE '%" + nome + "%' ORDER BY contas_pagar.id,nome,data_vencimento");
            while (resultadoQ.next()) {
                dadosTabela[lin][0] = resultadoQ.getInt("id");
                dadosTabela[lin][1] = resultadoQ.getString("nome");
                String dataCompra = f.ajustaDataDMA(resultadoQ.getString("data_compra"));
                dadosTabela[lin][2] = dataCompra;
                String dataVencimento = f.ajustaDataDMA(resultadoQ.getString("data_vencimento"));
                dadosTabela[lin][3] = dataVencimento;
                valor = resultadoQ.getDouble("valor_total");
                dadosTabela[lin][4] = nf.format(valor);
                valor = resultadoQ.getDouble("valor_pago");
                dadosTabela[lin][5] = nf.format(valor);
                valor = resultadoQ.getDouble("valor_atualizado");
                dadosTabela[lin][6] = nf.format(valor);
                lin++;
            }
        } catch (Exception e) {
            System.out.println("Problemas ao popular a tabela de despesas...");
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
