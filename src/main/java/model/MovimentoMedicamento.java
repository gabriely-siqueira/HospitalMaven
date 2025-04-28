package model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "movimento_medicamento")
public class MovimentoMedicamento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "data_hora_movimento", nullable = false)
    private String dataHoraMovimento;

    @Column(name = "tipo_movimento", nullable = false, length = 20)
    private String tipoMovimento;

    @Column(name = "quantidade_medicamento", nullable = false)
    private float qtdMedicamento;

    @Column(columnDefinition = "TEXT")
    private String observacao;

    @Column(nullable = false, length = 20)
    private String status;

    // Relationships (uncomment and implement as needed)
    // @ManyToOne
    // @JoinColumn(name = "medicamento_id", nullable = false)
    // private Medicamento medicamento;
    
    // @ManyToOne
    // @JoinColumn(name = "usuario_id", nullable = false)
    // private Usuario usuario;

    public MovimentoMedicamento() {
    }

    public MovimentoMedicamento(int id, String dataHoraMovimento, String tipoMovimento, 
                              float qtdMedicamento, String observacao, String status) {
        this.id = id;
        this.dataHoraMovimento = dataHoraMovimento;
        this.tipoMovimento = tipoMovimento;
        this.qtdMedicamento = qtdMedicamento;
        this.observacao = observacao;
        this.status = status;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDataHoraMovimento() {
        return dataHoraMovimento;
    }

    public void setDataHoraMovimento(String dataHoraMovimento) {
        this.dataHoraMovimento = dataHoraMovimento;
    }

    public String getTipoMovimento() {
        return tipoMovimento;
    }

    public void setTipoMovimento(String tipoMovimento) {
        this.tipoMovimento = tipoMovimento;
    }

    public float getQtdMedicamento() {
        return qtdMedicamento;
    }

    public void setQtdMedicamento(float qtdMedicamento) {
        this.qtdMedicamento = qtdMedicamento;
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
        return "Movimento de Medicamento \n" +
               "  ID: " + id + ",\n" +
               "  Data/Hora: '" + dataHoraMovimento + "',\n" +
               "  Tipo: '" + tipoMovimento + "',\n" +
               "  Quantidade: " + qtdMedicamento + ",\n" +
               "  Status: '" + status + "',\n" +
               "  Observação: '" + observacao + "'\n";
    }
}