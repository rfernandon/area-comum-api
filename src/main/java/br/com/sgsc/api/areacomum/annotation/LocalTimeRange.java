package br.com.sgsc.api.areacomum.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import br.com.sgsc.api.areacomum.constraints.LocalTimeRangeConstraint;

/**
 * Annotation usada para representar a constraint LocalTimeRangeConstraint.
 * 
 * @author rfernandon
 * @since 01/10/2018
 * @version 1.0.0
 */
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = LocalTimeRangeConstraint.class)
public @interface LocalTimeRange {
	
	String message () default "{br.com.sgsc.api.areacomum.annotation.LocalTimeRange.message}";
	
	String start();
	String end();
	Class<?>[] groups () default {};
	Class<? extends Payload>[] payload () default {};

}
