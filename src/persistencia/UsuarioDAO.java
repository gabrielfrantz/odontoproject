package persistencia;

import entidade.Usuario;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import static odonto._new.Odonto_NEW.conexao;
import sun.misc.BASE64Encoder;
import tela.JfrmPrincipal;

/**
 * @author gabriel.frantz
 */
public class UsuarioDAO implements IDAO_T<Usuario> {

    ResultSet resultadoQ = null;
    Calendar c = Calendar.getInstance();
    Usuario usuario;
    int usuarioAtivo;

    public String criptografa(String senha) {
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            digest.update(senha.getBytes());
            BASE64Encoder encoder = new BASE64Encoder();
            return encoder.encode(digest.digest());
        } catch (NoSuchAlgorithmException ns) {
            ns.printStackTrace();
        }
        return senha;
    }

    public boolean testaUsuario(String email, String senha) {
        String sql = "SELECT * FROM usuario WHERE email LIKE '" + email + "' AND senha LIKE '" + senha + "'";
        try {
            resultadoQ = conexao.getConnection().createStatement().executeQuery(sql);
            if (!resultadoQ.next()) {
                return false;
            } else {
                return true;
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro no Banco de Dados!" + erro);
            return false;
        }
    }

    @Override
    public String salvar(Usuario o) {
        usuario = (Usuario) o;
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            String senha = criptografa(usuario.getSenha());
            String sql = "INSERT INTO usuario VALUES("
                    + "DEFAULT, "
                    + "'" + usuario.getEmail() + "',"
                    + "'" + senha + "'"
                    + ");";
            System.out.println("Sql: " + sql);
            int resultado = st.executeUpdate(sql);
            if (resultado == 0) {
                return "Erro ao cadastrar usuário!";
            } else {
                JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir novo usuário: " + ex);
            return ex.toString();
        }
        return null;
    }

    @Override
    public String atualizar(Usuario o) {
        usuario = (Usuario) o;
        int resultado = 0;
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            System.out.println("COMPARA SENHA:" + usuario.getSenha());
            if (usuario.getSenha() == null || usuario.getSenha().isEmpty() || usuario.getSenha() == "") {
                String sql = "UPDATE usuario "
                        + "SET email = '" + usuario.getEmail() + "'"
                        + "WHERE id = " + usuario.getId();
                System.out.println("Sql: " + sql);
                resultado = st.executeUpdate(sql);
            } else {
                String sql = "UPDATE usuario "
                        + "SET email = '" + usuario.getEmail() + "',"
                        + "senha = '" + criptografa(usuario.getSenha()) + "'"
                        + "WHERE id = " + usuario.getId();
                resultado = st.executeUpdate(sql);
            }
            if (resultado == 0) {
                return "Erro ao atualizar cadastro do usuário!";
            } else {
                JOptionPane.showMessageDialog(null, "Cadastro do usuário atualizado com sucesso!");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar cadastro do usuário: " + ex);
            return ex.toString();
        }
        return null;
    }

    @Override
    public ArrayList<Usuario> consultarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Usuario> consultar(String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuario consultarId(int id) {
        Usuario usuario = null;
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            String sql = "SELECT * FROM usuario WHERE id = '" + id + "'";
            System.out.println("Sql: " + sql);
            resultadoQ = st.executeQuery(sql);
            while (resultadoQ.next()) {
                usuario = new Usuario();
                usuario.setId(id);
                usuario.setEmail(resultadoQ.getString("email"));
                usuario.setSenha(resultadoQ.getString("senha"));
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao consultar usuário: " + ex);
        }
        return usuario;
    }

    public void popularTabela(JTable tabela, String criterio) {
        Object[][] dadosTabela = null;
        Object[] cabecalho = new Object[2];
        cabecalho[0] = "Código";
        cabecalho[1] = "E-mail";
        try {
            resultadoQ = ConexaoBD.getInstance().getConnection().createStatement().executeQuery("SELECT count(*) FROM usuario WHERE lower(email) ILIKE '%" + criterio + "%'");
            resultadoQ.next();
            dadosTabela = new Object[resultadoQ.getInt(1)][2];
        } catch (Exception e) {
            System.out.println("Erro ao consultar usuário: " + e);
        }
        int lin = 0;
        try {
            resultadoQ = ConexaoBD.getInstance().getConnection().createStatement().executeQuery("SELECT * FROM usuario WHERE lower(email) LIKE '%" + criterio + "%' ORDER BY id");
            while (resultadoQ.next()) {
                dadosTabela[lin][0] = resultadoQ.getInt("id");
                dadosTabela[lin][1] = resultadoQ.getString("email");
                lin++;
            }
        } catch (Exception e) {
            System.out.println("Problemas ao popular a tabela de usuários...");
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

    @Override
    public String excluir(int id) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            if (this.usuarioAtivo != 1) {
                System.out.println("ERRO" + this.usuarioAtivo);
                String sql = ""
                        + "DELETE FROM usuario "
                        + "WHERE id = " + id;
                System.out.println("Sql: " + sql);
                int resultado = st.executeUpdate(sql);
                if (resultado == 0) {
                    return "Erro ao excluir usuário!";
                } else {
                    JOptionPane.showMessageDialog(null, "Usuário excluído com sucesso!");
                }
            } else {
                System.out.println("ERRO" + this.usuarioAtivo);
                JOptionPane.showMessageDialog(null, "Você não pode excluir o usuário que está em uso!");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao excluir usuário: " + e);
            return e.toString();
        }
        return null;
    }
    
    
    public int getUsuarioAtivo(int i) {
        return this.usuarioAtivo = i;
    }
}
