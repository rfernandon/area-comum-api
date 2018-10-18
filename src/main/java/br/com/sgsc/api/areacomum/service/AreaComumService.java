package br.com.sgsc.api.areacomum.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import br.com.sgsc.api.areacomum.entity.AreaComum;
import br.com.sgsc.api.areacomum.entity.Condominio;
import br.com.sgsc.api.areacomum.exception.NotFoundException;
import br.com.sgsc.api.areacomum.repositories.AreaComumRepository;
import br.com.sgsc.api.areacomum.repositories.CondominioRepository;
import br.com.sgsc.api.areacomum.ws.pojo.JsonAreaComum;

/**
 * Classe service contendo a regra de negócio para uma AreaComum.
 * 
 * @author rfernandon
 * @since 05/10/2018
 * @version 1.0.0
 */
@Service
public class AreaComumService {
	
	AreaComumRepository areaComumRepository;
	
	CondominioRepository condominioRepository;

	public AreaComum findById(Integer id) {
		
		Optional<AreaComum> areaComum = areaComumRepository.findById(id);
		if(!areaComum.isPresent()) {
			throw new NotFoundException("A área comum não foi localizada.");
		}
		
		return areaComum.get();
	}
	
	public Condominio findCondominioById(Integer id) {
		
		Optional<Condominio> condominio = condominioRepository.findById(id);
		if(!condominio.isPresent()) {
			throw new NotFoundException("O condomínio não foi localizado.");
		}
		
		return condominio.get();
	}
	
	public List<AreaComum> findAreaComumByCondominio(Condominio condominio) {
		
		List<AreaComum> areasComum = areaComumRepository.findByCondominio(condominio);
		if(areasComum.isEmpty()) {
			throw new NotFoundException("A área comum não foi localizada.");
		}
		
		return areasComum;
	}
	
	
	
	
	
	
	
	
	

	public AreaComum save(@Valid JsonAreaComum jsonAreaComum) {
		// TODO Auto-generated method stub
		return null;
	}

	public AreaComum modify(@Valid JsonAreaComum jsonAreaComum, AreaComum areaComum) {
		// TODO Auto-generated method stub
		return null;
	}

	public void remove(AreaComum areaComum) {
		// TODO Auto-generated method stub
		
	}

	

}
