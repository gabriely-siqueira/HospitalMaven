/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.List;
import model.Prontuario;
import model.DAO.ProntuarioDAO;

/**
 *
 * @author gabriely
 */
public class ServiceProntuario {
 public static void adicionar(Prontuario objeto) {
        ProntuarioDAO prontuarioDAO = new ProntuarioDAO();
        prontuarioDAO.create(objeto);
    }

    public static List<Prontuario> ler() {
        ProntuarioDAO prontuarioDAO = new ProntuarioDAO();
        return prontuarioDAO.retrieve();
    }

    public static Prontuario ler(int PK) {
        ProntuarioDAO prontuarioDAO = new ProntuarioDAO();
        return prontuarioDAO.retrieve(PK);
    }

    public static List<Prontuario> ler(String parametro, String atributo) {
        ProntuarioDAO prontuarioDAO = new ProntuarioDAO();
        return prontuarioDAO.retrieve(parametro, atributo);
    }

    public static void atualizar(Prontuario objeto) {
        ProntuarioDAO prontuarioDAO = new ProntuarioDAO();
        prontuarioDAO.update(objeto);
    }

    public static void deletar(Prontuario objeto) {
        ProntuarioDAO prontuarioDAO = new ProntuarioDAO();
        prontuarioDAO.delete(objeto);
    }
}


