/*

*Fecha: 14/05/2021

*@Author NextoMarket

*@Version 1.0

*

*/

package com.ejemplos.spring.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ejemplos.spring.model.Proyecto;

@Service
public class ProyectoServiceImpl implements ProyectoService {

	// Metodo para listar
	public List<Proyecto> findAll() {

		RestTemplate restTemplate = new RestTemplate();
		Proyecto[] proyectos = restTemplate.getForObject("http://localhost:5000/proyectos", Proyecto[].class);
		List<Proyecto> listaProyectos = Arrays.asList(proyectos);
		return listaProyectos;

	}

	// Método para guardar
	public Proyecto save() {
		RestTemplate restTemplateSave = new RestTemplate();
		Proyecto proyectos2 = new Proyecto();
		Proyecto p = restTemplateSave.postForObject("http://localhost:5000/addproyectos", proyectos2, Proyecto.class);
		return p;
	}

}
