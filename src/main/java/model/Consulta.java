package model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
public class Consulta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String responsavel;

    @Column
    private String dataHoraConsulta;

    @Column
    private String anamnese;

    @Column
    private String diagnostico;

    @Column
    private String prescricao;

    @Column
    private String observacoes;

    @Column
    private String status;

    public Consulta() {
    }

    public Consulta(int id, String responsavel, String dataHoraConsulta, String anamnese, String diagnostico, String prescricao, String observacoes, String status) {
        this.id = id;
        this.responsavel = responsavel;
        this.dataHoraConsulta = dataHoraConsulta;
        this.anamnese = anamnese;
        this.diagnostico = diagnostico;
        this.prescricao = prescricao;
        this.observacoes = observacoes;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public String getDataHoraConsulta() {
        return dataHoraConsulta;
    }

    public void setDataHoraConsulta(String dataHoraConsulta) {
        this.dataHoraConsulta = dataHoraConsulta;
    }

    public String getAnamnese() {
        return anamnese;
    }

    public void setAnamnese(String anamnese) {
        this.anamnese = anamnese;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getPrescricao() {
        return prescricao;
    }

    public void setPrescricao(String prescricao) {
        this.prescricao = prescricao;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Consulta \n" +
               "  ID: " + id + ",\n" +
               "  Responsável: '" + responsavel + "',\n" +
               "  Data/Hora: '" + dataHoraConsulta + "',\n" +
               "  Anamnese: '" + anamnese + "',\n" +
               "  Diagnóstico: '" + diagnostico + "',\n" +
               "  Prescrição: '" + prescricao + "',\n" +
               "  Observações: '" + observacoes + "',\n" +
               "  Status: '" + status + "'\n";
    }
}
