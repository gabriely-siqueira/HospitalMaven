package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.Exame;
import service.ServiceExame;
import view.ExameForm;
import view.TelaBuscaExame;

/**
 *
 * 
 * @author Gabriely
 */
public class ExameController implements ActionListener {

    private ExameForm exameForm;

    public ExameController(ExameForm exameForm) {
        this.exameForm = exameForm;

        this.exameForm.getjButtonNovo().addActionListener(this);
        this.exameForm.getjButtonCancelar().addActionListener(this);
        this.exameForm.getjButtonGravar().addActionListener(this);
        this.exameForm.getjButtonBuscar().addActionListener(this);
        this.exameForm.getjButtonSair().addActionListener(this);

        utilities.Utilities.ativaDesativa(false, this.exameForm.getjPanelBotoes());
        utilities.Utilities.limpaComponentes(false, this.exameForm.getjPanelDados3());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.exameForm.getjButtonNovo()) {
            utilities.Utilities.ativaDesativa(true, this.exameForm.getjPanelBotoes());
            utilities.Utilities.limpaComponentes(true, this.exameForm.getjPanelDados3());
            this.exameForm.getIdField().setEnabled(false);
        } else if (e.getSource() == this.exameForm.getjButtonSair()) {
            this.exameForm.dispose();
        } else if (e.getSource() == this.exameForm.getjButtonGravar()) {
            salvarExame();
        } else if (e.getSource() == this.exameForm.getjButtonBuscar()) {
            TelaBuscaExame telaBuscaExame = new TelaBuscaExame(null, true);
            ControllerBuscaExame controllerBuscaExame = new ControllerBuscaExame(telaBuscaExame);
            telaBuscaExame.setVisible(true);
        }
    }

    private void salvarExame() {
        try {
            Exame exame = new Exame();
            String nomeExame = exameForm.getNomeExame().getText().trim();
            String tipoExame = exameForm.getTipoExame().getText().trim();
             String statusExame = exameForm.getStatusExame().getText().trim();

            // Validações obrigatórias
            if (nomeExame.isEmpty()) {
                JOptionPane.showMessageDialog(
                        exameForm,
                        "O campo 'Nome do Exame' é obrigatório.",
                        "Erro",
                        JOptionPane.ERROR_MESSAGE
                );
                return;
            }

            exame.setTituloExame(nomeExame);
            exame.setTipoExame(tipoExame);
            exame.setStatus(statusExame);

            if (exameForm.getIdField().getText().isEmpty()) {
                // Adicionar um novo exame
                ServiceExame.adicionar(exame);
                JOptionPane.showMessageDialog(
                        exameForm,
                        "Exame cadastrado com sucesso!",
                        "Confirmação",
                        JOptionPane.INFORMATION_MESSAGE
                );
            } else {
                // Atualizar um exame existente
                exame.setId(Integer.parseInt(exameForm.getIdField().getText()));
                ServiceExame.atualizar(exame);
                JOptionPane.showMessageDialog(
                        exameForm,
                        "Exame atualizado com sucesso!",
                        "Confirmação",
                        JOptionPane.INFORMATION_MESSAGE
                );
            }

            utilities.Utilities.ativaDesativa(false, exameForm.getjPanelBotoes());
            utilities.Utilities.limpaComponentes(false, exameForm.getjPanelDados3());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(
                    exameForm,
                    "ID inválido. Verifique os dados informados.",
                    "Erro",
                    JOptionPane.ERROR_MESSAGE
            );
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(
                    exameForm,
                    "Erro ao salvar o exame: " + ex.getMessage(),
                    "Erro",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }
}
