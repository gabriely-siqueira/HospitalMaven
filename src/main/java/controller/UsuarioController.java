/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.Usuario;
import view.UsuarioForm;

/**
 *
 * @author gabriely
 */
public class UsuarioController implements ActionListener {
    
    UsuarioForm usuario;
    
    public UsuarioController( UsuarioForm usuario){
        this.usuario = usuario;
        this.usuario.getjButtonNovo().addActionListener(this);
        this.usuario.getjButtonCancelar().addActionListener(this);
        this.usuario.getjButtonGravar().addActionListener(this);
        this.usuario.getjButtonBuscar().addActionListener(this);
        this.usuario.getjButtonSair().addActionListener(this);

        utilities.Utilities.ativaDesativa(false, this.usuario.getjPanelBotoes());
        utilities.Utilities.limpaComponentes(false, this.usuario.getjPanelDados3());

       
    }
    
 
     @Override
    public void actionPerformed(ActionEvent evento) {

        if (evento.getSource() == this.usuario.getjButtonNovo()) {
            utilities.Utilities.ativaDesativa(true, this.usuario.getjPanelBotoes());
            utilities.Utilities.limpaComponentes(true,this.usuario.getjPanelDados3());
            
            this.usuario.getIdField().setEnabled(false);

        } else if (evento.getSource() == this.usuario.getjButtonCancelar()) {
            utilities.Utilities.ativaDesativa(false, this.usuario.getjPanelBotoes());
            utilities.Utilities.limpaComponentes(false, this.usuario.getjPanelDados3() );

        } else if (evento.getSource() == this.usuario.getjButtonGravar()) {

            Usuario novoUsuario = new Usuario();
            
        novoUsuario.setId(model.ClasseDadosGravacao.listaUsuario.size() + 1); 
        novoUsuario.setLogin(this.usuario.getLogin().getText());
        novoUsuario.setNome(this.usuario.getNome().getText());
        novoUsuario.setSenha(this.usuario.getSenha().getText());


            model.ClasseDadosGravacao.listaUsuario.add(novoUsuario);
            JOptionPane.showMessageDialog(null, "Gravado com sucesso!");
            utilities.Utilities.ativaDesativa(false, this.usuario.getjPanelBotoes());
            utilities.Utilities.limpaComponentes(false, this.usuario.getjPanelDados3() );

        } else if (evento.getSource() == this.usuario.getjButtonBuscar()) {
       
            JOptionPane.showMessageDialog(null, model.ClasseDadosGravacao.listaUsuario.toString());
        } else if (evento.getSource() == this.usuario.getjButtonSair()) {
            this.usuario.dispose();
        }

    }

}
   
