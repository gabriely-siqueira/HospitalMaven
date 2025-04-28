package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.Laboratorio;
import service.ServiceLaboratorio;
import view.LaboratorioForm;
import view.TelaBuscaLaboratorio;

/**
 * 
 * @author Gabriely
 */
public class LaboratorioController implements ActionListener {

    private LaboratorioForm laboratorioForm;
    public static int codigo;

    public LaboratorioController(LaboratorioForm laboratorioForm) {
        this.laboratorioForm = laboratorioForm;

        this.laboratorioForm.getjButtonNovo().addActionListener(this);
        this.laboratorioForm.getjButtonCancelar().addActionListener(this);
        this.laboratorioForm.getjButtonGravar().addActionListener(this);
        this.laboratorioForm.getjButtonBuscar().addActionListener(this);
        this.laboratorioForm.getjButtonSair().addActionListener(this);
        utilities.Utilities.ativaDesativa(false, this.laboratorioForm.getjPanelBotoes());
        utilities.Utilities.limpaComponentes(false, this.laboratorioForm.getjPanelDados3());
    }

    @Override
    public void actionPerformed(ActionEvent evento) {

        if (evento.getSource() == this.laboratorioForm.getjButtonNovo()) {
            utilities.Utilities.ativaDesativa(true, this.laboratorioForm.getjPanelBotoes());
            utilities.Utilities.limpaComponentes(true, this.laboratorioForm.getjPanelDados3());

            this.laboratorioForm.getIdField().setEnabled(false);

        } else if (evento.getSource() == this.laboratorioForm.getjButtonCancelar()) {
            utilities.Utilities.ativaDesativa(false, this.laboratorioForm.getjPanelBotoes());
            utilities.Utilities.limpaComponentes(false, this.laboratorioForm.getjPanelDados3());

        } else if (evento.getSource() == this.laboratorioForm.getjButtonGravar()) {

            Laboratorio laboratorio = new Laboratorio();

            laboratorio.setNomeFantasia(this.laboratorioForm.getNomeFantasia().getText());
            laboratorio.setContato(this.laboratorioForm.getContatoField().getText());
            laboratorio.setStatus("A");

            if (this.laboratorioForm.getIdField().getText().equals("")) {
                service.ServiceLaboratorio.adicionar(laboratorio);
                JOptionPane.showMessageDialog(null, "Laboratório cadastrado com sucesso!");
                
            } else {
                laboratorio.setId(Integer.parseInt(this.laboratorioForm.getIdField().getText()));
                service.ServiceLaboratorio.atualizar(laboratorio);
            }

            utilities.Utilities.ativaDesativa(false, this.laboratorioForm.getjPanelBotoes());
            utilities.Utilities.limpaComponentes(false, this.laboratorioForm.getjPanelDados3());

        } else if (evento.getSource() == this.laboratorioForm.getjButtonBuscar()) {
            codigo = 0;
            TelaBuscaLaboratorio telaBuscaLaboratorio = new TelaBuscaLaboratorio(null, true);
            ControllerBuscaLaboratorio controllerBuscaLaboratorio = new ControllerBuscaLaboratorio(telaBuscaLaboratorio);
            telaBuscaLaboratorio.setVisible(true);

            if (codigo != 0) {

                Laboratorio laboratorio = new Laboratorio();
                laboratorio = service.ServiceLaboratorio.ler(codigo);

                utilities.Utilities.ativaDesativa(true, this.laboratorioForm.getjPanelBotoes());
                utilities.Utilities.limpaComponentes(true, this.laboratorioForm.getjPanelDados3());

                this.laboratorioForm.getIdField().setText(laboratorio.getId() + "");
                this.laboratorioForm.getNomeFantasia().setText(laboratorio.getNomeFantasia());
                this.laboratorioForm.getContatoField().setText(laboratorio.getContato());
                this.laboratorioForm.getIdField().setEnabled(false);
                this.laboratorioForm.getNomeFantasia().requestFocus();

            }

        } else if (evento.getSource() == this.laboratorioForm.getjButtonSair()) {
            this.laboratorioForm.dispose();
        }

    }

}
