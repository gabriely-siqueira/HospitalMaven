/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.DAO;

import model.Acompanhante;
import java.util.List;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
/**
 *
 * @author gabriely
 */
public class AcompanhanteDAO implements InterfaceDAO<Acompanhante> {

   @Override
public void create(Acompanhante objeto) {
    Connection conexao = ConnectionFactory.getConnection();
    PreparedStatement pstm = null;

    try {
        String sqlInstrucao = "Insert Into acompanhante ("
                + "nome,"
                + "grauParentesco,"
                + "cpf,"
                + "fone,"
                + "email,"
                + "status) "
                + "Values(?,?,?,?,?,?)";

        pstm = conexao.prepareStatement(sqlInstrucao);
        pstm.setString(1, objeto.getNome());
        pstm.setString(2, objeto.getGrauParentesco());
        pstm.setString(3, objeto.getCpf());
        pstm.setString(4, objeto.getFone());
        pstm.setString(5, objeto.getEmail());
        pstm.setString(6, objeto.getStatus());
        pstm.execute();
    } catch (SQLException ex) {
        ex.printStackTrace();
    } finally {
        ConnectionFactory.closeConnection(conexao, pstm, null);
    }
}

@Override
public List<Acompanhante> retrieve() {
    Connection conexao = ConnectionFactory.getConnection();
    PreparedStatement pstm = null;
    ResultSet resultado = null;
    List<Acompanhante> listaAcompanhantes = new ArrayList<>();

    String sqlInstrucao = "Select id, nome, grauParentesco, cpf, fone, email, status From acompanhante";

    try {
        pstm = conexao.prepareStatement(sqlInstrucao);
        resultado = pstm.executeQuery();
        while (resultado.next()) {
            Acompanhante acompanhante = new Acompanhante();
            acompanhante.setId(resultado.getInt("id"));
            acompanhante.setNome(resultado.getString("nome"));
            acompanhante.setGrauParentesco(resultado.getString("grauParentesco"));
            acompanhante.setCpf(resultado.getString("cpf"));
            acompanhante.setFone(resultado.getString("fone"));
            acompanhante.setEmail(resultado.getString("email"));
            acompanhante.setStatus(resultado.getString("status"));
            listaAcompanhantes.add(acompanhante);
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
    } finally {
        ConnectionFactory.closeConnection(conexao, pstm, resultado);
        return listaAcompanhantes;
    }
}

@Override
public Acompanhante retrieve(int pk) {
    Connection conexao = ConnectionFactory.getConnection();
    PreparedStatement pstm = null;
    ResultSet resultado = null;
    Acompanhante acompanhante = new Acompanhante();

    String sqlInstrucao = "Select id, nome, grauParentesco, cpf, fone, email, status From acompanhante Where id = ?";

    try {
        pstm = conexao.prepareStatement(sqlInstrucao);
        pstm.setInt(1, pk);
        resultado = pstm.executeQuery();
        while (resultado.next()) {
            acompanhante.setId(resultado.getInt("id"));
            acompanhante.setNome(resultado.getString("nome"));
            acompanhante.setGrauParentesco(resultado.getString("grauParentesco"));
            acompanhante.setCpf(resultado.getString("cpf"));
            acompanhante.setFone(resultado.getString("fone"));
            acompanhante.setEmail(resultado.getString("email"));
            acompanhante.setStatus(resultado.getString("status"));
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
    } finally {
        ConnectionFactory.closeConnection(conexao, pstm, resultado);
        return acompanhante;
    }
}

@Override
public List<Acompanhante> retrieve(String parametro, String atributo) {
    Connection conexao = ConnectionFactory.getConnection();
    PreparedStatement pstm = null;
    ResultSet resultado = null;
    List<Acompanhante> listaAcompanhantes = new ArrayList<>();

    String sqlInstrucao = "Select id, nome, grauParentesco, cpf, fone, email, status From acompanhante Where " + atributo + " like ?";

    try {
        pstm = conexao.prepareStatement(sqlInstrucao);
        pstm.setString(1, "%" + parametro + "%");
        resultado = pstm.executeQuery();
        while (resultado.next()) {
            Acompanhante acompanhante = new Acompanhante();
            acompanhante.setId(resultado.getInt("id"));
            acompanhante.setNome(resultado.getString("nome"));
            acompanhante.setGrauParentesco(resultado.getString("grauParentesco"));
            acompanhante.setCpf(resultado.getString("cpf"));
            acompanhante.setFone(resultado.getString("fone"));
            acompanhante.setEmail(resultado.getString("email"));
            acompanhante.setStatus(resultado.getString("status"));
            listaAcompanhantes.add(acompanhante);
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
    } finally {
        ConnectionFactory.closeConnection(conexao, pstm, resultado);
        return listaAcompanhantes;
    }
}

@Override
public void update(Acompanhante objeto) {
    Connection conexao = ConnectionFactory.getConnection();
    String sqlInstrucao = "Update acompanhante Set "
            + "nome = ?, "
            + "grauParentesco = ?, "
            + "cpf = ?, "
            + "fone = ?, "
            + "email = ?, "
            + "status = ? "
            + "Where id = ?";
    PreparedStatement pstm = null;

    try {
        pstm = conexao.prepareStatement(sqlInstrucao);
        pstm.setString(1, objeto.getNome());
        pstm.setString(2, objeto.getGrauParentesco());
        pstm.setString(3, objeto.getCpf());
        pstm.setString(4, objeto.getFone());
        pstm.setString(5, objeto.getEmail());
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
public void delete(Acompanhante objeto) {
    Connection conexao = ConnectionFactory.getConnection();
    String sqlInstrucao = "DELETE FROM acompanhante WHERE id = ?";
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
}}
