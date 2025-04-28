package model.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Medico;

public class MedicoDAO {

    private static MedicoDAO instance;

    public static MedicoDAO getInstance() {
        if (instance == null) {
            instance = new MedicoDAO();
        }
        return instance;
    }

    public void create(Medico medico) {
        String sqlPessoa = "INSERT INTO pessoa (nomeCompleto, cpf, rg, telefone, endereco, complemento) " +
                           "VALUES (?, ?, ?, ?, ?, ?)";
        String sqlMedico = "INSERT INTO medico (id, nome, fone1, fone2, email, cpfCnpj, rgInscricaoEstadual, " +
                           "dataCadastro, cep, cidade, bairro, logradouro, complemento, crm, senha, login) " +
                           "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        Connection conn = null;
        PreparedStatement stmtPessoa = null;
        PreparedStatement stmtMedico = null;
        
        try {
            conn = ConnectionFactory.getConnection();
            conn.setAutoCommit(false);
            
            String endereco = String.format("%s, %s, %s, CEP: %s",
                medico.getLogradouro() != null ? medico.getLogradouro() : "",
                medico.getBairro() != null ? medico.getBairro() : "",
                medico.getCidade() != null ? medico.getCidade() : "",
                medico.getCep() != null ? medico.getCep() : "");
            
            stmtPessoa = conn.prepareStatement(sqlPessoa, Statement.RETURN_GENERATED_KEYS);
            stmtPessoa.setString(1, medico.getNome());
            stmtPessoa.setString(2, medico.getCpfCnpj());
            stmtPessoa.setString(3, medico.getRgInscricaoEstadual());
            stmtPessoa.setString(4, medico.getFone1());
            stmtPessoa.setString(5, endereco);
            stmtPessoa.setString(6, medico.getComplemento());
            stmtPessoa.executeUpdate();
            
            int idPessoa;
            try (ResultSet generatedKeys = stmtPessoa.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    idPessoa = generatedKeys.getInt(1);
                } else {
                    throw new SQLException("Falha ao obter o ID da pessoa.");
                }
            }
            
            stmtMedico = conn.prepareStatement(sqlMedico);
            stmtMedico.setInt(1, idPessoa);
            stmtMedico.setString(2, medico.getNome());
            stmtMedico.setString(3, medico.getFone1());
            stmtMedico.setString(4, medico.getFone2());
            stmtMedico.setString(5, medico.getEmail());
            stmtMedico.setString(6, medico.getCpfCnpj());
            stmtMedico.setString(7, medico.getRgInscricaoEstadual());
            stmtMedico.setString(8, medico.getDataCadastro());
            stmtMedico.setString(9, medico.getCep());
            stmtMedico.setString(10, medico.getCidade());
            stmtMedico.setString(11, medico.getBairro());
            stmtMedico.setString(12, medico.getLogradouro());
            System.out.println("Salvando complemento na tabela medico: " + medico.getComplemento());
            stmtMedico.setString(13, medico.getComplemento());
            stmtMedico.setString(14, medico.getCrm());
            stmtMedico.setString(15, medico.getSenha());
            stmtMedico.setString(16, medico.getLogin());
            stmtMedico.executeUpdate();
            
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
            throw new RuntimeException("Erro ao cadastrar médico", e);
        } finally {
            try {
                if (stmtPessoa != null) stmtPessoa.close();
                if (stmtMedico != null) stmtMedico.close();
                if (conn != null) {
                    conn.setAutoCommit(true);
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public List<Medico> retrieve() {
        List<Medico> medicos = new ArrayList<>();
        String sql = "SELECT * FROM medico";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Medico medico = new Medico();
                medico.setId(rs.getInt("id"));
                medico.setNome(rs.getString("nome"));
                medico.setFone1(rs.getString("fone1"));
                medico.setFone2(rs.getString("fone2"));
                medico.setEmail(rs.getString("email"));
                medico.setCpfCnpj(rs.getString("cpfCnpj"));
                medico.setRgInscricaoEstadual(rs.getString("rgInscricaoEstadual"));
                medico.setDataCadastro(rs.getString("dataCadastro"));
                medico.setCep(rs.getString("cep"));
                medico.setCidade(rs.getString("cidade"));
                String bairro = rs.getString("bairro");
                medico.setBairro(bairro != null ? bairro : "");
                medico.setLogradouro(rs.getString("logradouro"));
                String complemento = rs.getString("complemento");
                medico.setComplemento(complemento);
                medico.setCrm(rs.getString("crm"));
                medico.setSenha(rs.getString("senha"));
                medico.setLogin(rs.getString("login"));
                medicos.add(medico);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao recuperar médicos", e);
        }
        return medicos;
    }

    public Medico retrieve(int id) {
        Medico medico = null;
        String sql = "SELECT * FROM medico WHERE id = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    medico = new Medico();
                    medico.setId(rs.getInt("id"));
                    medico.setNome(rs.getString("nome"));
                    medico.setFone1(rs.getString("fone1"));
                    medico.setFone2(rs.getString("fone2"));
                    medico.setEmail(rs.getString("email"));
                    medico.setCpfCnpj(rs.getString("cpfCnpj"));
                    medico.setRgInscricaoEstadual(rs.getString("rgInscricaoEstadual"));
                    medico.setDataCadastro(rs.getString("dataCadastro"));
                    medico.setCep(rs.getString("cep"));
                    medico.setCidade(rs.getString("cidade"));
                    String bairro = rs.getString("bairro");
                    medico.setBairro(bairro != null ? bairro : "");
                    medico.setLogradouro(rs.getString("logradouro"));
                    String complemento = rs.getString("complemento");
                    medico.setComplemento(complemento);
                    medico.setCrm(rs.getString("crm"));
                    medico.setSenha(rs.getString("senha"));
                    medico.setLogin(rs.getString("login"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao recuperar médico", e);
        }
        return medico;
    }

    public List<Medico> retrieve(String parametro, String atributo) {
        List<Medico> medicos = new ArrayList<>();
        String sql = "SELECT * FROM medico WHERE " + atributo + " = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, parametro);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Medico medico = new Medico();
                    medico.setId(rs.getInt("id"));
                    medico.setNome(rs.getString("nome"));
                    medico.setFone1(rs.getString("fone1"));
                    medico.setFone2(rs.getString("fone2"));
                    medico.setEmail(rs.getString("email"));
                    medico.setCpfCnpj(rs.getString("cpfCnpj"));
                    medico.setRgInscricaoEstadual(rs.getString("rgInscricaoEstadual"));
                    medico.setDataCadastro(rs.getString("dataCadastro"));
                    medico.setCep(rs.getString("cep"));
                    medico.setCidade(rs.getString("cidade"));
                    String bairro = rs.getString("bairro");
                    medico.setBairro(bairro != null ? bairro : "");
                    medico.setLogradouro(rs.getString("logradouro"));
                    String complemento = rs.getString("complemento");
                    medico.setComplemento(complemento);
                    medico.setCrm(rs.getString("crm"));
                    medico.setSenha(rs.getString("senha"));
                    medico.setLogin(rs.getString("login"));
                    medicos.add(medico);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao recuperar médicos", e);
        }
        return medicos;
    }

    public void update(Medico medico) {
        String sql = "UPDATE medico SET nome = ?, fone1 = ?, fone2 = ?, email = ?, cpfCnpj = ?, " +
                     "rgInscricaoEstadual = ?, dataCadastro = ?, cep = ?, cidade = ?, bairro = ?, " +
                     "logradouro = ?, complemento = ?, crm = ?, senha = ?, login = ? WHERE id = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, medico.getNome());
            stmt.setString(2, medico.getFone1());
            stmt.setString(3, medico.getFone2());
            stmt.setString(4, medico.getEmail());
            stmt.setString(5, medico.getCpfCnpj());
            stmt.setString(6, medico.getRgInscricaoEstadual());
            stmt.setString(7, medico.getDataCadastro());
            stmt.setString(8, medico.getCep());
            stmt.setString(9, medico.getCidade());
            stmt.setString(10, medico.getBairro());
            stmt.setString(11, medico.getLogradouro());
            stmt.setString(12, medico.getComplemento());
            stmt.setString(13, medico.getCrm());
            stmt.setString(14, medico.getSenha());
            stmt.setString(15, medico.getLogin());
            stmt.setInt(16, medico.getId());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao atualizar médico", e);
        }
    }

    public void delete(int id) {
        String sql = "DELETE FROM medico WHERE id = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao excluir médico", e);
        }
    }
}