package br.com.sgsc.api.areacomum.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import br.com.sgsc.api.areacomum.entity.Condominio;

/**
 * Interface usada para representar o repository (DAO) da entidade "Condominio".
 * 
 * @author rfernandon
 * @since 01/10/2018
 * @version 1.0.0
 */
@Transactional(readOnly = true)
public interface CondominioRepository extends JpaRepository<Condominio, Integer> {
	
}
