package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2025-04-29T14:39:09")
@StaticMetamodel(Paciente.class)
public class Paciente_ extends Pessoa_ {

    public static volatile SingularAttribute<Paciente, Integer> id;
    public static volatile SingularAttribute<Paciente, String> nomeSocial;
    public static volatile SingularAttribute<Paciente, String> sexo;
    public static volatile SingularAttribute<Paciente, String> tipoSanguineo;

}