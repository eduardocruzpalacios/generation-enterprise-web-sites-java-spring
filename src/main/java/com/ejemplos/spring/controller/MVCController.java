package com.ejemplos.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ejemplos.spring.service.CargoService;
import com.ejemplos.spring.service.ClienteService;
import com.ejemplos.spring.service.PersonaService;
import com.ejemplos.spring.service.ProyectoService;

@Controller
public class MVCController {

	/*@Autowired
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
	}*/

	@Autowired
	private PersonaService personaService;

	// listar las personas del equipo
	@GetMapping("/equipo")
	public String getEquipo(Model model) {
		model.addAttribute("listarPersonas", personaService.findAll());
		return "equipo";
	}

	@Autowired
	private ProyectoService proyectoService;

	// Listar Proyectos
	@GetMapping("/proyectos")
	public String getProyectos(Model model) {
		model.addAttribute("listarProyectos", proyectoService.findAll());
		return "proyectos";
	}
}
