/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.List;
import model.Acompanhante;
import model.DAO.AcompanhanteDAO;

/**
 *
 * @author gabriely
 */
public class ServiceAcompanhante {
    

    public static void adicionar(Acompanhante objeto) {
        AcompanhanteDAO acompanhanteDAO = new AcompanhanteDAO();
        acompanhanteDAO.create(objeto);
    }

    public static List<Acompanhante> ler() {
        AcompanhanteDAO acompanhanteDAO = new AcompanhanteDAO();
        return acompanhanteDAO.retrieve();
    }

    public static Acompanhante ler(int PK) {
        AcompanhanteDAO acompanhanteDAO = new AcompanhanteDAO();
        return acompanhanteDAO.retrieve(PK);
    }

    public static List<Acompanhante> ler(String parametro, String atributo) {
        AcompanhanteDAO acompanhanteDAO = new AcompanhanteDAO();
        return acompanhanteDAO.retrieve(parametro, atributo);
    }

    public static void atualizar(Acompanhante objeto) {
        AcompanhanteDAO acompanhanteDAO = new AcompanhanteDAO();
        acompanhanteDAO.update(objeto);
    }

    public static void deletar(Acompanhante objeto) {
        AcompanhanteDAO acompanhanteDAO = new AcompanhanteDAO();
        acompanhanteDAO.delete(objeto);
    }
}

