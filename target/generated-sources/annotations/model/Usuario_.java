package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2025-05-08T20:06:26")
@StaticMetamodel(Usuario.class)
public class Usuario_ extends Pessoa_ {

    public static volatile SingularAttribute<Usuario, String> senha;
    public static volatile SingularAttribute<Usuario, Integer> id;
    public static volatile SingularAttribute<Usuario, String> nomeSocial;
    public static volatile SingularAttribute<Usuario, String> login;

}