package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.Medicamento;
import view.MedicamentoForm;
import view.TelaBuscaMedicamento;

/**
 * 
 * @author Gabriely
 */
public class MedicamentoController implements ActionListener {

    private MedicamentoForm medicamentoForm;
    public static int codigo;

    public MedicamentoController(MedicamentoForm medicamentoForm) {
        this.medicamentoForm = medicamentoForm;

        this.medicamentoForm.getjButtonNovo().addActionListener(this);
        this.medicamentoForm.getjButtonCancelar().addActionListener(this);
        this.medicamentoForm.getjButtonGravar().addActionListener(this);
        this.medicamentoForm.getjButtonBuscar().addActionListener(this);
        this.medicamentoForm.getjButtonSair().addActionListener(this);

        utilities.Utilities.ativaDesativa(false, this.medicamentoForm.getjPanelBotoes());
        utilities.Utilities.limpaComponentes(false, this.medicamentoForm.getjPanelDados3());
    }

    @Override
    public void actionPerformed(ActionEvent evento) {

        if (evento.getSource() == this.medicamentoForm.getjButtonNovo()) {
            utilities.Utilities.ativaDesativa(true, this.medicamentoForm.getjPanelBotoes());
            utilities.Utilities.limpaComponentes(true, this.medicamentoForm.getjPanelDados3());
            this.medicamentoForm.getIdField().setEnabled(false);

        } else if (evento.getSource() == this.medicamentoForm.getjButtonCancelar()) {
            utilities.Utilities.ativaDesativa(false, this.medicamentoForm.getjPanelBotoes());
            utilities.Utilities.limpaComponentes(false, this.medicamentoForm.getjPanelDados3());

        } else if (evento.getSource() == this.medicamentoForm.getjButtonGravar()) {
            try {
                Medicamento medicamento = new Medicamento();

                medicamento.setDescricaoMedicamento(this.medicamentoForm.getDescMedicamento().getText());
                medicamento.setPrincipioAtivo(this.medicamentoForm.getPrincipioAtivo().getText());
                medicamento.setQtdMinima(Float.parseFloat(this.medicamentoForm.getQtdMinima().getText()));
                medicamento.setStatus("A");

                if (this.medicamentoForm.getIdField().getText().isEmpty()) {
                    service.ServiceMedicamento.adicionar(medicamento);
                    JOptionPane.showMessageDialog(null, "Medicamento cadastrado com sucesso!");
                } else {
                    medicamento.setId(Integer.parseInt(this.medicamentoForm.getIdField().getText()));
                    service.ServiceMedicamento.atualizar(medicamento);
                    JOptionPane.showMessageDialog(null, "Medicamento atualizado com sucesso!");
                }

                utilities.Utilities.ativaDesativa(false, this.medicamentoForm.getjPanelBotoes());
                utilities.Utilities.limpaComponentes(false, this.medicamentoForm.getjPanelDados3());

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Quantidade mínima inválida.");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao gravar medicamento: " + e.getMessage());
            }

        } else if (evento.getSource() == this.medicamentoForm.getjButtonBuscar()) {
            codigo = 0;
            TelaBuscaMedicamento telaBuscaMedicamento = new TelaBuscaMedicamento(null, true);
            ControllerBuscaMedicamento controllerBuscaMedicamento = new ControllerBuscaMedicamento(telaBuscaMedicamento);
            telaBuscaMedicamento.setVisible(true);

            if (codigo != 0) {
                Medicamento medicamento = service.ServiceMedicamento.ler(codigo);

                utilities.Utilities.ativaDesativa(true, this.medicamentoForm.getjPanelBotoes());
                utilities.Utilities.limpaComponentes(true, this.medicamentoForm.getjPanelDados3());

                this.medicamentoForm.getIdField().setText(String.valueOf(medicamento.getId()));
                this.medicamentoForm.getDescMedicamento().setText(medicamento.getDescricaoMedicamento());
                this.medicamentoForm.getPrincipioAtivo().setText(medicamento.getPrincipioAtivo());
                this.medicamentoForm.getQtdMinima().setText(String.valueOf(medicamento.getQtdMinima()));

                this.medicamentoForm.getIdField().setEnabled(false);
                this.medicamentoForm.getDescMedicamento().requestFocus();
            }

        } else if (evento.getSource() == this.medicamentoForm.getjButtonSair()) {
            this.medicamentoForm.dispose();
        }
    }
}
