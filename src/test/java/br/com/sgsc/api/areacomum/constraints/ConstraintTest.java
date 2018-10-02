package br.com.sgsc.api.areacomum.constraints;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.sgsc.api.areacomum.emuns.Situacao;
import br.com.sgsc.api.areacomum.ws.pojo.JsonAreaComum;

/**
 * Classe contendo os testes relacionados as Constraints - Bean Validate.
 * 
 * @author rfernandon
 * @since 01/10/2018
 * @version 1.0.0
 */
@RunWith(SpringRunner.class)
public class ConstraintTest {

	private static Validator validator;

	@BeforeClass
	public static void setUp() throws Exception {
		ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
		validator = validatorFactory.getValidator();
	}
	
	@Test
	public void testNotNull() throws Exception {
		
		JsonAreaComum areaComum = new JsonAreaComum();
		areaComum.setCodigo(null);
		areaComum.setDescricao(null);
		areaComum.setCapacidade(0);
		areaComum.setValorDiaria(0.);
		areaComum.setDhCadastro(null);
		areaComum.setHoraAbertura(null);
		areaComum.setHoraEncerramento(null);
		areaComum.setSituacao(null);
		
		Set<ConstraintViolation<JsonAreaComum>> violations = validator.validate(areaComum);
//		for (ConstraintViolation<?> violation : violations) {
//			String message = String.format("%s", violation.getMessage());
//			System.out.println(message);
//		}		
		assertEquals(7, violations.size());
	}

	@Test
	public void testLocalTimeRange() throws Exception {

		JsonAreaComum areaComum = new JsonAreaComum();
		areaComum.setCodigo("CODIGO");
		areaComum.setDescricao("DESCRICAODESCRICAO");
		areaComum.setCapacidade(100);
		areaComum.setValorDiaria(10.0);
		areaComum.setDhCadastro(LocalDateTime.now());
		areaComum.setHoraAbertura(LocalTime.of(23, 0));
		areaComum.setHoraEncerramento(LocalTime.of(22, 0));
		areaComum.setSituacao(Situacao.DISPONIVEL);

		Set<ConstraintViolation<JsonAreaComum>> violations = validator.validate(areaComum);
		assertEquals(1, violations.size());
	}
	
	@Test
	public void testSize() throws Exception {

		JsonAreaComum areaComum = new JsonAreaComum();
		areaComum.setDescricao("DESCRICAODESCRICAO");
		areaComum.setCapacidade(100);
		areaComum.setValorDiaria(null);
		areaComum.setDhCadastro(LocalDateTime.now());
		areaComum.setHoraAbertura(LocalTime.of(8, 0));
		areaComum.setHoraEncerramento(LocalTime.of(22, 0));
		areaComum.setSituacao(Situacao.DISPONIVEL);

		areaComum.setCodigo("0123456789");
		Set<ConstraintViolation<JsonAreaComum>> violations1 = validator.validate(areaComum);
		assertEquals(0, violations1.size());
		
		areaComum.setCodigo("012345678");
		Set<ConstraintViolation<JsonAreaComum>> violations2 = validator.validate(areaComum);
		assertEquals(0, violations2.size());
		
		areaComum.setCodigo("012345678901234567890");
		Set<ConstraintViolation<JsonAreaComum>> violations3 = validator.validate(areaComum);
		assertEquals(1, violations3.size());
	}
	
	@Test
	public void testPositiveOrZero() throws Exception {

		JsonAreaComum areaComum = new JsonAreaComum();
		areaComum.setCodigo("CODIGO");
		areaComum.setDescricao("DESCRICAODESCRICAO");
		areaComum.setDhCadastro(LocalDateTime.now());
		areaComum.setHoraAbertura(LocalTime.of(8, 0));
		areaComum.setHoraEncerramento(LocalTime.of(22, 0));
		areaComum.setSituacao(Situacao.DISPONIVEL);

		areaComum.setValorDiaria(-100.0);
		areaComum.setCapacidade(-100);
		Set<ConstraintViolation<JsonAreaComum>> violations1 = validator.validate(areaComum);
		assertEquals(2, violations1.size());
		
		areaComum.setValorDiaria(0.0);
		areaComum.setCapacidade(0);
		Set<ConstraintViolation<JsonAreaComum>> violations2 = validator.validate(areaComum);
		assertEquals(1, violations2.size());
	}
}
