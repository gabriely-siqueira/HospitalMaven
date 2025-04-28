package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import model.Ala;
import model.Quarto;
import model.DAO.AlaDAO;
import service.ServiceAla;
import service.ServiceQuarto;
import view.QuartoForm;
import view.TelaBuscaQuarto;

/**
 * 
 * @author Gabriely
 */
public class QuartoController implements ActionListener {

    private QuartoForm quartoForm;
    public static int codigo;

    public QuartoController(QuartoForm quartoForm) {
        this.quartoForm = quartoForm;

        this.quartoForm.getjButtonNovo().addActionListener(this);
        this.quartoForm.getjButtonCancelar().addActionListener(this);
        this.quartoForm.getjButtonGravar().addActionListener(this);
        this.quartoForm.getjButtonBuscar().addActionListener(this);
        this.quartoForm.getjButtonSair().addActionListener(this);

        utilities.Utilities.ativaDesativa(false, this.quartoForm.getjPanelBotoes());
        utilities.Utilities.limpaComponentes(false, this.quartoForm.getjPanelDados3());

        carregarAlas();
    }

    private void carregarAlas() {
        this.quartoForm.getComboBoxAla().removeAllItems();
        this.quartoForm.getComboBoxAla().addItem("Selecione");
        List<Ala> alas = ServiceAla.listarAlas();
        for (Ala ala : alas) {
            this.quartoForm.getComboBoxAla().addItem(ala.getDescricao());
        }
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == this.quartoForm.getjButtonNovo()) {
            utilities.Utilities.ativaDesativa(true, this.quartoForm.getjPanelBotoes());
            utilities.Utilities.limpaComponentes(true, this.quartoForm.getjPanelDados3());
            this.quartoForm.getIdField().setEnabled(false);

        } else if (evento.getSource() == this.quartoForm.getjButtonCancelar()) {
            utilities.Utilities.ativaDesativa(false, this.quartoForm.getjPanelBotoes());
            utilities.Utilities.limpaComponentes(false, this.quartoForm.getjPanelDados3());

        } else if (evento.getSource() == this.quartoForm.getjButtonGravar()) {
            salvarQuarto();

        } else if (evento.getSource() == this.quartoForm.getjButtonBuscar()) {
            codigo = 0;
            TelaBuscaQuarto telaBuscaQuarto = new TelaBuscaQuarto(null, true);
            ControllerBuscaQuarto controllerBuscaQuarto = new ControllerBuscaQuarto(telaBuscaQuarto);
            telaBuscaQuarto.setVisible(true);

            if (codigo != 0) {
                Quarto quarto = ServiceQuarto.ler(codigo);

                utilities.Utilities.ativaDesativa(true, this.quartoForm.getjPanelBotoes());
                utilities.Utilities.limpaComponentes(true, this.quartoForm.getjPanelDados3());

                this.quartoForm.getIdField().setText(quarto.getId() + "");
                this.quartoForm.getDescricaoField().setText(quarto.getDescricao());
                this.quartoForm.getStatusField().setSelectedItem(quarto.getStatus());
                this.quartoForm.getComboBoxAla().setSelectedItem(quarto.getAla().getDescricao());

                this.quartoForm.getIdField().setEnabled(false);
                this.quartoForm.getDescricaoField().requestFocus();
            }

        } else if (evento.getSource() == this.quartoForm.getjButtonSair()) {
            this.quartoForm.dispose();
        }
    }

    private void salvarQuarto() {
        try {
            Quarto quarto = new Quarto();
            String descricao = quartoForm.getDescricaoField().getText().trim();
            String status = quartoForm.getStatusField().getSelectedItem().toString();
            String alaDescricao = quartoForm.getComboBoxAla().getSelectedItem().toString();

            if (descricao.isEmpty()) {
                JOptionPane.showMessageDialog(
                        quartoForm,
                        "O campo 'Descrição' é obrigatório.",
                        "Erro",
                        JOptionPane.ERROR_MESSAGE
                );
                return;
            }

            quarto.setDescricao(descricao);
            quarto.setStatus(status);

            if (!alaDescricao.equals("Selecione")) {
                AlaDAO alaDAO = new AlaDAO();
                List<Ala> alas = alaDAO.retrieve(alaDescricao, "descricao");
                if (!alas.isEmpty()) {
                    quarto.setAla(alas.get(0));
                } else {
                    JOptionPane.showMessageDialog(
                            quartoForm,
                            "Ala não encontrada.",
                            "Erro",
                            JOptionPane.ERROR_MESSAGE
                    );
                    return;
                }
            }

            if (quartoForm.getIdField().getText().isEmpty()) {
                ServiceQuarto.adicionar(quarto);
                JOptionPane.showMessageDialog(
                        quartoForm,
                        "Quarto cadastrado com sucesso!",
                        "Confirmação",
                        JOptionPane.INFORMATION_MESSAGE
                );
            } else {
                quarto.setId(Integer.parseInt(quartoForm.getIdField().getText()));
                ServiceQuarto.atualizar(quarto);
                JOptionPane.showMessageDialog(
                        quartoForm,
                        "Quarto atualizado com sucesso!",
                        "Confirmação",
                        JOptionPane.INFORMATION_MESSAGE
                );
            }

            utilities.Utilities.ativaDesativa(false, quartoForm.getjPanelBotoes());
            utilities.Utilities.limpaComponentes(false, quartoForm.getjPanelDados3());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(
                    quartoForm,
                    "ID inválido. Verifique os dados informados.",
                    "Erro",
                    JOptionPane.ERROR_MESSAGE
            );
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(
                    quartoForm,
                    "Erro ao salvar o quarto: " + ex.getMessage(),
                    "Erro",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }
}
