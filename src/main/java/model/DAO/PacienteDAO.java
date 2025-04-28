/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Paciente;

/**
 *
 * @author gabriely
 */
public class PacienteDAO implements InterfaceDAO<Paciente> {

    @Override
    public void create(Paciente objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;

        try {
            String sqlInstrucao = "Insert Into paciente ("
                    + "tipoSanguineo,"
                    + "sexo,"
                    + "nomeSocial) "
                    + "Values(?,?,?) ";

            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setString(1, objeto.getTipoSanguineo());
            pstm.setString(2, objeto.getSexo());
            pstm.setString(3, objeto.getNomeSocial());
            pstm.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, null);
        }
    }

    @Override
    public List<Paciente> retrieve() {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        ResultSet resultado = null;
        List<Paciente> listaPaciente = new ArrayList<>();

        String sqlInstrucao = "Select id, tipoSanguineo, sexo, nomeSocial "
                + "From paciente";

        try {
            pstm = conexao.prepareStatement(sqlInstrucao);
            resultado = pstm.executeQuery();
            while (resultado.next()) {
                Paciente paciente = new Paciente();
                paciente.setId(resultado.getInt("id"));
                paciente.setTipoSanguineo(resultado.getString("tipoSanguineo"));
                paciente.setSexo(resultado.getString("sexo"));
                paciente.setNomeSocial(resultado.getString("nomeSocial"));
                listaPaciente.add(paciente);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, resultado);
            return listaPaciente;
        }
    }

    @Override
    public Paciente retrieve(int pk) {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        ResultSet resultado = null;
        Paciente paciente = new Paciente();

        String sqlInstrucao = "Select id, tipoSanguineo, sexo, nomeSocial "
                + "From paciente Where id = ?";

        try {
            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setInt(1, pk);
            resultado = pstm.executeQuery();
            if (resultado.next()) {
                paciente.setId(resultado.getInt("id"));
                paciente.setTipoSanguineo(resultado.getString("tipoSanguineo"));
                paciente.setSexo(resultado.getString("sexo"));
                paciente.setNomeSocial(resultado.getString("nomeSocial"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, resultado);
            return paciente;
        }
    }

    @Override
    public List<Paciente> retrieve(String parametro, String atributo) {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        ResultSet resultado = null;
        List<Paciente> listaPaciente = new ArrayList<>();

        String sqlInstrucao = "Select id, tipoSanguineo, sexo, nomeSocial "
                + "From paciente Where " + atributo + " like ?";

        try {
            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setString(1, "%" + parametro + "%");
            resultado = pstm.executeQuery();
            while (resultado.next()) {
                Paciente paciente = new Paciente();
                paciente.setId(resultado.getInt("id"));
                paciente.setTipoSanguineo(resultado.getString("tipoSanguineo"));
                paciente.setSexo(resultado.getString("sexo"));
                paciente.setNomeSocial(resultado.getString("nomeSocial"));
                listaPaciente.add(paciente);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, resultado);
            return listaPaciente;
        }
    }

    @Override
    public void update(Paciente objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlInstrucao = "Update paciente "
                + "set tipoSanguineo = ?, "
                + "sexo = ?, "
                + "nomeSocial = ? "
                + "Where id = ?";
        PreparedStatement pstm = null;
        try {
            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setString(1, objeto.getTipoSanguineo());
            pstm.setString(2, objeto.getSexo());
            pstm.setString(3, objeto.getNomeSocial());
            pstm.setInt(4, objeto.getId());
            pstm.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, null);
        }
    }

    @Override
    public void delete(Paciente objeto) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
