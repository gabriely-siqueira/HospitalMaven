package model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
public class Enfermeiro extends Pessoa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String cre;

    @Column
    private String senha;

    @Column
    private String login;

    @Column
    private String nomeSocial;

    public Enfermeiro() {
    }

    public Enfermeiro(int id, String cre, String senha, String login, String nomeSocial) {
        this.id = id;
        this.cre = cre;
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

    public String getCre() {
        return cre;
    }

    public void setCre(String cre) {
        this.cre = cre;
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
        return "Enfermeiro \n" +
               "  ID: " + id + ",\n" +
               "  CRE: '" + cre + "',\n" +
               "  Login: '" + login + "',\n" +
               "  Nome Social: '" + nomeSocial + "',\n" +
               "  Senha: '" + senha + "'\n";
    }
}
