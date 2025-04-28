package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Atendimento;

public class AtendimentoDAO implements InterfaceDAO<Atendimento> {

    @Override
    public void create(Atendimento objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;

        try {
            String sqlInstrucao = "INSERT INTO atendimento ("
                    + "dataHoraAtendimento, pressao, temperatura, bpm, oximetria, "
                    + "historicoDeDoencas, alergias, medicacoesEmUso, anamnese, "
                    + "tipoAtendimento, classificacao, observacoes, status) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setString(1, objeto.getDataHoraAtendimento());
            pstm.setString(2, objeto.getPressao());
            pstm.setString(3, objeto.getTemperatura());
            pstm.setInt(4, objeto.getBpm());
            pstm.setFloat(5, objeto.getOximetria());
            pstm.setString(6, objeto.getHistoricoDeDoencas());
            pstm.setString(7, objeto.getAlergias());
            pstm.setString(8, objeto.getMedicacoesEmUso());
            pstm.setString(9, objeto.getAnamnese());
            pstm.setString(10, objeto.getTipoAtendimento());
            pstm.setString(11, objeto.getClassificacao());
            pstm.setString(12, objeto.getObservacoes());
            pstm.setString(13, objeto.getStatus());
            pstm.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, null);
        }
    }

    @Override
    public List<Atendimento> retrieve() {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        ResultSet resultado = null;
        List<Atendimento> listaAtendimentos = new ArrayList<>();

        String sqlInstrucao = "SELECT * FROM atendimento";

        try {
            pstm = conexao.prepareStatement(sqlInstrucao);
            resultado = pstm.executeQuery();
            while (resultado.next()) {
                Atendimento atendimento = new Atendimento();
                atendimento.setId(resultado.getInt("id"));
                atendimento.setDataHoraAtendimento(resultado.getString("dataHoraAtendimento"));
                atendimento.setPressao(resultado.getString("pressao"));
                atendimento.setTemperatura(resultado.getString("temperatura"));
                atendimento.setBpm(resultado.getInt("bpm"));
                atendimento.setOximetria(resultado.getFloat("oximetria"));
                atendimento.setHistoricoDeDoencas(resultado.getString("historicoDeDoencas"));
                atendimento.setAlergias(resultado.getString("alergias"));
                atendimento.setMedicacoesEmUso(resultado.getString("medicacoesEmUso"));
                atendimento.setAnamnese(resultado.getString("anamnese"));
                atendimento.setTipoAtendimento(resultado.getString("tipoAtendimento"));
                atendimento.setClassificacao(resultado.getString("classificacao"));
                atendimento.setObservacoes(resultado.getString("observacoes"));
                atendimento.setStatus(resultado.getString("status"));
                listaAtendimentos.add(atendimento);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, resultado);
        }
        return listaAtendimentos;
    }

    @Override
    public Atendimento retrieve(int pk) {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        ResultSet resultado = null;
        Atendimento atendimento = null;

        String sqlInstrucao = "SELECT * FROM atendimento WHERE id = ?";

        try {
            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setInt(1, pk);
            resultado = pstm.executeQuery();
            if (resultado.next()) {
                atendimento = new Atendimento();
                atendimento.setId(resultado.getInt("id"));
                atendimento.setDataHoraAtendimento(resultado.getString("dataHoraAtendimento"));
                atendimento.setPressao(resultado.getString("pressao"));
                atendimento.setTemperatura(resultado.getString("temperatura"));
                atendimento.setBpm(resultado.getInt("bpm"));
                atendimento.setOximetria(resultado.getFloat("oximetria"));
                atendimento.setHistoricoDeDoencas(resultado.getString("historicoDeDoencas"));
                atendimento.setAlergias(resultado.getString("alergias"));
                atendimento.setMedicacoesEmUso(resultado.getString("medicacoesEmUso"));
                atendimento.setAnamnese(resultado.getString("anamnese"));
                atendimento.setTipoAtendimento(resultado.getString("tipoAtendimento"));
                atendimento.setClassificacao(resultado.getString("classificacao"));
                atendimento.setObservacoes(resultado.getString("observacoes"));
                atendimento.setStatus(resultado.getString("status"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, resultado);
        }
        return atendimento;
    }

    @Override
    public List<Atendimento> retrieve(String parametro, String atributo) {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        ResultSet resultado = null;
        List<Atendimento> listaAtendimentos = new ArrayList<>();

        String sqlInstrucao = "SELECT * FROM atendimento WHERE " + atributo + " LIKE ?";

        try {
            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setString(1, "%" + parametro + "%");
            resultado = pstm.executeQuery();
            while (resultado.next()) {
                Atendimento atendimento = new Atendimento();
                atendimento.setId(resultado.getInt("id"));
                atendimento.setDataHoraAtendimento(resultado.getString("dataHoraAtendimento"));
                atendimento.setPressao(resultado.getString("pressao"));
                atendimento.setTemperatura(resultado.getString("temperatura"));
                atendimento.setBpm(resultado.getInt("bpm"));
                atendimento.setOximetria(resultado.getFloat("oximetria"));
                atendimento.setHistoricoDeDoencas(resultado.getString("historicoDeDoencas"));
                atendimento.setAlergias(resultado.getString("alergias"));
                atendimento.setMedicacoesEmUso(resultado.getString("medicacoesEmUso"));
                atendimento.setAnamnese(resultado.getString("anamnese"));
                atendimento.setTipoAtendimento(resultado.getString("tipoAtendimento"));
                atendimento.setClassificacao(resultado.getString("classificacao"));
                atendimento.setObservacoes(resultado.getString("observacoes"));
                atendimento.setStatus(resultado.getString("status"));
                listaAtendimentos.add(atendimento);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, resultado);
        }
        return listaAtendimentos;
    }

    @Override
    public void update(Atendimento objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlInstrucao = "UPDATE atendimento SET "
                + "dataHoraAtendimento = ?, pressao = ?, temperatura = ?, bpm = ?, oximetria = ?, "
                + "historicoDeDoencas = ?, alergias = ?, medicacoesEmUso = ?, anamnese = ?, "
                + "tipoAtendimento = ?, classificacao = ?, observacoes = ?, status = ? "
                + "WHERE id = ?";
        PreparedStatement pstm = null;
        try {
            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setString(1, objeto.getDataHoraAtendimento());
            pstm.setString(2, objeto.getPressao());
            pstm.setString(3, objeto.getTemperatura());
            pstm.setInt(4, objeto.getBpm());
            pstm.setFloat(5, objeto.getOximetria());
            pstm.setString(6, objeto.getHistoricoDeDoencas());
            pstm.setString(7, objeto.getAlergias());
            pstm.setString(8, objeto.getMedicacoesEmUso());
            pstm.setString(9, objeto.getAnamnese());
            pstm.setString(10, objeto.getTipoAtendimento());
            pstm.setString(11, objeto.getClassificacao());
            pstm.setString(12, objeto.getObservacoes());
            pstm.setString(13, objeto.getStatus());
            pstm.setInt(14, objeto.getId());
            pstm.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, null);
        }
    }

    @Override
    public void delete(Atendimento objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        try {
            String sqlInstrucao = "DELETE FROM atendimento WHERE id = ?";
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
