
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

	@GetMapping("/adminpersonas")
	public String getAdminEquipo(Model model) {
		model.addAttribute("personas", personaService.findAll());
		return "adminpersonas";
	}

	@GetMapping("/equipoAddNuevo")
	public String getAdminEquipoAddNuevo(Model model) {
		model.addAttribute("persona", new Persona());
		return "equipoAddNuevo";
	}

	@PostMapping("/addpersona")
	public String savePersona(Persona persona) {
		personaService.create(persona);
		return "redirect:/adminequipo";
	}

	@GetMapping("/eliminarpersona/{idpersona}")
	public String deleteByIdPersona(@PathVariable Integer idpersona) {
		personaService.delete(idpersona);
		return "redirect:/adminequipo";

	}

	@GetMapping("/editarequipo/{idpersona}")
	public String editarEquipo(@PathVariable Integer idpersona, Model m) {
		Persona p = personaService.findById(idpersona);
		m.addAttribute("persona", p);
		return "equipoModificar";
	}

	@PostMapping("/updatepersona")
	public String updatePersona(Persona persona) {
		personaService.update(persona);
		return "redirect:/adminequipo";
	}

}
