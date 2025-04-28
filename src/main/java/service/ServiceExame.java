/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.List;
import model.DAO.ExameDAO;
import model.Exame;

/**
 *
 * @author gabriely
 */
public class ServiceExame {
 public static void adicionar(Exame objeto) {
        ExameDAO exameDAO = new ExameDAO();
        exameDAO.create(objeto);
    }

    public static List<Exame> ler() {
        ExameDAO exameDAO = new ExameDAO();
        return exameDAO.retrieve();
    }

    public static Exame ler(int PK) {
        ExameDAO exameDAO = new ExameDAO();
        return exameDAO.retrieve(PK);
    }

    public static List<Exame> ler(String parametro, String atributo) {
        ExameDAO exameDAO = new ExameDAO();
        return exameDAO.retrieve(parametro, atributo);
    }
    
    public static void atualizar(Exame objeto){
        ExameDAO exameDAO = new ExameDAO();
        exameDAO.update(objeto);
    }

}
