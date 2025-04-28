package model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
public class Farmaceutico extends Pessoa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true)
    private String cpf;

    @Column
    private String senha;

    @Column(unique = true)
    private String login;

    @Column
    private String nomeSocial;

    public Farmaceutico() {
    }

    public Farmaceutico(int id, String cpf, String senha, String login, String nomeSocial) {
        this.id = id;
        this.cpf = cpf;
        this.senha = senha;
        this.login = login;
        this.nomeSocial = nomeSocial;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
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

    public String getNomeSocial() {
        return nomeSocial;
    }

    public void setNomeSocial(String nomeSocial) {
        this.nomeSocial = nomeSocial;
    }

    @Override
    public String toString() {
        return "Farmacêutico \n" +
               "  ID: " + id + ",\n" +
               "  CPF: '" + cpf + "',\n" +
               "  Login: '" + login + "',\n" +
               "  Nome Social: '" + nomeSocial + "',\n" +
               "  Senha: '" + senha + "'\n";
    }
}