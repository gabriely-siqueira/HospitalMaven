package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import model.Medico;
import service.ServiceMedico;
import view.MedicoForm;
import view.TelaBuscaMedico;

public class MedicoController implements ActionListener {

    private MedicoForm medicoForm;
    public static int codigo;

    public MedicoController(MedicoForm medicoForm) {
        this.medicoForm = medicoForm;

        this.medicoForm.getjButtonNovo().addActionListener(this);
        this.medicoForm.getjButtonCancelar().addActionListener(this);
        this.medicoForm.getjButtonGravar().addActionListener(this);
        this.medicoForm.getjButtonBuscar().addActionListener(this);
        this.medicoForm.getjButtonSair().addActionListener(this);

        utilities.Utilities.ativaDesativa(false, this.medicoForm.getjPanelBotoes());
        utilities.Utilities.limpaComponentes(false, this.medicoForm.getjPanelDados3());
    }

    @Override
    public void actionPerformed(ActionEvent evento) {

        if (evento.getSource() == this.medicoForm.getjButtonNovo()) {
            utilities.Utilities.ativaDesativa(true, this.medicoForm.getjPanelBotoes());
            utilities.Utilities.limpaComponentes(true, this.medicoForm.getjPanelDados3());
            this.medicoForm.getIdField().setEnabled(false);

        } else if (evento.getSource() == this.medicoForm.getjButtonCancelar()) {
            utilities.Utilities.ativaDesativa(false, this.medicoForm.getjPanelBotoes());
            utilities.Utilities.limpaComponentes(false, this.medicoForm.getjPanelDados3());

        } else if (evento.getSource() == this.medicoForm.getjButtonGravar()) {

            Medico medico = new Medico();

            medico.setNome(this.medicoForm.getNomeMedico().getText());
            medico.setCrm(this.medicoForm.getCRM().getText());
            medico.setSenha(this.medicoForm.getSenha().getText());
            medico.setLogin(this.medicoForm.getLogin().getText());
            medico.setFone1(this.medicoForm.getTelefoneMedico().getText());
            medico.setFone2(this.medicoForm.getTelefoneMedico2().getText());
            medico.setEmail(this.medicoForm.getEmail().getText());
            medico.setCpfCnpj(this.medicoForm.getCpfMedico().getText());
            medico.setRgInscricaoEstadual(this.medicoForm.getRgMedico().getText());
            medico.setCep(this.medicoForm.getCep().getText());
            medico.setCidade(this.medicoForm.getCidade().getText());
            medico.setBairro(this.medicoForm.getBairro().getText());
            medico.setComplemento(this.medicoForm.getComplemento().getText());
            medico.setLogradouro(this.medicoForm.getLogradouro1().getText());
            
            // Definir a data de cadastro automaticamente
            LocalDate dataAtual = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            medico.setDataCadastro(dataAtual.format(formatter));
            

            if (this.medicoForm.getIdField().getText().equals("")) {
                ServiceMedico.adicionar(medico);
                JOptionPane.showMessageDialog(null, "Médico cadastrado com sucesso!");
            } else {
                medico.setId(Integer.parseInt(this.medicoForm.getIdField().getText()));
                ServiceMedico.atualizar(medico);
                JOptionPane.showMessageDialog(null, "Médico atualizado com sucesso!");
            }

            utilities.Utilities.ativaDesativa(false, this.medicoForm.getjPanelBotoes());
            utilities.Utilities.limpaComponentes(false, this.medicoForm.getjPanelDados3());

        } else if (evento.getSource() == this.medicoForm.getjButtonBuscar()) {
            codigo = 0;
            TelaBuscaMedico telaBuscaMedico = new TelaBuscaMedico(null, true);
            ControllerBuscaMedico controllerBuscaMedico = new ControllerBuscaMedico(telaBuscaMedico);
            telaBuscaMedico.setVisible(true);

            if (codigo != 0) {
                Medico medico = ServiceMedico.ler(codigo);

                utilities.Utilities.ativaDesativa(true, this.medicoForm.getjPanelBotoes());
                utilities.Utilities.limpaComponentes(true, this.medicoForm.getjPanelDados3());

                this.medicoForm.getIdField().setText(medico.getId() + "");
                this.medicoForm.getNomeMedico().setText(medico.getNome());
                this.medicoForm.getCRM().setText(medico.getCrm());
                this.medicoForm.getSenha().setText(medico.getSenha());
                this.medicoForm.getLogin().setText(medico.getLogin());
                this.medicoForm.getTelefoneMedico().setText(medico.getFone1());
                this.medicoForm.getTelefoneMedico2().setText(medico.getFone2());
                this.medicoForm.getEmail().setText(medico.getEmail());
                this.medicoForm.getCpfMedico().setText(medico.getCpfCnpj());
                this.medicoForm.getRgMedico().setText(medico.getRgInscricaoEstadual());
                this.medicoForm.getCep().setText(medico.getCep());
                this.medicoForm.getCidade().setText(medico.getCidade());
                this.medicoForm.getBairro().setText(medico.getBairro());
               this.medicoForm.getComplemento().setText(medico.getComplemento());
                this.medicoForm.getLogradouro1().setText(medico.getLogradouro());

                this.medicoForm.getIdField().setEnabled(false);
                this.medicoForm.getNomeMedico().requestFocus();
            }

        } else if (evento.getSource() == this.medicoForm.getjButtonSair()) {
            this.medicoForm.dispose();
        }
    }
}