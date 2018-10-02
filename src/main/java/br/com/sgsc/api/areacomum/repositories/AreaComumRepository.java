package br.com.sgsc.api.areacomum.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sgsc.api.areacomum.entity.AreaComum;

/**
 * Interface usada para representar o repository (DAO) da entidade "AreaComum".
 * 
 * @author rfernandon
 * @since 01/10/2018
 * @version 1.0.0
 */
public interface AreaComumRepository extends JpaRepository<AreaComum, Integer> {

}
