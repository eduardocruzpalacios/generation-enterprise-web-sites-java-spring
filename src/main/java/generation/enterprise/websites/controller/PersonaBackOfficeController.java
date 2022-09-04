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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import generation.enterprise.websites.model.Persona;
import generation.enterprise.websites.service.PersonaService;

@Controller
public class PersonaBackOfficeController {

	@Autowired
	private PersonaService personaService;

	private final String BASE_URL = "backoffice/";
	private final String REDIRECT_PERSONAS = "redirect:/admin/personas";

	@PostMapping("/admin/personas/create")
	public String create(Persona persona) {
		personaService.create(persona);
		return REDIRECT_PERSONAS;
	}

	@GetMapping("/admin/persona_create")
	public String createForm(Model model) {
		model.addAttribute("persona", new Persona());
		return BASE_URL + "persona_create";
	}

	@GetMapping("/admin/personas")
	public String findAll(Model model) {
		model.addAttribute("personas", personaService.findAll());
		return BASE_URL + "personas";
	}

	@GetMapping("/admin/personas/{id}")
	public String updateForm(@PathVariable int id, Model model) {
		Persona persona = personaService.findById(id);
		model.addAttribute("persona", persona);
		return BASE_URL + "persona_update";
	}

	@PostMapping("/admin/personas/update")
	public String updatePersona(Persona persona) {
		personaService.update(persona);
		return REDIRECT_PERSONAS;
	}

	@GetMapping("/admin/personas/{id}/delete")
	public String delete(@PathVariable int id) {
		personaService.delete(id);
		return REDIRECT_PERSONAS;
	}

}
