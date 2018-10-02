package br.com.sgsc.api.areacomum.constraints;

import java.lang.reflect.Field;
import java.util.logging.Logger;

/**
 * Classe abstrata usada para disponibilizar métodos defaults para as constraints usando 
 * Cross Parameter Constraints - Bean Validation.
 * 
 * @author rfernandon
 * @since 01/10/2018
 * @version 1.0.0
 */
public abstract class CrossFieldValidation {
	
	Logger log = Logger.getLogger(CrossFieldValidation.class.getName());
	
	/**
	 * Método utilizado para recuperar o valor de uma propriedade.
	 * 
	 * @param object
	 * @param fieldName
	 * @return
	 * @throws NoSuchFieldException
	 * @throws IllegalAccessException
	 */
	Object getFieldValue(Object object, String fieldName) throws NoSuchFieldException, IllegalAccessException {
		Class<?> clazz = object.getClass();
		Field passwordField = clazz.getDeclaredField(fieldName);
		passwordField.setAccessible(true);
		return passwordField.get(object);
	}
}
