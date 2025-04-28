package model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Pessoa implements Serializable {

    @Column
    private String nome;

    @Column
    private String fone1;

    @Column
    private String fone2;

    @Column
    private String email;

    @Column
    private String cpfCnpj;

    @Column
    private String rgInscricaoEstadual;

    @Column
    private String dataCadastro;

    @Column
    private String cep;

    @Column
    private String cidade;

    @Column
    private String bairro;

    @Column
    private String logradouro;

    @Column
    private String complemento;

    public Pessoa() {}

   public Pessoa(String nome, String fone1, String fone2, String email, String cpfCnpj,
              String rgInscricaoEstadual, String dataCadastro, String cep, String cidade,
              String bairro, String logradouro, String complemento) {
    this.nome = nome;
    this.fone1 = fone1;
    this.fone2 = fone2;
    this.email = email;
    this.cpfCnpj = cpfCnpj;
    this.rgInscricaoEstadual = rgInscricaoEstadual;
    this.dataCadastro = dataCadastro;
    this.cep = cep;
    this.cidade = cidade;
    this.bairro = bairro;
    this.logradouro = logradouro;
    this.complemento = complemento;
}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFone1() {
        return fone1;
    }

    public void setFone1(String fone1) {
        this.fone1 = fone1;
    }

    public String getFone2() {
        return fone2;
    }

    public void setFone2(String fone2) {
        this.fone2 = fone2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public String getRgInscricaoEstadual() {
        return rgInscricaoEstadual;
    }

    public void setRgInscricaoEstadual(String rgInscricaoEstadual) {
        this.rgInscricaoEstadual = rgInscricaoEstadual;
    }

    public String getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(String dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    @Override
    public String toString() {
        return "Pessoa: nome=" + nome + '}';
    }
}
