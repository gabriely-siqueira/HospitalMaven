package model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "laboratorio_medicamento")
public class LaboratorioMedicamento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "codigo_barras", unique = true, nullable = false, length = 50)
    private String codigoBarras;

    @Column(columnDefinition = "TEXT")
    private String observacao;

    @Column(nullable = false, length = 20)
    private String status;

    // Relationships (uncomment and implement as needed)
    // @ManyToOne
    // @JoinColumn(name = "laboratorio_id", nullable = false)
    // private Laboratorio laboratorio;
    
    // @ManyToOne
    // @JoinColumn(name = "medicamento_id", nullable = false)
    // private Medicamento medicamento;

    public LaboratorioMedicamento() {
    }

    public LaboratorioMedicamento(int id, String codigoBarras, String observacao, String status) {
        this.id = id;
        this.codigoBarras = codigoBarras;
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

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
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
        return "Laboratório Medicamento \n" +
               "  ID: " + id + ",\n" +
               "  Código de Barras: '" + codigoBarras + "',\n" +
               "  Observação: '" + observacao + "',\n" +
               "  Status: '" + status + "'\n";
    }
}