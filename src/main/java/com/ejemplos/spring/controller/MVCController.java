
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
import org.springframework.web.bind.annotation.RequestBody;

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
	@PostMapping
	public Proyecto saveProyecto(@RequestBody Proyecto proyecto) {
		return proyectoService.save(proyecto);
	}

	/*
	 * Borrar proyecto
	 * 
	 * @GetMapping("/eliminarproyecto/{idproyecto}") public String
	 * eliminarProyecto(Model model) { log.info("---- borrar");
	 * model.addAttribute("listaproyectos", proyectoService.deleteById(idproyecto));
	 * return "proyectos";
	 * 
	 * }
	 */

	/*
	 * @RequestMapping(value = "/eliminarproyecto/{idproyecto}", method =
	 * RequestMethod.DELETE) public ResponseEntity<String>
	 * eliminarProyecto(@PathVariable Integer idproyecto, @RequestBody Proyecto p) {
	 * log.info("------------------- borrar ");
	 * proyectoService.deleteById(idproyecto); return new
	 * ResponseEntity<>("Delete forever", HttpStatus.MOVED_PERMANENTLY); }
	 */

	/*
	 * @DeleteMapping(value = "/eliminarproyecto/{id}") public
	 * ResponseEntity<String> deleteProyecto(@PathVariable("id") int id) { return
	 * new ResponseEntity<String>(HttpStatus.OK); }
	 */

	@GetMapping("/eliminarproyecto/{idproyecto}")
	public String deleteById(@PathVariable Integer idproyecto) {
		proyectoService.deleteById(idproyecto);
		return "redirect:/adminproyectos";

	}

	/*
	 * private static void deleteEmployee() { final String uri =
	 * "http://localhost:8080/springrestexample/employees/{id}"; RestTemplate
	 * restTemplate = new RestTemplate();
	 * 
	 * Map<String, String> params = new HashMap<String, String>(); params.put("id",
	 * "2");
	 * 
	 * restTemplate.delete ( uri, params );
	 * 
	 */

	@GetMapping("/admin")
	public String getAdmin() {
		return "admin";
	}

	@GetMapping("/adminequipo")
	public String getAdminEquipo() {
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
	public String getAdminProyectoAddNuevo() {
		return "proyectoAddNuevo";
	}

	@GetMapping("/equipoAddNuevo")
	public String getAdminEquipoAddNuevo() {
		return "equipoAddNuevo";
	}
}
