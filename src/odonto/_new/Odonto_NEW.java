package odonto._new;

import static java.awt.Frame.MAXIMIZED_BOTH;
import persistencia.ConexaoBD;
import tela.JfrmLogin;
import tela.JfrmPrincipal;

/**
 *
 * @author GabrielFrantz
 */

public class Odonto_NEW {

    public static ConexaoBD conexao = new ConexaoBD();

    public static void main(String[] args) throws ClassNotFoundException {
        if (testaBD()) {
            JfrmLogin login = new JfrmLogin();;
            login.setVisible(true);
//            JfrmPrincipal principal = new JfrmPrincipal();
//            principal.setExtendedState(MAXIMIZED_BOTH);
//            principal.setVisible(true);
        } else {
            System.out.println("Erro ao conectar com o Banco de  dados!");
        }
    }

    private static boolean testaBD() {
        try {
            if (conexao.getConnection().isValid(0)) {
                return true;
            }
        } catch (Exception e) {
            System.err.println("Erro: " + e);
            return false;
        }
        return false;
    }
}
