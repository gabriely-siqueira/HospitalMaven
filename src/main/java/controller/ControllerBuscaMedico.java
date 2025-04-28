package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Medico;
import service.ServiceMedico;
import view.TelaBuscaMedico;

public class ControllerBuscaMedico implements ActionListener {

    private TelaBuscaMedico telaBuscaMedico;

    public ControllerBuscaMedico(TelaBuscaMedico telaBuscaMedico) {
        this.telaBuscaMedico = telaBuscaMedico;

        this.telaBuscaMedico.getjButtonCarregar().addActionListener(this);
        this.telaBuscaMedico.getjButtonSair().addActionListener(this);
        this.telaBuscaMedico.getjCBFiltro().addActionListener(this);
        this.telaBuscaMedico.getjButtonFiltrar().addActionListener(this);
        this.telaBuscaMedico.getjButtonExcluir().addActionListener(this); 
    }

    @Override
    public void actionPerformed(ActionEvent evento) {

        if (evento.getSource() == this.telaBuscaMedico.getjButtonCarregar()) {
            if (this.telaBuscaMedico.getjTableDados().getSelectedRow() != -1) {
                // Carrega o médico selecionado, independentemente do status
                MedicoController.codigo = (int) this.telaBuscaMedico.getjTableDados()
                        .getValueAt(this.telaBuscaMedico.getjTableDados().getSelectedRow(), 0);
                this.telaBuscaMedico.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Selecione um médico para carregar.");
            }
        } else if (evento.getSource() == this.telaBuscaMedico.getjButtonFiltrar()) {

            // Filtro pelo ID
            String idFiltro = this.telaBuscaMedico.getjTFFiltro().getText();
            
            DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaMedico.getjTableDados().getModel();
            tabela.setRowCount(0);

            if (idFiltro.isEmpty()) {
                for (Medico objetoAtualDaLista : ServiceMedico.ler()) {
                    tabela.addRow(new Object[]{
                        objetoAtualDaLista.getId(),
                        objetoAtualDaLista.getNome(),
                        objetoAtualDaLista.getCrm(),
                        objetoAtualDaLista.getLogin(),
                        objetoAtualDaLista.getSenha(),
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
                    Medico medico = ServiceMedico.ler(id);
                    if (medico != null) {
                        tabela.addRow(new Object[]{
                            medico.getId(),
                            medico.getNome(),
                            medico.getCrm(),
                            medico.getLogin(),
                            medico.getSenha(),
                            medico.getEmail(),
                            medico.getCpfCnpj(),
                            medico.getRgInscricaoEstadual(),
                            medico.getCep(),
                            medico.getCidade(),
                            medico.getBairro(),
                            medico.getLogradouro(),
                            medico.getComplemento(),
                            medico.getFone1(),
                            medico.getFone2(),
                            medico.getDataCadastro()
                        });
                    } else {
                        JOptionPane.showMessageDialog(null, "Nenhum médico encontrado com esse ID.");
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Por favor, insira um ID válido.");
                }
            }

        } else if (evento.getSource() == this.telaBuscaMedico.getjButtonSair()) {
            this.telaBuscaMedico.dispose();
        } else if (evento.getSource() == this.telaBuscaMedico.getjButtonExcluir()) {
            int selectedRow = this.telaBuscaMedico.getjTableDados().getSelectedRow();

            if (selectedRow != -1) {
                int idMedico = (int) this.telaBuscaMedico.getjTableDados()
                        .getValueAt(selectedRow, 0);

                int confirmacao = JOptionPane.showConfirmDialog(null,
                        "Você tem certeza que deseja excluir este médico?",
                        "Confirmar exclusão",
                        JOptionPane.YES_NO_OPTION);

                if (confirmacao == JOptionPane.YES_OPTION) {
                    ServiceMedico.excluir(idMedico);
                    JOptionPane.showMessageDialog(null, "Médico excluído com sucesso!");

                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaMedico.getjTableDados().getModel();
                    tabela.setRowCount(0);
                    for (Medico objetoAtualDaLista : ServiceMedico.ler()) {
                        tabela.addRow(new Object[]{
                            objetoAtualDaLista.getId(),
                            objetoAtualDaLista.getNome(),
                            objetoAtualDaLista.getCrm(),
                            objetoAtualDaLista.getLogin(),
                            objetoAtualDaLista.getSenha(),
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
                JOptionPane.showMessageDialog(null, "Selecione um médico para excluir.");
            }
        }
    }
}