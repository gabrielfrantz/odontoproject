package persistencia;

import entidade.Paciente;
import entidade.Procedimento;
import entidade.Procedimento;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author gabriel.frantz
 */
public class ProcedimentoDAO implements IDAO_T<Procedimento> {

    ResultSet resultadoQ = null;
    Procedimento procedimento;
    Formatacao f = new Formatacao();

    @Override
    public String salvar(Procedimento o) {
        procedimento = (Procedimento) o;
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            String sql = "INSERT INTO procedimento VALUES("
                    + "DEFAULT, "
                    + "'" + procedimento.getDescricao() + "',"
                    + "'" + procedimento.getValor() + "'"
                    + ");";
            System.out.println("Sql: " + sql);
            int resultado = st.executeUpdate(sql);
            if (resultado == 0) {
                return "Erro ao cadastrar procedimento!";
            } else {
                JOptionPane.showMessageDialog(null, "Procedimento cadastrado com sucesso!");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar procedimento: " + ex);
        }
        return null;
    }

    @Override
    public String atualizar(Procedimento o) {
        procedimento = (Procedimento) o;
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            String sql = "UPDATE procedimento "
                    + "SET descricao = '" + procedimento.getDescricao() + "',"
                    + "valor = '" + procedimento.getValor() + "'"
                    + "WHERE id = " + procedimento.getId();
            System.out.println("SQL: " + sql);
            int resultado = st.executeUpdate(sql);
            if (resultado == 0) {
                return "Erro ao atualizar cadastro do procedimento!";
            } else {
                JOptionPane.showMessageDialog(null, "Cadastro do procedimento atualizado com sucesso!");
            }
        } catch (Exception e) {
            System.out.println("Erro ao atualizar cadastro do procedimento: " + e);
            return e.toString();
        }
        return null;
    }

    @Override
    public ArrayList<Procedimento> consultarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Procedimento> consultar(String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Procedimento consultarId(int id) {
        Procedimento procedimento = null;
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            String sql = "SELECT * FROM procedimento WHERE id = '" + id + "'";
            System.out.println("Sql: " + sql);
            resultadoQ = st.executeQuery(sql);
            while (resultadoQ.next()) {
                procedimento = new Procedimento();
                procedimento.setId(id);
                procedimento.setDescricao(resultadoQ.getString("descricao"));
                procedimento.setValor(Double.parseDouble(resultadoQ.getString("valor")));
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao consultar procedimento: " + ex);
        }
        return procedimento;
    }

    @Override
    public String excluir(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void popularTabela(JTable tabela, String criterio) {
        Object[][] dadosTabela = null;
        Object[] cabecalho = new Object[3];
        cabecalho[0] = "Código";
        cabecalho[1] = "Descrição";
        cabecalho[2] = "Valor";
        try {
            resultadoQ = ConexaoBD.getInstance().getConnection().createStatement().executeQuery("SELECT count(*) FROM procedimento WHERE lower(descricao) ILIKE '%" + criterio + "%'");
            resultadoQ.next();
            dadosTabela = new Object[resultadoQ.getInt(1)][3];
        } catch (Exception e) {
            System.out.println("Erro ao consultar procedimento: " + e);
        }
        int lin = 0;
        try {
            resultadoQ = ConexaoBD.getInstance().getConnection().createStatement().executeQuery("SELECT * FROM procedimento WHERE lower(descricao) LIKE '%" + criterio + "%' ORDER BY descricao");
            while (resultadoQ.next()) {
                dadosTabela[lin][0] = resultadoQ.getInt("id");
                dadosTabela[lin][1] = resultadoQ.getString("descricao");
                dadosTabela[lin][2] = "R$ " + resultadoQ.getString("valor");
                lin++;
            }
        } catch (Exception e) {
            System.out.println("Problemas ao popular a tabela de procedimentos...");
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
