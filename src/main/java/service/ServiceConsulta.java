/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.List;
import model.Consulta;
import model.DAO.ConsultaDAO;

/**
 *
 * @author gabriely
 */
public class ServiceConsulta {
 public static void adicionar(Consulta objeto) {
        ConsultaDAO atendimentoDAO = new ConsultaDAO();
        atendimentoDAO.create(objeto);
    }

    public static List<Consulta> ler() {
        ConsultaDAO consultaDAO = new ConsultaDAO();
        return consultaDAO.retrieve();
    }

    public static Consulta ler(int PK) {
        ConsultaDAO consultaDAO = new ConsultaDAO();
        return consultaDAO.retrieve(PK);
    }

    public static List<Consulta> ler(String parametro, String atributo) {
        ConsultaDAO consultaDAO = new ConsultaDAO();
        return consultaDAO.retrieve(parametro, atributo);
    }

    public static void atualizar(Consulta objeto) {
        ConsultaDAO consultaDAO = new ConsultaDAO();
        consultaDAO.update(objeto);
    }

    public static void deletar(Consulta objeto) {
        ConsultaDAO consultaDAO = new ConsultaDAO();
        consultaDAO.delete(objeto);
    }
}