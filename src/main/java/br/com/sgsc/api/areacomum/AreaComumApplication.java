package br.com.sgsc.api.areacomum;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * Classe contendo o ponto de inicio da aplicação.
 * 
 * @author rfernandon
 * @since 01/10/2018
 * @version 1.0.0
 */
@SpringBootApplication
public class AreaComumApplication {

	private Log log = LogFactory.getLog(AreaComumApplication.class);
	
	@Value("${app.sgsc.name}")
	private String name;
	
	@Value("${app.sgsc.description}")
	private String description;
	
	@Value("${app.sgsc.version}")
	private String version;
	
	public static void main(String[] args) {
		SpringApplication.run(AreaComumApplication.class, args);
	}
	
	/**
	 * O método é chamado sempre que a aplicação do spring é executada.
	 * Utilizado para inicializar algum recurso.
	 * 
	 * A anotação @Bean informa ao spring que ele deve criar um componente.
	 * 
	 * @return
	 */
	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> {
			log.info("starting "+name+"...");
			log.info("====================================================================================");
			log.info(" ____   ____ ____   ____  ");
			log.info("/ ___| / ___/ ___| / ___| ");
			log.info("\\___ \\| |  _\\___ \\| |     ");
			log.info(" ___) | |_| |___) | |___  ");
			log.info("|____/ \\____|____/ \\____| [AREA COMUM - Version "+version+"]");
			log.info("");
			log.info(description);
			log.info("====================================================================================");
		};
	}
}
