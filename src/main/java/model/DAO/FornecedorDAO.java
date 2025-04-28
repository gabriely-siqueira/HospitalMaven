package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Fornecedor;

public class FornecedorDAO implements InterfaceDAO<Fornecedor> {

    @Override
    public void create(Fornecedor objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;

        try {
            String sqlInstrucao = "INSERT INTO fornecedor (nomeFantasia, contato) VALUES (?, ?)";
            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setString(1, objeto.getNomeFantasia());
            pstm.setString(2, objeto.getContato());
            pstm.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, null);
        }
    }

    @Override
    public List<Fornecedor> retrieve() {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        ResultSet resultado = null;
        List<Fornecedor> listaFornecedor = new ArrayList<>();

        String sqlInstrucao = "SELECT id, nomeFantasia, contato FROM fornecedor";

        try {
            pstm = conexao.prepareStatement(sqlInstrucao);
            resultado = pstm.executeQuery();
            while (resultado.next()) {
                Fornecedor fornecedor = new Fornecedor();
                fornecedor.setId(resultado.getInt("id"));
                fornecedor.setNomeFantasia(resultado.getString("nomeFantasia"));
                fornecedor.setContato(resultado.getString("contato"));
                listaFornecedor.add(fornecedor);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, resultado);
        }

        return listaFornecedor;
    }

    @Override
    public Fornecedor retrieve(int pk) {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        ResultSet resultado = null;
        Fornecedor fornecedor = null;

        String sqlInstrucao = "SELECT id, nomeFantasia, contato FROM fornecedor WHERE id = ?";

        try {
            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setInt(1, pk);
            resultado = pstm.executeQuery();
            if (resultado.next()) {
                fornecedor = new Fornecedor();
                fornecedor.setId(resultado.getInt("id"));
                fornecedor.setNomeFantasia(resultado.getString("nomeFantasia"));
                fornecedor.setContato(resultado.getString("contato"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, resultado);
        }

        return fornecedor;
    }

    @Override
    public List<Fornecedor> retrieve(String parametro, String atributo) {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        ResultSet resultado = null;
        List<Fornecedor> listaFornecedor = new ArrayList<>();

        String sqlInstrucao = "SELECT id, nomeFantasia, contato FROM fornecedor WHERE " + atributo + " LIKE ?";

        try {
            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setString(1, "%" + parametro + "%");
            resultado = pstm.executeQuery();
            while (resultado.next()) {
                Fornecedor fornecedor = new Fornecedor();
                fornecedor.setId(resultado.getInt("id"));
                fornecedor.setNomeFantasia(resultado.getString("nomeFantasia"));
                fornecedor.setContato(resultado.getString("contato"));
                listaFornecedor.add(fornecedor);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, resultado);
        }

        return listaFornecedor;
    }

    @Override
    public void update(Fornecedor objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlInstrucao = "UPDATE fornecedor SET nomeFantasia = ?, contato = ? WHERE id = ?";
        PreparedStatement pstm = null;

        try {
            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setString(1, objeto.getNomeFantasia());
            pstm.setString(2, objeto.getContato());
            pstm.setInt(3, objeto.getId());
            pstm.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, null);
        }
    }

    @Override
    public void delete(Fornecedor objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlInstrucao = "DELETE FROM fornecedor WHERE id = ?";
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
