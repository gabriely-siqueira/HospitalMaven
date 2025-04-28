/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.List;
import model.DAO.EnfermeiroDAO;
import model.Enfermeiro;

/**
 *
 * @author gabriely
 */
public class ServiceEnfermeiro {
    public static void adicionar(Enfermeiro objeto) {
        EnfermeiroDAO enfermeiroDAO = new EnfermeiroDAO();
        enfermeiroDAO.create(objeto);
    }

    public static List<Enfermeiro> ler() {
        EnfermeiroDAO enfermeiroDAO = new EnfermeiroDAO();
        return enfermeiroDAO.retrieve();
    }

    public static Enfermeiro ler(int PK) {
        EnfermeiroDAO enfermeiroDAO = new EnfermeiroDAO();
        return enfermeiroDAO.retrieve(PK);
    }

    public static List<Enfermeiro> ler(String parametro, String atributo) {
        EnfermeiroDAO enfermeiroDAO = new EnfermeiroDAO();
        return enfermeiroDAO.retrieve(parametro, atributo);
    }
    
    public static void atualizar(Enfermeiro objeto){
        EnfermeiroDAO enfermeiroDAO = new EnfermeiroDAO();
        enfermeiroDAO.update(objeto);
    }

}
