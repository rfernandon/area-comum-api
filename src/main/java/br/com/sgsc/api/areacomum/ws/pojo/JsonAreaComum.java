package br.com.sgsc.api.areacomum.ws.pojo;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import br.com.sgsc.api.areacomum.annotation.LocalTimeRange;
import br.com.sgsc.api.areacomum.emuns.Situacao;

/**
 * Classe usada para representar o JSON dos dados da "AreaComum".
 * 
 * @author rfernandon
 * @since 01/10/2018
 * @version 1.0.0
 */
@JsonRootName(value = "areaComum")
@LocalTimeRange(start="horaAbertura", end="horaEncerramento")
public class JsonAreaComum implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -4350381069765126399L;
	
	@JsonProperty("id")
	private Integer areaComumId;
	
	@NotNull(message="É necessário informar o código!")
	@Pattern(regexp="^[A-Za-z0-9]*$", message="O codigo deve conter apenas caracteres alfanumérico (números ou letras de A a Z)!")
	@Size(max=20, message="O codigo deve conter pelo menos 10 caracteres!")
	private String codigo;
	
	@NotNull(message="É necessário informar a descrição!")
	@Size(min=10, max=100, message="A descrição deve conter entre 10 a 100 caracteres!")
	private String descricao;
	
	@NotNull(message="É necessário informar a capacidade!")
	@Positive(message="A capacidade não pode ser negativa e deve ser maior que 1!")
	private Integer capacidade;
	
	@PositiveOrZero(message="O valor da diária não pode ser negativo!")
	private Double valorDiaria;
	
	@NotNull(message="É necessário informar a data de cadastro!")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy hh:mm")
	private LocalDateTime dhCadastro;
	
	@NotNull(message="É necessário informar a hora da abertura!")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "hh:mm")
	private LocalTime horaAbertura;
	
	@NotNull(message="É necessário informar a hora de encerramento!")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy hh:mm")
	private LocalTime horaEncerramento;
	
	@NotNull(message="É necessário informar a situacao da Area Comum!")
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
	public Double getValorDiaria() {
		return valorDiaria;
	}

	/**
	 * @param valorDiaria the valorDiaria to set
	 */
	public void setValorDiaria(Double valorDiaria) {
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
}
