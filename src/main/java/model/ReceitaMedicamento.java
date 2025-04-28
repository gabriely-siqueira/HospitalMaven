package model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ReceitaMedicamento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String prescricao;

    @Column
    private String status; // 

    public ReceitaMedicamento() {
    }

    public ReceitaMedicamento(int id, String prescricao, String staus) {
        this.id = id;
        this.prescricao = prescricao;
        this.status = staus;
    }

    @Override
    public String toString() {
        return "ReceitaMedicamento{" +
               "id=" + id +
               ", prescricao='" + prescricao + '\'' +
               ", staus='" + status + '\'' +
               '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPrescricao() {
        return prescricao;
    }

    public void setPrescricao(String prescricao) {
        this.prescricao = prescricao;
    }

    public String getStaus() {
        return status;
    }

    public void setStaus(String staus) {
        this.status = staus;
    }
}
