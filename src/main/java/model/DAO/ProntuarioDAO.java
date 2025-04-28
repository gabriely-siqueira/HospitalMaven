package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Prontuario;

public class ProntuarioDAO implements InterfaceDAO<Prontuario> {

    @Override
    public void create(Prontuario objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;

        try {
            String sqlInstrucao = "INSERT INTO prontuario (dataHoraVisita, descricaoVisita, observacao, status) VALUES (?, ?, ?, ?)";
            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setString(1, objeto.getDataHoraVisita());
            pstm.setString(2, objeto.getDescricaoVisita());
            pstm.setString(3, objeto.getObservacao());
            pstm.setString(4, objeto.getStatus());
            pstm.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, null);
        }
    }

    @Override
    public List<Prontuario> retrieve() {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        ResultSet resultado = null;
        List<Prontuario> listaProntuario = new ArrayList<>();

        String sqlInstrucao = "SELECT id, dataHoraVisita, descricaoVisita, observacao, status FROM prontuario";

        try {
            pstm = conexao.prepareStatement(sqlInstrucao);
            resultado = pstm.executeQuery();
            while (resultado.next()) {
                Prontuario prontuario = new Prontuario();
                prontuario.setId(resultado.getInt("id"));
                prontuario.setDataHoraVisita(resultado.getString("dataHoraVisita"));
                prontuario.setDescricaoVisita(resultado.getString("descricaoVisita"));
                prontuario.setObservacao(resultado.getString("observacao"));
                prontuario.setStatus(resultado.getString("status"));
                listaProntuario.add(prontuario);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, resultado);
        }
        return listaProntuario;
    }

    @Override
    public Prontuario retrieve(int pk) {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        ResultSet resultado = null;
        Prontuario prontuario = null;

        String sqlInstrucao = "SELECT id, dataHoraVisita, descricaoVisita, observacao, status FROM prontuario WHERE id = ?";

        try {
            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setInt(1, pk);
            resultado = pstm.executeQuery();
            if (resultado.next()) {
                prontuario = new Prontuario();
                prontuario.setId(resultado.getInt("id"));
                prontuario.setDataHoraVisita(resultado.getString("dataHoraVisita"));
                prontuario.setDescricaoVisita(resultado.getString("descricaoVisita"));
                prontuario.setObservacao(resultado.getString("observacao"));
                prontuario.setStatus(resultado.getString("status"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, resultado);
        }
        return prontuario;
    }

    @Override
    public List<Prontuario> retrieve(String parametro, String atributo) {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        ResultSet resultado = null;
        List<Prontuario> listaProntuario = new ArrayList<>();

        String sqlInstrucao = "SELECT id, dataHoraVisita, descricaoVisita, observacao, status FROM prontuario WHERE " + atributo + " LIKE ?";

        try {
            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setString(1, "%" + parametro + "%");
            resultado = pstm.executeQuery();
            while (resultado.next()) {
                Prontuario prontuario = new Prontuario();
                prontuario.setId(resultado.getInt("id"));
                prontuario.setDataHoraVisita(resultado.getString("dataHoraVisita"));
                prontuario.setDescricaoVisita(resultado.getString("descricaoVisita"));
                prontuario.setObservacao(resultado.getString("observacao"));
                prontuario.setStatus(resultado.getString("status"));
                listaProntuario.add(prontuario);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, resultado);
        }
        return listaProntuario;
    }

    @Override
    public void update(Prontuario objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlInstrucao = "UPDATE prontuario SET dataHoraVisita = ?, descricaoVisita = ?, observacao = ?, status = ? WHERE id = ?";
        PreparedStatement pstm = null;

        try {
            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setString(1, objeto.getDataHoraVisita());
            pstm.setString(2, objeto.getDescricaoVisita());
            pstm.setString(3, objeto.getObservacao());
            pstm.setString(4, objeto.getStatus());
            pstm.setInt(5, objeto.getId());
            pstm.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, null);
        }
    }

    @Override
    public void delete(Prontuario objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlInstrucao = "DELETE FROM prontuario WHERE id = ?";
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
