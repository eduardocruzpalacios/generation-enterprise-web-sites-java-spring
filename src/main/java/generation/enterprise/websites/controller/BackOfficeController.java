/*

*Fecha: 14/05/2021

*@Author NextoMarket

*@Version 1.0

*

*/
package generation.enterprise.websites.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BackOfficeController {

	private final String BASE_URL = "backoffice/";

	@GetMapping("/admin")
	public String getAdmin() {
		return BASE_URL + "admin";
	}

	@GetMapping("/login")
	public String getLogin() {
		return "login";
	}

}
