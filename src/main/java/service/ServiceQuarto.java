package service;

import java.util.List;
import model.DAO.QuartoDAO;
import model.Quarto;


public class ServiceQuarto {

    public static void adicionar(Quarto objeto) {
       QuartoDAO.getInstance().create(objeto);
    }

    public static List<Quarto> ler() {
        return QuartoDAO.getInstance().retrieve();
    }

    public static Quarto ler(int PK) {
        return QuartoDAO.getInstance().retrieve(PK);
    }

    public static List<Quarto> ler(String parametro, String atributo) {
        return QuartoDAO.getInstance().retrieve(parametro, atributo);
    }

    public static void atualizar(Quarto objeto) {
        QuartoDAO.getInstance().update(objeto);
    }

    // Método de exclusão
    public static void excluir(int id) {
        QuartoDAO.getInstance().delete(id);
    }
}
