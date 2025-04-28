package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Ala;
import service.ServiceAla;
import view.TelaBuscaAla;

public class ControllerBuscaAla implements ActionListener {

    private TelaBuscaAla telaBuscaAla;

    public ControllerBuscaAla(TelaBuscaAla telaBuscaAla) {
        this.telaBuscaAla = telaBuscaAla;

        this.telaBuscaAla.getjButtonCarregar().addActionListener(this);
        this.telaBuscaAla.getjButtonSair().addActionListener(this);
        this.telaBuscaAla.getjCBFiltro().addActionListener(this);
        this.telaBuscaAla.getjButtonFiltrar().addActionListener(this);
        this.telaBuscaAla.getjButtonExcluir().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == this.telaBuscaAla.getjButtonCarregar()) {
            if (this.telaBuscaAla.getjTableDados().getValueAt(
                    this.telaBuscaAla.getjTableDados().getSelectedRow(), 2).equals("A")) {

                AlaController.codigo = (int) this.telaBuscaAla.getjTableDados()
                        .getValueAt(this.telaBuscaAla.getjTableDados().getSelectedRow(), 0);

                this.telaBuscaAla.dispose();
            }

        } else if (evento.getSource() == this.telaBuscaAla.getjButtonFiltrar()) {
            String idFiltro = this.telaBuscaAla.getjTFFiltro().getText().trim();
            DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaAla.getjTableDados().getModel();
            tabela.setRowCount(0);

            if (idFiltro.isEmpty()) {
                for (Ala ala : ServiceAla.listarAlas()) {
                    tabela.addRow(new Object[]{ala.getId(), ala.getDescricao(), ala.getStatus()});
                }
            } else {
                try {
                    int id = Integer.parseInt(idFiltro);
                    Ala ala = ServiceAla.ler(id);
                    if (ala != null) {
                        tabela.addRow(new Object[]{ala.getId(), ala.getDescricao(), ala.getStatus()});
                    } else {
                        JOptionPane.showMessageDialog(null, "Nenhuma ala encontrada com esse ID.");
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "O ID deve conter apenas números.");
                }
            }

        } else if (evento.getSource() == this.telaBuscaAla.getjButtonExcluir()) {
            int selectedRow = this.telaBuscaAla.getjTableDados().getSelectedRow();

            if (selectedRow != -1) {
                int idAla = (int) this.telaBuscaAla.getjTableDados()
                        .getValueAt(selectedRow, 0);

                int confirmacao = JOptionPane.showConfirmDialog(null,
                        "Você tem certeza que deseja excluir esta ala?",
                        "Confirmar exclusão",
                        JOptionPane.YES_NO_OPTION);

                if (confirmacao == JOptionPane.YES_OPTION) {
                    ServiceAla.excluir(idAla);
                    JOptionPane.showMessageDialog(null, "Ala excluída com sucesso!");

                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaAla.getjTableDados().getModel();
                    tabela.setRowCount(0);
                    for (Ala ala : ServiceAla.listarAlas()) {
                        tabela.addRow(new Object[]{ala.getId(), ala.getDescricao(), ala.getStatus()});
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Selecione uma ala para excluir.");
            }

        } else if (evento.getSource() == this.telaBuscaAla.getjButtonSair()) {
            this.telaBuscaAla.dispose();
        }
    }
}
