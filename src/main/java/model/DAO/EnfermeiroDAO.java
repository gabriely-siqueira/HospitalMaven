package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Enfermeiro;

/**
 *
 * @author gabriely
 */
public class EnfermeiroDAO implements InterfaceDAO<Enfermeiro> {

    @Override
    public void create(Enfermeiro objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;

        try {
            String sqlInstrucao = "INSERT INTO enfermeiro ("
                    + "nomeSocial, "
                    + "cre, "
                    + "login, "
                    + "senha) "
                    + "VALUES (?, ?, ?, ?)";

            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setString(1, objeto.getNomeSocial());
            pstm.setString(2, objeto.getCre());
            pstm.setString(3, objeto.getLogin());
            pstm.setString(4, objeto.getSenha());
            pstm.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, null);
        }
    }

    @Override
    public List<Enfermeiro> retrieve() {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        ResultSet resultado = null;
        List<Enfermeiro> listaEnfermeiro = new ArrayList<>();

        String sqlInstrucao = "SELECT id, nomeSocial, cre, login, senha FROM enfermeiro";

        try {
            pstm = conexao.prepareStatement(sqlInstrucao);
            resultado = pstm.executeQuery();
            while (resultado.next()) {
                Enfermeiro enfermeiro = new Enfermeiro();
                enfermeiro.setId(resultado.getInt("id"));
                enfermeiro.setNomeSocial(resultado.getString("nomeSocial"));
                enfermeiro.setCre(resultado.getString("cre"));
                enfermeiro.setLogin(resultado.getString("login"));
                enfermeiro.setSenha(resultado.getString("senha"));
                listaEnfermeiro.add(enfermeiro);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, resultado);
            return listaEnfermeiro;
        }
    }

    @Override
    public Enfermeiro retrieve(int pk) {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        ResultSet resultado = null;
        Enfermeiro enfermeiro = new Enfermeiro();

        String sqlInstrucao = "SELECT id, nomeSocial, cre, login, senha FROM enfermeiro WHERE id = ?";

        try {
            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setInt(1, pk);
            resultado = pstm.executeQuery();
            if (resultado.next()) {
                enfermeiro.setId(resultado.getInt("id"));
                enfermeiro.setNomeSocial(resultado.getString("nomeSocial"));
                enfermeiro.setCre(resultado.getString("cre"));
                enfermeiro.setLogin(resultado.getString("login"));
                enfermeiro.setSenha(resultado.getString("senha"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, resultado);
            return enfermeiro;
        }
    }

    @Override
    public List<Enfermeiro> retrieve(String parametro, String atributo) {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        ResultSet resultado = null;
        List<Enfermeiro> listaEnfermeiro = new ArrayList<>();

        String sqlInstrucao = "SELECT id, nomeSocial, cre, login, senha FROM enfermeiro WHERE " + atributo + " LIKE ?";

        try {
            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setString(1, "%" + parametro + "%");
            resultado = pstm.executeQuery();
            while (resultado.next()) {
                Enfermeiro enfermeiro = new Enfermeiro();
                enfermeiro.setId(resultado.getInt("id"));
                enfermeiro.setNomeSocial(resultado.getString("nomeSocial"));
                enfermeiro.setCre(resultado.getString("cre"));
                enfermeiro.setLogin(resultado.getString("login"));
                enfermeiro.setSenha(resultado.getString("senha"));
                listaEnfermeiro.add(enfermeiro);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, resultado);
            return listaEnfermeiro;
        }
    }

    @Override
    public void update(Enfermeiro objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlInstrucao = "UPDATE enfermeiro "
                + "SET nomeSocial = ?, "
                + "cre = ?, "
                + "login = ?, "
                + "senha = ? "
                + "WHERE id = ?";
        PreparedStatement pstm = null;
        try {
            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setString(1, objeto.getNomeSocial());
            pstm.setString(2, objeto.getCre());
            pstm.setString(3, objeto.getLogin());
            pstm.setString(4, objeto.getSenha());
            pstm.setInt(5, objeto.getId());
            pstm.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, null);
        }
    }

    @Override
    public void delete(Enfermeiro objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlInstrucao = "DELETE FROM enfermeiro WHERE id = ?";
        PreparedStatement pstm = null;
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
