package service;

import java.util.List;
import model.DAO.MedicamentoDAO;
import model.Medicamento;

public class ServiceMedicamento {

       public static void adicionar(Medicamento objeto) {
        MedicamentoDAO.getInstance().create(objeto);
    }

    public static List<Medicamento> ler() {
        return MedicamentoDAO.getInstance().retrieve();
    }

    public static Medicamento ler(int PK) {
        return MedicamentoDAO.getInstance().retrieve(PK);
    }

    public static List<Medicamento> ler(String parametro, String atributo) {
        return MedicamentoDAO.getInstance().retrieve(parametro, atributo);
    }

    public static void atualizar(Medicamento objeto) {
        MedicamentoDAO.getInstance().update(objeto);
    }

    // Método de exclusão
    public static void excluir(int id) {
        MedicamentoDAO.getInstance().delete(id);
    }

}
