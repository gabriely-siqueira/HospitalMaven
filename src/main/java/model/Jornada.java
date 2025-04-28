package model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "jornadas")
public class Jornada implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "data_inicial", nullable = false)
    private String dataInicial;

    @Column(name = "data_final")
    private String dataFinal;

    @Column(name = "carga_horaria", nullable = false, length = 10)
    private String cargaHoraria;

    // Relacionamentos (adicione conforme necessário)
    // @ManyToOne
    // @JoinColumn(name = "funcionario_id", nullable = false)
    // private Funcionario funcionario;

    public Jornada() {
    }

    public Jornada(int id, String dataInicial, String dataFinal, String cargaHoraria) {
        this.id = id;
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
        this.cargaHoraria = cargaHoraria;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(String dataInicial) {
        this.dataInicial = dataInicial;
    }

    public String getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(String dataFinal) {
        this.dataFinal = dataFinal;
    }

    public String getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(String cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    // Método corrigido para evitar duplicação
    public String getDataIncial() {
        return dataInicial;
    }

    public void setDataIncial(String dataIncial) {
        this.dataInicial = dataIncial;
    }

    @Override
    public String toString() {
        return "Jornada \n" +
               "  ID: " + id + ",\n" +
               "  Data Inicial: '" + dataInicial + "',\n" +
               "  Data Final: '" + dataFinal + "',\n" +
               "  Carga Horária: '" + cargaHoraria + "'\n";
    }
}