package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Laboratorio;
import service.ServiceLaboratorio;
import view.TelaBuscaLaboratorio;

public class ControllerBuscaLaboratorio implements ActionListener {

    private TelaBuscaLaboratorio telaBuscaLaboratorio;

    public ControllerBuscaLaboratorio(TelaBuscaLaboratorio telaBuscaLaboratorio) {
        this.telaBuscaLaboratorio = telaBuscaLaboratorio;

        this.telaBuscaLaboratorio.getjButtonCarregar().addActionListener(this);
        this.telaBuscaLaboratorio.getjButtonSair().addActionListener(this);
        this.telaBuscaLaboratorio.getjCBFiltro().addActionListener(this);
        this.telaBuscaLaboratorio.getjButtonFiltrar().addActionListener(this);
        this.telaBuscaLaboratorio.getjButtonExcluir().addActionListener(this); 
    }
@Override
public void actionPerformed(ActionEvent evento) {

    if (evento.getSource() == this.telaBuscaLaboratorio.getjButtonCarregar()) {
        if (this.telaBuscaLaboratorio.getjTableDados().getValueAt(
                this.telaBuscaLaboratorio.getjTableDados().getSelectedRow(), 3).equals("A")) {

            LaboratorioController.codigo = (int) this.telaBuscaLaboratorio.getjTableDados()
                    .getValueAt(this.telaBuscaLaboratorio.getjTableDados().getSelectedRow(), 0);

            this.telaBuscaLaboratorio.dispose();
        }
    } else if (evento.getSource() == this.telaBuscaLaboratorio.getjButtonFiltrar()) {

        // Filtro pelo ID
        String idFiltro = this.telaBuscaLaboratorio.getjTFFiltro().getText();
        
        DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaLaboratorio.getjTableDados().getModel();
        tabela.setRowCount(0);

        if (idFiltro.isEmpty()) {
            for (Laboratorio objetoAtualDaLista : service.ServiceLaboratorio.ler()) {
                tabela.addRow(new Object[]{objetoAtualDaLista.getId(), objetoAtualDaLista.getNomeFantasia(),
                        objetoAtualDaLista.getContato(), objetoAtualDaLista.getStatus()});
            }
        } else {
            int id = Integer.parseInt(idFiltro);
            Laboratorio laboratorio = service.ServiceLaboratorio.ler(id);
            if (laboratorio != null) {
                tabela.addRow(new Object[]{laboratorio.getId(), laboratorio.getNomeFantasia(),
                        laboratorio.getContato(), laboratorio.getStatus()});
            } else {
                JOptionPane.showMessageDialog(null, "Nenhum laboratório encontrado com esse ID.");
            }
        }

    } else if (evento.getSource() == this.telaBuscaLaboratorio.getjButtonSair()) {
        this.telaBuscaLaboratorio.dispose();
    } else if (evento.getSource() == this.telaBuscaLaboratorio.getjButtonExcluir()) {
        int selectedRow = this.telaBuscaLaboratorio.getjTableDados().getSelectedRow();

        if (selectedRow != -1) {
            int idLaboratorio = (int) this.telaBuscaLaboratorio.getjTableDados()
                    .getValueAt(selectedRow, 0);

            int confirmacao = JOptionPane.showConfirmDialog(null,
                    "Você tem certeza que deseja excluir este laboratório?",
                    "Confirmar exclusão",
                    JOptionPane.YES_NO_OPTION);

            if (confirmacao == JOptionPane.YES_OPTION) {
                service.ServiceLaboratorio.excluir(idLaboratorio);
                JOptionPane.showMessageDialog(null, "Laboratório excluído com sucesso!");

                DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaLaboratorio.getjTableDados().getModel();
                tabela.setRowCount(0);
                for (Laboratorio objetoAtualDaLista : service.ServiceLaboratorio.ler()) {
                    tabela.addRow(new Object[]{objetoAtualDaLista.getId(), objetoAtualDaLista.getNomeFantasia(),
                            objetoAtualDaLista.getContato(), objetoAtualDaLista.getStatus()});
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um laboratório para excluir.");
        }
    }
}
}
