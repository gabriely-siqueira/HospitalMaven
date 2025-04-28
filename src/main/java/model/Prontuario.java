package model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Prontuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String dataHoraVisita;

    @Column
    private String descricaoVisita;

    @Column
    private String observacao;

    @Column
    private String status;

    public Prontuario() {
    }

    public Prontuario(int id, String dataHoraVisita, String descricaoVisita, String observacao, String status) {
        this.id = id;
        this.dataHoraVisita = dataHoraVisita;
        this.descricaoVisita = descricaoVisita;
        this.observacao = observacao;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Prontuario{" +
               "id=" + id +
               ", dataHoraVisita='" + dataHoraVisita + '\'' +
               ", descricaoVisita='" + descricaoVisita + '\'' +
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

    public String getDataHoraVisita() {
        return dataHoraVisita;
    }

    public void setDataHoraVisita(String dataHoraVisita) {
        this.dataHoraVisita = dataHoraVisita;
    }

    public String getDescricaoVisita() {
        return descricaoVisita;
    }

    public void setDescricaoVisita(String descricaoVisita) {
        this.descricaoVisita = descricaoVisita;
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
