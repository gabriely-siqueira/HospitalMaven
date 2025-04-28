package service;

import java.util.List;
import model.DAO.InternacaoDAO;
import model.Internacao;

public class ServiceInternacao {

    public static void adicionar(Internacao objeto) {
        InternacaoDAO internacaoDAO = new InternacaoDAO();
        internacaoDAO.create(objeto);
    }

    public static List<Internacao> ler() {
        InternacaoDAO internacaoDAO = new InternacaoDAO();
        return internacaoDAO.retrieve();
    }

    public static Internacao ler(int PK) {
        InternacaoDAO internacaoDAO = new InternacaoDAO();
        return internacaoDAO.retrieve(PK);
    }

    public static List<Internacao> ler(String parametro, String atributo) {
        InternacaoDAO internacaoDAO = new InternacaoDAO();
        return internacaoDAO.retrieve(parametro, atributo);
    }
    
    public static void atualizar(Internacao objeto){
        InternacaoDAO internacaoDAO = new InternacaoDAO();
        internacaoDAO.update(objeto);
    }

}
