package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Consulta;

public class ConsultaDAO implements InterfaceDAO<Consulta> {

    @Override
    public void create(Consulta objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;

        try {
            String sqlInstrucao = "INSERT INTO consulta (responsavel, dataHoraConsulta, anamnese, diagnostico, prescricao, observacoes, status) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?)";

            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setString(1, objeto.getResponsavel());
            pstm.setString(2, objeto.getDataHoraConsulta());
            pstm.setString(3, objeto.getAnamnese());
            pstm.setString(4, objeto.getDiagnostico());
            pstm.setString(5, objeto.getPrescricao());
            pstm.setString(6, objeto.getObservacoes());
            pstm.setString(7, objeto.getStatus());
            pstm.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, null);
        }
    }

    @Override
    public List<Consulta> retrieve() {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        ResultSet resultado = null;
        List<Consulta> listaConsulta = new ArrayList<>();

        String sqlInstrucao = "SELECT id, responsavel, dataHoraConsulta, anamnese, diagnostico, prescricao, observacoes, status FROM consulta";

        try {
            pstm = conexao.prepareStatement(sqlInstrucao);
            resultado = pstm.executeQuery();
            while (resultado.next()) {
                Consulta consulta = new Consulta(
                    resultado.getInt("id"),
                    resultado.getString("responsavel"),
                    resultado.getString("dataHoraConsulta"),
                    resultado.getString("anamnese"),
                    resultado.getString("diagnostico"),
                    resultado.getString("prescricao"),
                    resultado.getString("observacoes"),
                    resultado.getString("status")
                );
                listaConsulta.add(consulta);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, resultado);
        }
        return listaConsulta;
    }

    @Override
    public Consulta retrieve(int pk) {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        ResultSet resultado = null;
        Consulta consulta = null;

        String sqlInstrucao = "SELECT id, responsavel, dataHoraConsulta, anamnese, diagnostico, prescricao, observacoes, status FROM consulta WHERE id = ?";

        try {
            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setInt(1, pk);
            resultado = pstm.executeQuery();
            if (resultado.next()) {
                consulta = new Consulta(
                    resultado.getInt("id"),
                    resultado.getString("responsavel"),
                    resultado.getString("dataHoraConsulta"),
                    resultado.getString("anamnese"),
                    resultado.getString("diagnostico"),
                    resultado.getString("prescricao"),
                    resultado.getString("observacoes"),
                    resultado.getString("status")
                );
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, resultado);
        }
        return consulta;
    }

    @Override
    public List<Consulta> retrieve(String parametro, String atributo) {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        ResultSet resultado = null;
        List<Consulta> listaConsulta = new ArrayList<>();

        String sqlInstrucao = "SELECT id, responsavel, dataHoraConsulta, anamnese, diagnostico, prescricao, observacoes, status FROM consulta WHERE " 
                            + atributo + " LIKE ?";

        try {
            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setString(1, "%" + parametro + "%");
            resultado = pstm.executeQuery();
            while (resultado.next()) {
                Consulta consulta = new Consulta(
                    resultado.getInt("id"),
                    resultado.getString("responsavel"),
                    resultado.getString("dataHoraConsulta"),
                    resultado.getString("anamnese"),
                    resultado.getString("diagnostico"),
                    resultado.getString("prescricao"),
                    resultado.getString("observacoes"),
                    resultado.getString("status")
                );
                listaConsulta.add(consulta);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, resultado);
        }
        return listaConsulta;
    }

    @Override
    public void update(Consulta objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlInstrucao = "UPDATE consulta SET responsavel = ?, dataHoraConsulta = ?, anamnese = ?, diagnostico = ?, prescricao = ?, observacoes = ?, status = ? WHERE id = ?";
        PreparedStatement pstm = null;

        try {
            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setString(1, objeto.getResponsavel());
            pstm.setString(2, objeto.getDataHoraConsulta());
            pstm.setString(3, objeto.getAnamnese());
            pstm.setString(4, objeto.getDiagnostico());
            pstm.setString(5, objeto.getPrescricao());
            pstm.setString(6, objeto.getObservacoes());
            pstm.setString(7, objeto.getStatus());
            pstm.setInt(8, objeto.getId());
            pstm.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, null);
        }
    }

    @Override
    public void delete(Consulta objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlInstrucao = "DELETE FROM consulta WHERE id = ?";
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
