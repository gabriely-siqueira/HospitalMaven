/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.List;
import model.DAO.ReceitaDAO;
import model.Receita;

/**
 *
 * @author gabriely
 */
public class ServiceReceita {
  public static void adicionar(Receita objeto) {
        ReceitaDAO receitaDAO = new ReceitaDAO();
        receitaDAO.create(objeto);
    }

    public static List<Receita> ler() {
        ReceitaDAO receitaDAO = new ReceitaDAO();
        return receitaDAO.retrieve();
    }

    public static Receita ler(int PK) {
        ReceitaDAO receitaDAO = new ReceitaDAO();
        return receitaDAO.retrieve(PK);
    }

    public static List<Receita> ler(String parametro, String atributo) {
        ReceitaDAO receitaDAO = new ReceitaDAO();
        return receitaDAO.retrieve(parametro, atributo);
    }
    
    public static void atualizar(Receita objeto){
        ReceitaDAO receitaDAO = new ReceitaDAO();
        receitaDAO.update(objeto);
    }

}