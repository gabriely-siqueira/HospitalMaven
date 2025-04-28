package model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "pacientes")
public class Paciente extends Pessoa implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "tipo_sanguineo", length = 3)
    private String tipoSanguineo;

    @Column(length = 1)
    private String sexo;

    @Column(name = "nome_social", length = 100)
    private String nomeSocial;


    public Paciente() {
        // Construtor padrão exigido pelo JPA
    }

    public Paciente(int id, String nome, String fone1, String fone2, String email, 
                   String cpfCnpj, String rgInscricaoEstadual, String dataCadastro, 
                   String cep, String cidade, String bairro, String logradouro, 
                   String complemento, String tipoSanguineo, String sexo, String nomeSocial) {
        super(nome, fone1, fone2, email, cpfCnpj, rgInscricaoEstadual, 
              dataCadastro, cep, cidade, bairro, logradouro, complemento);
        this.tipoSanguineo = tipoSanguineo;
        this.sexo = sexo;
        this.nomeSocial = nomeSocial;
    }

    // Getters e Setters
    public String getTipoSanguineo() {
        return tipoSanguineo;
    }

    public void setTipoSanguineo(String tipoSanguineo) {
        this.tipoSanguineo = tipoSanguineo;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getNomeSocial() {
        return nomeSocial;
    }

    public void setNomeSocial(String nomeSocial) {
        this.nomeSocial = nomeSocial;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    

    @Override
    public String toString() {
        return "Paciente \n" +
               super.toString() + 
               "  Tipo Sanguíneo: '" + tipoSanguineo + "',\n" +
               "  Sexo: '" + sexo + "',\n" +
               "  Nome Social: '" + nomeSocial + "'\n";
    }
}