package model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
public class Ala implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String descricao;

    @Column
    private String status;

    public Ala() {
    }

    public Ala(int id, String descricao, String status) {
        this.id = id;
        this.descricao = descricao;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Ala \n" +
               "  ID: " + id + ",\n" +
               "  Descrição: '" + descricao + "',\n" +
               "  Status: '" + status + "'\n";
    }
}
