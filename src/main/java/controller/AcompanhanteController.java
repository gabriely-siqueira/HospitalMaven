/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.Acompanhante;
import view.AcompanhanteForm;

/**
 *
 * @author gabriely
 */
public class AcompanhanteController implements ActionListener {
    
    AcompanhanteForm acompanhante;
    
    public AcompanhanteController(AcompanhanteForm acompanhante){
        this.acompanhante = acompanhante;
        this.acompanhante.getjButtonNovo().addActionListener(this);
        this.acompanhante.getjButtonCancelar().addActionListener(this);
        this.acompanhante.getjButtonGravar().addActionListener(this);
        this.acompanhante.getjButtonBuscar().addActionListener(this);
        this.acompanhante.getjButtonSair().addActionListener(this);

        utilities.Utilities.ativaDesativa(false, this.acompanhante.getjPanelBotoes());
        utilities.Utilities.limpaComponentes(false, this.acompanhante.getjPanelDados3());
    }
 
     @Override
    public void actionPerformed(ActionEvent evento) {

        if (evento.getSource() == this.acompanhante.getjButtonNovo()) {
            utilities.Utilities.ativaDesativa(true, this.acompanhante.getjPanelBotoes());
            utilities.Utilities.limpaComponentes(true,this.acompanhante.getjPanelDados3());
            
            this.acompanhante.getIdField().setEnabled(false);

        } else if (evento.getSource() == this.acompanhante.getjButtonCancelar()) {
            utilities.Utilities.ativaDesativa(false, this.acompanhante.getjPanelBotoes());
            utilities.Utilities.limpaComponentes(false, this.acompanhante.getjPanelDados3() );

        } else if (evento.getSource() == this.acompanhante.getjButtonGravar()) {

            Acompanhante novoAcompanhante = new Acompanhante();
            
        novoAcompanhante.setId(model.ClasseDadosGravacao.listaLaboratorio.size() + 1); 
        novoAcompanhante.setNome(this.acompanhante.getNomeAcompanhante().getText());
        novoAcompanhante.setGrauParentesco(this.acompanhante.getGrauParentesco().getText());
        novoAcompanhante.setCpf(this.acompanhante.getCpfField().getText());
        novoAcompanhante.setFone(this.acompanhante.getTelefoneField().getText());
        novoAcompanhante.setEmail(this.acompanhante.getEmailField().getText());
        novoAcompanhante.setStatus(this.acompanhante.getStatus().getSelectedItem().toString());


            model.ClasseDadosGravacao.listaAcompanhante.add(novoAcompanhante);
            JOptionPane.showMessageDialog(null, "Gravado com sucesso!");
            
            utilities.Utilities.ativaDesativa(false, this.acompanhante.getjPanelBotoes());
            utilities.Utilities.limpaComponentes(false, this.acompanhante.getjPanelDados3() );

        } else if (evento.getSource() == this.acompanhante.getjButtonBuscar()) {
       
            JOptionPane.showMessageDialog(null, model.ClasseDadosGravacao.listaAcompanhante.toString());
        } else if (evento.getSource() == this.acompanhante.getjButtonSair()) {
            this.acompanhante.dispose();
        }

    }

}
