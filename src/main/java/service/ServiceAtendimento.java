/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.List;
import model.Atendimento;
import model.DAO.AtendimentoDAO;

/**
 *
 * @author gabriely
 */
public class ServiceAtendimento {

    public static void adicionar(Atendimento objeto) {
        AtendimentoDAO atendimentoDAO = new AtendimentoDAO();
        atendimentoDAO.create(objeto);
    }

    public static List<Atendimento> ler() {
        AtendimentoDAO atendimentoDAO = new AtendimentoDAO();
        return atendimentoDAO.retrieve();
    }

    public static Atendimento ler(int PK) {
        AtendimentoDAO atendimentoDAO = new AtendimentoDAO();
        return atendimentoDAO.retrieve(PK);
    }

    public static List<Atendimento> ler(String parametro, String atributo) {
        AtendimentoDAO atendimentoDAO = new AtendimentoDAO();
        return atendimentoDAO.retrieve(parametro, atributo);
    }

    public static void atualizar(Atendimento objeto) {
        AtendimentoDAO atendimentoDAO = new AtendimentoDAO();
        atendimentoDAO.update(objeto);
    }

    public static void deletar(Atendimento objeto) {
        AtendimentoDAO atendimentoDAO = new AtendimentoDAO();
        atendimentoDAO.delete(objeto);
    }
}

