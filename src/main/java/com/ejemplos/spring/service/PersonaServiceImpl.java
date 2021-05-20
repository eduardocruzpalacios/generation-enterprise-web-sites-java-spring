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
		Persona[] personas = restTemplate.getForObject("http://localhost:5000/equipo", Persona[].class);
		List<Persona> listaPersonas = Arrays.asList(personas);
		return listaPersonas;

	}

	// Método para guardar
	public Persona saveAdd(Persona persona) {

		RestTemplate restTemplateSave = new RestTemplate();
		Persona person = restTemplateSave.postForObject("http://localhost:5000/addpersona", persona, Persona.class);
		return person;
	}

	// Método eliminar
	@Override
	public void deleteById(int idpersona) {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete("http://localhost:5000/eliminarpersona/" + idpersona);
	}
	
	//Método para localizar
		public Persona findById(int idpersona) {
			RestTemplate restTemplate = new RestTemplate();
			Persona[] p = restTemplate.getForObject("http://localhost:5000/localizarpersona/" + idpersona, Persona[].class);
			 return p[0];
		}

	// Método para modificar
		public void updatePersona(Persona persona) {
			RestTemplate restTemplateUpdate = new RestTemplate();
			restTemplateUpdate.put("http://localhost:5000/updatePersona/" + persona.getIdpersona(), persona, Persona.class);
		}

}
