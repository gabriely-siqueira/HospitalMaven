package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Farmaceutico;

/**
 * Classe DAO para manipular dados do Farmacêutico no banco de dados.
 * Implementa os métodos da interface InterfaceDAO.
 * 
 * @author gabriely
 */
public class FarmaceuticoDAO implements InterfaceDAO<Farmaceutico> {

    @Override
    public void create(Farmaceutico objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;

        try {
            String sqlInstrucao = "INSERT INTO farmaceutico (cpf, senha, login, nomeSocial) VALUES (?, ?, ?, ?)";
            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setString(1, objeto.getCpf());
            pstm.setString(2, objeto.getSenha());
            pstm.setString(3, objeto.getLogin());
            pstm.setString(4, objeto.getNomeSocial());
            pstm.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, null);
        }
    }

    @Override
    public List<Farmaceutico> retrieve() {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        ResultSet resultado = null;
        List<Farmaceutico> listaFarmaceuticos = new ArrayList<>();

        String sqlInstrucao = "SELECT id, cpf, senha, login, nomeSocial FROM farmaceutico";

        try {
            pstm = conexao.prepareStatement(sqlInstrucao);
            resultado = pstm.executeQuery();
            while (resultado.next()) {
                Farmaceutico farmaceutico = new Farmaceutico();
                farmaceutico.setId(resultado.getInt("id"));
                farmaceutico.setCpf(resultado.getString("cpf"));
                farmaceutico.setSenha(resultado.getString("senha"));
                farmaceutico.setLogin(resultado.getString("login"));
                farmaceutico.setNomeSocial(resultado.getString("nomeSocial"));
                listaFarmaceuticos.add(farmaceutico);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, resultado);
        }

        return listaFarmaceuticos;
    }

    @Override
    public Farmaceutico retrieve(int pk) {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        ResultSet resultado = null;
        Farmaceutico farmaceutico = null;

        String sqlInstrucao = "SELECT id, cpf, senha, login, nomeSocial FROM farmaceutico WHERE id = ?";

        try {
            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setInt(1, pk);
            resultado = pstm.executeQuery();
            if (resultado.next()) {
                farmaceutico = new Farmaceutico();
                farmaceutico.setId(resultado.getInt("id"));
                farmaceutico.setCpf(resultado.getString("cpf"));
                farmaceutico.setSenha(resultado.getString("senha"));
                farmaceutico.setLogin(resultado.getString("login"));
                farmaceutico.setNomeSocial(resultado.getString("nomeSocial"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, resultado);
        }

        return farmaceutico;
    }

    @Override
    public List<Farmaceutico> retrieve(String parametro, String atributo) {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        ResultSet resultado = null;
        List<Farmaceutico> listaFarmaceuticos = new ArrayList<>();

        String sqlInstrucao = "SELECT id, cpf, senha, login, nomeSocial FROM farmaceutico WHERE " + atributo + " LIKE ?";

        try {
            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setString(1, "%" + parametro + "%");
            resultado = pstm.executeQuery();
            while (resultado.next()) {
                Farmaceutico farmaceutico = new Farmaceutico();
                farmaceutico.setId(resultado.getInt("id"));
                farmaceutico.setCpf(resultado.getString("cpf"));
                farmaceutico.setSenha(resultado.getString("senha"));
                farmaceutico.setLogin(resultado.getString("login"));
                farmaceutico.setNomeSocial(resultado.getString("nomeSocial"));
                listaFarmaceuticos.add(farmaceutico);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, resultado);
        }

        return listaFarmaceuticos;
    }

    @Override
    public void update(Farmaceutico objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;

        String sqlInstrucao = "UPDATE farmaceutico SET cpf = ?, senha = ?, login = ?, nomeSocial = ? WHERE id = ?";

        try {
            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setString(1, objeto.getCpf());
            pstm.setString(2, objeto.getSenha());
            pstm.setString(3, objeto.getLogin());
            pstm.setString(4, objeto.getNomeSocial());
            pstm.setInt(5, objeto.getId());
            pstm.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, null);
        }
    }

    @Override
    public void delete(Farmaceutico objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;

        String sqlInstrucao = "DELETE FROM farmaceutico WHERE id = ?";

        try {
            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setInt(1, objeto.getId());
            pstm.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, null);
        }
    }
}
