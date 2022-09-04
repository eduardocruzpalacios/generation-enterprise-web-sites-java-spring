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

import generation.enterprise.websites.service.MensajeService;

@Controller
public class MensajeBackOfficeController {

	private final String BASE_URL = "backoffice/";

	@Autowired
	private MensajeService mensajeService;

	@GetMapping("/admin/mensajes")
	public String findAll(Model model) {
		model.addAttribute("mensajes", mensajeService.findAll());
		return BASE_URL + "mensajes";
	}

}
