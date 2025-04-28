package model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
public class Exame implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String tituloExame;

    @Column
    private String tipoExame;

    @Column
    private String status;

    public Exame() {
    }

    public Exame(int id, String tituloExame, String tipoExame, String status) {
        this.id = id;
        this.tituloExame = tituloExame;
        this.tipoExame = tipoExame;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTituloExame() {
        return tituloExame;
    }

    public void setTituloExame(String tituloExame) {
        this.tituloExame = tituloExame;
    }

    public String getTipoExame() {
        return tipoExame;
    }

    public void setTipoExame(String tipoExame) {
        this.tipoExame = tipoExame;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Exame \n" +
               "  ID: " + id + ",\n" +
               "  Título: '" + tituloExame + "',\n" +
               "  Tipo: '" + tipoExame + "',\n" +
               "  Status: '" + status + "'\n";
    }
}