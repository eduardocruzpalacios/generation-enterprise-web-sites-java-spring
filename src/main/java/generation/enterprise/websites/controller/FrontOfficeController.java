
/*

*Fecha: 14/05/2021

*@Author NextoMarket

*@Version 1.0

*

*/
package generation.enterprise.websites.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import generation.enterprise.websites.service.PersonaService;
import generation.enterprise.websites.service.ProyectoService;

@Controller
public class FrontOfficeController {

	@Autowired
	private PersonaService personaService;

	@Autowired
	private ProyectoService proyectoService;

	private final String BASE_URL = "frontoffice/";

	@GetMapping("/home")
	public String getHome() {
		return BASE_URL + "home";
	}

	@GetMapping("/equipo")
	public String getEquipo(Model model) {
		model.addAttribute("personas", personaService.findAll());
		return BASE_URL + "equipo";
	}

	@GetMapping("/proyectos")
	public String getProyectos(Model model) {
		model.addAttribute("proyectos", proyectoService.findAll());
		return BASE_URL + "proyectos";
	}

	@GetMapping("/trabaja")
	public String getTrabaja() {
		return BASE_URL + "trabaja";
	}

	@GetMapping("/contacto")
	public String getContacto() {
		return BASE_URL + "contacto";
	}

}
