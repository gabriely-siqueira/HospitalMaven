package utilities;

import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Utilities {

  public static void ativaDesativa(boolean estadoBotoes, JPanel painel) {
    Component[] matrizComponentes = painel.getComponents();
    for (Component componenteAtualDaMatriz : matrizComponentes) {
        if (componenteAtualDaMatriz instanceof JButton) {
            JButton botao = (JButton) componenteAtualDaMatriz;
            if ("0".equals(botao.getActionCommand())) {
                botao.setEnabled(estadoBotoes);
            } else if ("1".equals(botao.getActionCommand())) {
                botao.setEnabled(!estadoBotoes);
            }
        }
    }
}


    public static void limpaComponentes(boolean status, JPanel painel) {
        Component[] matrizComponentes = painel.getComponents();

        for (Component componenteAtualDaMatriz : matrizComponentes) {
            if (componenteAtualDaMatriz instanceof JTextField) {
                ((JTextField) componenteAtualDaMatriz).setText("");
            } else if (componenteAtualDaMatriz instanceof JFormattedTextField) {
                ((JFormattedTextField) componenteAtualDaMatriz).setText("");
            } else if (componenteAtualDaMatriz instanceof JTextArea) {
                ((JTextArea) componenteAtualDaMatriz).setText("");
            } else if (componenteAtualDaMatriz instanceof JComboBox) {
                ((JComboBox) componenteAtualDaMatriz).setSelectedIndex(-1);
            } else if (componenteAtualDaMatriz instanceof JPasswordField) {
                ((JPasswordField) componenteAtualDaMatriz).setText("");
            }

            componenteAtualDaMatriz.setEnabled(status);
        }
    }
}
