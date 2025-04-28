package model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Quarto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String descricao;

    @Column
    private String status;

    @ManyToOne
    @JoinColumn(name = "idAla") 
    private Ala ala;

    public Quarto() {
    }

    public Quarto(int id, String descricao, String status, Ala ala) {
        this.id = id;
        this.descricao = descricao;
        this.status = status;
        this.ala = ala;
    }

    @Override
    public String toString() {
        return "Quarto{" +
               "id=" + id +
               ", descricao='" + descricao + '\'' +
               ", status='" + status + '\'' +
               ", ala=" + (ala != null ? ala.getDescricao() : "Nenhuma") +
               '}';
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

    public Ala getAla() {
        return ala;
    }

    public void setAla(Ala ala) {
        this.ala = ala;
    }
}
