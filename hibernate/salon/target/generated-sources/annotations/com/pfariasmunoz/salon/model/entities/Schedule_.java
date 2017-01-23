package com.pfariasmunoz.salon.model.entities;

import java.time.LocalDateTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Schedule.class)
public abstract class Schedule_ {

	public static volatile SingularAttribute<Schedule, LocalDateTime> mFrom;
	public static volatile SingularAttribute<Schedule, Long> mId;
	public static volatile SingularAttribute<Schedule, LocalDateTime> mTo;

}

