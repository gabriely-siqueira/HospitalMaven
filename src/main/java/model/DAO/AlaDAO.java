package model.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Ala;

public class AlaDAO {

    private static AlaDAO instance;

    public static AlaDAO getInstance() {
        if (instance == null) {
            instance = new AlaDAO();
        }
        return instance;
    }

    public void create(Ala ala) {
        String sql = "INSERT INTO ala (descricao, status) VALUES (?, ?)";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, ala.getDescricao());
            stmt.setString(2, ala.getStatus());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao cadastrar ala", e);
        }
    }

    public List<Ala> retrieve() {
        List<Ala> alas = new ArrayList<>();
        String sql = "SELECT * FROM ala";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Ala ala = new Ala();
                ala.setId(rs.getInt("id"));
                ala.setDescricao(rs.getString("descricao"));
                ala.setStatus(rs.getString("status"));
                alas.add(ala);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao recuperar alas", e);
        }
        return alas;
    }

    public Ala retrieve(int id) {
        Ala ala = null;
        String sql = "SELECT * FROM ala WHERE id = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    ala = new Ala();
                    ala.setId(rs.getInt("id"));
                    ala.setDescricao(rs.getString("descricao"));
                    ala.setStatus(rs.getString("status"));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao recuperar ala", e);
        }
        return ala;
    }

    public List<Ala> retrieve(String parametro, String atributo) {
        List<Ala> alas = new ArrayList<>();
        String sql = "SELECT * FROM ala WHERE " + atributo + " LIKE ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, "%" + parametro + "%");
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Ala ala = new Ala();
                    ala.setId(rs.getInt("id"));
                    ala.setDescricao(rs.getString("descricao"));
                    ala.setStatus(rs.getString("status"));
                    alas.add(ala);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao recuperar alas por atributo", e);
        }
        return alas;
    }

    public void update(Ala ala) {
        String sql = "UPDATE ala SET descricao = ?, status = ? WHERE id = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, ala.getDescricao());
            stmt.setString(2, ala.getStatus());
            stmt.setInt(3, ala.getId());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao atualizar ala", e);
        }
    }

    public void delete(int id) {
        String sql = "DELETE FROM ala WHERE id = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao excluir ala", e);
        }
    }
}
