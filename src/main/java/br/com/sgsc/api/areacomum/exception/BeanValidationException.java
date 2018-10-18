package br.com.sgsc.api.areacomum.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.BAD_REQUEST)
public class BeanValidationException extends RuntimeException {
	
	private final List<String> errors;
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 455042045203413436L;

	public BeanValidationException(String exception) {
		super(exception);
		this.errors = new ArrayList<>();
	}
	
	public BeanValidationException(String exception, List<String> errors) {
		super(exception);
		this.errors = errors;
	}

	/**
	 * @return the errors
	 */
	public List<String> getErrors() {
		return errors;
	}
}
