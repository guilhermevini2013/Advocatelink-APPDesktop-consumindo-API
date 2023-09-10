package classes.shared.client;

import classes.models.Clients;
import classes.shared.client.https.HttpsUtil;

import javax.swing.*;

public abstract class MethodsUtil {
    // VALIDA SE UM CAMPO SERA STRING OU NUMERO, SE CASO FOR STRING RETORNARAR ERROR
    public static Object validatesNumber(Object numero) throws NumberFormatException {
        if ((numero instanceof String)) {
            throw new NumberFormatException();
        }
        return numero;
    }
    public static boolean validatesInput(JTextField tf1, JTextField tf2, JTextField tf3, JTextField tf4, JTextField tf5, JTextField tf6, JTextField tf7) {
        return (!tf1.getText().isEmpty() && !tf2.getText().isEmpty() && !tf3.getText().isEmpty() && !tf4.getText().isEmpty() &&
                !tf5.getText().isEmpty() && !tf6.getText().isEmpty()&&!tf7.getText().isEmpty());
    }

    // VALIDA SE TODOS OS CAMPOS FORAM COMPLETADOS
    public static boolean validatesInput(JTextField tf1, JTextField tf2, JTextField tf3, JTextField tf4, JTextField tf5, JTextField tf6) {
        return (!tf1.getText().isEmpty() && !tf2.getText().isEmpty() && !tf3.getText().isEmpty() && !tf4.getText().isEmpty() &&
                !tf5.getText().isEmpty() && !tf6.getText().isEmpty());
         }

    // VALIDA SE TODOS OS CAMPOS FORAM COMPLETADOS
    public static boolean validatesInput(JTextField tf1, JTextField tf2) {
        return (!tf1.getText().isEmpty() && !tf2.getText().isEmpty());
    }

    // PESQUISA O CLIENTE A PARTIR DO NOME _____________________
    public static Clients search(String name) throws NullPointerException {
        for (Clients c: HttpsUtil.getClients()) {
            if (c.getNome().equals(name)) {
                return c;
            }
        }
        throw new NullPointerException();
    }
}
