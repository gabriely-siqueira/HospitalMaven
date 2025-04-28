/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.Receita;
import view.ReceitaForm;

public class ReceitaController implements ActionListener {
    
    ReceitaForm receita;
    
    public ReceitaController(ReceitaForm receita){
        this.receita = receita;
        this.receita.getjButtonNovo().addActionListener(this);
        this.receita.getjButtonCancelar().addActionListener(this);
        this.receita.getjButtonGravar().addActionListener(this);
        this.receita.getjButtonBuscar().addActionListener(this);
        this.receita.getjButtonSair().addActionListener(this);

        utilities.Utilities.ativaDesativa(false, this.receita.getjPanelBotoes());
        utilities.Utilities.limpaComponentes(false, this.receita.getjPanelDados3());
    }
   
 
     @Override
    public void actionPerformed(ActionEvent evento) {

        if (evento.getSource() == this.receita.getjButtonNovo()) {
            utilities.Utilities.ativaDesativa(true, this.receita.getjPanelBotoes());
            utilities.Utilities.limpaComponentes(true,this.receita.getjPanelDados3());
            
            this.receita.getIdField().setEnabled(false);

        } else if (evento.getSource() == this.receita.getjButtonCancelar()) {
            utilities.Utilities.ativaDesativa(false, this.receita.getjPanelBotoes());
            utilities.Utilities.limpaComponentes(false, this.receita.getjPanelDados3() );

        } else if (evento.getSource() == this.receita.getjButtonGravar()) {

            Receita novaReceita = new Receita();
            
        novaReceita.setId(model.ClasseDadosGravacao.listaReceita.size() + 1); 
        novaReceita.setDataHoraReceita(this.receita.getData().getText());
        novaReceita.setObservacao(this.receita.getObservacao().getText());
        novaReceita.setStatus(this.receita.getStatus().getText());


            model.ClasseDadosGravacao.listaReceita.add(novaReceita);
            JOptionPane.showMessageDialog(null, "Gravado com sucesso!");
            
            utilities.Utilities.ativaDesativa(false, this.receita.getjPanelBotoes());
            utilities.Utilities.limpaComponentes(false, this.receita.getjPanelDados3() );

        } else if (evento.getSource() == this.receita.getjButtonBuscar()) {
       
            JOptionPane.showMessageDialog(null, model.ClasseDadosGravacao.listaReceita.toString());
        } else if (evento.getSource() == this.receita.getjButtonSair()) {
            this.receita.dispose();
        }

    }

}
   
