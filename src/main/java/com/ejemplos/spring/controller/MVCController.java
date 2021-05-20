
/*

*Fecha: 14/05/2021

*@Author NextoMarket

*@Version 1.0

*

*/
package com.ejemplos.spring.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.ejemplos.spring.model.Persona;
import com.ejemplos.spring.model.Proyecto;
import com.ejemplos.spring.service.PersonaService;
import com.ejemplos.spring.service.ProyectoService;

@Controller
public class MVCController {

	private static final Logger log = LoggerFactory.getLogger(MVCController.class);

	// EQUIPO---------------------------------------

	@Autowired
	private PersonaService personaService;

	// AÑADIR PERSONA
	@PostMapping("/addpersona")
	public String savePersona(Persona persona) {
		// log.info("----" + personaService.saveAdd(persona));
		personaService.saveAdd(persona);
		return "redirect:/adminequipo";
	}

	// ELIMINAR PERSONA
	@GetMapping("/eliminarpersona/{idpersona}")
	public String deleteByIdPersona(@PathVariable Integer idpersona) {
		personaService.deleteById(idpersona);
		return "redirect:/adminequipo";

	}

	// EDITAR PERSONA
	@GetMapping("/editarequipo")
	public String updatePersona(Persona persona) {
		personaService.saveUpdate(persona);
		return "redirect:/adminequipo";
	}

	// PROYECTO----------------------------------------

	@Autowired
	private ProyectoService proyectoService;

	// AÑADIR PROYECTO
	@PostMapping("/addproyecto")
	public String saveProyecto(Proyecto proyecto) {
		log.info("proyectoService.saveAdd(proyecto)");
		proyectoService.saveAdd(proyecto);
		return "redirect:/adminproyectos";
	}

	// ELIMINAR PROYECTO
	@GetMapping("/eliminarproyecto/{idproyecto}")
	public String deleteByIdProyecto(@PathVariable Integer idproyecto) {
		proyectoService.deleteById(idproyecto);
		return "redirect:/adminproyectos";

	}

	// EDITAR PROYECTO
	@GetMapping("/editarproyecto/{idproyecto}")
	public String editarProyecto(@PathVariable Integer idproyecto, Model m) {
		Proyecto p = proyectoService.findById(idproyecto);
		m.addAttribute("proyecto", p);
		return "proyectoModificar";
	}
	
	@PutMapping("/updateProyecto")
	public String updateProyecto(Proyecto proyecto) {
		log.info("proyectoService.saveAdd(proyecto)");
		proyectoService.saveAdd(proyecto);
		return "redirect:/adminproyectos";
	}

	// ADMINISTRACION---------------------------------------

	@GetMapping("/admin")
	public String getAdmin() {
		return "admin";
	}

	// ADMINISTRAR EQUIPO

	@Autowired
	private PersonaService personaAdmin;

	@GetMapping("/adminequipo")
	public String getAdminEquipo(Model model) {
		model.addAttribute("listarPersonas", personaAdmin.findAll());
		return "adminequipo";
	}

	@GetMapping("/equipoAddNuevo")
	public String getAdminEquipoAddNuevo(Model model) {
		model.addAttribute("persona", new Persona());
		return "equipoAddNuevo";
	}

	// ADMINSITRAR PROYECTOS

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

	// FRONT--------------------------------------------------

	@GetMapping("/home")
	public String getHome() {
		return "home";
	}

	// LISTAR EQUIPO
	@GetMapping("/equipo")
	public String getEquipo(Model model) {
		model.addAttribute("listarPersonas", personaService.findAll());
		return "equipo";
	}

	// LISTAR PROYECTOS
	@GetMapping("/proyectos")
	public String getProyectos(Model model) {
		log.info("----" + proyectoService.findAll());
		model.addAttribute("listaProyectos", proyectoService.findAll());
		return "proyectos";
	}

	@GetMapping("/trabajaConNosotros")
	public String getTrabajaConNosotros() {
		return "trabajaConNosotros";
	}

	@GetMapping("/contacto")
	public String getContacto() {
		return "contacto";
	}

}
