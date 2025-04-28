package model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
public class Atendimento extends Pessoa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String dataHoraAtendimento;

    @Column
    private String pressao;

    @Column
    private String temperatura;

    @Column
    private int bpm;

    @Column
    private float oximetria;

    @Column
    private String historicoDeDoencas;

    @Column
    private String alergias;

    @Column
    private String medicacoesEmUso;

    @Column
    private String anamnese;

    @Column
    private String tipoAtendimento;

    @Column
    private String classificacao;

    @Column
    private String observacoes;

    @Column
    private String status;

    public Atendimento() {
    }

    public Atendimento(int id, String dataHoraAtendimento, String pressao, String temperatura, int bpm, float oximetria, String historicoDeDoencas, String alergias, String medicacoesEmUso, String anamnese, String tipoAtendimento, String classificacao, String observacoes, String status) {
        this.id = id;
        this.dataHoraAtendimento = dataHoraAtendimento;
        this.pressao = pressao;
        this.temperatura = temperatura;
        this.bpm = bpm;
        this.oximetria = oximetria;
        this.historicoDeDoencas = historicoDeDoencas;
        this.alergias = alergias;
        this.medicacoesEmUso = medicacoesEmUso;
        this.anamnese = anamnese;
        this.tipoAtendimento = tipoAtendimento;
        this.classificacao = classificacao;
        this.observacoes = observacoes;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDataHoraAtendimento() {
        return dataHoraAtendimento;
    }

    public void setDataHoraAtendimento(String dataHoraAtendimento) {
        this.dataHoraAtendimento = dataHoraAtendimento;
    }

    public String getPressao() {
        return pressao;
    }

    public void setPressao(String pressao) {
        this.pressao = pressao;
    }

    public String getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(String temperatura) {
        this.temperatura = temperatura;
    }

    public int getBpm() {
        return bpm;
    }

    public void setBpm(int bpm) {
        this.bpm = bpm;
    }

    public float getOximetria() {
        return oximetria;
    }

    public void setOximetria(float oximetria) {
        this.oximetria = oximetria;
    }

    public String getHistoricoDeDoencas() {
        return historicoDeDoencas;
    }

    public void setHistoricoDeDoencas(String historicoDeDoencas) {
        this.historicoDeDoencas = historicoDeDoencas;
    }

    public String getAlergias() {
        return alergias;
    }

    public void setAlergias(String alergias) {
        this.alergias = alergias;
    }

    public String getMedicacoesEmUso() {
        return medicacoesEmUso;
    }

    public void setMedicacoesEmUso(String medicacoesEmUso) {
        this.medicacoesEmUso = medicacoesEmUso;
    }

    public String getAnamnese() {
        return anamnese;
    }

    public void setAnamnese(String anamnese) {
        this.anamnese = anamnese;
    }

    public String getTipoAtendimento() {
        return tipoAtendimento;
    }

    public void setTipoAtendimento(String tipoAtendimento) {
        this.tipoAtendimento = tipoAtendimento;
    }

    public String getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(String classificacao) {
        this.classificacao = classificacao;
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
        return "Atendimento \n" +
               "  ID: " + id + ",\n" +
               "  Data/Hora: '" + dataHoraAtendimento + "',\n" +
               "  Pressão: '" + pressao + "',\n" +
               "  Temperatura: '" + temperatura + "',\n" +
               "  BPM: " + bpm + ",\n" +
               "  Oximetria: " + oximetria + ",\n" +
               "  Histórico de Doenças: '" + historicoDeDoencas + "',\n" +
               "  Alergias: '" + alergias + "',\n" +
               "  Medicações em Uso: '" + medicacoesEmUso + "',\n" +
               "  Anamnese: '" + anamnese + "',\n" +
               "  Tipo de Atendimento: '" + tipoAtendimento + "',\n" +
               "  Classificação: '" + classificacao + "',\n" +
               "  Observações: '" + observacoes + "',\n" +
               "  Status: '" + status + "'\n";
    }
}
