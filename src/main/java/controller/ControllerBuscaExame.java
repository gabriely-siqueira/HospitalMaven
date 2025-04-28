package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Exame;
import service.ServiceExame;
import view.TelaBuscaExame;

public class ControllerBuscaExame implements ActionListener {

    private TelaBuscaExame telaBuscaExame;

    public ControllerBuscaExame(TelaBuscaExame telaBuscaExame) {
        this.telaBuscaExame = telaBuscaExame;

        this.telaBuscaExame.getjButtonCarregar().addActionListener(this);
        this.telaBuscaExame.getjButtonSair().addActionListener(this);
        this.telaBuscaExame.getjCBFiltro().addActionListener(this);
        this.telaBuscaExame.getjButtonFiltrar().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        Object source = evento.getSource();

        if (source == this.telaBuscaExame.getjButtonCarregar()) {
            carregarExame(); // Nome do método ajustado para refletir o contexto
        } else if (source == this.telaBuscaExame.getjButtonSair()) {
            this.telaBuscaExame.dispose();
        } else if (source == this.telaBuscaExame.getjButtonFiltrar()) {
            filtrarExames(); // Nome do método ajustado para refletir o contexto
        }
    }

    private void carregarExame() {
        JOptionPane.showMessageDialog(telaBuscaExame, "Funcionalidade 'Carregar Exame' ainda não implementada.");
    }

    private void filtrarExames() {
        String filtro = this.telaBuscaExame.getjTFFiltro().getText().trim();

        if (filtro.isEmpty()) {
            JOptionPane.showMessageDialog(telaBuscaExame, "É obrigatório o preenchimento do campo de filtro.");
            this.telaBuscaExame.getjTFFiltro().requestFocus();
            return;
        }

        String filtroSelecionado = this.telaBuscaExame.getjCBFiltro().getSelectedItem().toString();
        DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaExame.getjTableDados().getModel();
        tabela.setRowCount(0); // Limpa a tabela antes de preencher os dados

        try {
            switch (filtroSelecionado) {
                case "ID":
                    Exame exame = ServiceExame.ler(Integer.parseInt(filtro));
                    if (exame != null) {
                        tabela.addRow(new Object[]{
                            exame.getId(),
                            exame.getTituloExame(),
                            exame.getTipoExame(),
                            exame.getStatus()
                        });
                    } else {
                        JOptionPane.showMessageDialog(telaBuscaExame, "Nenhum exame encontrado com o ID fornecido.");
                    }
                    break;

                case "NOME EXAME":
                    preencherTabela(ServiceExame.ler(filtro, "tituloExame"), tabela);
                    break;

                case "TIPO EXAME":
                    preencherTabela(ServiceExame.ler(filtro, "tipoExame"), tabela);
                    break;

                case "STATUS":
                    preencherTabela(ServiceExame.ler(filtro, "status"), tabela);
                    break;

                default:
                    JOptionPane.showMessageDialog(telaBuscaExame, "Filtro inválido selecionado.");
                    break;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(telaBuscaExame, "O filtro ID deve conter apenas números.", "Erro de Formato", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(telaBuscaExame, "Erro ao filtrar exames: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void preencherTabela(List<Exame> exames, DefaultTableModel tabela) {
        if (exames == null || exames.isEmpty()) {
            JOptionPane.showMessageDialog(telaBuscaExame, "Nenhum exame encontrado com o filtro aplicado.");
            return;
        }

        for (Exame exame : exames) {
            tabela.addRow(new Object[]{
                exame.getId(),
                exame.getTituloExame(),
                exame.getTipoExame(),
                exame.getStatus()
            });
        }
    }
}
