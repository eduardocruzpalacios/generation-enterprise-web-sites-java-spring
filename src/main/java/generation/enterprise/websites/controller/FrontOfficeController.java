
/*

*Fecha: 14/05/2021

*@Author NextoMarket

*@Version 1.0

*

*/
package generation.enterprise.websites.controller;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import generation.enterprise.websites.model.Cliente;
import generation.enterprise.websites.model.Mensaje;
import generation.enterprise.websites.model.Persona;
import generation.enterprise.websites.model.Proyecto;
import generation.enterprise.websites.service.ClienteService;
import generation.enterprise.websites.service.MensajeService;
import generation.enterprise.websites.service.PersonaFakeService;
import generation.enterprise.websites.service.PersonaService;
import generation.enterprise.websites.service.ProyectoService;

@Controller
public class FrontOfficeController {

	private final String BASE_URL = "./frontoffice/";
	private final String REDIRECT_PROYECTOS = "redirect:/proyectos";

	@Autowired
	private PersonaService personaService;

	@Autowired
	private ProyectoService proyectoService;

	@Autowired
	private MensajeService mensajeService;

	@Autowired
	private ClienteService clienteService;

	@GetMapping("/home")
	public String getHome() {
		return BASE_URL + "home";
	}

	@GetMapping("/equipo")
	public String getEquipo(Model model) {
		List<Persona> realPersonas = personaService.findAll();
		List<Persona> fakePersonas = PersonaFakeService.createPersonas(4);
		List<Persona> personas = new ArrayList<Persona>();
		realPersonas.forEach(e -> personas.add(e));
		fakePersonas.forEach(e -> personas.add(e));
		model.addAttribute("personas", personas);
		return BASE_URL + "equipo";
	}

	@GetMapping("/proyectos")
	public String getProyectos(Model model) {
		model.addAttribute("proyectos", proyectoService.findAll());
		model.addAttribute("clientes", clienteService.findAll());
		model.addAttribute("cliente", new Cliente());
		return BASE_URL + "proyectos";
	}

	@GetMapping("/proyectos/cliente")
	public String getProyectosByCliente(@RequestParam int idcliente, Model model) {
		if (idcliente == 0) {
			return REDIRECT_PROYECTOS;
		} else {
			List<Proyecto> proyectos = proyectoService.findByCliente(idcliente);
			model.addAttribute("proyectos", proyectos);
			model.addAttribute("clientes", clienteService.findAll());
			Cliente cliente = new Cliente();
			cliente.setIdcliente(idcliente);
			model.addAttribute("cliente", cliente);
			return BASE_URL + "proyectos";
		}
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
