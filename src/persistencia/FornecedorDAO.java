package persistencia;

import entidade.Fornecedor;
import entidade.Paciente;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author gabriel.frantz
 */
public class FornecedorDAO implements IDAO_T<Fornecedor> {

    ResultSet resultadoQ = null;
    Fornecedor fornecedor;
    Formatacao f = new Formatacao();

    @Override
    public String salvar(Fornecedor o) {
        fornecedor = (Fornecedor) o;
        try {
            if (!consultaCNPJ(fornecedor.getCnpj())) {
                Statement st = ConexaoBD.getInstance().getConnection().createStatement();
                String sql = "INSERT INTO fornecedor VALUES("
                        + "DEFAULT, "
                        + "'" + fornecedor.getNome() + "',"
                        + "'" + fornecedor.getEmail() + "',"
                        + "'" + f.removerFormatacao(fornecedor.getTelefone()) + "',"
                        + "'" + f.removerFormatacao(fornecedor.getCnpj()) + "',"
                        + "'" + fornecedor.getTipo_longradouro() + "',"
                        + "'" + fornecedor.getLongradouro() + "',"
                        + "'" + fornecedor.getNumero() + "',"
                        + "'" + fornecedor.getComplemento() + "',"
                        + "'" + fornecedor.getBairro() + "',"
                        + "'" + fornecedor.getCidade() + "',"
                        + "'" + fornecedor.getEstado() + "',"
                        + "'" + fornecedor.getUf() + "'"
                        + ");";
                System.out.println("Sql: " + sql);
                int resultado = st.executeUpdate(sql);
                if (resultado == 0) {
                    return "Erro ao cadastrar fornecedor!";
                } else {
                    JOptionPane.showMessageDialog(null, "Fornecedor cadastrado com sucesso!");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Este CNPJ já está cadastrado!");
                return "cpf";
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar fornecedor: " + ex);
        }
        return null;
    }

    @Override
    public String atualizar(Fornecedor o) {
        fornecedor = (Fornecedor) o;
        try {
            if (consultaCNPJ(fornecedor.getCnpj())) {
                Statement st = ConexaoBD.getInstance().getConnection().createStatement();
                String sql = "UPDATE fornecedor "
                        + "SET nome = '" + fornecedor.getNome() + "',"
                        + "email = '" + fornecedor.getEmail() + "',"
                        + "telefone = '" + f.removerFormatacao(fornecedor.getTelefone()) + "',"
                        + "cnpj = '" + f.removerFormatacao(fornecedor.getCnpj()) + "',"
                        + "tipo_longradouro = '" + fornecedor.getTipo_longradouro() + "',"
                        + "longradouro = '" + fornecedor.getLongradouro() + "',"
                        + "numero = '" + fornecedor.getNumero() + "',"
                        + "complemento = '" + fornecedor.getComplemento() + "',"
                        + "bairro = '" + fornecedor.getBairro() + "',"
                        + "cidade = '" + fornecedor.getCidade() + "',"
                        + "estado = '" + fornecedor.getEstado() + "',"
                        + "uf = '" + fornecedor.getUf() + "' "
                        + "WHERE id = " + fornecedor.getId();
                System.out.println("SQL: " + sql);
                int resultado = st.executeUpdate(sql);
                if (resultado == 0) {
                    return "Erro ao atualizar cadastro do fornecedor!";
                } else {
                    JOptionPane.showMessageDialog(null, "Cadastro do fornecedor atualizado com sucesso!");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Este CNPJ já está cadastrado!");
            }
        } catch (Exception e) {
            System.out.println("Erro ao atualizar cadastro do fornecedor: " + e);
            return e.toString();
        }
        return null;
    }

    @Override
    public ArrayList<Fornecedor> consultarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Fornecedor> consultar(String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String data_sistema(String data) throws ParseException {
        SimpleDateFormat in = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat out = new SimpleDateFormat("dd/MM/yyyy");
        String result = out.format(in.parse(data.toString()));
        return result;
    }

    private boolean consultaCNPJ(String cnpj) throws SQLException {
        Statement st = ConexaoBD.getInstance().getConnection().createStatement();
        String sql = "SELECT * FROM fornecedor WHERE cnpj LIKE '%" + f.removerFormatacao(cnpj) + "%'";
        System.out.println("Sql: " + sql);
        resultadoQ = st.executeQuery(sql);
        try {
            if (resultadoQ.next()) {
                return true;
            }
        } catch (Exception ex) {
            Logger.getLogger(PacienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public Fornecedor consultarId(int id) {
        Fornecedor fornecedor = null;
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            String sql = "SELECT * FROM fornecedor WHERE id = '" + id + "'";
            System.out.println("Sql: " + sql);
            resultadoQ = st.executeQuery(sql);
            while (resultadoQ.next()) {
                fornecedor = new Fornecedor();
                fornecedor.setId(id);
                fornecedor.setNome(resultadoQ.getString("nome"));
                fornecedor.setEmail(resultadoQ.getString("email"));
                fornecedor.setTelefone(resultadoQ.getString("telefone"));
                fornecedor.setCnpj(resultadoQ.getString("cnpj"));
                fornecedor.setTipo_longradouro(resultadoQ.getString("tipo_longradouro"));
                fornecedor.setLongradouro(resultadoQ.getString("longradouro"));
                fornecedor.setNumero(Integer.parseInt(resultadoQ.getString("numero")));
                fornecedor.setComplemento(resultadoQ.getString("complemento"));
                fornecedor.setBairro(resultadoQ.getString("bairro"));
                fornecedor.setCidade(resultadoQ.getString("cidade"));
                fornecedor.setEstado(resultadoQ.getString("estado"));
                fornecedor.setUf(resultadoQ.getString("uf"));
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao consultar fornecedor: " + ex);
        }
        return fornecedor;
    }

    @Override
    public String excluir(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void popularTabela(JTable tabela, String criterio) {
        Object[][] dadosTabela = null;
        Object[] cabecalho = new Object[5];
        cabecalho[0] = "Código";
        cabecalho[1] = "Razão Social";
        cabecalho[2] = "CNPJ";
        cabecalho[3] = "Telefone";
        cabecalho[4] = "E-mail";
        try {
            resultadoQ = ConexaoBD.getInstance().getConnection().createStatement().executeQuery("SELECT count(*) FROM fornecedor WHERE lower(nome) ILIKE '%" + criterio + "%'");
            resultadoQ.next();
            dadosTabela = new Object[resultadoQ.getInt(1)][5];
        } catch (Exception e) {
            System.out.println("Erro ao consultar paciente: " + e);
        }
        int lin = 0;
        try {
            resultadoQ = ConexaoBD.getInstance().getConnection().createStatement().executeQuery("SELECT * FROM fornecedor WHERE lower(nome) LIKE '%" + criterio + "%' ORDER BY nome");
            while (resultadoQ.next()) {
                dadosTabela[lin][0] = resultadoQ.getInt("id");
                dadosTabela[lin][1] = resultadoQ.getString("nome");
                dadosTabela[lin][2] = resultadoQ.getString("cnpj");
                dadosTabela[lin][3] = resultadoQ.getString("telefone");
                dadosTabela[lin][4] = resultadoQ.getString("email");
                lin++;
            }
        } catch (Exception e) {
            System.out.println("Problemas ao popular a tabela de fornecedores...");
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
