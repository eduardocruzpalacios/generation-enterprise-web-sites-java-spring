/*
 * @Author Maria y Andrei
 * @Version 1.0
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

}
