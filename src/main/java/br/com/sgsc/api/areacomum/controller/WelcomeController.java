package br.com.sgsc.api.areacomum.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Classe controller para lidar com requisições HTTP para a página Welcome.
 * 
 * @author rfernandon
 * @since 05/10/2018
 * @version 1.0.0
 */
@Controller
public class WelcomeController {
	
	@Value("${app.sgsc.name}")
	private String name;
	
	@Value("${app.sgsc.description}")
	private String description;
	
	@Value("${app.sgsc.version}")
	private String version;
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String getWelcome(Model model) {
		
        model.addAttribute("name", name);
        model.addAttribute("description", description);
        model.addAttribute("version", version);
        
        return "welcome";
    }
}
