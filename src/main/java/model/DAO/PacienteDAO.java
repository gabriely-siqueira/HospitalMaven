package model.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Paciente;

public class PacienteDAO {

    private static PacienteDAO instance;

    public static PacienteDAO getInstance() {
        if (instance == null) {
            instance = new PacienteDAO();
        }
        return instance;
    }

    public void create(Paciente paciente) {
        String sqlPessoa = "INSERT INTO pessoa (nomeCompleto, cpf, rg, telefone, endereco, complemento) " +
                           "VALUES (?, ?, ?, ?, ?, ?)";
        String sqlPaciente = "INSERT INTO paciente (id, nome, tipoSanguineo, sexo, cpfCnpj, rgInscricaoEstadual, fone1, fone2, " +
                             "email, cep, cidade, bairro, logradouro, complemento, dataCadastro) " +
                             "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        Connection conn = null;
        PreparedStatement stmtPessoa = null;
        PreparedStatement stmtPaciente = null;

        try {
            conn = ConnectionFactory.getConnection();
            conn.setAutoCommit(false);

            // Formatação do endereço
            String endereco = String.format("%s, %s, %s, CEP: %s",
                paciente.getLogradouro() != null ? paciente.getLogradouro() : "",
                paciente.getBairro() != null ? paciente.getBairro() : "",
                paciente.getCidade() != null ? paciente.getCidade() : "",
                paciente.getCep() != null ? paciente.getCep() : "");

            // Inserção de dados na tabela pessoa
            stmtPessoa = conn.prepareStatement(sqlPessoa, Statement.RETURN_GENERATED_KEYS);
            stmtPessoa.setString(1, paciente.getNome());
            stmtPessoa.setString(2, paciente.getCpfCnpj());
            stmtPessoa.setString(3, paciente.getRgInscricaoEstadual());
            stmtPessoa.setString(4, paciente.getFone1());
            stmtPessoa.setString(5, endereco);
            stmtPessoa.setString(6, paciente.getComplemento());
            stmtPessoa.executeUpdate();

            int idPessoa;
            try (ResultSet generatedKeys = stmtPessoa.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    idPessoa = generatedKeys.getInt(1);
                } else {
                    throw new SQLException("Falha ao obter o ID da pessoa.");
                }
            }

            // Inserção de dados na tabela paciente
            stmtPaciente = conn.prepareStatement(sqlPaciente);
            stmtPaciente.setInt(1, idPessoa);
            stmtPaciente.setString(2, paciente.getNome());
            stmtPaciente.setString(3, paciente.getTipoSanguineo());
            stmtPaciente.setString(4, paciente.getSexo());
            stmtPaciente.setString(5, paciente.getCpfCnpj());
            stmtPaciente.setString(6, paciente.getRgInscricaoEstadual());
            stmtPaciente.setString(7, paciente.getFone1());
            stmtPaciente.setString(8, paciente.getFone2());
            stmtPaciente.setString(9, paciente.getEmail());
            stmtPaciente.setString(10, paciente.getCep());
            stmtPaciente.setString(11, paciente.getCidade());
            stmtPaciente.setString(12, paciente.getBairro());
            stmtPaciente.setString(13, paciente.getLogradouro());
            stmtPaciente.setString(14, paciente.getComplemento());
            stmtPaciente.setString(15, paciente.getDataCadastro());
            stmtPaciente.executeUpdate();

            conn.commit();
        } catch (SQLException e) {
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            e.printStackTrace();
            throw new RuntimeException("Erro ao cadastrar paciente", e);
        } finally {
            try {
                if (stmtPessoa != null) stmtPessoa.close();
                if (stmtPaciente != null) stmtPaciente.close();
                if (conn != null) {
                    conn.setAutoCommit(true);
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public List<Paciente> retrieve() {
        List<Paciente> pacientes = new ArrayList<>();
        String sql = "SELECT * FROM paciente";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Paciente paciente = new Paciente();
                paciente.setId(rs.getInt("id"));
                paciente.setNome(rs.getString("nome"));
                paciente.setTipoSanguineo(rs.getString("tipoSanguineo"));
                paciente.setSexo(rs.getString("sexo"));
                paciente.setCpfCnpj(rs.getString("cpfCnpj"));
                paciente.setRgInscricaoEstadual(rs.getString("rgInscricaoEstadual"));
                paciente.setFone1(rs.getString("fone1"));
                paciente.setFone2(rs.getString("fone2"));
                paciente.setEmail(rs.getString("email"));
                paciente.setCep(rs.getString("cep"));
                paciente.setCidade(rs.getString("cidade"));
                paciente.setBairro(rs.getString("bairro"));
                paciente.setLogradouro(rs.getString("logradouro"));
                paciente.setComplemento(rs.getString("complemento"));
                paciente.setDataCadastro(rs.getString("dataCadastro"));
                pacientes.add(paciente);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao recuperar pacientes", e);
        }
        return pacientes;
    }

    public Paciente retrieve(int id) {
        Paciente paciente = null;
        String sql = "SELECT * FROM paciente WHERE id = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    paciente = new Paciente();
                    paciente.setId(rs.getInt("id"));
                    paciente.setNome(rs.getString("nome"));
                    paciente.setTipoSanguineo(rs.getString("tipoSanguineo"));
                    paciente.setSexo(rs.getString("sexo"));
                    paciente.setCpfCnpj(rs.getString("cpfCnpj"));
                    paciente.setRgInscricaoEstadual(rs.getString("rgInscricaoEstadual"));
                    paciente.setFone1(rs.getString("fone1"));
                    paciente.setFone2(rs.getString("fone2"));
                    paciente.setEmail(rs.getString("email"));
                    paciente.setCep(rs.getString("cep"));
                    paciente.setCidade(rs.getString("cidade"));
                    paciente.setBairro(rs.getString("bairro"));
                    paciente.setLogradouro(rs.getString("logradouro"));
                    paciente.setComplemento(rs.getString("complemento"));
                    paciente.setDataCadastro(rs.getString("dataCadastro"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao recuperar paciente", e);
        }
        return paciente;
    }

    public List<Paciente> retrieve(String parametro, String atributo) {
        List<Paciente> pacientes = new ArrayList<>();
        String sql = "SELECT * FROM paciente WHERE " + atributo + " = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, parametro);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Paciente paciente = new Paciente();
                    paciente.setId(rs.getInt("id"));
                    paciente.setNome(rs.getString("nome"));
                    paciente.setTipoSanguineo(rs.getString("tipoSanguineo"));
                    paciente.setSexo(rs.getString("sexo"));
                    paciente.setCpfCnpj(rs.getString("cpfCnpj"));
                    paciente.setRgInscricaoEstadual(rs.getString("rgInscricaoEstadual"));
                    paciente.setFone1(rs.getString("fone1"));
                    paciente.setFone2(rs.getString("fone2"));
                    paciente.setEmail(rs.getString("email"));
                    paciente.setCep(rs.getString("cep"));
                    paciente.setCidade(rs.getString("cidade"));
                    paciente.setBairro(rs.getString("bairro"));
                    paciente.setLogradouro(rs.getString("logradouro"));
                    paciente.setComplemento(rs.getString("complemento"));
                    paciente.setDataCadastro(rs.getString("dataCadastro"));
                    pacientes.add(paciente);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao recuperar pacientes", e);
        }
        return pacientes;
    }

    public void update(Paciente paciente) {
        String sql = "UPDATE paciente SET tipoSanguineo = ?, sexo = ?, cpfCnpj = ?, rgInscricaoEstadual = ?, fone1 = ?, " +
                     "fone2 = ?, email = ?, cep = ?, cidade = ?, bairro = ?, logradouro = ?, " +
                     "complemento = ?, dataCadastro = ? WHERE id = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, paciente.getTipoSanguineo());
            stmt.setString(2, paciente.getNome());
            stmt.setString(3, paciente.getSexo());
            stmt.setString(4, paciente.getCpfCnpj());
            stmt.setString(5, paciente.getRgInscricaoEstadual());
            stmt.setString(6, paciente.getFone1());
            stmt.setString(7, paciente.getFone2());
            stmt.setString(8, paciente.getEmail());
            stmt.setString(9, paciente.getCep());
            stmt.setString(10, paciente.getCidade());
            stmt.setString(11, paciente.getBairro());
            stmt.setString(12, paciente.getLogradouro());
            stmt.setString(13, paciente.getComplemento());
            stmt.setString(14, paciente.getDataCadastro());
            stmt.setInt(15, paciente.getId());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao atualizar paciente", e);
        }
    }

    public void delete(int id) {
        String sql = "DELETE FROM paciente WHERE id = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao excluir paciente", e);
        }
    }
}
