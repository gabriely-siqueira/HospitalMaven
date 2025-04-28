package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.Ala;
import service.ServiceAla;
import view.AlaForm;
import view.TelaBuscaAla;

public class AlaController implements ActionListener {

    private AlaForm alaForm;
    public static int codigo;

    public AlaController(AlaForm alaForm) {
        this.alaForm = alaForm;

        this.alaForm.getjButtonNovo().addActionListener(this);
        this.alaForm.getjButtonCancelar().addActionListener(this);
        this.alaForm.getjButtonGravar().addActionListener(this);
        this.alaForm.getjButtonBuscar().addActionListener(this);
        this.alaForm.getjButtonSair().addActionListener(this);

        utilities.Utilities.ativaDesativa(false, alaForm.getjPanelBotoes());
        utilities.Utilities.limpaComponentes(false, alaForm.getjPanelDados3());
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == alaForm.getjButtonNovo()) {
            novo();
        } else if (evento.getSource() == alaForm.getjButtonCancelar()) {
            cancelar();
        } else if (evento.getSource() == alaForm.getjButtonGravar()) {
            gravarAla();
        } else if (evento.getSource() == alaForm.getjButtonBuscar()) {
            buscarAla();
        } else if (evento.getSource() == alaForm.getjButtonSair()) {
            alaForm.dispose();
        }
    }

    private void novo() {
        utilities.Utilities.ativaDesativa(true, alaForm.getjPanelBotoes());
        utilities.Utilities.limpaComponentes(true, alaForm.getjPanelDados3());
        alaForm.getIdField().setEnabled(false);
    }

    private void cancelar() {
        utilities.Utilities.ativaDesativa(false, alaForm.getjPanelBotoes());
        utilities.Utilities.limpaComponentes(false, alaForm.getjPanelDados3());
    }

    private void gravarAla() {
        try {
            Ala ala = new Ala();
            ala.setDescricao(alaForm.getDescricaoAla().getText().trim());
            ala.setStatus(alaForm.getStatusAla().getSelectedItem().toString());

            if (alaForm.getDescricaoAla().getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(alaForm, "O campo 'Descrição' é obrigatório.", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (alaForm.getIdField().getText().isEmpty()) {
                ServiceAla.adicionar(ala);
                JOptionPane.showMessageDialog(alaForm, "Ala cadastrada com sucesso!", "Confirmação", JOptionPane.INFORMATION_MESSAGE);
            } else {
                ala.setId(Integer.parseInt(alaForm.getIdField().getText()));
                ServiceAla.atualizar(ala);
                JOptionPane.showMessageDialog(alaForm, "Ala atualizada com sucesso!", "Confirmação", JOptionPane.INFORMATION_MESSAGE);
            }

            cancelar();

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(alaForm, "ID inválido. Verifique os dados informados.", "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(alaForm, "Erro ao salvar a ala: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void buscarAla() {
        codigo = 0;
        TelaBuscaAla telaBusca = new TelaBuscaAla(null, true);
        ControllerBuscaAla controllerBuscaAla = new ControllerBuscaAla(telaBusca);
        telaBusca.setVisible(true);

        if (codigo != 0) {
            Ala ala = ServiceAla.ler(codigo);

            utilities.Utilities.ativaDesativa(true, alaForm.getjPanelBotoes());
            utilities.Utilities.limpaComponentes(true, alaForm.getjPanelDados3());

            alaForm.getIdField().setText(String.valueOf(ala.getId()));
            alaForm.getDescricaoAla().setText(ala.getDescricao());
            alaForm.getStatusAla().setSelectedItem(ala.getStatus());

            alaForm.getIdField().setEnabled(false);
            alaForm.getDescricaoAla().requestFocus();
        }
    }
}
