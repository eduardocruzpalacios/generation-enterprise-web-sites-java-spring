/*
 * class ProyectoController
 * 12/05/2021
 * v 1.0
 * @Raúl
 */

package com.ejemplos.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ejemplos.spring.service.ProyectoService;

@Controller
public class ProyectoController {

	@Autowired
	private ProyectoService proyectoService;

	// Listar Proyectos
	@GetMapping("/proyectos")
	public String getProyectos(Model model) {
		model.addAttribute("listarProyectos", proyectoService.findAll());
		return "ListarProyectos";
	}

}
