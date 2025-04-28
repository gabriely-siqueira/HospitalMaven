package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Quarto;
import service.ServiceQuarto;
import view.TelaBuscaQuarto;

public class ControllerBuscaQuarto implements ActionListener {

    private TelaBuscaQuarto telaBuscaQuarto;

    public ControllerBuscaQuarto(TelaBuscaQuarto telaBuscaQuarto) {
        this.telaBuscaQuarto = telaBuscaQuarto;

        this.telaBuscaQuarto.getjButtonCarregar().addActionListener(this);
        this.telaBuscaQuarto.getjButtonSair().addActionListener(this);
        this.telaBuscaQuarto.getjCBFiltro().addActionListener(this);
        this.telaBuscaQuarto.getjButtonFiltrar().addActionListener(this);
        this.telaBuscaQuarto.getjButtonExcluir().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {

        if (evento.getSource() == this.telaBuscaQuarto.getjButtonCarregar()) {
            if (this.telaBuscaQuarto.getjTableDados().getValueAt(
                    this.telaBuscaQuarto.getjTableDados().getSelectedRow(), 2).equals("A")) {

                QuartoController.codigo = (int) this.telaBuscaQuarto.getjTableDados()
                        .getValueAt(this.telaBuscaQuarto.getjTableDados().getSelectedRow(), 0);

                this.telaBuscaQuarto.dispose();
            }
        } else if (evento.getSource() == this.telaBuscaQuarto.getjButtonFiltrar()) {
            String filtro = this.telaBuscaQuarto.getjTFFiltro().getText().trim();
            String filtroSelecionado = this.telaBuscaQuarto.getjCBFiltro().getSelectedItem().toString();
            DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaQuarto.getjTableDados().getModel();
            tabela.setRowCount(0);

            if (filtro.isEmpty()) {
                for (Quarto q : ServiceQuarto.ler()) {
                    tabela.addRow(new Object[]{
                        q.getId(),
                        q.getDescricao(),
                        q.getStatus(),
                        q.getAla() != null ? q.getAla().getDescricao() : "Sem Ala"
                    });
                }
            } else {
                try {
                    switch (filtroSelecionado) {
                        case "ID":
                            int id = Integer.parseInt(filtro);
                            Quarto q = ServiceQuarto.ler(id);
                            if (q != null) {
                                tabela.addRow(new Object[]{
                                    q.getId(),
                                    q.getDescricao(),
                                    q.getStatus(),
                                    q.getAla() != null ? q.getAla().getDescricao() : "Sem Ala"
                                });
                            } else {
                                JOptionPane.showMessageDialog(null, "Nenhum quarto encontrado com esse ID.");
                            }
                            break;

                        case "DESCRICAO":
                        case "STATUS":
                        case "ALA":
                            List<Quarto> lista = ServiceQuarto.ler(filtro, filtroSelecionado.toLowerCase());
                            for (Quarto quarto : lista) {
                                tabela.addRow(new Object[]{
                                    quarto.getId(),
                                    quarto.getDescricao(),
                                    quarto.getStatus(),
                                    quarto.getAla() != null ? quarto.getAla().getDescricao() : "Sem Ala"
                                });
                            }
                            break;

                        default:
                            JOptionPane.showMessageDialog(null, "Filtro inválido selecionado.");
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Filtro de ID deve conter apenas números.");
                }
            }
        } else if (evento.getSource() == this.telaBuscaQuarto.getjButtonSair()) {
            this.telaBuscaQuarto.dispose();
        } else if (evento.getSource() == this.telaBuscaQuarto.getjButtonExcluir()) {
            int selectedRow = this.telaBuscaQuarto.getjTableDados().getSelectedRow();

            if (selectedRow != -1) {
                int idQuarto = (int) this.telaBuscaQuarto.getjTableDados().getValueAt(selectedRow, 0);

                int confirmacao = JOptionPane.showConfirmDialog(null,
                        "Você tem certeza que deseja excluir este quarto?",
                        "Confirmar exclusão",
                        JOptionPane.YES_NO_OPTION);

                if (confirmacao == JOptionPane.YES_OPTION) {
                    ServiceQuarto.excluir(idQuarto);
                    JOptionPane.showMessageDialog(null, "Quarto excluído com sucesso!");

                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaQuarto.getjTableDados().getModel();
                    tabela.setRowCount(0);
                    for (Quarto q : ServiceQuarto.ler()) {
                        tabela.addRow(new Object[]{
                            q.getId(),
                            q.getDescricao(),
                            q.getStatus(),
                            q.getAla() != null ? q.getAla().getDescricao() : "Sem Ala"
                        });
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Selecione um quarto para excluir.");
            }
        }
    }
}
