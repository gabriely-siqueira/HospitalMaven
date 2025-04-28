package model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
public class Fornecedor extends Pessoa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String nomeFantasia;

    @Column
    private String contato;

    public Fornecedor() {
    }

    public Fornecedor(int id, String nomeFantasia, String contato) {
        this.id = id;
        this.nomeFantasia = nomeFantasia;
        this.contato = contato;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    @Override
    public String toString() {
        return "Fornecedor \n" +
               "  ID: " + id + ",\n" +
               "  Nome Fantasia: '" + nomeFantasia + "',\n" +
               "  Contato: '" + contato + "'\n";
    }
}