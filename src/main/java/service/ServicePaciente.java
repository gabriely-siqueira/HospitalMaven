package service;

import java.util.List;
import model.DAO.PacienteDAO;
import model.Paciente;



public class ServicePaciente{
    public static void adicionar(Paciente objeto) {
        PacienteDAO.getInstance().create(objeto);
    }

    public static List<Paciente> ler() {
        return PacienteDAO.getInstance().retrieve();
    }

    public static Paciente ler(int PK) {
        return PacienteDAO.getInstance().retrieve(PK);
    }

    public static void atualizar(Paciente objeto) {
        PacienteDAO.getInstance().update(objeto);
    }

    // Método de exclusão
    public static void excluir(int id) {
        PacienteDAO.getInstance().delete(id);
    };


}
