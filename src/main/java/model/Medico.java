package model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Medico extends Pessoa implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String crm;

    @Column
    private String senha;

    @Column
    private String login;

    public Medico() {
        // Construtor padrão
    }

    public Medico(int id, String nome, String fone1, String fone2, String email, String cpfCnpj, 
              String rgInscricaoEstadual, String dataCadastro, String cep, String cidade, 
              String bairro, String logradouro, String complemento, String crm, 
              String senha, String login) {
    super(nome, fone1, fone2, email, cpfCnpj, rgInscricaoEstadual, dataCadastro, 
          cep, cidade, bairro, logradouro, complemento);
    this.id = id;
    this.crm = crm;
    this.senha = senha;
    this.login = login;
}

      public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public String toString() {
        return "Medico{" +
               "id=" + id + 
               ", nome=" + getNome() +
               ", fone=" + getFone1() +
               ", email=" + getEmail() +
               ", cpf=" + getCpfCnpj() +
               ", rg=" + getRgInscricaoEstadual() +
               ", cep=" + getCep() +
               ", cidade=" + getCidade() +
               ", bairro=" + getBairro() +
               ", logradouro=" + getLogradouro() +
               ", complemento=" + getComplemento() +
               ", crm=" + crm +
               ", senha=" + senha +
               ", login=" + login +
               '}';
    }
}
