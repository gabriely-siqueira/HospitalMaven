package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2025-05-08T20:06:26")
@StaticMetamodel(Paciente.class)
public class Paciente_ extends Pessoa_ {

    public static volatile SingularAttribute<Paciente, String> nome;
    public static volatile SingularAttribute<Paciente, Integer> id;
    public static volatile SingularAttribute<Paciente, String> sexo;
    public static volatile SingularAttribute<Paciente, String> tipoSanguineo;

}