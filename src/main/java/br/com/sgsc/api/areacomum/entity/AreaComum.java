package br.com.sgsc.api.areacomum.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.com.sgsc.api.areacomum.emuns.Situacao;

/**
 * Classe usada para representar a entidade "AreaComum" onde será guardada as informações da área comum do condomínio.
 * 
 * @author rfernandon
 * @since 22/09/2018
 * @version 1.0.0
 */
@Entity
@Table(name="area_comum")
@SequenceGenerator(name="areaComumSeq", sequenceName="area_omum_seq", allocationSize=1)
public class AreaComum implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -4350381069765126399L;
	
	@Id
	@Column(name="area_comum_id")
	@GeneratedValue(generator="areaComumSeq", strategy=GenerationType.SEQUENCE)
	private Integer areaComumId;
	
	@Column(length=20, nullable=true, unique=true)
	private String codigo;
	
	@Column(length=100, nullable=true)
	private String descricao;
	
	@Column
	private Integer capacidade;
	
	@Column(name="valor_diaria")
	private BigDecimal valorDiaria;
	
	@Column(name="dh_cadastro", nullable=true)
	private LocalDateTime dhCadastro;
	
	@Column(name="hora_abertura", nullable=true)
	private LocalTime horaAbertura;
	
	@Column(name="hora_encerramento", nullable=true)
	private LocalTime horaEncerramento;
	
	@Column(nullable=true)
	@Enumerated(EnumType.STRING)
	private Situacao situacao;
	
	/**
	 * @return the areaComumId
	 */
	public Integer getAreaComumId() {
		return areaComumId;
	}

	/**
	 * @param areaComumId the areaComumId to set
	 */
	public void setAreaComumId(Integer areaComumId) {
		this.areaComumId = areaComumId;
	}

	/**
	 * @return the codigo
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	/**
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * @param descricao the descricao to set
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	/**
	 * @return the capacidade
	 */
	public Integer getCapacidade() {
		return capacidade;
	}

	/**
	 * @param capacidade the capacidade to set
	 */
	public void setCapacidade(Integer capacidade) {
		this.capacidade = capacidade;
	}

	/**
	 * @return the valorDiaria
	 */
	public BigDecimal getValorDiaria() {
		return valorDiaria;
	}

	/**
	 * @param valorDiaria the valorDiaria to set
	 */
	public void setValorDiaria(BigDecimal valorDiaria) {
		this.valorDiaria = valorDiaria;
	}

	/**
	 * @return the dhCadastro
	 */
	public LocalDateTime getDhCadastro() {
		return dhCadastro;
	}

	/**
	 * @param dhCadastro the dhCadastro to set
	 */
	public void setDhCadastro(LocalDateTime dhCadastro) {
		this.dhCadastro = dhCadastro;
	}

	/**
	 * @return the horaAbertura
	 */
	public LocalTime getHoraAbertura() {
		return horaAbertura;
	}

	/**
	 * @param horaAbertura the horaAbertura to set
	 */
	public void setHoraAbertura(LocalTime horaAbertura) {
		this.horaAbertura = horaAbertura;
	}

	/**
	 * @return the horaEncerramento
	 */
	public LocalTime getHoraEncerramento() {
		return horaEncerramento;
	}

	/**
	 * @param horaEncerramento the horaEncerramento to set
	 */
	public void setHoraEncerramento(LocalTime horaEncerramento) {
		this.horaEncerramento = horaEncerramento;
	}

	/**
	 * @return the situacao
	 */
	public Situacao getSituacao() {
		return situacao;
	}

	/**
	 * @param situacao the situacao to set
	 */
	public void setSituacao(Situacao situacao) {
		this.situacao = situacao;
	}

	/**
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AreaComum [areaComumId=" + areaComumId + ", codigo=" + codigo + ", descricao=" + descricao
				+ ", capacidade=" + capacidade + ", valorDiaria=" + valorDiaria + ", situacao=" + situacao
				+ ", horaAbertura=" + horaAbertura + ", horaEncerramento=" + horaEncerramento + "]";
	}

	/**
	 * (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((areaComumId == null) ? 0 : areaComumId.hashCode());
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	/**
	 * (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		
		if (this == obj) { 
			return true; 
		}
		
		if (obj == null) { 
			return false; 
		}
		
		if (!(obj instanceof AreaComum)) { 
			return false; 
		}
		
		AreaComum other = (AreaComum) obj;
		
		return other.areaComumId.equals(this.areaComumId)
				&& other.codigo.equals(this.codigo);
	}
}
