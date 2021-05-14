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

import com.ejemplos.spring.model.Persona;

@Service
public class PersonaServiceImpl implements PersonaService {

	// Metodo para listar
	public List<Persona> findAll() {

		RestTemplate restTemplate = new RestTemplate();
		Persona[] personas = restTemplate.getForObject("http://localhost:5000/personas", Persona[].class);
		List<Persona> listaPersonas = Arrays.asList(personas);
		return listaPersonas;

	}
	
	
		
		
	
}
