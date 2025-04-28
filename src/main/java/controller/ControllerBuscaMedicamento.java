package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Medicamento;
import service.ServiceMedicamento;
import view.TelaBuscaMedicamento;

public class ControllerBuscaMedicamento implements ActionListener {

    private TelaBuscaMedicamento telaBuscaMedicamento;

    public ControllerBuscaMedicamento(TelaBuscaMedicamento telaBuscaMedicamento) {
        this.telaBuscaMedicamento = telaBuscaMedicamento;

        this.telaBuscaMedicamento.getjButtonCarregar().addActionListener(this);
        this.telaBuscaMedicamento.getjButtonSair().addActionListener(this);
        this.telaBuscaMedicamento.getjCBFiltro().addActionListener(this);
        this.telaBuscaMedicamento.getjButtonFiltrar().addActionListener(this);
        this.telaBuscaMedicamento.getjButtonExcluir().addActionListener(this); // Adicionando ação de excluir
    }

    @Override
    public void actionPerformed(ActionEvent evento) {

        if (evento.getSource() == this.telaBuscaMedicamento.getjButtonCarregar()) {
            if (this.telaBuscaMedicamento.getjTableDados().getValueAt(
                    this.telaBuscaMedicamento.getjTableDados().getSelectedRow(), 3).equals("A")) {

                // Definindo o ID do medicamento carregado para uso posterior
                MedicamentoController.codigo = (int) this.telaBuscaMedicamento.getjTableDados()
                        .getValueAt(this.telaBuscaMedicamento.getjTableDados().getSelectedRow(), 0);

                this.telaBuscaMedicamento.dispose();
            }
        } else if (evento.getSource() == this.telaBuscaMedicamento.getjButtonFiltrar()) {

            // Filtro pelo ID
            String idFiltro = this.telaBuscaMedicamento.getjTFFiltro().getText();
            
            DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaMedicamento.getjTableDados().getModel();
            tabela.setRowCount(0);

            if (idFiltro.isEmpty()) {
                for (Medicamento objetoAtualDaLista : service.ServiceMedicamento.ler()) {
                    tabela.addRow(new Object[]{objetoAtualDaLista.getId(), objetoAtualDaLista.getDescricaoMedicamento(),
                            objetoAtualDaLista.getPrincipioAtivo(), objetoAtualDaLista.getStatus()});
                }
            } else {
                int id = Integer.parseInt(idFiltro);
                Medicamento medicamento = service.ServiceMedicamento.ler(id);
                if (medicamento != null) {
                    tabela.addRow(new Object[]{medicamento.getId(), medicamento.getDescricaoMedicamento(),
                            medicamento.getPrincipioAtivo(), medicamento.getStatus()});
                } else {
                    JOptionPane.showMessageDialog(null, "Nenhum medicamento encontrado com esse ID.");
                }
            }

        } else if (evento.getSource() == this.telaBuscaMedicamento.getjButtonSair()) {
            this.telaBuscaMedicamento.dispose();
        } else if (evento.getSource() == this.telaBuscaMedicamento.getjButtonExcluir()) {
            int selectedRow = this.telaBuscaMedicamento.getjTableDados().getSelectedRow();

            if (selectedRow != -1) {
                int idMedicamento = (int) this.telaBuscaMedicamento.getjTableDados()
                        .getValueAt(selectedRow, 0);

                int confirmacao = JOptionPane.showConfirmDialog(null,
                        "Você tem certeza que deseja excluir este medicamento?",
                        "Confirmar exclusão",
                        JOptionPane.YES_NO_OPTION);

                if (confirmacao == JOptionPane.YES_OPTION) {
                    service.ServiceMedicamento.excluir(idMedicamento);
                    JOptionPane.showMessageDialog(null, "Medicamento excluído com sucesso!");

                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaMedicamento.getjTableDados().getModel();
                    tabela.setRowCount(0);
                    for (Medicamento objetoAtualDaLista : service.ServiceMedicamento.ler()) {
                        tabela.addRow(new Object[]{objetoAtualDaLista.getId(), objetoAtualDaLista.getDescricaoMedicamento(),
                                objetoAtualDaLista.getPrincipioAtivo(), objetoAtualDaLista.getStatus()});
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Selecione um medicamento para excluir.");
            }
        }
    }
}
