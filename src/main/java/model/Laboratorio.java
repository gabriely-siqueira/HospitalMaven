package model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

    
@Entity
public class Laboratorio implements Serializable{
       
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String nomeFantasia;
    @Column
    private String contato;
    @Column
    private String status;
    
    public Laboratorio(){
        
   }

    public Laboratorio(int id, String nomeFantasia, String contato, String status) {
        this.id = id;
        this.nomeFantasia = nomeFantasia;
        this.contato = contato;
        this.status = status;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
public String toString() {
    return "Laboratorio \n" +
           "  ID: " + id + ",\n" +
           "  Nome Fantasia: '" + nomeFantasia + "',\n" +
           "  Contato: '" + contato + "',\n" +
           "  Status: '" + status + "'\n" ;
}
   
}
