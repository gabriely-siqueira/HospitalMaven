package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2025-04-28T16:18:31")
@StaticMetamodel(Atendimento.class)
public class Atendimento_ extends Pessoa_ {

    public static volatile SingularAttribute<Atendimento, Float> oximetria;
    public static volatile SingularAttribute<Atendimento, String> alergias;
    public static volatile SingularAttribute<Atendimento, String> dataHoraAtendimento;
    public static volatile SingularAttribute<Atendimento, String> observacoes;
    public static volatile SingularAttribute<Atendimento, String> historicoDeDoencas;
    public static volatile SingularAttribute<Atendimento, String> pressao;
    public static volatile SingularAttribute<Atendimento, String> classificacao;
    public static volatile SingularAttribute<Atendimento, Integer> id;
    public static volatile SingularAttribute<Atendimento, String> anamnese;
    public static volatile SingularAttribute<Atendimento, String> temperatura;
    public static volatile SingularAttribute<Atendimento, String> medicacoesEmUso;
    public static volatile SingularAttribute<Atendimento, Integer> bpm;
    public static volatile SingularAttribute<Atendimento, String> tipoAtendimento;
    public static volatile SingularAttribute<Atendimento, String> status;

}