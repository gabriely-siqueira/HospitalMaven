/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.Jornada;
import view.JornadaForm;


/**
 *
 * @author bielj
 */
public class JornadaController implements ActionListener {
    
    JornadaForm jornada;
    
    public JornadaController( JornadaForm medico){
        this.jornada = medico;
        this.jornada.getjButtonNovo().addActionListener(this);
        this.jornada.getjButtonCancelar().addActionListener(this);
        this.jornada.getjButtonGravar().addActionListener(this);
        this.jornada.getjButtonBuscar().addActionListener(this);
        this.jornada.getjButtonSair().addActionListener(this);


        utilities.Utilities.ativaDesativa(false, this.jornada.getjPanelBotoes());
        utilities.Utilities.limpaComponentes(false, this.jornada.getjPanelDados3());
       
    }
   
    
     @Override
    public void actionPerformed(ActionEvent evento) {

        if (evento.getSource() == this.jornada.getjButtonNovo()) {
            utilities.Utilities.ativaDesativa(true, this.jornada.getjPanelBotoes());
            utilities.Utilities.limpaComponentes(true,this.jornada.getjPanelDados3());
            
            this.jornada.getIdField().setEnabled(false);

        } else if (evento.getSource() == this.jornada.getjButtonCancelar()) {
            utilities.Utilities.ativaDesativa(false, this.jornada.getjPanelBotoes());
            utilities.Utilities.limpaComponentes(false, this.jornada.getjPanelDados3() );

        } else if (evento.getSource() == this.jornada.getjButtonGravar()) {

        Jornada novoJornada = new Jornada();
            
        novoJornada.setId(model.ClasseDadosGravacao.listaJornada.size() + 1); 
        novoJornada.setDataInicial(this.jornada.getDataInicial().getText());
        novoJornada.setDataFinal(this.jornada.getDataFinal().getText());
        novoJornada.setCargaHoraria(this.jornada.getCargaHoraria().getText());


            model.ClasseDadosGravacao.listaJornada.add(novoJornada);
            JOptionPane.showMessageDialog(null, "Gravado com sucesso!");
            
            utilities.Utilities.ativaDesativa(false, this.jornada.getjPanelBotoes());
            utilities.Utilities.limpaComponentes(false, this.jornada.getjPanelDados3() );

        } else if (evento.getSource() == this.jornada.getjButtonBuscar()) {
       
            JOptionPane.showMessageDialog(null, model.ClasseDadosGravacao.listaJornada.toString());
        } else if (evento.getSource() == this.jornada.getjButtonSair()) {
            this.jornada.dispose();
        }

    }

}