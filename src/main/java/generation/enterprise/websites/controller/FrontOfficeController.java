
/*

*Fecha: 14/05/2021

*@Author NextoMarket

*@Version 1.0

*

*/
package generation.enterprise.websites.controller;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import generation.enterprise.websites.model.Mensaje;
import generation.enterprise.websites.service.MensajeService;
import generation.enterprise.websites.service.PersonaService;
import generation.enterprise.websites.service.ProyectoService;

@Controller
public class FrontOfficeController {

	private final String BASE_URL = "frontoffice/";

	@Autowired
	private PersonaService personaService;

	@Autowired
	private ProyectoService proyectoService;

	@Autowired
	private MensajeService mensajeService;

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
	public String getContacto(Model model) {
		model.addAttribute("mensaje", new Mensaje());
		return BASE_URL + "contacto";
	}

	@PostMapping("/mensajes/create")
	public String createMensaje(Mensaje mensaje) {
		LocalDateTime now = LocalDateTime.now();
		mensaje.setFecha(Timestamp.valueOf(now));
		mensaje.setRespuesta("");
		mensajeService.create(mensaje);
		return BASE_URL + "contacto";
	}

}
