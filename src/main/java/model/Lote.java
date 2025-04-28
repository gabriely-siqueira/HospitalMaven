package model;

import java.io.Serializable;
import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "lotes")
public class Lote implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 100)
    private String descricao;

    @Column(name = "data_fabricacao", nullable = false)
    private String dataFabricacao;

    @Column(name = "data_validade", nullable = false)
    private String dataValidade;

    @Column(nullable = false, length = 20)
    private String status;

    // Relationships (uncomment and implement as needed)
    // @ManyToOne
    // @JoinColumn(name = "medicamento_id", nullable = false)
    // private Medicamento medicamento;

    // @OneToMany(mappedBy = "lote")
    // private List<ItemEstoque> itensEstoque;

    public Lote() {
    }

    public Lote(int id, String descricao, String dataFabricacao, String dataValidade, String status) {
        this.id = id;
        this.descricao = descricao;
        this.dataFabricacao = dataFabricacao;
        this.dataValidade = dataValidade;
        this.status = status;
    }

    // Getters and Setters
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

    public String getDataFabricacao() {
        return dataFabricacao;
    }

    public void setDataFabricacao(String dataFabricacao) {
        this.dataFabricacao = dataFabricacao;
    }

    public String getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(String dataValidade) {
        this.dataValidade = dataValidade;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Lote \n" +
               "  ID: " + id + ",\n" +
               "  Descrição: '" + descricao + "',\n" +
               "  Data Fabricação: '" + dataFabricacao + "',\n" +
               "  Data Validade: '" + dataValidade + "',\n" +
               "  Status: '" + status + "'\n";
    }
}