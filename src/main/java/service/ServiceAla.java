package service;

import java.util.List;
import model.Ala;
import model.DAO.AlaDAO;


public class ServiceAla {

    public static void adicionar(Ala objeto) {
        AlaDAO.getInstance().create(objeto);
    }

    public static List<Ala> ler() {
        return AlaDAO.getInstance().retrieve();
    }

    public static Ala ler(int PK) {
        return AlaDAO.getInstance().retrieve(PK);
    }

    public static List<Ala> ler(String parametro, String atributo) {
        return AlaDAO.getInstance().retrieve(parametro, atributo);
    }

    public static void atualizar(Ala objeto) {
        AlaDAO.getInstance().update(objeto);
    }

    // Método de exclusão
    public static void excluir(int id) {
        AlaDAO.getInstance().delete(id);
    }
       public static List<Ala> listarAlas() {
        AlaDAO alaDAO = new AlaDAO();
        return alaDAO.retrieve();
    }
}

