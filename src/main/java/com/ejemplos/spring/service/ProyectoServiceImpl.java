/*

*Fecha: 14/05/2021

*@Author NextoMarket

*@Version 1.0

*

*/

package com.ejemplos.spring.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ejemplos.spring.model.Proyecto;

@Service
public class ProyectoServiceImpl implements ProyectoService {

	// Metodo para listar
	public List<Proyecto> findAll() {

		RestTemplate restTemplate = new RestTemplate();
		Proyecto[] proyectos = restTemplate.getForObject("http://localhost:5000/listarproyectos", Proyecto[].class);
		List<Proyecto> listaProyectos = Arrays.asList(proyectos);
		return listaProyectos;

	}

	// Método para guardar
	public Proyecto save(Proyecto proyecto) {

		RestTemplate restTemplateSave = new RestTemplate();
		Proyecto p = restTemplateSave.postForObject("http://localhost:5000/addproyectos", proyecto, Proyecto.class);
		return p;
	}

	@Override
	public void deleteById(int idproyecto) {
		final String uri = "http://localhost:5000/eliminarproyectos/{idproyecto}";
		RestTemplate restTemplate = new RestTemplate();

		Map<String, Integer> params = new HashMap<String, Integer>();
		params.put("idproyecto", idproyecto);

		restTemplate.delete(uri, params);
	}
	
	/*public void deleteById(int idproyecto) {

		RestTemplate restTemplateDeleteById = new RestTemplate();
		restTemplateDeleteById.delete("http://localhost:5000/eliminarproyecto/" + idproyecto);
	}*/

	

}
