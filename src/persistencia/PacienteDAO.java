package persistencia;

import com.sun.xml.internal.bind.v2.schemagen.Util;
import entidade.Paciente;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class PacienteDAO implements IDAO_T<Paciente> {

    ResultSet resultadoQ = null;
    Paciente paciente;
    Formatacao f = new Formatacao();

    @Override
    public String salvar(Paciente o) {
        paciente = (Paciente) o;
        try {
            if (!consultaCPF(paciente.getCpf())) {
                Statement st = ConexaoBD.getInstance().getConnection().createStatement();
                String sql = "INSERT INTO paciente VALUES("
                        + "DEFAULT, "
                        + "'" + paciente.getNome() + "',"
                        + "'" + paciente.getData_nascimento().toString() + "',"
                        + "'" + f.removerFormatacao(paciente.getTelefone()) + "',"
                        + "'" + f.removerFormatacao(paciente.getCpf()) + "',"
                        + "'" + paciente.getTipo_longradouro() + "',"
                        + "'" + paciente.getLongradouro() + "',"
                        + "'" + paciente.getNumero() + "',"
                        + "'" + paciente.getComplemento() + "',"
                        + "'" + paciente.getBairro() + "',"
                        + "'" + paciente.getCidade() + "',"
                        + "'" + paciente.getEstado() + "',"
                        + "'" + paciente.getUf() + "'"
                        + ");";
                System.out.println("Sql: " + sql);
                int resultado = st.executeUpdate(sql);
                if (resultado == 0) {
                    return "Erro ao cadastrar paciente!";
                } else {
                    JOptionPane.showMessageDialog(null, "Paciente cadastrado com sucesso!");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Este CPF já está cadastrado!");
                return "cpf";
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar paciente: " + ex);
        }
        return null;
    }

    @Override
    public String atualizar(Paciente o) {
        paciente = (Paciente) o;
        try {
            if (consultaCPF(paciente.getCpf())) {
                Statement st = ConexaoBD.getInstance().getConnection().createStatement();
                String sql = "UPDATE paciente "
                        + "SET nome = '" + paciente.getNome() + "',"
                        + "data_nascimento = '" + paciente.getData_nascimento().toString() + "',"
                        + "telefone = '" + f.removerFormatacao(paciente.getTelefone()) + "',"
                        + "cpf = '" + f.removerFormatacao(paciente.getCpf()) + "',"
                        + "tipo_longradouro = '" + paciente.getTipo_longradouro() + "',"
                        + "longradouro = '" + paciente.getLongradouro() + "',"
                        + "numero = '" + paciente.getNumero() + "',"
                        + "complemento = '" + paciente.getComplemento() + "',"
                        + "bairro = '" + paciente.getBairro() + "',"
                        + "cidade = '" + paciente.getCidade() + "',"
                        + "estado = '" + paciente.getEstado() + "',"
                        + "uf = '" + paciente.getUf() + "' "
                        + "WHERE id = " + paciente.getId();
                System.out.println("SQL: " + sql);
                int resultado = st.executeUpdate(sql);
                if (resultado == 0) {
                    return "Erro ao atualizar cadastro do paciente!";
                } else {
                    JOptionPane.showMessageDialog(null, "Cadastro do paciente atualizado com sucesso!");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Este CPF já está cadastrado!");
            }
        } catch (Exception e) {
            System.out.println("Erro ao atualizar cadastro do paciente: " + e);
            return e.toString();
        }
        return null;
    }

    @Override
    public ArrayList<Paciente> consultarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Paciente> consultar(String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String data_sistema(String data) throws ParseException {
        SimpleDateFormat in = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat out = new SimpleDateFormat("dd/MM/yyyy");
        String result = out.format(in.parse(data.toString()));
        return result;
    }

    private boolean consultaCPF(String cpf) throws SQLException {
        Statement st = ConexaoBD.getInstance().getConnection().createStatement();
        String sql = "SELECT * FROM paciente WHERE cpf LIKE '%" + f.removerFormatacao(cpf) + "%'";
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
    public Paciente consultarId(int id) {
        Paciente paciente = null;
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            String sql = "SELECT * FROM paciente WHERE id = '" + id + "'";
            System.out.println("Sql: " + sql);
            resultadoQ = st.executeQuery(sql);
            while (resultadoQ.next()) {
                paciente = new Paciente();
                paciente.setId(id);
                paciente.setNome(resultadoQ.getString("nome"));
                paciente.setCpf(resultadoQ.getString("cpf"));
                paciente.setData_nascimento(resultadoQ.getDate("data_nascimento"));
                paciente.setTelefone(resultadoQ.getString("telefone"));
                paciente.setTipo_longradouro(resultadoQ.getString("tipo_longradouro"));
                paciente.setLongradouro(resultadoQ.getString("longradouro"));
                paciente.setNumero(Integer.parseInt(resultadoQ.getString("numero")));
                paciente.setComplemento(resultadoQ.getString("complemento"));
                paciente.setBairro(resultadoQ.getString("bairro"));
                paciente.setCidade(resultadoQ.getString("cidade"));
                paciente.setEstado(resultadoQ.getString("estado"));
                paciente.setUf(resultadoQ.getString("uf"));
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao consultar paciente: " + ex);
        }
        return paciente;
    }

    @Override
    public String excluir(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void popularTabela(JTable tabela, String criterio) {
        Object[][] dadosTabela = null;
        Object[] cabecalho = new Object[4];
        cabecalho[0] = "Código";
        cabecalho[1] = "Nome";
        cabecalho[2] = "CPF";
        cabecalho[3] = "Telefone";
        try {
            resultadoQ = ConexaoBD.getInstance().getConnection().createStatement().executeQuery("SELECT count(*) FROM paciente WHERE lower(nome) ILIKE '%" + criterio + "%'");
            resultadoQ.next();
            dadosTabela = new Object[resultadoQ.getInt(1)][4];
        } catch (Exception e) {
            System.out.println("Erro ao consultar paciente: " + e);
        }
        int lin = 0;
        try {
            resultadoQ = ConexaoBD.getInstance().getConnection().createStatement().executeQuery("SELECT * FROM paciente WHERE lower(nome) LIKE '%" + criterio + "%' ORDER BY nome");
            while (resultadoQ.next()) {
                dadosTabela[lin][0] = resultadoQ.getInt("id");
                dadosTabela[lin][1] = resultadoQ.getString("nome");
                dadosTabela[lin][2] = resultadoQ.getString("cpf");
                dadosTabela[lin][3] = resultadoQ.getString("telefone");
                lin++;
            }
        } catch (Exception e) {
            System.out.println("Problemas ao popular a tabela de pacientes...");
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
