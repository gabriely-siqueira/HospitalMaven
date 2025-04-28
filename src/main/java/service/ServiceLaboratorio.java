package service;

import java.util.List;
import model.DAO.LaboratorioDAO;
import model.Laboratorio;

public class ServiceLaboratorio {

    public static void adicionar(Laboratorio objeto) {
        LaboratorioDAO.getInstance().create(objeto);
    }

    public static List<Laboratorio> ler() {
        return LaboratorioDAO.getInstance().retrieve();
    }

    public static Laboratorio ler(int PK) {
        return LaboratorioDAO.getInstance().retrieve(PK);
    }

    public static List<Laboratorio> ler(String parametro, String atributo) {
        return LaboratorioDAO.getInstance().retrieve(parametro, atributo);
    }

    public static void atualizar(Laboratorio objeto) {
        LaboratorioDAO.getInstance().update(objeto);
    }

    // Método de exclusão
    public static void excluir(int id) {
        LaboratorioDAO.getInstance().delete(id);
    }
}
