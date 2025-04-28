/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.List;
import model.DAO.FarmaceuticoDAO;
import model.Farmaceutico;

/**
 *
 * @author gabriely
 */
public class ServiceFarmaceutico {
    
    public static void adicionar(Farmaceutico objeto) {
        FarmaceuticoDAO farmaceuticoDAO = new FarmaceuticoDAO();
        farmaceuticoDAO.create(objeto);
    }

    public static List<Farmaceutico> ler() {
        FarmaceuticoDAO farmaceuticoDAO = new FarmaceuticoDAO();
        return farmaceuticoDAO.retrieve();
    }

    public static Farmaceutico ler(int PK) {
        FarmaceuticoDAO farmaceuticoDAO = new FarmaceuticoDAO();
        return farmaceuticoDAO.retrieve(PK);
    }

    public static List<Farmaceutico> ler(String parametro, String atributo) {
        FarmaceuticoDAO farmaceuticoDAO = new FarmaceuticoDAO();
        return farmaceuticoDAO.retrieve(parametro, atributo);
    }
    
    public static void atualizar(Farmaceutico objeto){
        FarmaceuticoDAO farmaceuticoDAO = new FarmaceuticoDAO();
        farmaceuticoDAO.update(objeto);
    }

}
