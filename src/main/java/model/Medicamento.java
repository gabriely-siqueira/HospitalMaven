package model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "medicamentos")
public class Medicamento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "descricao", nullable = false, length = 100)
    private String descricaoMedicamento;

    @Column(name = "principio_ativo", nullable = false, length = 100)
    private String principioAtivo;

    @Column(name = "quantidade_minima", nullable = false)
    private float qtdMinima;

    @Column(nullable = false, length = 20)
    private String status;
    
    public Medicamento() {
    }

    public Medicamento(int id, String descricaoMedicamento, String principioAtivo, float qtdMinima, String status) {
        this.id = id;
        this.descricaoMedicamento = descricaoMedicamento;
        this.principioAtivo = principioAtivo;
        this.qtdMinima = qtdMinima;
        this.status = status;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricaoMedicamento() {
        return descricaoMedicamento;
    }

    public void setDescricaoMedicamento(String descricaoMedicamento) {
        this.descricaoMedicamento = descricaoMedicamento;
    }

    public String getPrincipioAtivo() {
        return principioAtivo;
    }

    public void setPrincipioAtivo(String principioAtivo) {
        this.principioAtivo = principioAtivo;
    }

    public float getQtdMinima() {
        return qtdMinima;
    }

    public void setQtdMinima(float qtdMinima) {
        this.qtdMinima = qtdMinima;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Medicamento \n" +
               "  ID: " + id + ",\n" +
               "  Descrição: '" + descricaoMedicamento + "',\n" +
               "  Princípio Ativo: '" + principioAtivo + "',\n" +
               "  Quantidade Mínima: " + qtdMinima + ",\n" +
               "  Status: '" + status + "'\n";
    }
}