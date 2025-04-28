package model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
public class ConsultaExame implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String dataHoraExame;

    @Column
    private String analiseExame;

    @Column
    private String imagemExame;

    @Column
    private String status;

    public ConsultaExame() {
    }

    public ConsultaExame(int id, String dataHoraExame, String analiseExame, String imagemExame, String status) {
        this.id = id;
        this.dataHoraExame = dataHoraExame;
        this.analiseExame = analiseExame;
        this.imagemExame = imagemExame;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDataHoraExame() {
        return dataHoraExame;
    }

    public void setDataHoraExame(String dataHoraExame) {
        this.dataHoraExame = dataHoraExame;
    }

    public String getAnaliseExame() {
        return analiseExame;
    }

    public void setAnaliseExame(String analiseExame) {
        this.analiseExame = analiseExame;
    }

    public String getImagemExame() {
        return imagemExame;
    }

    public void setImagemExame(String imagemExame) {
        this.imagemExame = imagemExame;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ConsultaExame \n" +
               "  ID: " + id + ",\n" +
               "  Data/Hora: '" + dataHoraExame + "',\n" +
               "  Análise do Exame: '" + analiseExame + "',\n" +
               "  Imagem do Exame: '" + imagemExame + "',\n" +
               "  Status: '" + status + "'\n";
    }
}
