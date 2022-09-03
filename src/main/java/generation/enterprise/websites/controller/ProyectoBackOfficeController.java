
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

	@Autowired
	private ProyectoService proyectoService;

	@PostMapping("/addproyecto")
	public String saveProyecto(Proyecto proyecto) {
		proyectoService.create(proyecto);
		return "redirect:/adminproyectos";
	}

	@GetMapping("/eliminarproyecto/{idproyecto}")
	public String deleteByIdProyecto(@PathVariable Integer idproyecto) {
		proyectoService.delete(idproyecto);
		return "redirect:/adminproyectos";

	}

	@GetMapping("/editarproyecto/{idproyecto}")
	public String editarProyecto(@PathVariable Integer idproyecto, Model m) {
		Proyecto p = proyectoService.findById(idproyecto);
		m.addAttribute("proyecto", p);
		return "proyectoModificar";
	}

	@Autowired
	private ProyectoService proyectoServiceUpdate;

	@PostMapping("/updateproyecto")
	public String updateProyecto(Proyecto proyecto) {
		proyectoServiceUpdate.update(proyecto);
		return "redirect:/adminproyectos";
	}

	@Autowired
	private ProyectoService proyectoAdmin;

	@GetMapping("/adminproyectos")
	public String getAdminProyectos(Model model) {
		model.addAttribute("listaProyectos", proyectoAdmin.findAll());
		return "adminproyectos";
	}

	@GetMapping("/proyectoAddNuevo")
	public String getAdminProyectoAddNuevo(Model model) {
		model.addAttribute("proyecto", new Proyecto());
		return "proyectoAddNuevo";
	}

}
