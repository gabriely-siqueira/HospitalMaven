package model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
public class Internacao implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "data_internacao")
    private String dataInternacao;

    @Column(name = "hora_internacao")
    private String horaInternacao;

    @Column(name = "data_alta")
    private String dataAlta;

    @Column(name = "hora_alta")
    private String horaAlta;

    @Column(columnDefinition = "TEXT")
    private String observacao;

    @Column
    private String status;

    // Relacionamentos (adicione conforme necessário)
    // @ManyToOne
    // @JoinColumn(name = "paciente_id")
    // private Paciente paciente;
    
    // @ManyToOne
    // @JoinColumn(name = "medico_id")
    // private Medico medico;

    public Internacao() {
    }

    public Internacao(int id, String dataInternacao, String horaInternacao, 
                     String dataAlta, String horaAlta, String observacao, String status) {
        this.id = id;
        this.dataInternacao = dataInternacao;
        this.horaInternacao = horaInternacao;
        this.dataAlta = dataAlta;
        this.horaAlta = horaAlta;
        this.observacao = observacao;
        this.status = status;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDataInternacao() {
        return dataInternacao;
    }

    public void setDataInternacao(String dataInternacao) {
        this.dataInternacao = dataInternacao;
    }

    public String getHoraInternacao() {
        return horaInternacao;
    }

    public void setHoraInternacao(String horaInternacao) {
        this.horaInternacao = horaInternacao;
    }

    public String getDataAlta() {
        return dataAlta;
    }

    public void setDataAlta(String dataAlta) {
        this.dataAlta = dataAlta;
    }

    public String getHoraAlta() {
        return horaAlta;
    }

    public void setHoraAlta(String horaAlta) {
        this.horaAlta = horaAlta;
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

    @Override
    public String toString() {
        return "Internação \n" +
               "  ID: " + id + ",\n" +
               "  Data Internação: '" + dataInternacao + "',\n" +
               "  Hora Internação: '" + horaInternacao + "',\n" +
               "  Data Alta: '" + dataAlta + "',\n" +
               "  Hora Alta: '" + horaAlta + "',\n" +
               "  Observação: '" + observacao + "',\n" +
               "  Status: '" + status + "'\n";
    }
}