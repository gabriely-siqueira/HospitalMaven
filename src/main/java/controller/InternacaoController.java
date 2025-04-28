/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.Internacao;
import view.InternacaoForm;


public class InternacaoController implements ActionListener {
    
    InternacaoForm internacao;
    
    public InternacaoController( InternacaoForm internacao){
        this.internacao = internacao;
        this.internacao.getjButtonNovo().addActionListener(this);
        this.internacao.getjButtonCancelar().addActionListener(this);
        this.internacao.getjButtonGravar().addActionListener(this);
        this.internacao.getjButtonBuscar().addActionListener(this);
        this.internacao.getjButtonSair().addActionListener(this);


        utilities.Utilities.ativaDesativa(false, this.internacao.getjPanelBotoes());
        utilities.Utilities.limpaComponentes(false, this.internacao.getjPanelDados3());
       
    }
   
    
     @Override
    public void actionPerformed(ActionEvent evento) {

        if (evento.getSource() == this.internacao.getjButtonNovo()) {
            utilities.Utilities.ativaDesativa(true, this.internacao.getjPanelBotoes());
            utilities.Utilities.limpaComponentes(true,this.internacao.getjPanelDados3());
            
            this.internacao.getIdField().setEnabled(false);

        } else if (evento.getSource() == this.internacao.getjButtonCancelar()) {
            utilities.Utilities.ativaDesativa(false, this.internacao.getjPanelBotoes());
            utilities.Utilities.limpaComponentes(false, this.internacao.getjPanelDados3() );

        } else if (evento.getSource() == this.internacao.getjButtonGravar()) {

        Internacao novaInternacao = new Internacao();
            
        novaInternacao.setId(model.ClasseDadosGravacao.listaInternacao.size() + 1); 
        novaInternacao.setDataInternacao(this.internacao.getDataEntrada().getText());
        novaInternacao.setHoraInternacao(this.internacao.getHoraEntrada().getText());
        novaInternacao.setDataAlta(this.internacao.getDataSaida().getText());
        novaInternacao.setHoraAlta(this.internacao.getHoraSaida().getText());    
        novaInternacao.setObservacao(this.internacao.getObsInternacao().getText());
        novaInternacao.setStatus(this.internacao.getStatusField().getSelectedItem().toString());

            model.ClasseDadosGravacao.listaInternacao.add(novaInternacao);
            JOptionPane.showMessageDialog(null, "Gravado com sucesso!");
            
            utilities.Utilities.ativaDesativa(false, this.internacao.getjPanelBotoes());
            utilities.Utilities.limpaComponentes(false, this.internacao.getjPanelDados3() );

        } else if (evento.getSource() == this.internacao.getjButtonBuscar()) {
       
            JOptionPane.showMessageDialog(null, model.ClasseDadosGravacao.listaInternacao.toString());
        } else if (evento.getSource() == this.internacao.getjButtonSair()) {
            this.internacao.dispose();
        }

    }

}

