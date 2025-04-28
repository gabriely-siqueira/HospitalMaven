package model.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Laboratorio;

public class LaboratorioDAO {

    private static LaboratorioDAO instance;

    // Método singleton para obter a instância da classe
    public static LaboratorioDAO getInstance() {
        if (instance == null) {
            instance = new LaboratorioDAO();
        }
        return instance;
    }

    // Método para criar um novo laboratório
    public void create(Laboratorio laboratorio) {
        String sql = "INSERT INTO laboratorio (nomeFantasia, contato, status) VALUES (?, ?, ?)";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, laboratorio.getNomeFantasia());
            stmt.setString(2, laboratorio.getContato());
            stmt.setString(3, laboratorio.getStatus());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao cadastrar laboratório", e);
        }
    }

    // Método para recuperar todos os laboratórios
    public List<Laboratorio> retrieve() {
        List<Laboratorio> laboratorios = new ArrayList<>();
        String sql = "SELECT * FROM laboratorio";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Laboratorio laboratorio = new Laboratorio();
                laboratorio.setId(rs.getInt("id"));
                laboratorio.setNomeFantasia(rs.getString("nomeFantasia"));
                laboratorio.setContato(rs.getString("contato"));
                laboratorio.setStatus(rs.getString("status"));
                laboratorios.add(laboratorio);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao recuperar laboratórios", e);
        }
        return laboratorios;
    }

    // Método para recuperar um laboratório específico
    public Laboratorio retrieve(int id) {
        Laboratorio laboratorio = null;
        String sql = "SELECT * FROM laboratorio WHERE id = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    laboratorio = new Laboratorio();
                    laboratorio.setId(rs.getInt("id"));
                    laboratorio.setNomeFantasia(rs.getString("nomeFantasia"));
                    laboratorio.setContato(rs.getString("contato"));
                    laboratorio.setStatus(rs.getString("status"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao recuperar laboratório", e);
        }
        return laboratorio;
    }

    // Método para recuperar laboratórios por um atributo e valor
    public List<Laboratorio> retrieve(String parametro, String atributo) {
        List<Laboratorio> laboratorios = new ArrayList<>();
        String sql = "SELECT * FROM laboratorio WHERE " + atributo + " = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, parametro);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Laboratorio laboratorio = new Laboratorio();
                    laboratorio.setId(rs.getInt("id"));
                    laboratorio.setNomeFantasia(rs.getString("nomeFantasia"));
                    laboratorio.setContato(rs.getString("contato"));
                    laboratorio.setStatus(rs.getString("status"));
                    laboratorios.add(laboratorio);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao recuperar laboratórios", e);
        }
        return laboratorios;
    }

    // Método para atualizar um laboratório
    public void update(Laboratorio laboratorio) {
        String sql = "UPDATE laboratorio SET nomeFantasia = ?, contato = ?, status = ? WHERE id = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, laboratorio.getNomeFantasia());
            stmt.setString(2, laboratorio.getContato());
            stmt.setString(3, laboratorio.getStatus());
            stmt.setInt(4, laboratorio.getId());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao atualizar laboratório", e);
        }
    }

    // Método para excluir um laboratório
    public void delete(int id) {
        String sql = "DELETE FROM laboratorio WHERE id = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao excluir laboratório", e);
        }
    }
}
