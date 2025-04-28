package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Internacao;

public class InternacaoDAO implements InterfaceDAO<Internacao> {

    @Override
    public void create(Internacao objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;

        try {
            String sqlInstrucao = "INSERT INTO internacao (dataInternacao, horaInternacao, dataAlta, horaAlta, observacao, status) "
                    + "VALUES (?, ?, ?, ?, ?, ?)";

            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setString(1, objeto.getDataInternacao());
            pstm.setString(2, objeto.getHoraInternacao());
            pstm.setString(3, objeto.getDataAlta());
            pstm.setString(4, objeto.getHoraAlta());
            pstm.setString(5, objeto.getObservacao());
            pstm.setString(6, objeto.getStatus());

            pstm.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, null);
        }
    }

    @Override
    public List<Internacao> retrieve() {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        ResultSet resultado = null;
        List<Internacao> listaInternacao = new ArrayList<>();

        String sqlInstrucao = "SELECT id, dataInternacao, horaInternacao, dataAlta, horaAlta, observacao, status FROM internacao";

        try {
            pstm = conexao.prepareStatement(sqlInstrucao);
            resultado = pstm.executeQuery();
            while (resultado.next()) {
                Internacao internacao = new Internacao();
                internacao.setId(resultado.getInt("id"));
                internacao.setDataInternacao(resultado.getString("dataInternacao"));
                internacao.setHoraInternacao(resultado.getString("horaInternacao"));
                internacao.setDataAlta(resultado.getString("dataAlta"));
                internacao.setHoraAlta(resultado.getString("horaAlta"));
                internacao.setObservacao(resultado.getString("observacao"));
                internacao.setStatus(resultado.getString("status"));
                listaInternacao.add(internacao);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, resultado);
        }
        return listaInternacao;
    }

    @Override
    public Internacao retrieve(int pk) {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        ResultSet resultado = null;
        Internacao internacao = null;

        String sqlInstrucao = "SELECT id, dataInternacao, horaInternacao, dataAlta, horaAlta, observacao, status FROM internacao WHERE id = ?";

        try {
            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setInt(1, pk);
            resultado = pstm.executeQuery();
            if (resultado.next()) {
                internacao = new Internacao();
                internacao.setId(resultado.getInt("id"));
                internacao.setDataInternacao(resultado.getString("dataInternacao"));
                internacao.setHoraInternacao(resultado.getString("horaInternacao"));
                internacao.setDataAlta(resultado.getString("dataAlta"));
                internacao.setHoraAlta(resultado.getString("horaAlta"));
                internacao.setObservacao(resultado.getString("observacao"));
                internacao.setStatus(resultado.getString("status"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, resultado);
        }
        return internacao;
    }

    @Override
    public List<Internacao> retrieve(String parametro, String atributo) {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        ResultSet resultado = null;
        List<Internacao> listaInternacao = new ArrayList<>();

        String sqlInstrucao = "SELECT id, dataInternacao, horaInternacao, dataAlta, horaAlta, observacao, status "
                + "FROM internacao WHERE " + atributo + " LIKE ?";

        try {
            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setString(1, "%" + parametro + "%");
            resultado = pstm.executeQuery();
            while (resultado.next()) {
                Internacao internacao = new Internacao();
                internacao.setId(resultado.getInt("id"));
                internacao.setDataInternacao(resultado.getString("dataInternacao"));
                internacao.setHoraInternacao(resultado.getString("horaInternacao"));
                internacao.setDataAlta(resultado.getString("dataAlta"));
                internacao.setHoraAlta(resultado.getString("horaAlta"));
                internacao.setObservacao(resultado.getString("observacao"));
                internacao.setStatus(resultado.getString("status"));
                listaInternacao.add(internacao);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, resultado);
        }
        return listaInternacao;
    }

    @Override
    public void update(Internacao objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlInstrucao = "UPDATE internacao SET dataInternacao = ?, horaInternacao = ?, dataAlta = ?, horaAlta = ?, observacao = ?, status = ? WHERE id = ?";
        PreparedStatement pstm = null;

        try {
            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setString(1, objeto.getDataInternacao());
            pstm.setString(2, objeto.getHoraInternacao());
            pstm.setString(3, objeto.getDataAlta());
            pstm.setString(4, objeto.getHoraAlta());
            pstm.setString(5, objeto.getObservacao());
            pstm.setString(6, objeto.getStatus());
            pstm.setInt(7, objeto.getId());

            pstm.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, null);
        }
    }

    @Override
    public void delete(Internacao objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;

        try {
            String sqlInstrucao = "DELETE FROM internacao WHERE id = ?";
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
