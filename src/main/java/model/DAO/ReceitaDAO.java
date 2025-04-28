package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Receita;

public class ReceitaDAO implements InterfaceDAO<Receita> {

    @Override
    public void create(Receita objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;

        try {
            String sqlInstrucao = "INSERT INTO receita (dataHoraReceita, observacao, status) VALUES (?, ?, ?)";
            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setString(1, objeto.getDataHoraReceita());
            pstm.setString(2, objeto.getObservacao());
            pstm.setString(3, objeto.getStatus());
            pstm.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, null);
        }
    }

    @Override
    public List<Receita> retrieve() {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        ResultSet resultado = null;
        List<Receita> listaReceitas = new ArrayList<>();

        String sqlInstrucao = "SELECT id, dataHoraReceita, observacao, status FROM receita";

        try {
            pstm = conexao.prepareStatement(sqlInstrucao);
            resultado = pstm.executeQuery();
            while (resultado.next()) {
                Receita receita = new Receita();
                receita.setId(resultado.getInt("id"));
                receita.setDataHoraReceita(resultado.getString("dataHoraReceita"));
                receita.setObservacao(resultado.getString("observacao"));
                receita.setStatus(resultado.getString("status"));
                listaReceitas.add(receita);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, resultado);
        }

        return listaReceitas;
    }

    @Override
    public Receita retrieve(int pk) {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        ResultSet resultado = null;
        Receita receita = null;

        String sqlInstrucao = "SELECT id, dataHoraReceita, observacao, status FROM receita WHERE id = ?";

        try {
            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setInt(1, pk);
            resultado = pstm.executeQuery();
            if (resultado.next()) {
                receita = new Receita();
                receita.setId(resultado.getInt("id"));
                receita.setDataHoraReceita(resultado.getString("dataHoraReceita"));
                receita.setObservacao(resultado.getString("observacao"));
                receita.setStatus(resultado.getString("status"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, resultado);
        }

        return receita;
    }

    @Override
    public List<Receita> retrieve(String parametro, String atributo) {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        ResultSet resultado = null;
        List<Receita> listaReceitas = new ArrayList<>();

        String sqlInstrucao = "SELECT id, dataHoraReceita, observacao, status FROM receita WHERE " + atributo + " LIKE ?";

        try {
            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setString(1, "%" + parametro + "%");
            resultado = pstm.executeQuery();
            while (resultado.next()) {
                Receita receita = new Receita();
                receita.setId(resultado.getInt("id"));
                receita.setDataHoraReceita(resultado.getString("dataHoraReceita"));
                receita.setObservacao(resultado.getString("observacao"));
                receita.setStatus(resultado.getString("status"));
                listaReceitas.add(receita);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, resultado);
        }

        return listaReceitas;
    }

    @Override
    public void update(Receita objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlInstrucao = "UPDATE receita SET dataHoraReceita = ?, observacao = ?, status = ? WHERE id = ?";
        PreparedStatement pstm = null;

        try {
            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setString(1, objeto.getDataHoraReceita());
            pstm.setString(2, objeto.getObservacao());
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
    public void delete(Receita objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlInstrucao = "DELETE FROM receita WHERE id = ?";
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
