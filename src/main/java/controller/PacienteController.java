package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import model.Paciente;
import service.ServicePaciente;
import view.PacienteForm;
import view.TelaBuscaPaciente;

public class PacienteController implements ActionListener {

    private PacienteForm pacienteForm;
    public static int codigo;

    public PacienteController(PacienteForm pacienteForm) {
        this.pacienteForm = pacienteForm;

        this.pacienteForm.getjButtonNovo().addActionListener(this);
        this.pacienteForm.getjButtonCancelar().addActionListener(this);
        this.pacienteForm.getjButtonGravar().addActionListener(this);
        this.pacienteForm.getjButtonBuscar().addActionListener(this);
        this.pacienteForm.getjButtonSair().addActionListener(this);

        utilities.Utilities.ativaDesativa(false, this.pacienteForm.getjPanelBotoes());
        utilities.Utilities.limpaComponentes(false, this.pacienteForm.getjPanelDados3());
    }

    @Override
    public void actionPerformed(ActionEvent evento) {

        if (evento.getSource() == this.pacienteForm.getjButtonNovo()) {
            utilities.Utilities.ativaDesativa(true, this.pacienteForm.getjPanelBotoes());
            utilities.Utilities.limpaComponentes(true, this.pacienteForm.getjPanelDados3());
            this.pacienteForm.getIdField().setEnabled(false);

        } else if (evento.getSource() == this.pacienteForm.getjButtonCancelar()) {
            utilities.Utilities.ativaDesativa(false, this.pacienteForm.getjPanelBotoes());
            utilities.Utilities.limpaComponentes(false, this.pacienteForm.getjPanelDados3());

        } else if (evento.getSource() == this.pacienteForm.getjButtonGravar()) {
            Paciente paciente = new Paciente();

            paciente.setNome(this.pacienteForm.getNome().getText());
            paciente.setTipoSanguineo(this.pacienteForm.getTipoSanguineo().getSelectedItem() != null 
                ? this.pacienteForm.getTipoSanguineo().getSelectedItem().toString() : "");
            paciente.setSexo(this.pacienteForm.getSexo().getSelectedItem() != null 
                ? this.pacienteForm.getSexo().getSelectedItem().toString() : "");
            paciente.setFone1(this.pacienteForm.getTelefone1().getText());
            paciente.setFone2(this.pacienteForm.getTelefone2().getText());
            paciente.setEmail(this.pacienteForm.getEmail().getText());
            paciente.setCpfCnpj(this.pacienteForm.getCpf().getText());
            paciente.setRgInscricaoEstadual(this.pacienteForm.getRg().getText());
            paciente.setCep(this.pacienteForm.getCep().getText());
            paciente.setCidade(this.pacienteForm.getCidade().getText());
            paciente.setBairro(this.pacienteForm.getBairro().getText());
            paciente.setComplemento(this.pacienteForm.getComplemento().getText());
            paciente.setLogradouro(this.pacienteForm.getLogradouro().getText());

            // Definir a data de cadastro automaticamente
            LocalDate dataAtual = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            paciente.setDataCadastro(dataAtual.format(formatter));

            if (this.pacienteForm.getIdField().getText().equals("")) {
                ServicePaciente.adicionar(paciente);
                JOptionPane.showMessageDialog(null, "Paciente cadastrado com sucesso!");
            } else {
                paciente.setId(Integer.parseInt(this.pacienteForm.getIdField().getText()));
                ServicePaciente.atualizar(paciente);
                JOptionPane.showMessageDialog(null, "Paciente atualizado com sucesso!");
            }

            utilities.Utilities.ativaDesativa(false, this.pacienteForm.getjPanelBotoes());
            utilities.Utilities.limpaComponentes(false, this.pacienteForm.getjPanelDados3());

        } else if (evento.getSource() == this.pacienteForm.getjButtonBuscar()) {
            codigo = 0;
            TelaBuscaPaciente telaBuscaPaciente = new TelaBuscaPaciente(null, true);
            ControllerBuscaPaciente controllerBuscaPaciente = new ControllerBuscaPaciente(telaBuscaPaciente);
            telaBuscaPaciente.setVisible(true);

            if (codigo != 0) {
                Paciente paciente = ServicePaciente.ler(codigo);

                utilities.Utilities.ativaDesativa(true, this.pacienteForm.getjPanelBotoes());
                utilities.Utilities.limpaComponentes(true, this.pacienteForm.getjPanelDados3());

                this.pacienteForm.getIdField().setText(String.valueOf(paciente.getId()));
                this.pacienteForm.getNome().setText(paciente.getNome());
                this.pacienteForm.getTipoSanguineo().setSelectedItem(paciente.getTipoSanguineo());
                this.pacienteForm.getSexo().setSelectedItem(paciente.getSexo());
                this.pacienteForm.getTelefone1().setText(paciente.getFone1());
                this.pacienteForm.getTelefone2().setText(paciente.getFone2());
                this.pacienteForm.getEmail().setText(paciente.getEmail());
                this.pacienteForm.getCpf().setText(paciente.getCpfCnpj());
                this.pacienteForm.getRg().setText(paciente.getRgInscricaoEstadual());
                this.pacienteForm.getCep().setText(paciente.getCep());
                this.pacienteForm.getCidade().setText(paciente.getCidade());
                this.pacienteForm.getBairro().setText(paciente.getBairro());
                this.pacienteForm.getComplemento().setText(paciente.getComplemento());
                this.pacienteForm.getLogradouro().setText(paciente.getLogradouro());

                this.pacienteForm.getIdField().setEnabled(false);
                this.pacienteForm.getNome().requestFocus();
            }

        } else if (evento.getSource() == this.pacienteForm.getjButtonSair()) {
            this.pacienteForm.dispose();
        }
    }
}