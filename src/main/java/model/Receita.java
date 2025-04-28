package model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Receita implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String dataHoraReceita;

    @Column
    private String observacao;

    @Column
    private String status;

    public Receita() {
    }

    public Receita(int id, String dataHoraReceita, String observacao, String status) {
        this.id = id;
        this.dataHoraReceita = dataHoraReceita;
        this.observacao = observacao;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Receita{" +
               "id=" + id +
               ", dataHoraReceita='" + dataHoraReceita + '\'' +
               ", observacao='" + observacao + '\'' +
               ", status='" + status + '\'' +
               '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDataHoraReceita() {
        return dataHoraReceita;
    }

    public void setDataHoraReceita(String dataHoraReceita) {
        this.dataHoraReceita = dataHoraReceita;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
