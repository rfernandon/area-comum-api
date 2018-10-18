package br.com.sgsc.api.areacomum.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Classe usada para representar a entidade "AreaComum" onde será guardada as informações da área comum do condomínio.
 * 
 * @author rfernandon
 * @since 22/09/2018
 * @version 1.0.0
 */
@Entity
@Table(name="condominio")
@SequenceGenerator(name="condominioSeq", sequenceName="condominio_seq", allocationSize=1)
public class Condominio implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -4350381069765126399L;
	
	@Id
	@Column(name="condominio_id")
	@GeneratedValue(generator="condominioSeq", strategy=GenerationType.SEQUENCE)
	private Integer condominioId;
	
	@OneToMany(mappedBy = "condominio", fetch=FetchType.LAZY)
	private List<AreaComum> areasComum;

	/**
	 * @return the condominioId
	 */
	public Integer getCondominioId() {
		return condominioId;
	}

	/**
	 * @param condominioId the condominioId to set
	 */
	public void setCondominioId(Integer condominioId) {
		this.condominioId = condominioId;
	}

	/**
	 * @return the areasComum
	 */
	public List<AreaComum> getAreasComum() {
		return areasComum;
	}

	/**
	 * @param areasComum the areasComum to set
	 */
	public void setAreasComum(List<AreaComum> areasComum) {
		this.areasComum = areasComum;
	}
	
	
}
