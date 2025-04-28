/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.List;
import model.DAO.UsuarioDAO;
import model.Usuario;

/**
 *
 * @author gabriely
 */
public class ServiceUsuario {
  public static void adicionar(Usuario objeto) {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        usuarioDAO.create(objeto);
    }

    public static List<Usuario> ler() {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        return usuarioDAO.retrieve();
    }

    public static Usuario ler(int PK) {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        return usuarioDAO.retrieve(PK);
    }

    public static List<Usuario> ler(String parametro, String atributo) {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        return usuarioDAO.retrieve(parametro, atributo);
    }
    
    public static void atualizar(Usuario objeto){
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        usuarioDAO.update(objeto);
    }

}