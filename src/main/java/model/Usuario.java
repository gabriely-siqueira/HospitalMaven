package model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Usuario extends Pessoa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String login;

    @Column
    private String senha;

    @Column
    private String nomeSocial;

    public Usuario() {
    }

    public Usuario(int id, String login, String senha, String nomeSocial) {
        this.id = id;
        this.login = login;
        this.senha = senha;
        this.nomeSocial = nomeSocial;
    }

    @Override
    public String toString() {
        return "Usuario{" +
               "id=" + id +
               ", login='" + login + '\'' +
               ", senha='" + senha + '\'' +
               ", nomeSocial='" + nomeSocial + '\'' +
               '}';
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNomeSocial() {
        return nomeSocial;
    }

    public void setNomeSocial(String nomeSocial) {
        this.nomeSocial = nomeSocial;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
