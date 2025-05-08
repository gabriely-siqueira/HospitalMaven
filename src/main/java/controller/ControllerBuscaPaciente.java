package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Paciente;
import service.ServicePaciente;
import view.TelaBuscaPaciente;

public class ControllerBuscaPaciente implements ActionListener {

    private TelaBuscaPaciente telaBuscaPaciente;

    public ControllerBuscaPaciente(TelaBuscaPaciente telaBuscaPaciente) {
        this.telaBuscaPaciente = telaBuscaPaciente;

        this.telaBuscaPaciente.getjButtonCarregar().addActionListener(this);
        this.telaBuscaPaciente.getjButtonSair().addActionListener(this);
        this.telaBuscaPaciente.getjCBFiltro().addActionListener(this);
        this.telaBuscaPaciente.getjButtonFiltrar().addActionListener(this);
        this.telaBuscaPaciente.getjButtonExcluir().addActionListener(this); 
    }

    @Override
    public void actionPerformed(ActionEvent evento) {

        if (evento.getSource() == this.telaBuscaPaciente.getjButtonCarregar()) {
            if (this.telaBuscaPaciente.getjTableDados().getSelectedRow() != -1) {
                // Carrega o médico selecionado, independentemente do status
                MedicoController.codigo = (int) this.telaBuscaPaciente.getjTableDados()
                        .getValueAt(this.telaBuscaPaciente.getjTableDados().getSelectedRow(), 0);
                this.telaBuscaPaciente.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Selecione um paciente para carregar.");
            }
        } else if (evento.getSource() == this.telaBuscaPaciente.getjButtonFiltrar()) {

            // Filtro pelo ID
            String idFiltro = this.telaBuscaPaciente.getjTFFiltro().getText();
            
            DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaPaciente.getjTableDados().getModel();
            tabela.setRowCount(0);

            if (idFiltro.isEmpty()) {
                for (Paciente objetoAtualDaLista : ServicePaciente.ler()) {
                    tabela.addRow(new Object[]{
                        objetoAtualDaLista.getId(),
                        objetoAtualDaLista.getNome(),
                        objetoAtualDaLista.getTipoSanguineo(),
                        objetoAtualDaLista.getSexo(),
                        objetoAtualDaLista.getEmail(),
                        objetoAtualDaLista.getCpfCnpj(),
                        objetoAtualDaLista.getRgInscricaoEstadual(),
                        objetoAtualDaLista.getCep(),
                        objetoAtualDaLista.getCidade(),
                        objetoAtualDaLista.getBairro(),
                        objetoAtualDaLista.getLogradouro(),
                        objetoAtualDaLista.getComplemento(),
                        objetoAtualDaLista.getFone1(),
                        objetoAtualDaLista.getFone2(),
                        objetoAtualDaLista.getDataCadastro()
                    });
                }
            } else {
                try {
                    int id = Integer.parseInt(idFiltro);
                    Paciente paciente = ServicePaciente.ler(id);
                    if (paciente != null) {
                        tabela.addRow(new Object[]{
                            paciente.getId(),
                            paciente.getNome(),
                            paciente.getTipoSanguineo(),
                            paciente.getSexo(),
                            paciente.getEmail(),
                            paciente.getCpfCnpj(),
                            paciente.getRgInscricaoEstadual(),
                            paciente.getCep(),
                            paciente.getCidade(),
                            paciente.getBairro(),
                            paciente.getLogradouro(),
                            paciente.getComplemento(),
                            paciente.getFone1(),
                            paciente.getFone2(),
                            paciente.getDataCadastro()
                        });
                    } else {
                        JOptionPane.showMessageDialog(null, "Nenhum paciente encontrado com esse ID.");
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Por favor, insira um ID válido.");
                }
            }

        } else if (evento.getSource() == this.telaBuscaPaciente.getjButtonSair()) {
            this.telaBuscaPaciente.dispose();
        } else if (evento.getSource() == this.telaBuscaPaciente.getjButtonExcluir()) {
            int selectedRow = this.telaBuscaPaciente.getjTableDados().getSelectedRow();

            if (selectedRow != -1) {
                int idPaciente = (int) this.telaBuscaPaciente.getjTableDados()
                        .getValueAt(selectedRow, 0);

                int confirmacao = JOptionPane.showConfirmDialog(null,
                        "Você tem certeza que deseja excluir este paciente?",
                        "Confirmar exclusão",
                        JOptionPane.YES_NO_OPTION);

                if (confirmacao == JOptionPane.YES_OPTION) {
                    ServicePaciente.excluir(idPaciente);
                    JOptionPane.showMessageDialog(null, "Paciente excluído com sucesso!");

                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaPaciente.getjTableDados().getModel();
                    tabela.setRowCount(0);
                    for (Paciente objetoAtualDaLista : ServicePaciente.ler()) {
                        tabela.addRow(new Object[]{
                            objetoAtualDaLista.getId(),
                            objetoAtualDaLista.getNome(),
                            objetoAtualDaLista.getTipoSanguineo(),
                            objetoAtualDaLista.getSexo(),
                            objetoAtualDaLista.getEmail(),
                            objetoAtualDaLista.getCpfCnpj(),
                            objetoAtualDaLista.getRgInscricaoEstadual(),
                            objetoAtualDaLista.getCep(),
                            objetoAtualDaLista.getCidade(),
                            objetoAtualDaLista.getBairro(),
                            objetoAtualDaLista.getLogradouro(),
                            objetoAtualDaLista.getComplemento(),
                            objetoAtualDaLista.getFone1(),
                            objetoAtualDaLista.getFone2(),
                            objetoAtualDaLista.getDataCadastro()
                        });
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Selecione um paciente para excluir.");
            }
        }
    }
}