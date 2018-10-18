package br.com.sgsc.api.areacomum.repositories;

import java.util.List;

import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import br.com.sgsc.api.areacomum.entity.AreaComum;
import br.com.sgsc.api.areacomum.entity.Condominio;

/**
 * Interface usada para representar o repository (DAO) da entidade "AreaComum".
 * 
 * @author rfernandon
 * @since 01/10/2018
 * @version 1.0.0
 */
@Transactional(readOnly = true)
@NamedQueries({
		@NamedQuery(name = "AreaComumRepository.findByCondomino", 
				query = "FROM AreaComum a WHERE a.condomino = :condomino") })
public interface AreaComumRepository extends JpaRepository<AreaComum, Integer> {
	
	List<AreaComum> findByCondominio(@Param("condomino") Condominio condomino);
	
	Page<AreaComum> findByCondominio(@Param("condomino") Condominio condomino, Pageable pageable);
}
