/*

*Fecha: 13/05/2021

*@Author NextoMarket

*@Version 1.0

*

*/

package com.ejemplos.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ejemplos.spring.service.CargoService;

@Controller
public class CargoController {

	@Autowired
	private CargoService cargoService;

	// listar las cargos
	@GetMapping("/cargo")
	public String getCargo(Model model) {
		model.addAttribute("listarCargos", cargoService.findAll());
		return "ListarCargos";
	}

}
