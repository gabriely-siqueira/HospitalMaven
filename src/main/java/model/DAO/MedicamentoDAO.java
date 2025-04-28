package model.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Medicamento;

public class MedicamentoDAO {

    private static MedicamentoDAO instance;

    public static MedicamentoDAO getInstance() {
        if (instance == null) {
            instance = new MedicamentoDAO();
        }
        return instance;
    }

    // Método para criar um novo medicamento
    public void create(Medicamento medicamento) {
        String sql = "INSERT INTO medicamento (descricaoMedicamento, principioAtivo, quantidadeMinima, status) VALUES (?, ?, ?, ?)";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, medicamento.getDescricaoMedicamento());
            stmt.setString(2, medicamento.getPrincipioAtivo());
            stmt.setFloat(3, medicamento.getQtdMinima());
            stmt.setString(4, medicamento.getStatus());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao cadastrar medicamento", e);
        }
    }

    // Método para recuperar todos os medicamentos
    public List<Medicamento> retrieve() {
        List<Medicamento> medicamentos = new ArrayList<>();
        String sql = "SELECT * FROM medicamento";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Medicamento medicamento = new Medicamento();
                medicamento.setId(rs.getInt("id"));
                medicamento.setDescricaoMedicamento(rs.getString("descricaoMedicamento"));
                medicamento.setPrincipioAtivo(rs.getString("principioAtivo"));
                medicamento.setQtdMinima(rs.getFloat("quantidadeMinima"));
                medicamento.setStatus(rs.getString("status"));
                medicamentos.add(medicamento);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao recuperar medicamentos", e);
        }
        return medicamentos;
    }

    // Método para recuperar um medicamento específico
    public Medicamento retrieve(int id) {
        Medicamento medicamento = null;
        String sql = "SELECT * FROM medicamento WHERE id = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    medicamento = new Medicamento();
                    medicamento.setId(rs.getInt("id"));
                    medicamento.setDescricaoMedicamento(rs.getString("descricaoMedicamento"));
                    medicamento.setPrincipioAtivo(rs.getString("principioAtivo"));
                    medicamento.setQtdMinima(rs.getFloat("quantidadeMinima"));
                    medicamento.setStatus(rs.getString("status"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao recuperar medicamento", e);
        }
        return medicamento;
    }

    // Método para recuperar medicamentos por um atributo e valor
    public List<Medicamento> retrieve(String parametro, String atributo) {
        List<Medicamento> medicamentos = new ArrayList<>();
        String sql = "SELECT * FROM medicamento WHERE " + atributo + " = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, parametro);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Medicamento medicamento = new Medicamento();
                    medicamento.setId(rs.getInt("id"));
                    medicamento.setDescricaoMedicamento(rs.getString("descricaoMedicamento"));
                    medicamento.setPrincipioAtivo(rs.getString("principioAtivo"));
                    medicamento.setQtdMinima(rs.getFloat("quantidadeMinima"));
                    medicamento.setStatus(rs.getString("status"));
                    medicamentos.add(medicamento);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao recuperar medicamentos", e);
        }
        return medicamentos;
    }

    // Método para atualizar um medicamento
    public void update(Medicamento medicamento) {
        String sql = "UPDATE medicamento SET descricaoMedicamento = ?, principioAtivo = ?, quantidadeMinima = ?, status = ? WHERE id = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, medicamento.getDescricaoMedicamento());
            stmt.setString(2, medicamento.getPrincipioAtivo());
            stmt.setFloat(3, medicamento.getQtdMinima());
            stmt.setString(4, medicamento.getStatus());
            stmt.setInt(5, medicamento.getId());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao atualizar medicamento", e);
        }
    }

    // Método para excluir um medicamento
    public void delete(int id) {
        String sql = "DELETE FROM medicamento WHERE id = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao excluir medicamento", e);
        }
    }
}
