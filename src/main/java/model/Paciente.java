package model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "paciente")
public class Paciente extends Pessoa implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column 
    private String tipoSanguineo;

    @Column
    private String sexo;    
    
    @Column
    private String nome;


    public Paciente() {
        // Construtor padrão exigido pelo JPA
    }

    public Paciente(int id, String nome, String fone1, String fone2, String email, 
                   String cpfCnpj, String rgInscricaoEstadual, String dataCadastro, 
                   String cep, String cidade, String bairro, String logradouro, 
                   String complemento, String tipoSanguineo, String sexo) {
        super(nome, fone1, fone2, email, cpfCnpj, rgInscricaoEstadual, 
              dataCadastro, cep, cidade, bairro, logradouro, complemento);
        this.id = id;
        this.tipoSanguineo = tipoSanguineo;
        this.sexo = sexo;
    }

    // Getters e Setters
    public String getTipoSanguineo() {
        return tipoSanguineo;
    }

    public void setTipoSanguineo(String tipoSanguineo) {
        this.tipoSanguineo = tipoSanguineo;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Paciente{" +
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
               ", tipoSanguineo=" + tipoSanguineo +
               ", sexo=" + sexo +
               '}';
    }
}