package br.com.sgsc.api.areacomum.constraints;

import java.time.LocalTime;
import java.util.logging.Level;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import br.com.sgsc.api.areacomum.annotation.LocalTimeRange;

/**
 * Classe usada para representar a constraint do intervalo entre os objetos LocalTime (start e end).
 * 
 * @author rfernandon
 * @since 01/10/2018
 * @version 1.0.0
 */
public class LocalTimeRangeConstraint extends CrossFieldValidation implements ConstraintValidator<LocalTimeRange, Object> {
	
	private String start;
	private String end;

	@Override
	public void initialize(LocalTimeRange constraint) {
		start = constraint.start();
		end = constraint.end();
	}

	@Override
	public boolean isValid(Object object, ConstraintValidatorContext constraintValidatorContext) {

		try {
			
			LocalTime startValue = (LocalTime) getFieldValue(object, start);
			LocalTime endValue = (LocalTime) getFieldValue(object, end);
			
			if(startValue == null && endValue == null) {
				return true;
			} else if((startValue != null && endValue == null) || startValue == null) {
				return false;
			}
			
			return startValue.isBefore(endValue);

		} catch (Exception e) {
			log.log(Level.SEVERE, "Captured Exception", e);
			return false;
		}
	}
}
