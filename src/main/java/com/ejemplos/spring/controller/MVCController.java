
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

import com.ejemplos.spring.model.Persona;
import com.ejemplos.spring.model.Proyecto;
import com.ejemplos.spring.service.CargoService;
import com.ejemplos.spring.service.ClienteService;
import com.ejemplos.spring.service.PersonaService;
import com.ejemplos.spring.service.ProyectoService;

@Controller
public class MVCController {

	private static final Logger log = LoggerFactory.getLogger(MVCController.class);

	@Autowired
	private CargoService cargoService;

	// listar las cargos
	@GetMapping("/cargo")
	public String getCargo(Model model) {
		model.addAttribute("listarCargos", cargoService.findAll());
		return "ListarCargos";
	}

	@Autowired
	private ClienteService clienteService;

	// Listar Clientes
	@GetMapping("/clientes")
	public String getClientes(Model model) {
		model.addAttribute("listarClientes", clienteService.findAll());
		return "ListarClientes";
	}

	@Autowired
	private PersonaService personaService;

	// listar las personas del equipo
	@GetMapping("/equipo")
	public String getEquipo(Model model) {
		model.addAttribute("listarPersonas", personaService.findAll());
		return "equipo";
	}

	// Guardar persona
	@GetMapping("/addpersona")
	public String savePersona(Persona persona) {
		log.info("----" + personaService.save(persona));
		personaService.save(persona);
		return "redirect:/adminequipo";
	}

	// Eliminar personas
	@GetMapping("/eliminarpersona/{idpersona}")
	public String deleteByIdPersona(@PathVariable Integer idpersona) {
		personaService.deleteById(idpersona);
		return "redirect:/adminequipo";

	}

	// Modificar persona
	@GetMapping("/editarequipo/{idpersona}")
	public String findByIdPersona(@PathVariable Integer idpersona) {
		personaService.findById(idpersona);
		return "redirect:/adminequipo";
	}

	@Autowired
	private ProyectoService proyectoService;

	// Listar Proyectos
	@GetMapping("/proyectos")
	public String getProyectos(Model model) {
		log.info("----" + proyectoService.findAll());
		model.addAttribute("listaProyectos", proyectoService.findAll());
		return "proyectos";
	}

	// Guardar proyecto
	@PostMapping("/addproyecto")
	public String saveProyecto(Proyecto proyecto) {
		log.info("----" + proyectoService.save(proyecto));
		proyectoService.save(proyecto);
		return "redirect:/adminproyectos";
	}

	// Eliminar proyecto
	@GetMapping("/eliminarproyecto/{idproyecto}")
	public String deleteByIdProyecto(@PathVariable Integer idproyecto) {
		proyectoService.deleteById(idproyecto);
		return "redirect:/adminproyectos";

	}

	// Modificar proyecto
	@GetMapping("/editarproyecto/{idproyecto}")
	public String findByIdProyecto(@PathVariable Integer idproyecto) {
		proyectoService.findById(idproyecto);
		return "redirect:/adminproyectos";
	}

	@GetMapping("/admin")
	public String getAdmin() {
		return "admin";
	}

	@Autowired
	private PersonaService personaAdmin;

	@GetMapping("/adminequipo")
	public String getAdminEquipo(Model model) {
		model.addAttribute("listarPersonas", personaAdmin.findAll());
		return "adminequipo";
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

	@GetMapping("/equipoAddNuevo")
	public String getAdminEquipoAddNuevo() {
		return "equipoAddNuevo";
	}
}
