package br.com.sgsc.api.areacomum.ws.resource;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import br.com.sgsc.api.areacomum.entity.AreaComum;
import br.com.sgsc.api.areacomum.entity.Condominio;
import br.com.sgsc.api.areacomum.exception.BeanValidationException;
import br.com.sgsc.api.areacomum.service.AreaComumService;
import br.com.sgsc.api.areacomum.ws.pojo.JsonAreaComum;
import br.com.sgsc.api.areacomum.ws.pojo.ResponseDetails;

/**
 * Classe controller para lidar com requisições HTTP para os serviços disponibilizados
 * da API AreaComum.
 * 
 * @author rfernandon
 * @since 05/10/2018
 * @version 1.0.0
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api")
public class AreaComumResource {
	
	@Autowired
	AreaComumService service;
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("v1/areacomum/{id}")
	public ResponseEntity<JsonAreaComum> getAreaComum(@PathVariable("id") Integer id) {
		return ResponseEntity
				.ok()
				.body(JsonAreaComum.valueOf(service.findById(id)));
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("v1/areacomum/condominio/{id}")
	public ResponseEntity<List<JsonAreaComum>> getAreaComumList(@PathVariable("id") Integer id) {
		
		final Condominio condominio = service.findCondominioById(id);
		final List<AreaComum> areasComum = service.findAreaComumByCondominio(condominio);
		
		return ResponseEntity
				.ok()
				.body(JsonAreaComum.valueOf(areasComum));
	}
	
	/**
	 * 
	 * @param jsonAreaComum
	 * @param bindingResult - guarda todos os erros de validação que foram encontradas
	 * @return
	 * @throws URISyntaxException 
	 */
	@PostMapping("v1/areacomum/cadastrar")
	public ResponseEntity<JsonAreaComum> postAreaComum(@Valid @RequestBody JsonAreaComum jsonAreaComum, BindingResult bindingResult) 
			throws URISyntaxException {
		
		if(bindingResult.hasErrors()) {
			throw new BeanValidationException("Houve um erro de validação nos dados enviados!", 
					bindingResult.getAllErrors().stream().map(ObjectError::getDefaultMessage).collect(Collectors.toList()));
		}
		
		final AreaComum areaComum = service.save(jsonAreaComum);
		
		return ResponseEntity
				.created(new URI("v1/areacomum/"+areaComum.getAreaComumId()))
				.body(JsonAreaComum.valueOf(areaComum));
	}
	
	/**
	 * 
	 * @param id
	 * @param request
	 * @return
	 */
	@PutMapping("v1/areacomum/modificar")
	public ResponseEntity<JsonAreaComum> putAreaComum(@Valid @RequestBody JsonAreaComum jsonAreaComum, BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			throw new BeanValidationException("Houve um erro de validação nos dados enviados!", 
					bindingResult.getAllErrors().stream().map(ObjectError::getDefaultMessage).collect(Collectors.toList()));
		}
		
		AreaComum areaComum = service.findById(jsonAreaComum.getAreaComumId());
		areaComum = service.modify(jsonAreaComum, areaComum);
		
		return ResponseEntity
				.ok()
				.body(JsonAreaComum.valueOf(areaComum));
	}
	
	/**
	 * 
	 * @param id
	 * @param request
	 * @return
	 */
	@DeleteMapping("v1/areacomum/remover/{id}")
	public ResponseEntity<ResponseDetails> deleteAreaComum(@PathVariable("id") Integer id, WebRequest request) {
		
		final AreaComum areaComum = service.findById(id);
		service.remove(areaComum);
		
		return ResponseEntity
				.ok()
				.body(ResponseDetails.builder()
						.addTimestamp(new Date().getTime())
						.addStatusCode(HttpStatus.OK.value())
						.addStatusMessage(HttpStatus.OK.getReasonPhrase())
						.addMessage("A area comum foi removida com sucesso!")
						.addPath(request.getDescription(false))
						.build());
	}
}
