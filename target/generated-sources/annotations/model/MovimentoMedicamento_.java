package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2025-05-08T19:25:07")
@StaticMetamodel(MovimentoMedicamento.class)
public class MovimentoMedicamento_ { 

    public static volatile SingularAttribute<MovimentoMedicamento, String> observacao;
    public static volatile SingularAttribute<MovimentoMedicamento, Float> qtdMedicamento;
    public static volatile SingularAttribute<MovimentoMedicamento, String> dataHoraMovimento;
    public static volatile SingularAttribute<MovimentoMedicamento, Integer> id;
    public static volatile SingularAttribute<MovimentoMedicamento, String> tipoMovimento;
    public static volatile SingularAttribute<MovimentoMedicamento, String> status;

}