package model.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Quarto;
import model.Ala;

public class QuartoDAO {

    private static QuartoDAO instance;

    public static QuartoDAO getInstance() {
        if (instance == null) {
            instance = new QuartoDAO();
        }
        return instance;
    }

    public void create(Quarto quarto) {
        String sql = "INSERT INTO quarto (descricao, status, idAla) VALUES (?, ?, ?)";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, quarto.getDescricao());
            stmt.setString(2, quarto.getStatus());
            stmt.setInt(3, quarto.getAla() != null ? quarto.getAla().getId() : 0);

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao cadastrar quarto", e);
        }
    }

    public List<Quarto> retrieve() {
        List<Quarto> quartos = new ArrayList<>();
        String sql = "SELECT * FROM quarto";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Quarto quarto = new Quarto();
                quarto.setId(rs.getInt("id"));
                quarto.setDescricao(rs.getString("descricao"));
                quarto.setStatus(rs.getString("status"));
                int idAla = rs.getInt("idAla");
                if (idAla > 0) {
                    Ala ala = new AlaDAO().retrieve(idAla);
                    quarto.setAla(ala);
                }
                quartos.add(quarto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao recuperar quartos", e);
        }
        return quartos;
    }

    public Quarto retrieve(int id) {
        Quarto quarto = null;
        String sql = "SELECT * FROM quarto WHERE id = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    quarto = new Quarto();
                    quarto.setId(rs.getInt("id"));
                    quarto.setDescricao(rs.getString("descricao"));
                    quarto.setStatus(rs.getString("status"));
                    int idAla = rs.getInt("idAla");
                    if (idAla > 0) {
                        Ala ala = new AlaDAO().retrieve(idAla);
                        quarto.setAla(ala);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao recuperar quarto", e);
        }
        return quarto;
    }

    public List<Quarto> retrieve(String parametro, String atributo) {
        List<Quarto> quartos = new ArrayList<>();
        String sql = "SELECT * FROM quarto WHERE " + atributo + " = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, parametro);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Quarto quarto = new Quarto();
                    quarto.setId(rs.getInt("id"));
                    quarto.setDescricao(rs.getString("descricao"));
                    quarto.setStatus(rs.getString("status"));
                    int idAla = rs.getInt("idAla");
                    if (idAla > 0) {
                        Ala ala = new AlaDAO().retrieve(idAla);
                        quarto.setAla(ala);
                    }
                    quartos.add(quarto);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao recuperar quartos", e);
        }
        return quartos;
    }

    public void update(Quarto quarto) {
        String sql = "UPDATE quarto SET descricao = ?, status = ?, idAla = ? WHERE id = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, quarto.getDescricao());
            stmt.setString(2, quarto.getStatus());
            stmt.setInt(3, quarto.getAla() != null ? quarto.getAla().getId() : 0);
            stmt.setInt(4, quarto.getId());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao atualizar quarto", e);
        }
    }

    public void delete(int id) {
        String sql = "DELETE FROM quarto WHERE id = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao excluir quarto", e);
        }
    }
}
