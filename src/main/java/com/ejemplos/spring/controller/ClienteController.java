package com.ejemplos.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ejemplos.spring.service.ClienteService;

@Controller
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	// Listar Clientes
	@GetMapping("/clientes")
	public String getClientes(Model model) {
		model.addAttribute("listarClientes", clienteService.findAll());
		return "ListarClientes";
	}
}
