package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Exame;

public class ExameDAO implements InterfaceDAO<Exame> {

    @Override
    public void create(Exame objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;

        try {
            String sqlInstrucao = "INSERT INTO exame (tituloExame, tipoExame, status) VALUES (?, ?, ?)";
            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setString(1, objeto.getTituloExame());
            pstm.setString(2, objeto.getTipoExame());
            pstm.setString(3, objeto.getStatus());
            pstm.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, null);
        }
    }

    @Override
    public List<Exame> retrieve() {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        ResultSet resultado = null;
        List<Exame> listaExame = new ArrayList<>();

        String sqlInstrucao = "SELECT id, tituloExame, tipoExame, status FROM exame";

        try {
            pstm = conexao.prepareStatement(sqlInstrucao);
            resultado = pstm.executeQuery();
            while (resultado.next()) {
                Exame exame = new Exame();
                exame.setId(resultado.getInt("id"));
                exame.setTituloExame(resultado.getString("tituloExame"));
                exame.setTipoExame(resultado.getString("tipoExame"));
                exame.setStatus(resultado.getString("status"));
                listaExame.add(exame);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, resultado);
        }
        return listaExame;
    }

    @Override
    public Exame retrieve(int pk) {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        ResultSet resultado = null;
        Exame exame = null;

        String sqlInstrucao = "SELECT id, tituloExame, tipoExame, status FROM exame WHERE id = ?";

        try {
            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setInt(1, pk);
            resultado = pstm.executeQuery();
            if (resultado.next()) {
                exame = new Exame();
                exame.setId(resultado.getInt("id"));
                exame.setTituloExame(resultado.getString("tituloExame"));
                exame.setTipoExame(resultado.getString("tipoExame"));
                exame.setStatus(resultado.getString("status"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, resultado);
        }
        return exame;
    }

    @Override
    public List<Exame> retrieve(String parametro, String atributo) {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        ResultSet resultado = null;
        List<Exame> listaExame = new ArrayList<>();

        String sqlInstrucao = "SELECT id, tituloExame, tipoExame, status FROM exame WHERE " + atributo + " LIKE ?";

        try {
            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setString(1, "%" + parametro + "%");
            resultado = pstm.executeQuery();
            while (resultado.next()) {
                Exame exame = new Exame();
                exame.setId(resultado.getInt("id"));
                exame.setTituloExame(resultado.getString("tituloExame"));
                exame.setTipoExame(resultado.getString("tipoExame"));
                exame.setStatus(resultado.getString("status"));
                listaExame.add(exame);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, resultado);
        }
        return listaExame;
    }

    @Override
    public void update(Exame objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlInstrucao = "UPDATE exame SET tituloExame = ?, tipoExame = ?, status = ? WHERE id = ?";
        PreparedStatement pstm = null;

        try {
            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setString(1, objeto.getTituloExame());
            pstm.setString(2, objeto.getTipoExame());
            pstm.setString(3, objeto.getStatus());
            pstm.setInt(4, objeto.getId());
            pstm.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, null);
        }
    }

    @Override
    public void delete(Exame objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlInstrucao = "DELETE FROM exame WHERE id = ?";
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
