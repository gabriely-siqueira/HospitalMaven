package model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "internacao_leito")
public class InternacaoLeito implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "data_hora_alocacao", nullable = false)
    private String dataHoraAlocacao;

    @Column(name = "data_hora_desocupacao")
    private String dataHoraDesocupacao;

    @Column(nullable = false)
    private String status;

    // Relacionamentos (adicione conforme necessário)
    // @ManyToOne
    // @JoinColumn(name = "internacao_id", nullable = false)
    // private Internacao internacao;
    
    // @ManyToOne
    // @JoinColumn(name = "leito_id", nullable = false)
    // private Leito leito;

    public InternacaoLeito() {
    }

    public InternacaoLeito(int id, String dataHoraAlocacao, String dataHoraDesocupacao, String status) {
        this.id = id;
        this.dataHoraAlocacao = dataHoraAlocacao;
        this.dataHoraDesocupacao = dataHoraDesocupacao;
        this.status = status;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDataHoraAlocacao() {
        return dataHoraAlocacao;
    }

    public void setDataHoraAlocacao(String dataHoraAlocacao) {
        this.dataHoraAlocacao = dataHoraAlocacao;
    }

    public String getDataHoraDesocupacao() {
        return dataHoraDesocupacao;
    }

    public void setDataHoraDesocupacao(String dataHoraDesocupacao) {
        this.dataHoraDesocupacao = dataHoraDesocupacao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Internação Leito \n" +
               "  ID: " + id + ",\n" +
               "  Data/Hora Alocação: '" + dataHoraAlocacao + "',\n" +
               "  Data/Hora Desocupação: '" + dataHoraDesocupacao + "',\n" +
               "  Status: '" + status + "'\n";
    }
}