package br.com.sgsc.api.areacomum.ws.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.sgsc.api.areacomum.exception.NotFoundException;
import br.com.sgsc.api.areacomum.exception.BeanValidationException;
import br.com.sgsc.api.areacomum.ws.pojo.ResponseDetails;

@RestController
@ControllerAdvice(basePackages = "br.com.sgsc.api.areacomum.ws.resource")
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(NotFoundException.class)
	public final ResponseEntity<ResponseDetails> handleAreaComumNotFoundException(NotFoundException ex, WebRequest request) {
		return new ResponseEntity<>(
				ResponseDetails.builder()
					.addTimestamp(new Date().getTime())
					.addStatusCode(HttpStatus.NOT_FOUND.value())
					.addStatusMessage(HttpStatus.NOT_FOUND.getReasonPhrase())
					.addMessage(ex.getMessage())
					.addPath(request.getDescription(false))
					.build(),
				HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(BeanValidationException.class)
	public final ResponseEntity<ResponseDetails> handleBeanValidationException(BeanValidationException ex, WebRequest request) {
		return new ResponseEntity<>(
				ResponseDetails.builder()
					.addTimestamp(new Date().getTime())
					.addStatusCode(HttpStatus.BAD_REQUEST.value())
					.addStatusMessage(HttpStatus.BAD_REQUEST.getReasonPhrase())
					.addMessage(ex.getMessage())
					.addValidations(ex.getErrors())
					.addPath(request.getDescription(false))
					.build(),
				HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ResponseDetails> handleAllExceptions(Exception ex, WebRequest request) {
		return new ResponseEntity<>(
				ResponseDetails.builder()
					.addTimestamp(new Date().getTime())
					.addStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
					.addStatusMessage(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase())
					.addMessage("Ocorreu um erro inesperado ao consumir o serviço ["+ex+"]")
					.addPath(request.getDescription(false))
					.build(),
				HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
