package persistencia;

import entidade.Dentista;
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
public class DentistaDAO implements IDAO_T<Dentista> {

    ResultSet resultadoQ = null;
    Dentista dentista;
    Formatacao f = new Formatacao();

    @Override
    public String salvar(Dentista o) {
        dentista = (Dentista) o;
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            String sql = "INSERT INTO dentista VALUES("
                    + "DEFAULT, "
                    + "'" + dentista.getNome() + "',"
                    + "'" + dentista.getCro() + "'"
                    + ");";
            System.out.println("Sql: " + sql);
            int resultado = st.executeUpdate(sql);
            if (resultado == 0) {
                return "Erro ao cadastrar dentista!";
            } else {
                JOptionPane.showMessageDialog(null, "Dentista cadastrado com sucesso!");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar dentista: " + ex);
        }
        return null;
    }

    @Override
    public String atualizar(Dentista o) {
        dentista = (Dentista) o;
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            String sql = "UPDATE dentista "
                    + "SET dentista = '" + dentista.getNome() + "',"
                    + "cro = '" + dentista.getCro() + "'"
                    + "WHERE id = " + dentista.getId();
            System.out.println("SQL: " + sql);
            int resultado = st.executeUpdate(sql);
            if (resultado == 0) {
                return "Erro ao atualizar cadastro do dentista!";
            } else {
                JOptionPane.showMessageDialog(null, "Cadastro do dentista atualizado com sucesso!");
            }
        } catch (Exception e) {
            System.out.println("Erro ao atualizar cadastro do dentista: " + e);
            return e.toString();
        }
        return null;
    }

    @Override
    public ArrayList<Dentista> consultarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Dentista> consultar(String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Dentista consultarId(int id) {
        Dentista dentista = null;
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            String sql = "SELECT * FROM dentista WHERE id = '" + id + "'";
            System.out.println("Sql: " + sql);
            resultadoQ = st.executeQuery(sql);
            while (resultadoQ.next()) {
                dentista = new Dentista();
                dentista.setId(id);
                dentista.setNome(resultadoQ.getString("dentista"));
                dentista.setCro(resultadoQ.getString("cro"));
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao consultar dentista: " + ex);
        }
        return dentista;
    }

    @Override
    public String excluir(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void popularTabela(JTable tabela, String criterio) {
        Object[][] dadosTabela = null;
        Object[] cabecalho = new Object[3];
        cabecalho[0] = "Código";
        cabecalho[1] = "Dentista";
        cabecalho[2] = "CRO";
        try {
            resultadoQ = ConexaoBD.getInstance().getConnection().createStatement().executeQuery("SELECT count(*) FROM dentista WHERE lower(dentista) ILIKE '%" + criterio + "%'");
            resultadoQ.next();
            dadosTabela = new Object[resultadoQ.getInt(1)][3];
        } catch (Exception e) {
            System.out.println("Erro ao consultar dentista: " + e);
        }
        int lin = 0;
        try {
            resultadoQ = ConexaoBD.getInstance().getConnection().createStatement().executeQuery("SELECT * FROM dentista WHERE lower(dentista) LIKE '%" + criterio + "%' ORDER BY dentista");
            while (resultadoQ.next()) {
                dadosTabela[lin][0] = resultadoQ.getInt("id");
                dadosTabela[lin][1] = "Dr(a). " + resultadoQ.getString("dentista");
                dadosTabela[lin][2] = resultadoQ.getString("cro");
                lin++;
            }
        } catch (Exception e) {
            System.out.println("Problemas ao popular a tabela de dentistas...");
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
