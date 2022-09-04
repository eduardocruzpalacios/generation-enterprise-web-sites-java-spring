
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

import generation.enterprise.websites.model.Proyecto;
import generation.enterprise.websites.service.ProyectoService;

@Controller
public class ProyectoBackOfficeController {

	private final String BASE_URL = "backoffice/";
	private final String REDIRECT_PROYECTOS = "redirect:/admin/proyectos";

	@Autowired
	private ProyectoService proyectoService;

	@PostMapping("/admin/proyectos/create")
	public String create(Proyecto proyecto) {
		proyectoService.create(proyecto);
		return REDIRECT_PROYECTOS;
	}

	@GetMapping("/admin/proyecto_create")
	public String createForm(Model model) {
		model.addAttribute("proyecto", new Proyecto());
		return BASE_URL + "proyecto_create";
	}

	@GetMapping("/admin/proyectos")
	public String findAll(Model model) {
		model.addAttribute("proyectos", proyectoService.findAll());
		return BASE_URL + "proyectos";
	}

	@GetMapping("/admin/proyectos/{id}")
	public String updateForm(@PathVariable int id, Model model) {
		Proyecto proyecto = proyectoService.findById(id);
		model.addAttribute("proyecto", proyecto);
		return BASE_URL + "proyecto_update";
	}

	@PostMapping("/admin/proyectos/update")
	public String update(Proyecto proyecto) {
		proyectoService.update(proyecto);
		return REDIRECT_PROYECTOS;
	}

	@GetMapping("/admin/proyectos/{id}/delete")
	public String delete(@PathVariable int id) {
		proyectoService.delete(id);
		return REDIRECT_PROYECTOS;

	}

}
